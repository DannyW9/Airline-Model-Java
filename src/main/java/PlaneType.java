public enum PlaneType {

    BOEING747(5, 20),
    AIRBUS340(10, 50),
    BEECHCRAFT1900(3, 10),
    CREATIVEPLANENAMEFORTESTINGSEARCH(5, 100);

    private final int capacity;
    private final int totalWeight;

    PlaneType(int capacity, int totalWeight){
        this.capacity = capacity;
        this.totalWeight = totalWeight;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getTotalWeight() {
        return this.totalWeight;
    }
}
