package model;

public class Customer {
    String name;
    String address;
    String mobileNo;

    @Override
    public String toString() {
        return "model.Customer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer(String name, String address, String mobileNo){
        this.name=name;
        this.address=address;
        this.mobileNo=mobileNo;
    }
}
