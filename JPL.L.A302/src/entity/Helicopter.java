package entity;

public class Helicopter {
    private String id;
    private String model;
    private double cruiseSpeed;
    private double emptyWeight;
    private double maxTakeoffWeight;
    private double range;

    public Helicopter(String id, String model, double cruiseSpeed,
                      double emptyWeight, double maxTakeoffWeight, double range) {
        this.id = id;
        this.model = model;
        this.cruiseSpeed = cruiseSpeed;
        this.emptyWeight = emptyWeight;
        this.maxTakeoffWeight = maxTakeoffWeight;
        this.range = range;
    }
    public String validateHelicopterId(String id) {
        if (!id.startsWith("RW") || id.length() != 7 || !id.substring(2).matches("\\d{5}")) {
            throw new IllegalArgumentException("Helicopter ID format is incorrect. It should start with 'RW' followed by 5 digits.");
        }
        // Additional validation if needed
        return id;
    }

    public String validateModel(String model) {
        if (model.length() > 40) {
            throw new IllegalArgumentException("Model name exceeds maximum length of 40 characters.");
        }
        // Additional validation if needed
        return model;
    }
    public void fly() {
        System.out.println("Flying with rotated wing");
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getCruiseSpeed() {
        return cruiseSpeed;
    }

    public void setCruiseSpeed(double cruiseSpeed) {
        this.cruiseSpeed = cruiseSpeed;
    }

    public double getEmptyWeight() {
        return emptyWeight;
    }

    public void setEmptyWeight(double emptyWeight) {
        this.emptyWeight = emptyWeight;
    }

    public double getMaxTakeoffWeight() {
        return maxTakeoffWeight;
    }

    public void setMaxTakeoffWeight(double maxTakeoffWeight) {
        this.maxTakeoffWeight = maxTakeoffWeight;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }
}
