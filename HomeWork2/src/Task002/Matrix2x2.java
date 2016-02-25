package Task002;

/**
 * Created by Rustam on 17.11.2014.
 */
public class Matrix2x2 {
    private double a[][] = new double[2][2];

    public double getA(int i, int j) {
        return a[i][j];
    }

    public void setA(int i, int j, double x) {
        a[i][j] = x;
    }

    public Matrix2x2() {
        this(0);
    }

    public Matrix2x2(double b) {
        this(b, b, b, b);
    }

    public Matrix2x2(double b[][]) {
       this(b[0][0],b[0][1],b[1][0],b[1][1]);
    }

    public Matrix2x2(double a1, double a2, double a3, double a4) {
        this.a[0][0] = a1;
        this.a[0][1] = a2;
        this.a[1][0] = a3;
        this.a[1][1] = a4;
    }

    public Matrix2x2 add(Matrix2x2 b) {
        Matrix2x2 c = new Matrix2x2();
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                c.a[i][j] = this.a[i][j] + b.a[i][j];
        return c;
    }

    public void add2(Matrix2x2 b) {
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                this.a[i][j] += b.a[i][j];
    }

    public Matrix2x2 sub(Matrix2x2 b) {
        Matrix2x2 c = new Matrix2x2();
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                c.a[i][j] = this.a[i][j] - b.a[i][j];
        return c;
    }

    public void sub2(Matrix2x2 b) {
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                this.a[i][j] -= b.a[i][j];
    }

    public Matrix2x2 multNumber(double x) {
        Matrix2x2 c = new Matrix2x2();
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                c.a[i][j] = this.a[i][j] * x;
        return c;
    }

    public void multNumber2(double x) {
        Matrix2x2 c = new Matrix2x2();
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                this.a[i][j] *= x;
    }

    public Matrix2x2 mult(Matrix2x2 b) {
        Matrix2x2 c = new Matrix2x2();
        for (int t = 0; t < 2; t++)
            for (int i = 0; i < 2; i++)
                for (int j = 0; j < 2; j++)
                    c.a[t][i] += (this.a[t][j] * b.a[j][i]);
        return c;
    }

    public void mult2(Matrix2x2 b) {
        double t1 = 0;
        double t2 = 0;
        double t3 = 0;
        double t4 = 0;
        for (int i = 0; i < 2; i++) {
            t1 += this.a[0][i] * b.a[i][0];
            t2 += this.a[0][i] * b.a[i][1];
            t3 += this.a[1][i] * b.a[i][0];
            t4 += this.a[1][i] * b.a[i][1];
        }
        a[0][0] = t1;
        a[0][1] = t2;
        a[1][0] = t3;
        a[1][1] = t4;
    }

    public double det() {
        return this.a[0][0] * this.a[1][1] - this.a[0][1] * this.a[1][0];
    }

    public void transpon() {
        double t = this.a[1][0];
        this.a[1][0] = this.a[0][1];
        this.a[0][1] = t;
    }

    public Matrix2x2 inverseMatrix() {
        Matrix2x2 c = new Matrix2x2();
        if (this.det() != 0) {
            c.a[1][0] = -1 * this.a[0][1] / this.det();
            c.a[0][1] = -1 * this.a[1][0] / this.det();
            c.a[0][0] = this.a[1][1] / this.det();
            c.a[1][1] = this.a[0][0] / this.det();
            c.transpon();
        } else
            System.out.println("Ошибка");
        return c;
    }

    public Vector2D multVector(Vector2D n1) {
        Vector2D c = new Vector2D();
        c.setX(n1.getX() * this.a[0][0] + n1.getY() * this.a[0][1]);
        c.setY(n1.getX() * this.a[1][0] + n1.getY() * this.a[1][1]);
        return c;
    }

    public Matrix2x2 equivalentDiagonal() {
        Matrix2x2 c = new Matrix2x2();
        if (this.a[0][0] == 0) {
            if (this.a[1][0] == 0) {
                a[0][0] = a[0][1];
                a[1][0] = a[1][1];
            }
            if (this.a[0][1] == 0) {
                a[0][0] = a[1][0];
                a[0][1] = a[1][1];
            } else {
                a[0][0] += a[1][0];
                a[0][1] += a[1][1];
            }
        }
        c.a[0][0] = this.getA(0, 0);
        c.setA(0, 1, 0);
        c.setA(1, 0, 0);
        c.a[1][1] = this.getA(1, 1) - this.getA(1, 0) * this.getA(0, 1) / this.getA(0, 0);
        return c;
    }

    public String toString() {
        return a[0][0] + " " + a[0][1] + "\n" + a[1][0] + " " + a[1][1];
    }

    public boolean equals(Object matrix) {
        if (matrix != null) {
            Matrix2x2 matrix2x2 = (Matrix2x2) matrix;
            return this.getA(0, 0) == matrix2x2.getA(0, 0) && this.getA(0, 1) == matrix2x2.getA(0, 1) &&
                    this.getA(1, 0) == matrix2x2.getA(1, 0) && this.getA(1, 1) == matrix2x2.getA(1, 1);
        } else
            return false;
    }
}