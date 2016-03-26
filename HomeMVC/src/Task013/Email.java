package Task013;

/**
 * Created by Rus on 21.03.2016.
 */
public class Email {
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String email;
    public Email(String email){
        this.setEmail(email);
    }
}
