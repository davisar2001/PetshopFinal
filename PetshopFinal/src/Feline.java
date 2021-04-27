public abstract class Feline extends Pet {

    public Feline(int age, String name) {
        super(age, name);
    }

    public Feline(String[] tokens) {
        super(tokens);
    }

    public abstract String toText();
}
