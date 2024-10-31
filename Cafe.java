/**
 * The Cafe class is a subclass of the Building Class. It sells coffeee and restocks inventory if needed.
 */
public class Cafe extends Building {
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Constructs a Cafe instance
     * 
     * @param name
     * @param address
     * @param nFloors
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) { //Do we pass in these values? 
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * This method sells a cup of coffee 
     * If there is insufficient inventory, it will attempt to restock.
     * 
     * @param size Coffe size
     * @param nSugarPackets number of sugar packets
     * @param nCreams amount of cream
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces >= size && this.nSugarPackets >= nSugarPackets &&
            this.nCreams >= nCreams && this.nCups > 0) {
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups--;
            System.out.println("Coffee sold!");
        } else {
            System.out.println("Not enough inventory to sell coffee. Restocking...");
            restock(size, nSugarPackets, nCreams, 1);
        }
    }

    /**
     * Restocks the cafe's inventory 
     * 
     * @param nCoffeeOunces amount of coffee
     * @param nSugarPackets number of sugar packets
     * @param nCreams amout of cream
     * @param nCups number of cups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * The main method tests the program.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Cafe compass = new Cafe("Compass", "1 ave", 1, 100, 20, 10, 10);
    }

}