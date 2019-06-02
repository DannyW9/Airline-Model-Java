import java.util.ArrayList;

public class FlightManager {

    public int reservedBagWeight(Flight flight) {
        return (flight.getPlane().getTotalWeight()) / 2;
    }

    public int calculateBagWeight(Flight flight) {
        return reservedBagWeight(flight) / flight.getPlane().getCapacity();
    }

    public int bookedBagWeight(Flight flight) {
        int totalBagWeight = 0;
        for (Passenger passenger : flight.getPassengerList()) {
            totalBagWeight += (passenger.getBags() * calculateBagWeight(flight));
        }
        return totalBagWeight;
    }

    public int remainingBagWeight(Flight flight) {
        return reservedBagWeight(flight) - bookedBagWeight(flight);
    }

    public void bookPassengerOnFlight(Flight flight, Passenger passenger){
        if (passenger.getBags() * calculateBagWeight(flight) <= remainingBagWeight(flight)){
            flight.bookPassenger(passenger);
        }
    }

    public ArrayList<Passenger> sortPassengersBySeatNumber(Flight flight) {
        int n = flight.getPassengerList().size();
        Passenger temp = null;
        ArrayList<Passenger> arr = flight.getPassengerList();

        for (int x = 0; x < n; x++) {
            for (int y = 1; y < n; y++) {
                if (arr.get(y-1).getSeatNumber() > arr.get(y).getSeatNumber()){
                    temp = arr.get(y-1);
                    arr.set(y-1, arr.get(y));
                    arr.set(y, temp);
                }
            }
        }
        return arr;
    }

    public Passenger findPassengerBySeatNumber(ArrayList<Passenger> passengers, int seatNumber) {
        ArrayList<Passenger> newSearchArray;
        int middleIndex = 0;
        int middleValue = passengers.get(middleIndex).getSeatNumber();

        if (passengers.size() == 0) {
            return null;
        }
        if (passengers.size() > 1) {
            middleIndex = passengers.size() / 2;
        }
        if (seatNumber == middleValue) {
            return passengers.get(middleIndex);
        }

        if (seatNumber < middleValue) {
            newSearchArray = new ArrayList<Passenger>(passengers.subList(0, middleIndex));
        } else {
            newSearchArray = new ArrayList<Passenger>(passengers.subList(middleIndex + 1, passengers.size()));
        }
        return findPassengerBySeatNumber(newSearchArray, seatNumber);
    }

}

