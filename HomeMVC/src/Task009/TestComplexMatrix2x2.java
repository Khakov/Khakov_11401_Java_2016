package Task009;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by Rustam on 19.11.2014.
 */
public class TestComplexMatrix2x2 {
    public static ComplexMatrix2x2 firstMatrix;
    public static ComplexMatrix2x2 secondMatrix;
    public static ComplexVector2D vector;
    public static ApplicationContext ac = new ClassPathXmlApplicationContext("Task009/spring-config-matrix.xml");

    @BeforeClass
    public static void beforeClass() {
        firstMatrix = (ComplexMatrix2x2) ac.getBean("firstMatrix");
        secondMatrix = (ComplexMatrix2x2) ac.getBean("secondMatrix");
        vector = (ComplexVector2D) ac.getBean("vector");
    }

    @Test
    public void everyElementShouldHaveParamValue() {
        ComplexMatrix2x2 result = (ComplexMatrix2x2) ac.getBean("firstMatrix");
        Assert.assertTrue(firstMatrix.equals(result));
    }

    @Test
    public void addMethodShouldBeCorrect() {
        ComplexMatrix2x2 result = (ComplexMatrix2x2) ac.getBean("thirdMatrix");
        ComplexMatrix2x2 matrix = firstMatrix.add(secondMatrix);
        Assert.assertTrue(result.equals(matrix));
    }

    @Test
    public void equalsMethodShouldBeCorrect() {
        ComplexMatrix2x2 result = (ComplexMatrix2x2) ac.getBean("firstMatrix");
        Assert.assertTrue(result.a[0][0].equals(firstMatrix.a[0][0]));
        Assert.assertTrue(result.a[0][1].equals(firstMatrix.a[0][1]));
        Assert.assertTrue(result.a[1][0].equals(firstMatrix.a[1][0]));
        Assert.assertTrue(result.a[1][1].equals(firstMatrix.a[1][1]));
    }

    @Test
    public void multMethodShouldBeCorrect() {
        ComplexMatrix2x2 result = (ComplexMatrix2x2) ac.getBean("fourthMatrix");
        ComplexMatrix2x2 matrix = firstMatrix.mult(secondMatrix);
        Assert.assertTrue(result.equals(matrix));
    }

    @Test
    public void determinateOfMatrixShouldBeCorrect() {
        ComplexNumber number = (ComplexNumber) ac.getBean("eleventhComplexNumber");
        Assert.assertTrue(firstMatrix.det().equals(number));
    }

    @Test
    public void multComplexVectorShouldBeCorrect() {
        ComplexVector2D result = (ComplexVector2D) ac.getBean("vector2");
        Assert.assertTrue(firstMatrix.multVector(vector).equals(result));
    }
}
