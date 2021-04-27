public abstract class Canine extends Pet {

    public Canine(int age, String name) {
        super(age, name);
    }

    public Canine(String[] tokens) {
        super(tokens);
    }

    public abstract String toText();
}

