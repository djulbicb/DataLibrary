package data;

import java.util.ArrayList;
import java.util.List;

public class DataCountry {
    private String country;
    private String city;
    private List<String> cities;

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public DataCountry() {
        this.cities = new ArrayList<>();
    }

    public DataCountry(String country, String city) {
        this.country = country;
        this.city = city;
        this.cities = new ArrayList<>();
    }

    public DataCountry(String country, String city, List<String> cities) {
        this.country = country;
        this.city = city;
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "DataCountry{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", cities=" + cities +
                '}';
    }
}
