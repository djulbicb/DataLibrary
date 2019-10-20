package data;

import java.util.List;

interface IDataLibrary {
    String getFirstNameMale();
    String getFirstNameFemale();
    String getFirstNameRandom();
    String getLastName();

    List<DataCountry> getCountries();
    DataCountry getCountryRandom();

    int getInt(int bound);
    int getInt(int minBound, int maxBound);

    int getAgeTeen();
    int getAgeMinor();
    int getAgeAdult();
    int getAgeChild();

    double getDouble(double bound);
    double getDouble(double minBound, double maxBound);

    String getImgUrlRandom(int size);
    String getImgUrlRandom(int sizeX, int sizeY);

    String getImgUrlRandomId(int size);
    String getImgUrlRandomId(int sizeX, int sizeY);

    String getStreetAddresse();
    String getCity();
    String getCountry();

    String getWord();
    String getSentence();
    String getSentence(int wordCount);
    String getParagraph();
    String getParagraph(int sentenceCount);

}
