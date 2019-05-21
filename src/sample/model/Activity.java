package sample.model;

public class Activity {
    private int id;
    private String name;
    private String location;
    private String contact;
    private String type;
    private Boolean indoor;
    private Boolean outdoor;

<<<<<<< HEAD
    public Activity(int id, String name, String location,String contact, String type, Boolean indoor, Boolean outdoor){
        this.id=id;
        this.name=name;
        this.location=location;
        this.contact=contact;
        this.type=type;
        this.indoor=indoor;
        this.outdoor=outdoor;
=======
    public Activity(int id, String name, String location, String contact, String type, Boolean indoor, Boolean outdoor) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.contact = contact;
        this.type = type;
        this.indoor = indoor;
        this.outdoor = outdoor;
>>>>>>> 9545c106b069d7b1eb592c042483e43de16092cd
    }

    public int getId() {
        return id;
    }

<<<<<<< HEAD
=======
    public void setId(int id) {
        this.id = id;
    }

>>>>>>> 9545c106b069d7b1eb592c042483e43de16092cd
    public String getName() {
        return name;
    }

<<<<<<< HEAD
=======
    public void setName(String name) {
        this.name = name;
    }

>>>>>>> 9545c106b069d7b1eb592c042483e43de16092cd
    public String getLocation() {
        return location;
    }

<<<<<<< HEAD
=======
    public void setLocation(String location) {
        this.location = location;
    }

>>>>>>> 9545c106b069d7b1eb592c042483e43de16092cd
    public String getContact() {
        return contact;
    }

<<<<<<< HEAD
=======
    public void setContact(String contact) {
        this.contact = contact;
    }

>>>>>>> 9545c106b069d7b1eb592c042483e43de16092cd
    public String getType() {
        return type;
    }

<<<<<<< HEAD
=======
    public void setType(String type) {
        this.type = type;
    }

>>>>>>> 9545c106b069d7b1eb592c042483e43de16092cd
    public Boolean getIndoor() {
        return indoor;
    }

<<<<<<< HEAD
    public Boolean getOutdoor() {
        return outdoor;
    }
=======
    public void setIndoor(Boolean indoor) {
        this.indoor = indoor;
    }

    public Boolean getOutdoor() {
        return outdoor;
    }

    public void setOutdoor(Boolean outdoor) {
        this.outdoor = outdoor;
    }
>>>>>>> 9545c106b069d7b1eb592c042483e43de16092cd
}

