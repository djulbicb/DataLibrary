package data;

import java.io.IOException;
import java.util.List;

class EnglishDataSupplier extends DataSupplier {
    public EnglishDataSupplier() {
        try {
            this.firstNameMaleList = ResourceUtility.readLinesFromResources(R.Data.English.list_of_names_male);
            this.firstNameFemaleList = ResourceUtility.readLinesFromResources(R.Data.English.list_of_names_female);
            this.lastNameList = ResourceUtility.readLinesFromResources(R.Data.English.list_of_surnames);
            this.cityList = ResourceUtility.readLinesFromResources(R.Data.English.list_of_cities);
            this.wordsList = ResourceUtility.readLinesFromResources(R.Data.English.list_of_words);
            this.streetList = ResourceUtility.readLinesFromResources(R.Data.English.list_of_street_names);
            this.country = "England";
        } catch (IOException e) {
            throw new RuntimeException("Cant read English data");
        }
    }
}

class RomanianDataSupplier extends DataSupplier {
    public RomanianDataSupplier() {
        try {
            this.firstNameMaleList = ResourceUtility.readLinesFromResources(R.Data.Romania.list_of_names_male);
            this.firstNameFemaleList = ResourceUtility.readLinesFromResources(R.Data.Romania.list_of_names_female);
            this.lastNameList = ResourceUtility.readLinesFromResources(R.Data.Romania.list_of_surnames);
            this.cityList = ResourceUtility.readLinesFromResources(R.Data.Romania.list_of_cities);
            this.wordsList = ResourceUtility.readLinesFromResources(R.Data.Romania.list_of_words);
            this.streetList = ResourceUtility.readLinesFromResources(R.Data.Romania.list_of_street_names);
            this.country = "România";
        } catch (IOException e) {
            throw new RuntimeException("Cant read Romania data");
        }
    }
}


class SerbianDataSupplier extends DataSupplier {
    public SerbianDataSupplier() {
        try {
            this.firstNameMaleList = ResourceUtility.readLinesFromResources(R.Data.Serbia.list_of_names_male);
            this.firstNameFemaleList = ResourceUtility.readLinesFromResources(R.Data.Serbia.list_of_names_female);
            this.lastNameList = ResourceUtility.readLinesFromResources(R.Data.Serbia.list_of_surnames);
            this.cityList = ResourceUtility.readLinesFromResources(R.Data.Serbia.list_of_cities);
            this.wordsList = ResourceUtility.readLinesFromResources(R.Data.Serbia.list_of_words);
            this.streetList = ResourceUtility.readLinesFromResources(R.Data.Serbia.list_of_street_names);
            this.country = "Srbija";
        } catch (IOException e) {
            throw new RuntimeException("Cant read serbia data");
        }

    }
}

class FrenchDataSupplier extends DataSupplier {
    public FrenchDataSupplier() {
        try {
            this.firstNameMaleList = ResourceUtility.readLinesFromResources(R.Data.France.list_of_names_male);
            this.firstNameFemaleList = ResourceUtility.readLinesFromResources(R.Data.France.list_of_names_female);
            this.lastNameList = ResourceUtility.readLinesFromResources(R.Data.France.list_of_surnames);
            this.cityList = ResourceUtility.readLinesFromResources(R.Data.France.list_of_cities);
            this.wordsList = ResourceUtility.readLinesFromResources(R.Data.France.list_of_words);
            this.streetList = ResourceUtility.readLinesFromResources(R.Data.France.list_of_street_names);
            this.country = "France";
        } catch (IOException e) {
            throw new RuntimeException("Cant read serbia data");
        }

    }
}

class GermanDataSupplier extends DataSupplier {
    public GermanDataSupplier() {
        try {
            this.firstNameMaleList = ResourceUtility.readLinesFromResources(R.Data.Germany.list_of_names_male);
            this.firstNameFemaleList = ResourceUtility.readLinesFromResources(R.Data.Germany.list_of_names_female);
            this.lastNameList = ResourceUtility.readLinesFromResources(R.Data.Germany.list_of_surnames);
            this.cityList = ResourceUtility.readLinesFromResources(R.Data.Germany.list_of_cities);
            this.wordsList = ResourceUtility.readLinesFromResources(R.Data.Germany.list_of_words);
            this.streetList = ResourceUtility.readLinesFromResources(R.Data.Germany.list_of_street_names);
            this.country = "Deutschland";
        } catch (IOException e) {
            throw new RuntimeException("Cant read serbia data");
        }

    }
}

abstract class DataSupplier {

    List<String> firstNameMaleList;
    List<String> firstNameFemaleList;
    List<String> lastNameList;
    List<String> cityList;
    List<String> streetList;
    List<String> wordsList;
    String country;

    DataSupplier(){

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
}




