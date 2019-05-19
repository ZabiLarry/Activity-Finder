package sample.model;

public class Activity {
    private int id;
    private String name;
    private String location;
    private String contact;
    private String type;
    private Boolean indoor;
    private Boolean outdoor;

    public Activity(int id, String name, String location,String contact, String type, Boolean indoor, Boolean outdoor){
        this.id=id;
        this.name=name;
        this.location=location;
        this.contact=contact;
        this.type=type;
        this.indoor=indoor;
        this.outdoor=outdoor;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getContact() {
        return contact;
    }

    public String getType() {
        return type;
    }

    public Boolean getIndoor() {
        return indoor;
    }

    public Boolean getOutdoor() {
        return outdoor;
    }
}
