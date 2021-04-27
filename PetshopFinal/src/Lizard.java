import java.text.SimpleDateFormat;

public class Lizard extends Reptile{

    public Lizard(int age, String name) {
        super(age, name);
    }

    public Lizard(String[] tokens) {
        super(tokens);
    }

    @Override
    public String toText() {
        return "Lizard\t" + name + "\t" + age + "\t" + petID + "\t" + (new SimpleDateFormat("yyyy-MM-dd").format(date));
    }

    @Override
    public String toString() {
        return "[Lizard] " + "Name: '" + name + '\'' + ", Age: " + age + ", Pet ID: " + petID;
    }
}
