package data;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

class DataCountryService extends JsonResourceReader<DataCountry[]> {

    private List<DataCountry> countryList;
    private final Random random = new Random();

    public DataCountryService() {
        DataCountry[] dataCountries = readConfig(DataCountry[].class);
        countryList = Arrays.asList(dataCountries);
    }

    public List<DataCountry> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<DataCountry> countryList) {
        this.countryList = countryList;
    }

    @Override
    public String getResourceFilePath() {
        return R.Data.General.list_of_countries_cities_and_capital;
    }

    public DataCountry getCountryRandom() {
        return countryList.get(random.nextInt(countryList.size()));
    }
}
