package net.accounting.Entity;

/**
 * Created by Admin on 08-Dec-16.
 */
public class Address {
    private String Country;
    private String City;
    private String Street;

    Address (String Country, String City, String Street) {
        this.Country = Country;
        this.City = City;
        this.Street = Street;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

}
