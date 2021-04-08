package DesignPatterns.Lab.P01Singleton;

public class Address implements Clone<Address>{
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String city;
    private String country;
    private String state;
    private String line1;
    private String line2;
    private String postalCode;

    public Address(){}

    public static class Builder{
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String city;
        private String country;
        private String state;
        private String line1;
        private String line2;
        private String postalCode;

        public static Builder get(){
            return new Builder();
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Builder withCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder withState(String state) {
            this.state = state;
            return this;
        }

        public Builder withLine1(String line1) {
            this.line1 = line1;
            return this;
        }

        public Builder withLine2(String line2) {
            this.line2 = line2;
            return this;
        }

        public Builder withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Address build(){
            return new Address()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setCity(city)
                    .setCountry(country)
                    .setEmail(email)
                    .setPhone(phone)
                    .setState(state)
                    .setLine1(line1)
                    .setLine2(line2)
                    .setPostalCode(postalCode);
        }
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public String getState() {
        return this.state;
    }

    public String getLine1() {
        return this.line1;
    }

    public String getLine2() {
        return this.line2;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public Address setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Address setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Address setEmail(String email) {
        this.email = email;
        return this;
    }

    public Address setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public Address setCountry(String country) {
        this.country = country;
        return this;
    }

    public Address setState(String state) {
        this.state = state;
        return this;
    }

    public Address setLine1(String line1) {
        this.line1 = line1;
        return this;
    }

    public Address setLine2(String line2) {
        this.line2 = line2;
        return this;
    }

    public Address setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    @Override
    public String toString() {
        return "Address{" +
                "firstName = " + firstName +
                ", lastName = " + lastName +
                ", email = " + email +
                ", phone = " + phone +
                ", city = " + city +
                ", country = " + country +
                ", state = " + state +
                ", line1 = " + line1 +
                ", line2 = " + line2 +
                ", postalCode = " + postalCode;
    }

    @Override
    public Address clone(){
        return new Address()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setCity(city)
                .setCountry(country)
                .setEmail(email)
                .setPhone(phone)
                .setState(state)
                .setLine1(line1)
                .setLine2(line2)
                .setPostalCode(postalCode);
    }
}
