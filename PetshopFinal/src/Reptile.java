public abstract class Reptile extends Pet{

    public Reptile(int age, String name) {
        super(age, name);
    }

    public Reptile(String[] tokens) {
        super(tokens);
    }

    public abstract String toText();
}
