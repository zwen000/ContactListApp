package data;

import javafx.beans.property.SimpleStringProperty;

public class contact implements Comparable<contact> {
    private SimpleStringProperty firstName = new SimpleStringProperty("");
    private SimpleStringProperty lastName = new SimpleStringProperty("") ;
    private SimpleStringProperty email = new SimpleStringProperty("") ;
    private SimpleStringProperty PhoneNumber = new SimpleStringProperty("") ;

    public contact() {
        this("","","","");
    }

    public contact(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.email.set(email);
        this.PhoneNumber.set(phoneNumber);
    }


    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPhoneNumber() {
        return PhoneNumber.get();
    }

    public SimpleStringProperty phoneNumberProperty() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber.set(phoneNumber);
    }



    @Override
    public String toString() {
        return firstName.get() + " " + lastName.get() ;
    }

    @Override
    public int compareTo(contact o) {
        return (this.getLastName().toLowerCase()).compareTo(o.getLastName().toLowerCase());
    }
}
