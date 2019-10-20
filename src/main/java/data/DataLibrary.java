package data;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DataLibrary implements IDataLibrary {

    private final DataSupplier data;
    private final DataCountryService dataCountryService;
    private final Random random = new Random();

    private DataLibrary(DataSupplier data){
        this.data = data;
        dataCountryService = new DataCountryService();
    }

    public static DataLibrary getSerbianData() {
        return new DataLibrary(new SerbianDataSupplier());
    }

    public static DataLibrary getEnglishData() {
        return new DataLibrary(new EnglishDataSupplier());
    }

    public static DataLibrary getRomanianData() {
        return new DataLibrary(new RomanianDataSupplier());
    }

    public static DataLibrary getFrenchData() { return new DataLibrary(new FrenchDataSupplier()); }

    public static DataLibrary getGermanData() {
        return new DataLibrary(new GermanDataSupplier());
    }

    @Override
    public String getFirstNameMale() {
        List<String> firstNameMaleList = data.firstNameMaleList;
        return firstNameMaleList.get(random.nextInt(firstNameMaleList.size()));
    }

    @Override
    public String getFirstNameFemale() {
        List<String> firstNameFemaleList = data.firstNameFemaleList;
        return firstNameFemaleList.get(random.nextInt(firstNameFemaleList.size()));
    }

    @Override
    public String getFirstNameRandom() {
        if (random.nextBoolean()){
            return getFirstNameMale();
        }else{
            return getFirstNameFemale();
        }
    }

    @Override
    public String getLastName() {
        List<String> lastNameList = data.lastNameList;
        return lastNameList.get(random.nextInt(lastNameList.size()));
    }

    @Override
    public List<DataCountry> getCountries() {
        return dataCountryService.getCountryList();
    }

    @Override
    public DataCountry getCountryRandom() {
        return getCountries().get(random.nextInt(getCountries().size()));
    }

    @Override
    public int getInt(int bound) {
        return random.nextInt(bound);
    }

    @Override
    public int getInt(int minBound, int maxBound) {
       return getNumberInRange(minBound, maxBound);
    }

    @Override
    public int getAgeTeen() {
        return getNumberInRange(13, 18);
    }

    @Override
    public int getAgeMinor() {
        return getNumberInRange(0, 18);
    }

    @Override
    public int getAgeAdult() {
        return getNumberInRange(18, 80);
    }

    @Override
    public int getAgeChild() {
        return getNumberInRange(0, 10);
    }

    @Override
    public double getDouble(double bound) {
        return getNumberInRange(0, bound);
    }

    @Override
    public double getDouble(double minBound, double maxBound) {
        return getNumberInRange(minBound, maxBound);
    }

    @Override
    public String getImgUrlRandom(int size) {
        return getFinalRedirectedURL(getImgUrlRandomId(size));
    }

    @Override
    public String getImgUrlRandom(int sizeX, int sizeY) {
        return getFinalRedirectedURL(getImgUrlRandomId(sizeX, sizeY));
    }

    @Override
    public String getImgUrlRandomId(int size) {
        return "https://picsum.photos/" + size;
    }

    @Override
    public String getImgUrlRandomId(int sizeX, int sizeY) {
        return "https://picsum.photos/" + sizeX + "/" + sizeY;
    }

    private static String getFinalRedirectedURL(String url) {
        try {
            URLConnection con = new URL( url ).openConnection();
            con.connect();
            InputStream is = con.getInputStream();
            is.close();
            return con.getURL().toString();
        }catch (Exception e){
            return "";
        }
    }

    @Override
    public String getStreetAddresse() {
        List<String> streetList = data.streetList;
        return streetList.get(random.nextInt(streetList.size())) + " " + getInt(1,100);
    }

    @Override
    public String getCity() {
        List<String> cityList = data.cityList;
        return cityList.get(random.nextInt(cityList.size()));
    }

    @Override
    public String getWord() {
        List<String> wordsList = data.wordsList;
        return wordsList.get(random.nextInt(wordsList.size()));
    }

    @Override
    public String getSentence() {
        return getSentence(10);
    }

    @Override
    public String getSentence(int count) {
        int wordCount = getInt(4, count);
        StringBuilder sb = new StringBuilder();

        // Randomly capitalize words
        for (int i = 0; i < wordCount; i++) {
            String word = getWord();
            if (random.nextInt(10) < 3){
                word = capitalizeString(word);
            }
            sb.append(word);
            sb.append(" ");
        }

        String s = sb.toString().trim().concat(".");
        s = s.substring(0,1).toUpperCase() + s.substring(1);
        return s;
    }

    /**
     * Paragraph in average has 3-8 sentences. This creates 5 sentences by default
     */
    @Override
    public String getParagraph() {
        return getParagraph(5);
    }

    @Override
    public String getParagraph(int count) {
        int sentenceCount = getInt(3, count);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            String sentence = getSentence();
            sb.append(sentence);
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    @Override
    public String getCountry() {
        return data.getCountry();
    }

    private int getNumberInRange(int minBound, int maxBound){
        return ThreadLocalRandom.current().nextInt(minBound, maxBound + 1);
    }

    private double getNumberInRange(double minBound, double maxBound){
        return ThreadLocalRandom.current().nextDouble(minBound, maxBound + 1);
    }

    private String capitalizeString(String str){
        String firstChar = "";
        String restOfWord = "";

        if (str.length() > 0){
            firstChar = str.toUpperCase().charAt(0) + "";
        }
        if (str.length() > 0){
            restOfWord = str.substring(1).toLowerCase();
        }
        return firstChar + restOfWord;
    }

}
