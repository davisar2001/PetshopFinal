import java.text.SimpleDateFormat;

public class Turtle extends Reptile{

    public Turtle(int age, String name) {
        super(age, name);
    }

    public Turtle(String[] tokens) {
        super(tokens);
    }

    @Override
    public String toText() {
        return "Turtle\t" + name + "\t" + age + "\t" + petID + "\t" + (new SimpleDateFormat("yyyy-MM-dd").format(date));
    }

    @Override
    public String toString() {
        return "[Turtle] " + "Name: '" + name + '\'' + ", Age: " + age + ", Pet ID: " + petID;
    }
}
