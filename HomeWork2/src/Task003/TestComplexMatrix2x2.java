package Task003;

import org.junit.*;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

/**
 * Created by Rustam on 19.11.2014.
 */
public class TestComplexMatrix2x2 {
    public static ComplexMatrix2x2 firstMatrix;
    public static ComplexMatrix2x2 secondMatrix;
    public static ComplexVector2D vector;

    @BeforeClass
    public static void beforeClass() {
        ComplexNumber n1 = mock(ComplexNumber.class);
        ComplexNumber n2 = mock(ComplexNumber.class);
        ComplexNumber n3 = mock(ComplexNumber.class);
        ComplexNumber n4 = mock(ComplexNumber.class);
        when(n1.getA()).thenReturn(3.0);
        when(n1.getBi()).thenReturn(4.0);
        when(n2.getA()).thenReturn(6.0);
        when(n2.getBi()).thenReturn(7.0);
        when(n3.getA()).thenReturn(5.0);
        when(n3.getBi()).thenReturn(4.0);
        when(n4.getA()).thenReturn(4.0);
        when(n4.getBi()).thenReturn(3.0);
        when(n1.add(anyObject())).thenCallRealMethod();
        when(n2.add(anyObject())).thenCallRealMethod();
        when(n3.add(anyObject())).thenCallRealMethod();
        when(n4.add(anyObject())).thenCallRealMethod();
        when(n1.mult(anyObject())).thenCallRealMethod();
        when(n2.mult(anyObject())).thenCallRealMethod();
        when(n3.mult(anyObject())).thenCallRealMethod();
        when(n4.mult(anyObject())).thenCallRealMethod();
        firstMatrix = new ComplexMatrix2x2(n1,n2,n3,n4);
        secondMatrix = new ComplexMatrix2x2(n1,n3,n2,n4);
        vector = mock(ComplexVector2D.class);
        when(vector.getS1()).thenReturn(n1);
        when(vector.getS2()).thenReturn(n3);
    }

    @Test
    public void everyElementShouldHaveParamValue(){
        ComplexNumber number1 = mock(ComplexNumber.class);
        ComplexNumber number2 = mock(ComplexNumber.class);
        ComplexNumber number3 = mock(ComplexNumber.class);
        ComplexNumber number4 = mock(ComplexNumber.class);
        when(number1.getA()).thenReturn(3.0);
        when(number1.getBi()).thenReturn(4.0);
        when(number1.equals(anyObject())).thenCallRealMethod();
        when(number2.getA()).thenReturn(6.0);
        when(number2.getBi()).thenReturn(7.0);
        when(number2.equals(anyObject())).thenCallRealMethod();
        when(number3.getA()).thenReturn(5.0);
        when(number3.getBi()).thenReturn(4.0);
        when(number3.equals(anyObject())).thenCallRealMethod();
        when(number4.getA()).thenReturn(4.0);
        when(number4.getBi()).thenReturn(3.0);
        when(number4.equals(anyObject())).thenCallRealMethod();
        ComplexMatrix2x2 result = new ComplexMatrix2x2(number1,number2,number3,number4);
        Assert.assertTrue(firstMatrix.equals(result));
    }

    @Test
    public void addMethodShouldBeCorrect(){
        ComplexNumber number1 = mock(ComplexNumber.class);
        ComplexNumber number2 = mock(ComplexNumber.class);
        ComplexNumber number3 = mock(ComplexNumber.class);
        ComplexNumber number4 = mock(ComplexNumber.class);
        when(number1.getA()).thenReturn(6.0);
        when(number1.getBi()).thenReturn(8.0);
        when(number1.equals(anyObject())).thenCallRealMethod();
        when(number2.getA()).thenReturn(11.0);
        when(number2.getBi()).thenReturn(11.0);
        when(number2.equals(anyObject())).thenCallRealMethod();
        when(number3.getA()).thenReturn(11.0);
        when(number3.getBi()).thenReturn(11.0);
        when(number3.equals(anyObject())).thenCallRealMethod();
        when(number4.getA()).thenReturn(8.0);
        when(number4.getBi()).thenReturn(6.0);
        when(number4.equals(anyObject())).thenCallRealMethod();
        ComplexMatrix2x2 result = new ComplexMatrix2x2(number1,number2,number3,number4);
        ComplexMatrix2x2 matrix = firstMatrix.add(secondMatrix);
        Assert.assertTrue(result.equals(matrix));
    }

    @Test
    public void equalsMethodShouldBeCorrect(){
        ComplexNumber number1 = mock(ComplexNumber.class);
        ComplexNumber number2 = mock(ComplexNumber.class);
        ComplexNumber number3 = mock(ComplexNumber.class);
        ComplexNumber number4 = mock(ComplexNumber.class);
        when(number1.getA()).thenReturn(3.0);
        when(number1.getBi()).thenReturn(4.0);
        when(number1.equals(anyObject())).thenCallRealMethod();
        when(number2.getA()).thenReturn(6.0);
        when(number2.getBi()).thenReturn(7.0);
        when(number2.equals(anyObject())).thenCallRealMethod();
        when(number3.getA()).thenReturn(5.0);
        when(number3.getBi()).thenReturn(4.0);
        when(number3.equals(anyObject())).thenCallRealMethod();
        when(number4.getA()).thenReturn(4.0);
        when(number4.getBi()).thenReturn(3.0);
        when(number4.equals(anyObject())).thenCallRealMethod();
        ComplexMatrix2x2 result = new ComplexMatrix2x2(number1,number2,number3,number4);
        Assert.assertTrue(result.a[0][0].equals(firstMatrix.a[0][0]));
        Assert.assertTrue(result.a[0][1].equals(firstMatrix.a[0][1]));
        Assert.assertTrue(result.a[1][0].equals(firstMatrix.a[1][0]));
        Assert.assertTrue(result.a[1][1].equals(firstMatrix.a[1][1]));
    }

    @Test
    public void multMethodShouldBeCorrect(){
        ComplexNumber number1 = mock(ComplexNumber.class);
        ComplexNumber number2 = mock(ComplexNumber.class);
        ComplexNumber number3 = mock(ComplexNumber.class);
        ComplexNumber number4 = mock(ComplexNumber.class);
        when(number1.getA()).thenReturn(-20.0);
        when(number1.getBi()).thenReturn(108.0);
        when(number2.getA()).thenReturn(2.0);
        when(number2.getBi()).thenReturn(78.0);
        when(number3.getA()).thenReturn(2.0);
        when(number3.getBi()).thenReturn(78.0);
        when(number4.getA()).thenReturn(16.0);
        when(number4.getBi()).thenReturn(64.0);
        when(number1.equals(anyObject())).thenCallRealMethod();
        when(number2.equals(anyObject())).thenCallRealMethod();
        when(number3.equals(anyObject())).thenCallRealMethod();
        when(number4.equals(anyObject())).thenCallRealMethod();
        when(number1.mult(anyObject())).thenCallRealMethod();
        when(number2.mult(anyObject())).thenCallRealMethod();
        when(number3.mult(anyObject())).thenCallRealMethod();
        when(number4.mult(anyObject())).thenCallRealMethod();
        ComplexMatrix2x2 result = new ComplexMatrix2x2(number1,number2,number3,number4);
        ComplexMatrix2x2 matrix = firstMatrix.mult(secondMatrix);
        Assert.assertTrue(result.equals(matrix));
    }

    @Test
    public void determinateOfMatrixShouldBeCorrect(){
        ComplexNumber number = mock(ComplexNumber.class);
        when(number.getA()).thenReturn(-2.0);
        when(number.getBi()).thenReturn(-34.0);
        when(number.equals(anyObject())).thenCallRealMethod();
        Assert.assertTrue(firstMatrix.det().equals(number));
    }

    @Test
    public void multComplexVectorShouldBeCorrect(){
        ComplexNumber number1 = mock(ComplexNumber.class);
        ComplexNumber number2 = mock(ComplexNumber.class);
        when(number1.getA()).thenReturn(-5.0);
        when(number2.getA()).thenReturn(7.0);
        when(number1.getBi()).thenReturn(83.0);
        when(number2.getBi()).thenReturn(63.0);
        when(number1.equals(anyObject())).thenCallRealMethod();
        when(number2.equals(anyObject())).thenCallRealMethod();
        ComplexVector2D result = mock(ComplexVector2D.class);
        when(result.getS1()).thenReturn(number1);
        when(result.getS2()).thenReturn(number2);
        Assert.assertTrue(firstMatrix.multVector(vector).equals(result));
    }
}
