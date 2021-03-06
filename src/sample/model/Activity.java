package sample.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sample.utils.DatabaseConnection;

public class Activity {
    private int id;
    private StringProperty name;
    private StringProperty location;
    private StringProperty contact;
    private StringProperty type;
    private Byte indoor;
    private Byte outdoor;

    public Activity(int id,String name, String location, String contact, String type, byte indoor, byte outdoor) {
        this.id = id;
        this.name = new SimpleStringProperty(name);
        this.location = new SimpleStringProperty(location);
        this.contact = new SimpleStringProperty(contact);
        this.type = new SimpleStringProperty(type);
        this.indoor = indoor;
        this.outdoor = outdoor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getID() {
        DatabaseConnection db = new DatabaseConnection();
        return db.getActivityID(getName(), getType());
    }


    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getLocation() {
        return location.get();
    }

    public void setLocation(String value) {
        location.set(value);
    }

    public String getContact() {
        return contact.get();
    }

    public void setContact(String value) {
        contact.set(value);
    }


    public Byte getIndoor() {
        return indoor;
    }

    public Byte getOutdoor() {
        return outdoor;
    }

    public void setIndoor(Byte indoor) {
        this.indoor = indoor;
    }

    public void setOutdoor(Byte outdoor) {
        this.outdoor = outdoor;
    }


    public StringProperty locationProperty() {
        return location;
    }

    public StringProperty contactProperty() {
        return contact;
    }


    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    private String getActivityPlace(){
        if(indoor==1){
            return "indoor";
        }
        return "outdoor";
    }

    @Override
    public String toString() {
        return "Activity Name " + getName() + "\n" +
                "Location: " + getLocation() + "\n" +
                "Contact: " + getContact() + "\n" +
                "Type: "  + getType() + "\n" +
                "Indoor/outdoor: " + getActivityPlace();
    }
}

