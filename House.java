import java.util.ArrayList;

/**
 * The House class is a subclass of the Building class
 * It has accessors, methods to move people in/out, and check if a person is a resident.
 */
public class House extends Building {

    private ArrayList < String > residents; // A list of residents living in the house
    private boolean hasDiningRoom; // Indicates if the house has a dining room

    /**
     * Constructs a House instance with the name, address, number of floors,
     * and whether it has a dining room.
     * 
     * @param name
     * @param address
     * @param nFloors
     * @param hasDiningRoom
     */
    public House(String name, String address, int nFloors, boolean hasDiningRoom) {
        super(name, address, nFloors);
        this.residents = new ArrayList < > ();
        this.hasDiningRoom = hasDiningRoom;
        System.out.println("You have built a house: 🏠");
    }

    /**
     * Accessor to get whether the house has a dining rooom. 
     * 
     * @return true if the house has a dining room, false otherwise.
     */
    public boolean getHasDiningRoom() {
        return this.hasDiningRoom;
    }

    /**
     * Accessor to get the number of residents in the house.
     * 
     * @return the number of reidents. 
     */
    public int getNResidents() {
        return this.residents.size();
    }

    /**
     * Adds a resident to the house. If the resident already exists, they will not be added again.
     * 
     * @param name
     */
    public void moveIn(String name) {
        if (!this.residents.contains(name)) {
            this.residents.add(name);
            System.out.println(name + " moved in.");
        } else {
            System.out.println("This resident already exist.");
        }
    }

    /**
     * Removes a resident from the house. Throws an exception if the resident is not found.
     * 
     * @param name
     * @return the name of the resident that moved out.
     * @throws NullPointerException if the person is not a resident. 
     */
    public String moveOut(String name) {
        if (this.residents.contains(name)) {
            System.out.println(name + " moved out.");
            this.residents.remove(name);
            return name;
        } else {
            throw new NullPointerException("There is no resident named " + name);
        }
    }

    /**
     * Checks if a specified person is a resident of the house.
     * 
     * @param person
     * @return true if the person is a resident, false otherwise
     */
    public boolean isResident(String person) {
        return this.residents.contains(person);
    }

    /**
     * The main method tests the program. 
     * 
     * @param args 
     */
    public static void main(String[] args) {
        House ziskind = new House("Ziskind", "1 Henshaw Ave", 3, true);
    }

}