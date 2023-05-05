package realEstate.classes;

public class Land extends Property implements Image {
    String shape;
    String zoning;
    String natural_feature;
    String soil_type;

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getZoning() {
        return zoning;
    }

    public void setZoning(String zoning) {
        this.zoning = zoning;
    }

    public String getNatural_feature() {
        return natural_feature;
    }

    public void setNatural_feature(String natural_feature) {
        this.natural_feature = natural_feature;
    }

    public String getSoil_type() {
        return soil_type;
    }

    public void setSoil_type(String soil_type) {
        this.soil_type = soil_type;
    }

    public Land(String district, String location, String country, String type, String availability, Integer propertyID, String landArea, String status, String shape, String zoning, String natural_feature, String soil_type) {
        super(district, location, country, type, availability, propertyID, landArea, status);
        this.shape = shape;
        this.zoning = zoning;
        this.natural_feature = natural_feature;
        this.soil_type = soil_type;
    }

    public Land() {

    }

    public void addImage() {

    }

    public void editImage() {

    }

    public void removeImage() {

    }
}
