package data;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DataLibrary implements IDataLibrary {

    private final DataSupplier data;
    private final DataCountryService dataCountryService;
    private int iterator = 0;
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

    public List<Method> getExposedMethods(){
        List<Method> methods = new ArrayList<>();
        for (Method method : DataLibrary.class.getMethods()) {
            if (method.isAnnotationPresent(ExposeToApi.class)){
                methods.add(method);
            }
        }
        return methods;
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
    @ExposeToApi
    public String getName() {
        if (random.nextBoolean()){
            return getNameMale();
        }else{
            return getNameFemale();
        }
    }

    @Override
    @ExposeToApi
    public String getNameMale() {
        List<String> firstNameMaleList = data.getFirstNameMaleList();
        return firstNameMaleList.get(random.nextInt(firstNameMaleList.size()));
    }

    @Override
    @ExposeToApi
    public String getNameFemale() {
        List<String> firstNameFemaleList = data.getFirstNameFemaleList();
        return firstNameFemaleList.get(random.nextInt(firstNameFemaleList.size()));
    }

    @Override
    @ExposeToApi
    public String getSurname() {
        List<String> lastNameList = data.getLastNameList();
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
    @ExposeToApi
    public int iterator() {
        return this.iterator++;
    }

    @Override
    @ExposeToApi
    public int iteratorBy(int incrementBy) {
        int currentIncrement = this.iterator;
        this.iterator+=incrementBy;
        return currentIncrement;
    }

    @Override
    @ExposeToApi
    public int getInt() {
        return getNumberInRange(0, 9999);
    }

    @Override
    @ExposeToApi
    public int getIntBound(int bound) {
        return getNumberInRange(0, bound);
    }

    @Override
    @ExposeToApi
    public int getIntInRange(int minBound, int maxBound) {
        return getNumberInRange(minBound, maxBound);
    }

    @Override
    @ExposeToApi
    public float getFloat() {
        return (float) getDouble();
    }

    @Override
    @ExposeToApi
    public float getFloatBound(float bound) {
        return (float) getDoubleBound(bound);
    }

    @Override
    @ExposeToApi
    public float getFloatInRange(float minRange, float maxRange) {
        return (float) getDoubleInRange(minRange, maxRange);
    }

    @Override
    @ExposeToApi
    public double getDouble() {
        return getNumberInRange(0d, 9999d);
    }

    @Override
    @ExposeToApi
    public double getDoubleBound(double bound) {
        return getNumberInRange(0d, bound);
    }

    @Override
    @ExposeToApi
    public double getDoubleInRange(double minRange, double maxRange) {
        return getNumberInRange(minRange, maxRange);
    }

    @Override
    @ExposeToApi
    public boolean getBoolean() {
        return random.nextBoolean();
    }

    @Override
    @ExposeToApi
    public Object pickRandom(Object... objects) {
        int randomIndex = random.nextInt(objects.length);
        return objects[randomIndex];
    }

    @Override
    @ExposeToApi
    public String print(String print) {
        return print;
    }

    @Override
    @ExposeToApi
    public int getAgeTeen() {
        return getIntInRange(13, 18);
    }

    @Override
    @ExposeToApi
    public int getAgeMinor() {
        return getIntInRange(0, 18);
    }

    @Override
    @ExposeToApi
    public int getAgeAdult() {
        return getIntInRange(18, 80);
    }

    @Override
    @ExposeToApi
    public int getAgeChild() {
        return getIntInRange(0, 10);
    }

    @Override
    @ExposeToApi
    public String getImgUrlSquare(int size) {
        String url = "https://picsum.photos/" + size;
        return getFinalRedirectedURL(url);
    }

    @Override
    @ExposeToApi
    public String getImgUrl(int sizeX, int sizeY) {
        String url =  "https://picsum.photos/" + sizeX + "/" + sizeY;
        return getFinalRedirectedURL(url);
    }

    @Override
    @ExposeToApi
    public String getImagePlaceholderSquare(int size) {
        String url = "http://via.placeholder.com/" + size;
        return getFinalRedirectedURL(url);
    }

    @Override
    @ExposeToApi
    public String getImagePlaceholder(int width, int height) {
        String url = "http://via.placeholder.com/" + width + "x" + height;
        return getFinalRedirectedURL(url);
    }

    @Override
    @ExposeToApi
    public String getStreet() {
        List<String> streetList = data.getStreetList();
        return streetList.get(random.nextInt(streetList.size()));
    }

    @Override
    @ExposeToApi
    public String getCity() {
        List<String> cityList = data.getCityList();
        return cityList.get(random.nextInt(cityList.size()));
    }

    @Override
    @ExposeToApi
    public String getCountry() {
        return data.getCountry();
    }

    @Override
    @ExposeToApi
    public String getWord() {
        List<String> wordsList = data.getWordsList();
        return wordsList.get(random.nextInt(wordsList.size()));
    }

    @Override
    @ExposeToApi
    public String getSentence() {
        return getSentenceBound(getIntInRange(4,10));
    }

    @Override
    @ExposeToApi
    public String getSentenceBound(int wordCount) {
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

    @Override
    @ExposeToApi
    public String getSentenceInRange(int minWordCount, int maxWordCount) {
        return getSentenceBound(getIntInRange(minWordCount,maxWordCount));
    }

    @Override
    @ExposeToApi
    public String getParagraph() {
        return getParagraphBound(getIntInRange(4, 10));
    }

    @Override
    @ExposeToApi
    public String getParagraphBound(int boundSentenceCount) {
        int sentenceCount = getIntInRange(3, boundSentenceCount);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < boundSentenceCount; i++) {
            String sentence = getSentence();
            sb.append(sentence);
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    @Override
    @ExposeToApi
    public String getParagraphInRange(int minSentenceCount, int maxSentenceCount) {
        return getParagraphBound(getIntInRange(minSentenceCount, maxSentenceCount));
    }

    @Override
    @ExposeToApi
    public String loremIpsum() {
        List<String> loremList = data.getLoremList();
        return loremList.get(random.nextInt(loremList.size()));
    }

    @Override
    @ExposeToApi
    public String loremIpsumBound(int bound) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bound; i++) {
            sb.append(loremIpsum() + " ");
        }
        return sb.toString().trim();
    }

    @Override
    @ExposeToApi
    public String loremIpsumInRange(int minSentenceCount, int maxSentenceCount) {
        int count = getIntInRange(minSentenceCount, maxSentenceCount);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(loremIpsum());
        }
        return sb.toString().trim();
    }
}
