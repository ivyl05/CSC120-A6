import java.util.Hashtable;

/**
 * The Library class is a subclass of the Building class
 * It has methods that allow you to add/remove titles, checkout/return items, 
 * and print out the entire collection in the library. 
 */
public class Library extends Building {

    private Hashtable < String, Boolean > collection; // The collection stores the titles and its availability. 

    /**
     * Constructs a library instance with name, address, and number of floors of the library.
     * 
     * @param name
     * @param address
     * @param nFloors
     */
    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors); //what to put in ()
        this.collection = new Hashtable < String, Boolean > ();

        System.out.println("You have built a library: 📖");
    }

    /**
     * This method allows us to add new titles. 
     * If a title already exist, it will not be added again. 
     * 
     * @param title
     */
    public void addTitle(String title) { //exception //do we need to consider having multiple books that are the same? do we need if statement to check?
        if (!this.collection.containsKey(title)) {

            this.collection.put(title, true);
            System.out.println(title + " is added.");
        } else {
            System.out.println("Cannot be added. This title already exist.");
        }

    }

    /**
     * This method allows us to remove a title.
     * 
     * @param title
     * @return the title that was removed
     * @throws NullPointerException if the title does not exist. 
     */
    public String removeTitle(String title) {
        if (this.collection.containsKey(title)) {
            this.collection.remove(title);
            System.out.println(title + " is removed.");
            return title;
        } else {
            throw new NullPointerException("This item does not exist.");
        }
    }

    /**
     * This method allows us to checkout a book.
     * The title will be marked as unavailable if checked out successfully.
     * 
     * @param title
     * @throws NullPointerException if the title does not exist in the collection. 
     */

    public void checkOut(String title) {
        if (this.collection.containsKey(title)) {
            if (this.collection.get(title)) {
                this.collection.put(title, false);
                System.out.println(title + " is checked out successfully.");
            } else {
                System.out.println(title + " is checked out already. Not available for checking out.");
            }
        } else {
            throw new NullPointerException(title + " does not exist.");
        }
    }

    /**
     * This method allows us to return a book.
     * If the book is available in the collection, it cannot be returned again. 
     * 
     * @param title
     * @throws NullPointerException if the title doesn't exist in the collection. 
     */
    public void returnBook(String title) {
        if (this.collection.containsKey(title)) {
            if (!this.collection.get(title)) {
                this.collection.put(title, true);
                System.out.println(title + " is returned.");
            } else {
                System.out.println(title + " is already returned. Not availble for return.");
            }
        } else {
            throw new NullPointerException("This item doesn't exist.");
        }
    }

    /**
     * This method check if a book exist in the collecion. 
     * 
     * @param title
     * @return true if the title appears as a key in the Libary's collection, false otherwise
     */
    public boolean containsTitle(String title) {
        return this.collection.containsKey(title);
    }

    /**
     * This method check if a book is available. 
     * @param title
     * @return true if the book is available, false otherwise
     * @throws NullPointerException if the book doesn't exist in the collection. 
     */
    public boolean isAvailable(String title) {
        if (this.collection.containsKey(title)) {
            return this.collection.get(title);
        } else {
            throw new NullPointerException("This item does not exist.");
        }
    }

    /**
     * This code is AI generated. 
     * This method prints the entire collection of titles with their availability status.
     */
    public void printCollection() {
        for (String title: this.collection.keySet()) {                                  //The for loop access each of the keys of the collection
            String status = this.collection.get(title) ? "Available" : "Checked Out";   //String status will be "available" if this.collection.get(title) return true, and "checked out" if returns false.
            System.out.println(title + ": " + status);                                  //This prints out the title and whether it is available.
        }
    }

    /**
     * The main method tests the program.
     *
     * @param args 
     */
    public static void main(String[] args) {
        Library neilson = new Library("Neilson", "1 ave", 4);
    }

}