package data;

import java.util.List;

interface IDataLibrary {
    String getName();
    String getNameMale();
    String getNameFemale();
    String getSurname();

    List<DataCountry> getCountries();
    DataCountry getCountryRandom();

    int iterator();
    int iteratorBy( int incrementBy);

    int getInt();
    int getIntBound(int bound);
    int getIntInRange(int minBound, int maxBound);

    float getFloat();
    float getFloatBound(float bound);
    float getFloatInRange(float minRange, float maxRange);

    double getDouble();
    double getDoubleBound(double bound);
    double getDoubleInRange(double minRange, double maxRange);

    boolean getBoolean();

    Object pickRandom(Object... objects);

    String print(String print);

    int getAgeTeen();
    int getAgeMinor();
    int getAgeAdult();
    int getAgeChild();

    String getImgUrlSquare(int size);
    String getImgUrl(int sizeX, int sizeY);

    String getImagePlaceholderSquare(int size);
    String getImagePlaceholder(int width, int height);

    String getStreet();
    String getCity();
    String getCountry();

    String getWord();

    String getSentence();
    String getSentenceBound(int wordCount);
    String getSentenceInRange(int minWordCount, int maxWordCount);

    String getParagraph();
    String getParagraphBound(int boundSentenceCount);
    String getParagraphInRange(int minSentenceCountt, int maxSentenceCount);

    String loremIpsum();
    String loremIpsumBound(int bound);
    String loremIpsumInRange(int minSentenceCount, int maxSentenceCount);
}
