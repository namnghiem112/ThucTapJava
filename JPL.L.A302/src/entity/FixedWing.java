package entity;

public class FixedWing {
    private String id;
    private String model;
    private String type; // CAG, LGR, PRV
    private double cruiseSpeed;
    private double emptyWeight;
    private double maxTakeoffWeight;
    private double minNeededRunwaySize;

    public FixedWing(String id, String model, String type, double cruiseSpeed,
                     double emptyWeight, double maxTakeoffWeight, double minNeededRunwaySize) {
        this.id = id;
        this.model = model;
        this.type = type;
        this.cruiseSpeed = cruiseSpeed;
        this.emptyWeight = emptyWeight;
        this.maxTakeoffWeight = maxTakeoffWeight;
        this.minNeededRunwaySize = minNeededRunwaySize;
    }
    public String validateFixedWingId(String id) {
        if (!id.startsWith("FW") || id.length() != 7 || !id.substring(2).matches("\\d{5}")) {
            throw new IllegalArgumentException("Fixed wing airplane ID format is incorrect. It should start with 'FW' followed by 5 digits.");
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
        System.out.println("Flying with fixed wing");
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public double getMinNeededRunwaySize() {
        return minNeededRunwaySize;
    }

    public void setMinNeededRunwaySize(double minNeededRunwaySize) {
        this.minNeededRunwaySize = minNeededRunwaySize;
    }
}
