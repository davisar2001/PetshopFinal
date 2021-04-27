import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Petshop {
    public static Petshop petshop;
    private Pet[] pets;
    private int count;

    public Petshop(int cap) {
        pets = new Pet[cap];
        count = 0;
    }

    public boolean add(Pet a) {
        if (contains(a)) return false;
        if (full()) doubleCapacity();
        pets[count++] = a;
        return true;
    }

    public boolean contains(Pet a) {
        return indexOf(a) != -1;
    }

    public boolean remove(Pet a) {
        if (!contains(a)) return false;
        pets[indexOf(a)] = pets[--count];
        return true;
    }

    public Pet find(int pet) {
        for (int i = 0; i < count; i++)
            if (pets[i].getPetID() == pet) return pets[i];
        return null;
    }

    public int getCount() {
        return count;
    }

    private int indexOf(Pet a) {
        if (a == null) return -1;
        for (int i = 0; i < count; i++)
            if (pets[i].equals(a)) return i;
        return -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pets\n");
        for (int i = 0; i < count; i++) {
            sb.append(pets[i].toString());
            sb.append("\n    **************    \n");
        }
        return sb.toString();
    }

    public void sort() {
        for (int i = 1; i < count; i++) {
            Pet temp = pets[i];
            int j;
            for (j = i - 1; j >= 0 && less(temp, pets[j]); j--) {
                pets[j + 1] = pets[j];
            }
            pets[j + 1] = temp;
        }
    }

    private void doubleCapacity() {
        Pet[] a = new Pet[pets.length * 2];
        System.arraycopy(pets, 0, a, 0, count);
        pets = a;
    }

    private boolean less(Pet temp, Pet j) {
        return temp.getPetID() < j.getPetID();
    }

    private boolean full() {
        return count == pets.length;
    }

    public int writePets(String filename) throws FileNotFoundException {
        int petNum = 0;

        File file = new File(filename);
        PrintWriter output = new PrintWriter(file);

        for (Pet pet : pets) {
            output.println(pet.toText());
            petNum++;
        }
        output.close();
        return petNum;
    }
}
