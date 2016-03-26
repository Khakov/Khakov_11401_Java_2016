package Task009;


/**
 * Created by RustamUS on 19.11.2014.
 */
public class ComplexMatrix2x2 {
    ComplexNumber a[][] = new ComplexNumber[2][2];

    public ComplexMatrix2x2() {
        this(new ComplexNumber());
    }

    public ComplexMatrix2x2(ComplexNumber b) {
        this(b, b, b, b);
    }

    public ComplexMatrix2x2(ComplexNumber x1, ComplexNumber x2, ComplexNumber x3, ComplexNumber x4) {
        a[0][0] = x1;
        a[0][1] = x2;
        a[1][0] = x3;
        a[1][1] = x4;
    }

    public ComplexMatrix2x2 add(ComplexMatrix2x2 b) {
        ComplexMatrix2x2 c = new ComplexMatrix2x2();
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                c.a[i][j] = this.a[i][j].add(b.a[i][j]);
        return c;
    }

    public ComplexMatrix2x2 mult(ComplexMatrix2x2 b) {
        ComplexMatrix2x2 c = new ComplexMatrix2x2();
        for (int t = 0; t < 2; t++)
            for (int i = 0; i < 2; i++)
                for (int j = 0; j < 2; j++)
                    c.a[t][i] = c.a[t][i].add(this.a[t][j].mult(b.a[j][i]));
        return c;
    }

    public ComplexNumber det() {
        ComplexNumber c1 = this.a[0][0].mult(this.a[1][1]);
        ComplexNumber c2 = this.a[0][1].mult(this.a[1][0]);
        return c1.sub(c2);

    }

    public ComplexVector2D multVector(ComplexVector2D n) {
        ComplexVector2D c = new ComplexVector2D();
        c.setS1(n.getS1().mult(this.a[0][0]).add(n.getS2().mult(this.a[0][1])));
        c.setS2(n.getS1().mult(this.a[1][0]).add(n.getS2().mult(this.a[1][1])));
        return c;
    }

    public String toString() {
        return a[0][0] + " " + a[0][1] + "\n" + a[1][0] + " " + a[1][1];
    }

    public boolean equals(Object o) {
        if (o != null) {
            ComplexMatrix2x2 matrix = (ComplexMatrix2x2) o;
            return matrix.a[0][0].equals(this.a[0][0]) && matrix.a[1][0].equals(this.a[1][0]) &&
                    matrix.a[0][1].equals(this.a[0][1]) && matrix.a[1][1].equals(this.a[1][1]);
        } else return false;
    }
}
