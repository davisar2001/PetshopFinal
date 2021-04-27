import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class PetTeller {

    private static final Petshop petshop = new Petshop(8);

        public static void main(String[] args) {
            ArrayList<Pet> stock = new ArrayList<>();
            char command = 0;
            int petID = 0;
            String filename = "";
            Scanner input = new Scanner(System.in);
            printMenu();
            do {
                // ask a user to choose a command
                System.out.println("\nPlease enter a command or type ?");
                command = input.nextLine().toLowerCase().charAt(0);

                switch (command) {
                    case 'a': // add a pet
                        int petType = -1;
                        while (petType < 1 || petType > 2) { //ask for user to pick from 3 species
                            System.out.print("\nEnter 1 for Canine, Enter 2 for Feline, Enter 3 for Reptile: ");
                            petType = Integer.parseInt(input.nextLine());
                            Pet a = null;
                            if (petType == 1) {
                                int dogBreed; //ask user to pick a dog breed
                                System.out.println("Enter 1 for GermShepard, Enter 2 for Pug, Enter 3 for Shiba");
                                dogBreed = Integer.parseInt(input.nextLine());
                                if (dogBreed == 1) {
                                    System.out.print("Enter pet name: ");
                                    String name = input.nextLine();
                                    System.out.print("Enter pet age: ");
                                    int age = input.nextInt();
                                    input.nextLine();
                                    a = new GermShepard(age, name) {
                                    }; //add new german shepard canine
                                }
                                if (dogBreed == 2) {
                                    System.out.print("Enter pet name: ");
                                    String name = input.nextLine();
                                    System.out.print("Enter pet age: ");
                                    int age = input.nextInt();
                                    input.nextLine();
                                    a = new Pug(age, name) {
                                    }; //add new pug canine
                                }
                                if (dogBreed == 3) {
                                    System.out.print("Enter pet name: ");
                                    String name = input.nextLine();
                                    System.out.print("Enter pet age: ");
                                    int age = input.nextInt();
                                    input.nextLine();
                                    a = new Shiba(age, name) {
                                    }; //add new shiba canine
                                }
                            }
                            if (petType == 2) {
                                int catBreed = 0; //ask user to pick a cat breed
                                System.out.println("Enter 1 for Siamese, Enter 2 for Persian");
                                catBreed = Integer.parseInt(input.nextLine());
                                if (catBreed == 1) {
                                    System.out.print("Enter pet name: ");
                                    String name = input.nextLine();
                                    System.out.print("Enter pet age: ");
                                    int age = input.nextInt();
                                    input.nextLine();
                                    a = new Siamese(age, name) {
                                    }; //add new siamese feline
                                }
                                if (catBreed == 2) {
                                    System.out.print("Enter pet name: ");
                                    String name = input.nextLine();
                                    System.out.print("Enter pet age: ");
                                    int age = input.nextInt();
                                    input.nextLine();
                                    a = new Persian(age, name) {
                                    }; //add new persian feline
                                }
                            }
                            if (petType == 3) {
                                int repBreed = 0; //ask user to pick a kind of reptile
                                System.out.println("Enter 1 for Lizard, Enter 2 for Snake, Enter 3 for Turtle");
                                repBreed = Integer.parseInt(input.nextLine());
                                if (repBreed == 1) {
                                    System.out.print("Enter pet name: ");
                                    String name = input.nextLine();
                                    System.out.print("Enter pet age: ");
                                    int age = input.nextInt();
                                    input.nextLine();
                                    a = new Lizard(age, name) {
                                    }; //add new lizard reptile
                                }
                                if (repBreed == 2) {
                                    System.out.print("Enter pet name: ");
                                    String name = input.nextLine();
                                    System.out.print("Enter pet age: ");
                                    int age = input.nextInt();
                                    input.nextLine();
                                    a = new Snake(age, name) {
                                    }; //add new snake reptile
                                }
                                if (repBreed == 3) {
                                    System.out.print("Enter pet name: ");
                                    String name = input.nextLine();
                                    System.out.print("Enter pet age: ");
                                    int age = input.nextInt();
                                    input.nextLine();
                                    a = new Turtle(age, name) {
                                    }; //add new turtle reptile
                                }
                            }
                            if (petshop.add(a)) System.out.print("\nPet successfully added.\n"); //display message when pet is added successfully
                            else System.out.print("Pet could not be added. No duplicates please.\n"); //display message if pet cannot be added
                            break;
                        }
                        break;
                    case 'b': // remove a pet
                        System.out.print("\nEnter petID: ");
                        petID = Integer.parseInt(input.nextLine());
                        if (petshop.remove(petshop.find(petID))) //remove pet according to petID
                            System.out.print("\nPet successfully removed.\n"); //pet removed message
                        else System.out.print("Pet was not found. Cannot remove.\n"); //cannot be found or unable to remove message
                        break;

                    case 'c': // display pets
                        System.out.println(petshop.toString()); //display all pets
                        break;

                    case 'd': // count pets
                        System.out.println("\nThere are " + petshop.getCount() + " Pets in the Petshop"); //display pet count
                        break;

                    case 'e': // sort pets
                        petshop.sort(); //use sort class to sort the pets
                        System.out.println("Pets sorted."); //display message after sort
                        break;

                    case 'f': // read from file
                        System.out.println("Enter file name to read: ");
                        filename = input.nextLine();
                        int numberRead = 0;
                        try { //imports file after user inputs file name
                            numberRead = readPets(filename);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        System.out.println(numberRead + " pets successfully imported."); //displays message after file is imported
                        break;

                    case 'g': // write to file
                        System.out.println("Enter file name to write: ");
                        filename = input.nextLine();
                        int numberWritten = 0;
                        try { //exports written file under the name inputted by user
                            numberWritten = petshop.writePets(filename);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        System.out.println(numberWritten + " pets successfully exported."); //displays message after file is exported
                        break;

                    case '?':
                        printMenu(); //reprints the menu
                        break;
                    case 'q':
                        System.out.println("GOOD BYE!"); //display message shown after the user quits
                        break;
                    default:
                        System.out.println("Invalid Input"); //default display message
                }

            } while (command != 'q'); //prompts the program to only end if the user quits

            input.close(); //closes the program after user selects 'q' to quit
        }

        public static void printMenu() { //prints off all options from the cases
            System.out.print("\nPet Teller Options\n"
                    + "______________________________________\n"
                    + "a: add a pet from the petshop\n"
                    + "b: remove a pet from the petshop\n"
                    + "c: display pets in the petshop\n"
                    + "d: count the pets in the petshop\n"
                    + "e: sort the pets in the petshop\n"
                    + "f: read pets from file\n"
                    + "g: save all pets to file\n"
                    + "?: display the menu again\n"
                    + "q: quit this program\n");
        } // end of the printMenu method


        public static int readPets(String filename) throws FileNotFoundException {
            Scanner fileScan = new Scanner(filename);
            int count = 0;
            while (fileScan.hasNext()) {
                String line = fileScan.nextLine();
                try {
                    petshop.add(parsePet(line));
                    count++;
                } catch (PetFileFormatException e) {
                    System.out.println("Bad pet info, line skipped"); //display message if PetFileFormatException is present
                } catch (ParseException e) {
                    System.out.println("Invalid info format detected, line skipped."); //display message if ParseException is present
                }
            }
            fileScan.close(); //closes the scanner
            return count;
        }

        public static Pet parsePet(String data) throws PetFileFormatException, ParseException {
            String[] tokens = data.split("\t");
            if (tokens.length != 5) throw new PetFileFormatException("Pet data format invalid");
            if (tokens[0].equals("GermShepard")) {
                return new GermShepard(tokens) {
                };
            }
            if (tokens[0].equals("Pug")) {
                return new Pug(tokens) {
                };
            }
            if (tokens[0].equals("Shiba")) {
                return new Shiba(tokens) {
                };
            }
            if (tokens[0].equals("Siamese")) {
                return new Siamese(tokens) {
                };
            }
            if (tokens[0].equals("Persian")) {
                return new Persian(tokens) {
                };
            }
            if (tokens[0].equals("Lizard")) {
                return new Lizard(tokens) {
                };
            }
            if (tokens[0].equals("Snake")) {
                return new Snake(tokens) {
                };
            }
            if (tokens[0].equals("Turtle")) {
                return new Turtle(tokens) {
                };
            } return null;
        }
    }
