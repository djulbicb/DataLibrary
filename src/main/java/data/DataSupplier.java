package data;

import java.io.IOException;
import java.util.List;

class EnglishDataSupplier extends DataSupplier {

    public EnglishDataSupplier() {
        try {
            setFirstNameMaleList(ResourceUtility.readLinesFromResources(R.Data.English.list_of_names_male));
            setFirstNameFemaleList(ResourceUtility.readLinesFromResources(R.Data.English.list_of_names_female));
            setLastNameList(ResourceUtility.readLinesFromResources(R.Data.English.list_of_surnames));
            setCityList(ResourceUtility.readLinesFromResources(R.Data.English.list_of_cities));
            setWordsList(ResourceUtility.readLinesFromResources(R.Data.English.list_of_words));
            setStreetList( ResourceUtility.readLinesFromResources(R.Data.English.list_of_street_names));
            setCountry("England");
        } catch (IOException e) {
            throw new RuntimeException("Cant read English data");
        }
    }
}

class RomanianDataSupplier extends DataSupplier {
    public RomanianDataSupplier() {
        try {
            setFirstNameMaleList(ResourceUtility.readLinesFromResources(R.Data.Romania.list_of_names_male));
            setFirstNameFemaleList(ResourceUtility.readLinesFromResources(R.Data.Romania.list_of_names_female));
            setLastNameList(ResourceUtility.readLinesFromResources(R.Data.Romania.list_of_surnames));
            setCityList(ResourceUtility.readLinesFromResources(R.Data.Romania.list_of_cities));
            setWordsList(ResourceUtility.readLinesFromResources(R.Data.Romania.list_of_words));
            setStreetList( ResourceUtility.readLinesFromResources(R.Data.Romania.list_of_street_names));
            setCountry("România");
        } catch (IOException e) {
            throw new RuntimeException("Cant read Romanian data");
        }
    }
}


class SerbianDataSupplier extends DataSupplier {
    public SerbianDataSupplier() {
        try {
            setFirstNameMaleList(ResourceUtility.readLinesFromResources(R.Data.Serbia.list_of_names_male));
            setFirstNameFemaleList(ResourceUtility.readLinesFromResources(R.Data.Serbia.list_of_names_female));
            setLastNameList(ResourceUtility.readLinesFromResources(R.Data.Serbia.list_of_surnames));
            setCityList(ResourceUtility.readLinesFromResources(R.Data.Serbia.list_of_cities));
            setWordsList(ResourceUtility.readLinesFromResources(R.Data.Serbia.list_of_words));
            setStreetList( ResourceUtility.readLinesFromResources(R.Data.Serbia.list_of_street_names));
            setCountry("Srbija");
        } catch (IOException e) {
            throw new RuntimeException("Cant read Serbia data");
        }

    }
}

class FrenchDataSupplier extends DataSupplier {
    public FrenchDataSupplier() {
        try {
            setFirstNameMaleList(ResourceUtility.readLinesFromResources(R.Data.France.list_of_names_male));
            setFirstNameFemaleList(ResourceUtility.readLinesFromResources(R.Data.France.list_of_names_female));
            setLastNameList(ResourceUtility.readLinesFromResources(R.Data.France.list_of_surnames));
            setCityList(ResourceUtility.readLinesFromResources(R.Data.France.list_of_cities));
            setWordsList(ResourceUtility.readLinesFromResources(R.Data.France.list_of_words));
            setStreetList( ResourceUtility.readLinesFromResources(R.Data.France.list_of_street_names));
            setCountry("France");
        } catch (IOException e) {
            throw new RuntimeException("Cant read France data");
        }

    }
}

class GermanDataSupplier extends DataSupplier {
    public GermanDataSupplier() {
        try {
            setFirstNameMaleList(ResourceUtility.readLinesFromResources(R.Data.Germany.list_of_names_male));
            setFirstNameFemaleList(ResourceUtility.readLinesFromResources(R.Data.Germany.list_of_names_female));
            setLastNameList(ResourceUtility.readLinesFromResources(R.Data.Germany.list_of_surnames));
            setCityList(ResourceUtility.readLinesFromResources(R.Data.Germany.list_of_cities));
            setWordsList(ResourceUtility.readLinesFromResources(R.Data.Germany.list_of_words));
            setStreetList( ResourceUtility.readLinesFromResources(R.Data.Germany.list_of_street_names));
            setCountry("Deutschland");
        } catch (IOException e) {
            throw new RuntimeException("Cant read Germany data");
        }

    }
}

abstract class DataSupplier {

    private List<String> firstNameMaleList;
    private List<String> firstNameFemaleList;
    private List<String> lastNameList;
    private List<String> cityList;
    private List<String> streetList;
    private List<String> wordsList;
    private List<String> loremList;
    private String country;

    DataSupplier() {
        try {
            setLoremList( ResourceUtility.readLinesFromResources(R.Data.General.lorem_ipsum));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getStreetList() {
        return streetList;
    }

    protected void setStreetList(List<String> streetList) {
        this.streetList = streetList;
    }

    public List<String> getFirstNameMaleList() {
        return firstNameMaleList;
    }

    protected void setFirstNameMaleList(List<String> firstNameMaleList) {
        this.firstNameMaleList = firstNameMaleList;
    }

    public List<String> getFirstNameFemaleList() {
        return firstNameFemaleList;
    }

    protected void setFirstNameFemaleList(List<String> firstNameFemaleList) {
        this.firstNameFemaleList = firstNameFemaleList;
    }

    public List<String> getLastNameList() {
        return lastNameList;
    }

    protected void setLastNameList(List<String> lastNameList) {
        this.lastNameList = lastNameList;
    }

    public List<String> getCityList() {
        return cityList;
    }

    protected void setCityList(List<String> cityList) {
        this.cityList = cityList;
    }

    public List<String> getWordsList() {
        return wordsList;
    }

    protected void setWordsList(List<String> wordsList) {
        this.wordsList = wordsList;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getLoremList() {
        return loremList;
    }

    public void setLoremList(List<String> loremList) {
        this.loremList = loremList;
    }
}




