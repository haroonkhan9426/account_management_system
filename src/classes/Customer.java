package classes;

public class Customer {
    private String name;
    private String address;
    private String phone;

    public Customer(String _name, String _address, String _phone){
        this.name = _name;
        this.address = _address;
        this.phone = _phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String convertToString(){
        return "Customer Name: " + name + "\n" + "Address: " + address + "Phone: " + phone;
    }
}
