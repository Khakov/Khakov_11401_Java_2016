package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.*;

public class Main extends Application {
    private int windowWidth = 600;
    private int windowHeight = 600;
    private int blockSize = 20;

    public String direction;
    boolean running = false;
    boolean active = true;
    private Timeline timeline = new Timeline();
    List<Node> snake;
    Map<Integer, Boolean> horizontalCoordinate = new HashMap<>();
    Map<Integer, Boolean> verticalCoordinate = new HashMap<>();
    public Text score = new Text();
    public Text level = new Text();
    Circle bonus = new Circle();
    Random random = new Random();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Snake");
        for (int i = 0; i < windowWidth / blockSize; i++) {
            horizontalCoordinate.put(i*blockSize,false);
        }
        for (int i = 0; i < windowHeight / blockSize; i++) {
            verticalCoordinate.put(i*blockSize,false);
        }
        horizontalCoordinate.replace(0,true);
        verticalCoordinate.replace(0,true);
        primaryStage.setScene(createScene());
        primaryStage.show();
        startGame();
    }

    private void addSceneListener(Scene scene) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(active) {
                    switch (event.getCode()) {
                        case UP:
                            if (!direction.equals("DOWN"))
                                direction = "UP";
                            break;
                        case DOWN:
                            if (!direction.equals("UP"))
                                direction = "DOWN";
                            break;
                        case LEFT:
                            if (!direction.equals("RIGHT"))
                                direction = "LEFT";
                            break;
                        case RIGHT:
                            if (!direction.equals("LEFT"))
                                direction = "RIGHT";
                            break;
                    }
                }
                active = false;
            }

        });
    }

    private static int count = 0;

    public KeyFrame createKeyFrame(int n, Rectangle food) {
        if(count>90)
            n = 90;
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500 - n*50), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (running) {
                    Node tail = snake.get(0);
                    if(snake.size()>1){
                        tail = snake.remove(snake.size()-1);
                    }
                    double tailX = tail.getTranslateX();
                    double tailY = tail.getTranslateY();
                    horizontalCoordinate.replace((int) tail.getTranslateX(),false);
                    verticalCoordinate.replace((int) tail.getTranslateY(),false);
                    active = true;
                    switch (direction) {
                        case "UP":
                            tail.setTranslateX(snake.get(0).getTranslateX());
                            tail.setTranslateY(snake.get(0).getTranslateY() - blockSize);
                            break;
                        case "DOWN":
                            tail.setTranslateX(snake.get(0).getTranslateX());
                            tail.setTranslateY(snake.get(0).getTranslateY() + blockSize);
                            break;
                        case "LEFT":
                            tail.setTranslateX(snake.get(0).getTranslateX() - blockSize);
                            tail.setTranslateY(snake.get(0).getTranslateY());
                            break;
                        case "RIGHT":
                            tail.setTranslateX(snake.get(0).getTranslateX() + blockSize);
                            tail.setTranslateY(snake.get(0).getTranslateY());
                            break;
                    }
                    if (snake.get(0)!= tail)
                        snake.add(0, tail);
                    horizontalCoordinate.replace((int) tail.getTranslateX(),true);
                    verticalCoordinate.replace((int) tail.getTranslateY(),true);
                    if (tail.getTranslateX() < 0 || tail.getTranslateY() < 0 || tail.getTranslateX() >= windowWidth || tail.getTranslateY() >= windowHeight-20) {
                        stopGame();
                    }
                    for (Node node : snake) {
                        if (node != tail && node.getTranslateX() == tail.getTranslateX() & node.getTranslateY() == tail.getTranslateY()) {
                            stopGame();
                        }
                    }
                    if (tail.getTranslateX() == food.getTranslateX() && tail.getTranslateY() == food.getTranslateY()) {
                        horizontalCoordinate.replace((int) food.getTranslateX(),true);
                        verticalCoordinate.replace((int) food.getTranslateY(),true);
                        food.setTranslateX(random.nextInt(windowHeight / blockSize) * blockSize);
                        food.setTranslateY(random.nextInt(windowWidth / blockSize) * blockSize);
                        while (horizontalCoordinate.get((int)food.getTranslateX()) && verticalCoordinate.get((int)food.getTranslateY())) {
                            food.setTranslateX(random.nextInt(windowHeight / blockSize) * blockSize);
                            food.setTranslateY(random.nextInt(windowWidth / blockSize) * blockSize);
                        }
                        Rectangle rectangle = new Rectangle(blockSize, blockSize);
                        rectangle.setTranslateX(tailX);
                        rectangle.setTranslateY(tailY);
                        snake.add(rectangle);
                        count++;
                        score.setText("счет:"+count +"");
                        if (count % 10 == 0) {
                            bonus.setCenterX(random.nextInt(windowWidth / blockSize) * blockSize);
                            bonus.setCenterY(random.nextInt(windowHeight / blockSize) * blockSize);
                            bonus.setRadius(15);
                            while (horizontalCoordinate.get((int)bonus.getCenterX())&&
                                    verticalCoordinate.get((int)bonus.getCenterY())){
                                bonus.setCenterX(random.nextInt(windowWidth / blockSize) * blockSize);
                                bonus.setCenterY(random.nextInt(windowHeight / blockSize) * blockSize);
                            }
                            stopGame();
                            running = true;
                            timeline = new Timeline();
                            timeline.getKeyFrames().add(createKeyFrame(count, food));
                            timeline.setCycleCount(Timeline.INDEFINITE);
                            timeline.play();
                        }
                    }
                }
            }
        });
        return keyFrame;
    }

    private Scene createScene() {
        Pane root = new Pane();
        Group snakeBody = new Group();
        snake = snakeBody.getChildren();
        final Rectangle food = new Rectangle(blockSize, blockSize);
        food.setFill(Color.GOLD);
        food.setTranslateX(100);
        food.setTranslateY(100);
        level.setX(0);
        level.setY(windowHeight - 45);
        level.setText("уровень: "+count/10 + "");
        level.setLayoutY(40);
        level.setLayoutX(10);
        score.setX(windowWidth - 45);
        score.setY(windowHeight - 5);
        score.setText("счет: "+count + "");
        KeyFrame keyFrame = createKeyFrame(1, food);
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        Line line = new Line(0,windowHeight-19,windowWidth,windowHeight -15);
        root.getChildren().addAll(snakeBody, food, score, line, level);
        Scene scene = new Scene(root, windowWidth, windowHeight);
        addSceneListener(scene);
        return scene;
    }

    private void startGame() {
        Rectangle rectangle = new Rectangle(blockSize, blockSize);
        direction = "DOWN";
        running = true;
        timeline.play();
        snake.add(rectangle);
    }

    private void stopGame() {
        timeline.stop();
        running = false;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
