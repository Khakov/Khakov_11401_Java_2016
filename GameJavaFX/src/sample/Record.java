package sample;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Rus on 27.05.2016.
 */
@XmlRootElement(name = "record")
public class Record {
    private int score;
    private String name;
    public Record(String name, int record){
        this.name =name;
        this.score = record;
    }

    public Record() {
    }

        @XmlElement(name = "score")
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
