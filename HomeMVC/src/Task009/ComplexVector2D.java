package Task009;


/**
 * Created by RustamUS on 19.11.2014.
 */
public class ComplexVector2D {
    private ComplexNumber s1;
    private ComplexNumber s2;
    public ComplexNumber getS1(){
        return this.s1;
    }
    public ComplexNumber getS2(){
        return this.s2;
    }
    public void setS1(ComplexNumber s1){
        this.s1 = s1;
    }
    public void setS2(ComplexNumber s2){
        this.s2 = s2;
    }
    public ComplexVector2D(){
        this(new ComplexNumber(),new ComplexNumber());
    }
    public ComplexVector2D(ComplexNumber s1, ComplexNumber s2){
        this.s1 = s1;
        this.s2 = s2;
    }
    public ComplexVector2D add(ComplexVector2D a1){
        ComplexVector2D c = new ComplexVector2D();
        c.s1 = this.getS1().add(a1.getS1());
        c.s2 = this.getS2().add(a1.getS2());
        return c;
    }
    public String toString(){
        return "{ " + this.getS1() + " , " + this.getS2() + " }";
    }
    public ComplexNumber ScalarProduct(ComplexVector2D a1){
        return this.s1.mult(a1.s1).add(this.s2.mult(a1.s2));
    }
    public boolean equals(ComplexVector2D a1){
        return this.getS1().equals(a1.getS1()) && this.getS2().equals(a1.getS2());
    }
}
