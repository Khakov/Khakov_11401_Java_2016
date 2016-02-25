package Task002;

import org.junit.*;

/**
 * Created by Rustam on 23.02.2016.
 */
public class TestMatrix2x2 {
    private static final double EPS = 1e-9;
    public static Matrix2x2 firstMatrix;
    public static Matrix2x2 secondMatrix;

    @BeforeClass
    public static void beforeClass() {
        firstMatrix = new Matrix2x2(1, 2, 3, 4);
        secondMatrix = new Matrix2x2(2, 3, 4, 1);
    }

    @Test
    public void firstParamOfConstructorShouldBeSavedInMatrix() {
        Assert.assertEquals(1, firstMatrix.getA(0, 0), EPS);
    }

    @Test
    public void secondParamOfConstructorShouldBeSavedInMatrix() {
        Assert.assertEquals(2, firstMatrix.getA(0, 1), EPS);
    }

    @Test
    public void thirdParamOfConstructorShouldBeSavedInMatrix() {
        Assert.assertEquals(3, firstMatrix.getA(1, 0), EPS);
    }

    @Test
    public void forthParamOfConstructorShouldBeSavedInMatrix() {
        Assert.assertEquals(4, firstMatrix.getA(1, 1), EPS);
    }

    @Test
    public void addMethodShouldBeCorrect() {
        Assert.assertEquals(new Matrix2x2(3, 5, 7, 5), firstMatrix.add(secondMatrix));
    }

    @Test
    public void add2MethodShouldBeCorrect() {
        Matrix2x2 matrix = new Matrix2x2(1, 2, 3, 4);
        matrix.add2(secondMatrix);
        Assert.assertEquals(new Matrix2x2(3, 5, 7, 5), matrix);
    }

    @Test
    public void subMethodShouldBeCorrect() {
        Assert.assertEquals(new Matrix2x2(-1, -1, -1, 3), firstMatrix.sub(secondMatrix));
    }

    @Test
    public void sub2MethodShouldBeCorrect() {
        Matrix2x2 matrix = new Matrix2x2(1, 2, 3, 4);
        matrix.sub2(secondMatrix);
        Assert.assertEquals(new Matrix2x2(-1, -1, -1, 3), matrix);
    }

    @Test
    public void multOnNumberMatrixShouldBeCorrect() {
        Assert.assertEquals(new Matrix2x2(2, 4, 6, 8), firstMatrix.multNumber(2));
    }

    @Test
    public void multOnNumber2MatrixShouldBeCorrect() {
        Matrix2x2 matrix = new Matrix2x2(1, 2, 3, 4);
        matrix.multNumber2(2);
        Assert.assertEquals(new Matrix2x2(2, 4, 6, 8), matrix);
    }

    @Test
    public void multMethodShouldBeCorrect() {
        Assert.assertEquals(new Matrix2x2(10, 5, 22, 13), firstMatrix.mult(secondMatrix));
    }

    @Test
    public void mult2MethodShouldBeCorrect() {
        Matrix2x2 matrix = new Matrix2x2(1, 2, 3, 4);
        matrix.mult2(secondMatrix);
        Assert.assertEquals(new Matrix2x2(10, 5, 22, 13), matrix);
    }

    @Test
    public void determinateOfMatrixShouldBeEqualsMinusTwo() {
        Assert.assertEquals(-2, firstMatrix.det(), EPS);
    }

    @Test
    public void transporateMatrixShouldBeCorrect() {
        Matrix2x2 matrix = new Matrix2x2(1, 2, 3, 4);
        matrix.transpon();
        Assert.assertEquals(new Matrix2x2(1, 3, 2, 4), matrix);
    }

    @Test
    public void inverseMatrixShouldBeCorrect() {
        Assert.assertEquals(new Matrix2x2(-2, 1, 1.5, -0.5), firstMatrix.inverseMatrix());
    }

    @Test
    public void multMatrixWithVector2DShouldBeCorrect() {
        Matrix2x2 matrix = new Matrix2x2(1, 2, 3, 4);
        Assert.assertEquals(new Vector2D(5, 11), matrix.multVector(new Vector2D(1, 2)));
    }

    @Test
    public void equivalentDiagonalShouldBeCorrect() {
        Matrix2x2 result = new Matrix2x2(1, 0, 0, -2);
        Matrix2x2 matrix = firstMatrix.equivalentDiagonal();
        Assert.assertEquals(result, matrix);
    }
    @Test
    public void setAMatrixWriteCorrect() {
        Matrix2x2 matrix = new Matrix2x2(1, 2, 3, 4);
        matrix.setA(1, 1, 3);
        Assert.assertEquals(3, matrix.getA(1, 1), EPS);
    }

    @Test
    public void equalsMatrixShouldBeEquals(){
        Matrix2x2 matrix = new Matrix2x2(1,2,3,4);
        if (!firstMatrix.equals(matrix)){
            Assert.fail();
        }
    }
}