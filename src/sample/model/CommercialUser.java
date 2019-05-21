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
}
