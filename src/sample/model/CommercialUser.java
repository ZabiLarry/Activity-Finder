package sample.model;

public class CommercialUser extends User {
    private String name;
    private String phoneNumber;
    private String address;

    public CommercialUser(String email, int id, String name, String phoneNumber, String address) {
        super(email, id);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
