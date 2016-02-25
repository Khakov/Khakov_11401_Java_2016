package Task002;

/**
 * Created by Rustam on 16.11.2014.
 */
public class Vector2D implements Comparable<Vector2D> {
    private double x;
    private double y;

    public Vector2D() {
        this(0, 0);
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Vector2D add(Vector2D n2) {
        Vector2D n3 = new Vector2D(this.getX() + n2.getX(), this.getY() + n2.getY());
        return n3;
    }

    public void add2(Vector2D n2) {
        this.x += n2.x;
        this.y += n2.y;
    }

    public Vector2D sub(Vector2D n2) {
        Vector2D n3 = new Vector2D(this.getX() - n2.getX(), this.getY() - n2.getY());
        return n3;
    }

    public void sub2(Vector2D n2) {
        this.x -= n2.x;
        this.y -= n2.y;
    }

    public Vector2D mult(double a) {
        Vector2D n3 = new Vector2D(this.getX() * a, this.getY() * a);
        return n3;
    }

    public void mult2(double a) {
        this.x *= a;
        this.y *= a;
    }

    public String toString() {
        return "{" + x + ", " + y + "}";
    }

    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public double ScalarProduct(Vector2D n2) {
        return this.getX() * n2.getX() + this.getY() * n2.getY();
    }

    public double cos(Vector2D n2) {
        return ScalarProduct(n2) / (this.length() * n2.length());
    }

    public boolean equals(Object vect) {
        if (vect != null) {
            Vector2D vector = (Vector2D) vect;
            return (this.getX() == vector.getX()) && (this.getY() == vector.getY());
        } else
            return false;
    }

    @Override
    public int compareTo(Vector2D o) {
        final double EPS = 1e-9;
        double vector_1 = this.length();
        double vector_2 = o.length();
        if (Math.abs(vector_1 - vector_2) < EPS)
            return 0;
        if (vector_1 > vector_2)
            return -1;
        else
            return 1;
    }
}
