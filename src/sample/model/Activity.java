package sample.model;

public class Activity {
    private int id;
    private String name;
    private String location;
    private String contact;
    private String type;
    private Boolean indoor;
    private Boolean outdoor;

    public Activity(int id, String name, String location, String contact, String type, Boolean indoor, Boolean outdoor) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.contact = contact;
        this.type = type;
        this.indoor = indoor;
        this.outdoor = outdoor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getIndoor() {
        return indoor;
    }

    public void setIndoor(Boolean indoor) {
        this.indoor = indoor;
    }

    public Boolean getOutdoor() {
        return outdoor;
    }

    public void setOutdoor(Boolean outdoor) {
        this.outdoor = outdoor;
    }
}

