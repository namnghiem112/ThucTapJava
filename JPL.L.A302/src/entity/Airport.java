package entity;

import java.util.ArrayList;
import java.util.List;

public class Airport {
    private String id;
    private String name;
    private int runwaySize;
    private int maxFixedwingParkingPlace;
    private List<String> fixedwingAirplaneIds;
    private int maxRotatedWingParkingPlace;
    private List<String> helicopterIds;
    public String validateAirportId(String id) {
        if (!id.startsWith("AP") || id.length() != 7 || !id.substring(2).matches("\\d{5}")) {
            throw new IllegalArgumentException("Airport ID format is incorrect. It should start with 'AP' followed by 5 digits.");
        }
        // Additional validation if needed
        return id;
    }

    public Airport() {
    }

    public Airport(String id, String name, int runwaySize, int maxFixedwingParkingPlace, int maxRotatedWingParkingPlace) {
        this.id = id;
        this.name = name;
        this.runwaySize = runwaySize;
        this.maxFixedwingParkingPlace = maxFixedwingParkingPlace;
        this.maxRotatedWingParkingPlace = maxRotatedWingParkingPlace;
        this.fixedwingAirplaneIds = new ArrayList<>();
        this.helicopterIds = new ArrayList<>();
    }

    public void addFixedWingAirplane(String airplaneId, double minNeededRunwaySize) {
        if (!fixedwingAirplaneIds.contains(airplaneId) && minNeededRunwaySize <= runwaySize) {
            fixedwingAirplaneIds.add(airplaneId);
            System.out.println("Fixed wing airplane " + airplaneId + " added to airport " + id);
        } else {
            System.out.println("Unable to add fixed wing airplane " + airplaneId);
        }
    }

    public void removeFixedWingAirplane(String airplaneId) {
        if (fixedwingAirplaneIds.remove(airplaneId)) {
            System.out.println("Fixed wing airplane " + airplaneId + " removed from airport " + id);
        } else {
            System.out.println("Unable to remove fixed wing airplane " + airplaneId);
        }
    }

    public void addHelicopter(String helicopterId) {
        if (!helicopterIds.contains(helicopterId)) {
            helicopterIds.add(helicopterId);
            System.out.println("Helicopter " + helicopterId + " added to airport " + id);
        } else {
            System.out.println("Helicopter " + helicopterId + " already exists in airport " + id);
        }
    }

    public void removeHelicopter(String helicopterId) {
        if (helicopterIds.remove(helicopterId)) {
            System.out.println("Helicopter " + helicopterId + " removed from airport " + id);
        } else {
            System.out.println("Unable to remove helicopter " + helicopterId);
        }
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRunwaySize() {
        return runwaySize;
    }

    public void setRunwaySize(int runwaySize) {
        this.runwaySize = runwaySize;
    }

    public int getMaxFixedwingParkingPlace() {
        return maxFixedwingParkingPlace;
    }

    public void setMaxFixedwingParkingPlace(int maxFixedwingParkingPlace) {
        this.maxFixedwingParkingPlace = maxFixedwingParkingPlace;
    }

    public List<String> getFixedwingAirplaneIds() {
        return fixedwingAirplaneIds;
    }

    public void setFixedwingAirplaneIds(List<String> fixedwingAirplaneIds) {
        this.fixedwingAirplaneIds = fixedwingAirplaneIds;
    }

    public int getMaxRotatedWingParkingPlace() {
        return maxRotatedWingParkingPlace;
    }

    public void setMaxRotatedWingParkingPlace(int maxRotatedWingParkingPlace) {
        this.maxRotatedWingParkingPlace = maxRotatedWingParkingPlace;
    }

    public List<String> getHelicopterIds() {
        return helicopterIds;
    }

    public void setHelicopterIds(List<String> helicopterIds) {
        this.helicopterIds = helicopterIds;
    }
}