import java.text.SimpleDateFormat;

public class Snake extends Reptile{

    public Snake(int age, String name) {
        super(age, name);
    }

    public Snake(String[] tokens) {
        super(tokens);
    }

    @Override
    public String toText() {
        return "Snake\t" + name + "\t" + age + "\t" + petID + "\t" + (new SimpleDateFormat("yyyy-MM-dd").format(date));
    }

    @Override
    public String toString() {
        return "[Snake] " + "Name: '" + name + '\'' + ", Age: " + age + ", Pet ID: " + petID;
    }
}
