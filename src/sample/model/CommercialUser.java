package sample.model;

public class CommercialUser extends User {
    private String name;
    private String phoneNumber;
    private String address;

    public CommercialUser(String name, String email, String name1, String phoneNumber, String address) {
        super(name, email);
        this.name = name1;
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
