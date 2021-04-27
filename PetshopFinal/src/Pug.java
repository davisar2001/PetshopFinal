import java.text.SimpleDateFormat;

public class Pug extends Canine{

    public Pug(int age, String name) {
        super(age, name);
    }

    public Pug(String[] tokens) {
        super(tokens);
    }

    @Override
    public String toText() {
        return "Pug\t" + name + "\t" + age + "\t" + petID + "\t" + (new SimpleDateFormat("yyyy-MM-dd").format(date));
    }

    @Override
    public String toString() {
        return "[Pug] " + "Name: '" + name + '\'' + ", Age: " + age + ", Pet ID: " + petID;
    }
}
