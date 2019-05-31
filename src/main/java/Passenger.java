public class Passenger {

    private String name;
    private int noOfBags;

    public Passenger(String name, int noOfBags) {
        this.name = name;
        this.noOfBags = noOfBags;
    }

    public String getName() {
        return this.name;
    }

    public int getBags() {
        return this.noOfBags;
    }
}
