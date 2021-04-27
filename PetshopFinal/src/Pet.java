import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public abstract class Pet {
    protected static int petStock;
    protected String name;
    protected int age;
    protected int petID;
    protected Date date;

    public Pet(int age, String name) {
        this.age = age;
        this.name = name;
        petID = generatePetID();
        date = new Date();
        petStock++;
    }

    public Pet(String name, int petID, int age, String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        this.age = age;
        this.name = name;
        this.petID = petID;
        this.date = formatter.parse(date);
    }

    public Pet(String name, int age) {
    }

    public Pet(String[] tokens) {
    }

    public int getAge() {
        return age;
    }

    public int getPetStock() {
        return petStock;
    }

    public int getPetID() {
        return petID;
    }

    public int compareTo(Pet that) {
        return this.petID - that.petID;
    }

    public boolean equals(Pet that) {
        return this.petID == that.petID;
    }

    protected abstract String toText();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet that = (Pet) o;
        return petID == that.petID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(petID);
    }

    private int generatePetID() {
        return (int) (Math.random() * 900000000) + 100000000;
    }
}