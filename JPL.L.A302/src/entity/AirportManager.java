package entity;

import java.util.ArrayList;
import java.util.List;

public class AirportManager {
    private List<Airport> airports;

    public AirportManager() {
        this.airports = new ArrayList<>();
    }

    public void createAirport(String id, String name, int runwaySize, int maxFixedwingParkingPlace, int maxRotatedWingParkingPlace) {
        Airport airport = new Airport();
        try {
            id = airport.validateAirportId(id);

            airport.setId(id);
            airport.setName(name);
            airport.setRunwaySize(runwaySize);
            airport.setMaxFixedwingParkingPlace(maxFixedwingParkingPlace);
            airport.setMaxRotatedWingParkingPlace(maxRotatedWingParkingPlace);

            airports.add(airport);
            System.out.println("Airport " + id + " created successfully");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addFixedWingAirplaneToAirport(String airportId, FixedWing airplane) {
        Airport airport = findAirportById(airportId);
        if (airport != null) {
            try {
                airplane.setId(airplane.validateFixedWingId(airplane.getId()));
                airplane.setModel(airplane.validateModel(airplane.getModel()));
                airport.addFixedWingAirplane(airplane.getId(), airplane.getMinNeededRunwaySize());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Airport " + airportId + " not found");
        }
    }

    public void removeFixedWingAirplaneFromAirport(String airportId, String airplaneId) {
        Airport airport = findAirportById(airportId);
        if (airport != null) {
            airport.removeFixedWingAirplane(airplaneId);
        } else {
            System.out.println("Airport " + airportId + " not found");
        }
    }

    public void addHelicopterToAirport(String airportId, Helicopter helicopter) {
        Airport airport = findAirportById(airportId);
        if (airport != null) {
            try {
                helicopter.setId(helicopter.validateHelicopterId(helicopter.getId()));
                helicopter.setModel(helicopter.validateModel(helicopter.getModel()));
                airport.addHelicopter(helicopter.getId());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Airport " + airportId + " not found");
        }
    }

    public void removeHelicopterFromAirport(String airportId, String helicopterId) {
        Airport airport = findAirportById(airportId);
        if (airport != null) {
            airport.removeHelicopter(helicopterId);
        } else {
            System.out.println("Airport " + airportId + " not found");
        }
    }

    private Airport findAirportById(String airportId) {
        for (Airport airport : airports) {
            if (airport.getId().equals(airportId)) {
                return airport;
            }
        }
        return null;
    }
}
