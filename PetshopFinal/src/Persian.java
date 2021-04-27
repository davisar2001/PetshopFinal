import java.text.SimpleDateFormat;

public class Persian extends Feline{

    public Persian(int age, String name) {
        super(age, name);
    }

    public Persian(String[] tokens) {
        super(tokens);
    }

    @Override
    public String toText() {
        return "Persian\t" + name + "\t" + age + "\t" + petID + "\t" + (new SimpleDateFormat("yyyy-MM-dd").format(date));
    }

    @Override
    public String toString() {
        return "[Persian] " + "Name: '" + name + '\'' + ", Age: " + age + ", Pet ID: " + petID;
    }
}
