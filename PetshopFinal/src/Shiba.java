import java.text.SimpleDateFormat;

public class Shiba extends Canine{

    public Shiba(int age, String name) {
        super(age, name);
    }

    public Shiba(String[] tokens) {
        super(tokens);
    }

        @Override
    public String toText() {
        return "Shiba\t" + name + "\t" + age + "\t" + petID + "\t" + (new SimpleDateFormat("yyyy-MM-dd").format(date));
    }

    @Override
    public String toString() {
        return "[Shiba] " + "Name: '" + name + '\'' + ", Age: " + age + ", Pet ID: " + petID;
    }
}
