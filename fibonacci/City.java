package fibonacci;

import java.util.UUID;

public class City {
    private String ID= UUID.randomUUID().toString();
    String Name;
    String CountryCode;
    String District;
    int Population;
     City(String nome , String codPost ,String District, int popolazione){
        this.Name = nome;
        this.CountryCode = codPost;
        this.District = District;
        this.Population = popolazione;
     }
    public String getID() {
        return ID;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getCountryCode() {
        return CountryCode;
    }
    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }
    public String getDistrict() {
        return District;
    }
    public void setDistrict(String district) {
        District = district;
    }
    public int getPopulation() {
        return Population;
    }
    public void setPopulation(int population) {
        Population = population;
    }
}
