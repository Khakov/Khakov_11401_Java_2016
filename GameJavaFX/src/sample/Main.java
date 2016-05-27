package sample;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.*;

public class Main extends Application {
    private int windowWidth = 600;
    private int windowHeight = 600;
    private int blockSize = 20;
    public String direction;
    boolean running;
    boolean active;
    boolean isBonus;
    private int second = 10;
    private int currentLevel = 1;
    private Timeline timeline;
    private Timeline timer;
    private Stage thisStage;
    private FadeTransition foodTransition;
    private FadeTransition bonusTransition;
    List<Node> snake;
    Map<Integer, Boolean> horizontalCoordinate = new HashMap<>();
    Map<Integer, Boolean> verticalCoordinate = new HashMap<>();
    public Text score = new Text();
    public Text level = new Text();
    private Label time = new Label("");
    Circle bonus = new Circle(blockSize / 2);
    Random random = new Random();
    private RecordList record = new RecordList();

    @Override
    public void start(Stage primaryStage) throws Exception {//начало игры
        primaryStage.setTitle("Snake");
        for (int i = 0; i < windowWidth / blockSize; i++) {
            horizontalCoordinate.put(i * blockSize, false);
        }
        for (int i = 0; i < windowHeight / blockSize; i++) {
            verticalCoordinate.put(i * blockSize, false);
        }
        horizontalCoordinate.replace(0, true);
        verticalCoordinate.replace(0, true);
        primaryStage.setScene(createScene());
        primaryStage.show();
        thisStage = primaryStage;
        startGame();
    }

    private Scene createScene() {//делаю сцену
        Pane root = new Pane();
        Group snakeBody = new Group();
        running = false;
        active = true;
        isBonus = true;
        timeline = new Timeline();
        timer = new Timeline();
        snake = snakeBody.getChildren();
        final Rectangle food = new Rectangle(blockSize, blockSize);
        food.setFill(Color.GOLD);
        food.setTranslateX(100);
        food.setTranslateY(100);
        level.setX(0);
        level.setY(windowHeight - 45);
        level.setText("уровень: " + (count / 10 + 1) + "");
        level.setLayoutY(40);
        level.setLayoutX(10);
        score.setX(windowWidth - 45);
        score.setY(windowHeight - 5);
        time.setTranslateX(windowHeight / 3);
        time.setTranslateY(windowHeight / 3);
        time.setTextFill(Color.RED);
        time.setFont(Font.font(35));
        score.setText("счет: " + count + "");
        KeyFrame keyFrame = createKeyFrame(1, food);
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        Line line = new Line(0, windowHeight - 19, windowWidth, windowHeight - 15);
        bonus.setCenterX(-50);
        bonus.setCenterY(-50);
        bonus.setRadius(blockSize / 2);
        bonus.setFill(Color.GREEN);
        root.getChildren().addAll(snakeBody, food, score, line, level, bonus, time);
        Scene scene = new Scene(root, windowWidth, windowHeight);
        foodTransition = new FadeTransition(Duration.millis(500), food);
        foodTransition.setFromValue(1.0);
        foodTransition.setToValue(0.3);
        foodTransition.setCycleCount(Timeline.INDEFINITE);
        foodTransition.setAutoReverse(true);
        foodTransition.play();
        addSceneListener(scene);
        return scene;
    }

    private void addSceneListener(Scene scene) {//проверяю нажатия клавиш
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (active) {
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

    public KeyFrame createKeyFrame(int n, Rectangle food) {//запускаю змайку, скорость зависит от уровня
        if (currentLevel > 5)
            n = 5;
        KeyFrame keyFrame = new KeyFrame(Duration.millis(300 - n * 50), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (running) {
                    bonusPlay();
                    Node tail = snake.get(0);
                    if (snake.size() > 1) {
                        tail = snake.remove(snake.size() - 1);
                    }
                    double tailX = tail.getTranslateX();
                    double tailY = tail.getTranslateY();
                    horizontalCoordinate.replace((int) tail.getTranslateX(), false);
                    verticalCoordinate.replace((int) tail.getTranslateY(), false);
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
                    if (snake.get(0) != tail)
                        snake.add(0, tail);
                    horizontalCoordinate.replace((int) tail.getTranslateX(), true);
                    verticalCoordinate.replace((int) tail.getTranslateY(), true);
                    if (tail.getTranslateX() < 0 || tail.getTranslateY() < 0 || tail.getTranslateX() >= windowWidth || tail.getTranslateY() >= windowHeight - 20) {
                        gameOver();
                    }
                    for (Node node : snake) {
                        if (node != tail && node.getTranslateX() == tail.getTranslateX() & node.getTranslateY() == tail.getTranslateY()) {
                            gameOver();
                        }
                    }
                    if (!isBonus)
                        bonusEat(tail);
                    if (tail.getTranslateX() == food.getTranslateX() && tail.getTranslateY() == food.getTranslateY()) {
                        horizontalCoordinate.replace((int) food.getTranslateX(), true);
                        verticalCoordinate.replace((int) food.getTranslateY(), true);
                        food.setTranslateX(random.nextInt(windowHeight / blockSize) * blockSize);
                        food.setTranslateY(random.nextInt(windowWidth / blockSize - 1) * blockSize);
                        while (horizontalCoordinate.get((int) food.getTranslateX()) && verticalCoordinate.get((int) food.getTranslateY())) {
                            food.setTranslateX(random.nextInt(windowHeight / blockSize) * blockSize);
                            food.setTranslateY(random.nextInt(windowWidth / blockSize - 1) * blockSize);
                        }
                        Rectangle rectangle = new Rectangle(blockSize, blockSize);
                        rectangle.setTranslateX(tailX);
                        rectangle.setTranslateY(tailY);
                        snake.add(rectangle);
                        isBonus = true;
                        count++;
                    }
                    score.setText("счет: " + count + "");
                    if (count > currentLevel * 10) {
                        currentLevel++;
                        level.setText("уровень: " + currentLevel);
                        stopGame();
                        running = true;
                        timeline = new Timeline();
                        timeline.getKeyFrames().add(createKeyFrame(currentLevel, food));
                        timeline.setCycleCount(Timeline.INDEFINITE);
                        timeline.play();
                    }
                }
            }
        });
        return keyFrame;
    }

    private void bonusEat(Node tail) {//действия если съели бонус
        if (Math.abs((tail.getTranslateY() + blockSize / 2) - (bonus.getCenterY())) < blockSize &&
                tail.getTranslateX() + blockSize / 2 == bonus.getCenterX() ||
                Math.abs((tail.getTranslateX() + blockSize / 2) - (bonus.getCenterX())) < blockSize &&
                        tail.getTranslateY() + blockSize / 2 == bonus.getCenterY()) {
            count += 4;
            stopTimer();
            isBonus = true;
            snake.remove(snake.size() - 1);
        }
    }

    private void bonusPlay() {//запускаю бонус
        if (count % 5 == 0 && isBonus && count > 0) {
            isBonus = false;
            setBonus();
            bonusTransition = new FadeTransition(Duration.millis(500), time);
            bonusTransition.setFromValue(1.0);
            bonusTransition.setToValue(0.1);
            bonusTransition.setCycleCount(Timeline.INDEFINITE);
            bonusTransition.setAutoReverse(true);
            bonusTransition.play();
            timer = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
                time.setText("bonus:" + second);
                second--;
                if (second < 0) stopTimer();
            }));
            timer.setCycleCount(Timeline.INDEFINITE);
            timer.play();
        }
    }

    private void setBonus() {//рандомная позиция бонуса
        bonus.setCenterX(random.nextInt(windowWidth / blockSize - 1) * blockSize + blockSize / 2);
        bonus.setCenterY(random.nextInt(windowHeight / blockSize - 1) * blockSize + blockSize / 2);
        while (horizontalCoordinate.get((int) bonus.getCenterX() - blockSize / 2) &&
                verticalCoordinate.get((int) bonus.getCenterY() - blockSize / 2)) {
            bonus.setCenterX(random.nextInt(windowWidth / blockSize - 1) * blockSize + blockSize / 2);
            bonus.setCenterY(random.nextInt(windowHeight / blockSize - 1) * blockSize + blockSize / 2);
        }
    }

    private void stopTimer() {//остановка бонуса
        time.setText("");
        bonus.setCenterY(-50);
        bonus.setCenterX(-50);
        if (bonusTransition != null)
            bonusTransition.stop();
        second = 10;
        timer.stop();
    }

    private void startGame() {//начало игры
        Rectangle rectangle = new Rectangle(blockSize, blockSize);
        direction = "DOWN";
        running = true;
        timeline.play();
        snake.add(rectangle);
    }

    private void stopGame() {//остановка игры
        timeline.stop();
        running = false;
    }

    private void gameOver() {//конец игры
        timeline.stop();
        stopTimer();
        foodTransition.stop();
        running = false;
        showMessage();
    }

    private void showMessage() {//результаты игры
        loadRecordDataFromFile(new File("src/sample/record.xml"));
        if (count > record.getRecords().get(4).getScore()) {
            thisStage.setScene(recordPage());
        } else
            thisStage.setScene(result());
    }

    private Scene recordPage() {
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, windowWidth / 3, windowHeight / 3);
        Label label = new Label("введите имя");
        label.setTranslateX(50);
        label.setTranslateY(10);
        TextField recordName = new TextField();
        recordName.setTranslateX(20);
        recordName.setTranslateY(30);
        Button button = new Button("записать");
        button.setTranslateX(50);
        button.setTranslateY(60);
        Label label1 = new Label("New Record!!!");
        label1.setTranslateY(80);
        label1.setTranslateX(50);
        label1.setFont(Font.font(20));
        label1.setTextFill(Color.GREEN);
        root.getChildren().addAll(recordName, button, label, label1);
        buttonListener(button, recordName);
        return scene;
    }

    private void buttonListener(Button button, TextField recordName) {
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                List<Record> records = record.getRecords();
                Record record1 = new Record(recordName.getText(), count);
                if (count > record.getRecords().get(3).getScore())
                    if (count > record.getRecords().get(2).getScore())
                        if (count > record.getRecords().get(1).getScore())
                            if (count > record.getRecords().get(0).getScore())
                                records.add(0, record1);
                            else
                                records.add(1, record1);
                        else
                            records.add(2, record1);
                    else
                        records.add(3, record1);
                else
                    records.add(4, record1);
                records.remove(5);
                record.setRecords(records);
                saveRecordsDataToFile(new File("src/sample/record.xml"));
                thisStage.setScene(result());
            }
        });
    }

    private void newGame() throws Exception {//новая игра
        count = 0;
        start(thisStage);
    }

    private Scene result() {//показывет результаты
        AnchorPane root = new AnchorPane();
        Button start = new Button("Новая игра");
        start.setTranslateX(50);
        start.setTranslateY(5);
        List<Label> records = new LinkedList<>();
        Label result = new Label("результат: " + count);
        result.setTranslateX(50);
        result.setTranslateY(30);
        addStartListen(start);
        Label label = new Label("рекорды:");
        label.setTranslateX(50);
        label.setTranslateY(60);
        Scene scene = new Scene(root, windowWidth / 3, windowHeight / 2);
        int i = 1;
        for (Record record1 : record.getRecords()) {
            Label label1 = new Label();
            label1.setTranslateX(10);
            label1.setTranslateY(60 + i * 20);
            label1.setLayoutX(50);
            label1.setLayoutY(20);
            label1.setText(i + ": " + record1.getName() + "-" + record1.getScore());
            records.add(label1);
            i++;
        }
        root.getChildren().addAll(start, result, label);
        root.getChildren().addAll(records);
        return scene;
    }

    private void addStartListen(Button button) {//слушаем кнопку "начало игры"
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    newGame();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void loadRecordDataFromFile(File file) {
        try {
            System.out.println(file.getName());
            JAXBContext context = JAXBContext.newInstance(RecordList.class);
            Unmarshaller um = context.createUnmarshaller();
            // Чтение XML из файла и демаршализация.
            record = (RecordList) um.unmarshal(file);
        } catch (Exception e) { // catches ANY exception
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("Could not load data from file:\n" + file.getPath());
            alert.showAndWait();
        }
    }

    /**
     * Сохраняет текущую информацию об адресатах в указанном файле.
     */
    public void saveRecordsDataToFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(RecordList.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(record, file);
        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + file.getPath());
            alert.showAndWait();
        }
    }
}
