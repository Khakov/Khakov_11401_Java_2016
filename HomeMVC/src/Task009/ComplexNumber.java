package Task009;

/**
 * Created by RustamUS on 12.11.2014.
 */
public class ComplexNumber {
    private double a;
    private double bi;

    public ComplexNumber() {
        this(0, 0);
    }

    public ComplexNumber(double a, double bi) {
        this.a = a;
        this.bi = bi;
    }

    public double getA() {
        return this.a;
    }

    public double getBi() {
        return this.bi;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setBi(double bi) {
        this.bi = bi;
    }

    public ComplexNumber add(ComplexNumber n2) {
        ComplexNumber c = new ComplexNumber(this.getA() + n2.getA(), this.getBi() + n2.getBi());
        return c;
    }

    public void add2(ComplexNumber n2) {
        this.a += n2.a;
        this.bi += n2.bi;
    }

    public ComplexNumber sub(ComplexNumber n2) {
        ComplexNumber c = new ComplexNumber(this.getA() - n2.getA(), this.getBi() - n2.getBi());
        return c;
    }

    public void sub2(ComplexNumber n2) {
        this.a -= n2.a;
        this.bi -= n2.bi;
    }

    public ComplexNumber multNumber(double x) {
        ComplexNumber c = new ComplexNumber(this.a * x, this.bi * x);
        return c;
    }

    public void multNumber2(double x) {
        this.a *= x;
        this.bi *= x;
    }

    public ComplexNumber mult(ComplexNumber n2) {
        ComplexNumber c = new ComplexNumber(this.getA() * n2.getA() - this.getBi() * n2.getBi(), this.getA() * n2.getBi() + this.getBi() * n2.getA());
        return c;
    }

    public void mult2(ComplexNumber n2) {
        double x = this.a;
        this.a = this.a * n2.a - this.bi * n2.bi;
        this.bi = x * n2.bi + this.bi * n2.a;
    }

    public ComplexNumber div(ComplexNumber n2) {
        double z = n2.getA() * n2.getA() + n2.getBi() * n2.getBi();
        double x = this.getA() * n2.getA() + this.getBi() * n2.getBi();
        double y = this.getBi() * n2.getA() - this.getA() * n2.getBi();
        ComplexNumber c = new ComplexNumber(x / z, y / z);
        return c;
    }

    public void div2(ComplexNumber n2) {
        double x = this.a;
        double y = this.bi;
        this.a = (this.a * n2.a + this.bi * n2.bi) / (n2.a * n2.a + n2.bi * n2.bi);
        this.bi = (y * n2.a - x * n2.bi) / (n2.a * n2.a + n2.bi * n2.bi);
    }

    public double length() {
        return Math.sqrt(this.a * this.a + this.bi * this.bi);
    }

    public double cos() {
        return this.a / this.length();
    }

    public double sin() {
        return this.bi / this.length();
    }

    public double arg() {
        return Math.toDegrees(Math.atan(this.a / this.bi));
    }

    public void pow(double step) {
        double arg = Math.toRadians(this.arg());
        double c = this.length();
        c = Math.pow(c, step);
        double psi = arg * step;
        this.a = c * Math.cos(psi);
        this.bi = c * Math.sin(psi);
    }

    public ComplexNumber pow2(double step) {
        double c = this.length();
        double arg = Math.toRadians(this.arg());
        c = Math.pow(c, step);
        double psi = arg * step;
        ComplexNumber x = new ComplexNumber(c * Math.cos(psi), c * Math.sin(psi));
        return x;
    }

    public boolean equals(ComplexNumber n2) {
        return (this.getA() == n2.getA()) && (this.getBi() == n2.getBi());
    }

    public String toString() {
        if (this.getBi() > 0)
            return this.getA() + "+" + this.getBi() + "i";
        else
            return this.getA() + "" + this.getBi() + "i";
    }


}
