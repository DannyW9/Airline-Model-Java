public enum AirportCode {

    GLA("Glasgow", "United Kingdom" ),
    EDI("Edinburgh", "United Kingdom" ),
    LAX("Los Angeles", "United States of America"),
    LHR("London Heathrow", "United Kingdom"),
    CDG("Paris Charles Degaulle", "France"),
    JFK("John F. Kennedy International", "United States of America"),
    SEA("Seattle-Tacoma International", "United States of America"),
    DUB("Dublin", "Ireland"),
    PRG("Prague", "Czech Republic");

    private final String airport;
    private final String country;

    AirportCode(String airport, String country){
        this.airport = airport;
        this.country = country;
    }

    public String getAirport() {
        return this.airport;
    }

    public String getCountry() {
        return this.country;
    }
}
