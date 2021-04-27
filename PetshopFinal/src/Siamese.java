import java.text.SimpleDateFormat;

public class Siamese extends Feline{

    public Siamese(int age, String name) {
        super(age, name);
    }

    public Siamese(String[] tokens) {
        super(tokens);
    }

    @Override
    public String toText() {
        return "Siamese\t" + name + "\t" + age + "\t" + petID + "\t" + (new SimpleDateFormat("yyyy-MM-dd").format(date));
    }

    @Override
    public String toString() {
        return "[Siamese] " + "Name: '" + name + '\'' + ", Age: " + age + ", Pet ID: " + petID;
    }
}
