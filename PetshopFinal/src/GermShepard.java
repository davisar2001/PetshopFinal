import java.text.SimpleDateFormat;

public class GermShepard extends Canine{

    public GermShepard(int age, String name) {
        super(age, name);
    }

    public GermShepard(String[] tokens) {
        super(tokens);
    }

    @Override
    public String toText() {
        return "GermShepard\t" + name + "\t" + age + "\t" + petID + "\t" + (new SimpleDateFormat("yyyy-MM-dd").format(date));
    }

    @Override
    public String toString() {
        return "[GermShepard] " + "Name: '" + name + '\'' + ", Age: " + age + ", Pet ID: " + petID;
    }
}
