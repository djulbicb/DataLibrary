# DataLibrary
Java library for generating random data. Just like Lorem Ipsum but with data that makes more sense - get names, surnames, street addresses, image urls, countries, age, numbers...

## Examples:
```
DataLibrary dl = DataLibrary.getEnglishData();  // Examples

dl.getFirstNameMale();                          // Jason
dl.getFirstNameFemale();                        // Mary
dl.getAgeTeen();                                // 13
dl.getImgUrlRandom(300);                        // https://picsum.photos/id/742/300/300
dl.getCountryRandom();                          //
dl.getWord();                                   // flexibility
dl.getSentence();                               // Galaxy Stripes sep char connecting wanted artist.
dl.getParagraph();
dl.getDouble(750);                              // 425.9584830719622
dl.getImgUrlRandom(300);                        // https://picsum.photos/id/577/300/300 -- gets random 300px image from picsum
...and more...
```

`DataLibrary` comes with a couple of predefined country/language specific data.
- English `DataLibrary.getEnglishData();`
- Serbian `DataLibrary.getSerbianData();`
- Romanian `DataLibrary.getRomanianData();`
- German `DataLibrary.getGermanData();`
- French `DataLibrary.getFrenchData();`

for more variations use data from `DataCountry` that contains name of the capitol and major cities in that country.
```
DataLibrary dl = DataLibrary.getEnglishData();
List<DataCountry> countries = dl.getCountries();
DataCountry country = dl.getCountryRandom();
```
## List of all methods

|method  |datatype  | description  |
|--|--|--|
| getName() | String | Returns male of female name |
| getNameMale() | String | Returns male name |
| getNameFemale() | String | Returns female name |
| getSurname() | String | Returns surname |
| iterator() | int | On every call increment a value and return it. Used for custom ids |
| getInt() | int | Return a int number in range of 0 and 9999 |
| getIntBound(int bound) | int | Return a int number in range of 0 and bound |
| getIntInRange(int minBound, int maxBound) | int | Return a int number in range of minBound and maxBound |
| getFloat() | float | Return a float number in range of 0 and 9999 |
| float getFloatBound(float bound) | float |  Return a float number in range of 0.0 and bound |
| float getFloatInRange(float minRange, float maxRange) | float | Return a float number in range of minBound and maxBound |
| getDouble() | double | Return a float number in range of 0 and 9999 |
| float getDoubleBound(double bound) | double |  Return a double number in range of 0.0 and bound |
| float getDoubleInRange(double minRange, double maxRange) | double | Return a double number in range of minBound and maxBound |
| getBoolean() | boolean | Return true of false randomly |
| pickRandom(Object... objects) | Object | Return one of specified objects |
| print(String print) | String | Prints specified string |
| getAgeTeen() | int | Return a int number in range of 13 and 19 |
| getAgeMinor() | int | Return a int number in range of 0 and 18 |
| getAgeAdult() | int | Return a int number in range of 18 and 100 |
| getAgeChild() | int | Return a int number in range of 0 and 8 |
| getImgUrlSquare(int size) | String | Gets a image url from https://picsum.photos/ | 
| getImgUrl(int sizeX, int sizeY) | String | Gets a image url from https://picsum.photos/ |
| getImagePlaceholderSquare(int size) | String | Gets a image url from http://via.placeholder.com/ |
| getImagePlaceholder(int width, int height) | String | Gets a image url from http://via.placeholder.com/ |
| getStreet() | String | Get street name |
| getCity() | String | Get city name |
| getCountry() | String | Get Country object |
| getWord() | String | Get random word |
| getSentence() | String | Get random sequence of words |
| getSentenceBound(int wordCount) | String | Get random sequence of words |
| getSentenceInRange(int minWordCount, int maxWordCount) | String | Get random sequence of words |
| getParagraph() | String | Get random sequence of sentences |
| getParagraphBound(int boundSentenceCount) | String | Get random sequence of sentences |
| getParagraphInRange(int minSentenceCount, int maxSentenceCount) | String | Get random sequence of sentences |
| loremIpsum() | String | Get lorem impsum sentence |
| loremIpsumBound(int bound) | String | Get random sequence of lorem impsum sentences |
| loremIpsumInRange(int minSentenceCount, int maxSentenceCount) | String | Get random sequence of lorem impsum sentences |

## Load into project
### Maven
```
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>

    <dependencies>
        <dependency>
            <groupId>com.github.djulbicb</groupId>
            <artifactId>DataLibrary</artifactId>
            <version>v9.0</version>
        </dependency>
    </dependencies>
```

make sure you are using Java 7 at least. Specify in `pom.xml` or in IDE you are using
```
 <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>8</source>
                    <target>8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
```

### Gradle
adding gradle. in app build.gradle
```
allprojects {
    repositories {
        google()
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```

in build.gradle for module
```
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'androidx.appcompat:appcompat:1.1.0'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    implementation 'com.github.djulbicb:datalibrary:v2.0'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'androidx.test:runner:1.2.0'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'
    implementation ('com.github.djulbicb:datalibrary:v9.0'){
        exclude group: 'org.hamcrest', module:'hamcrest-core'
    }
}

android {
...
    compileOptions {
        sourceCompatibility 1.8
        targetCompatibility 1.8
    }

```
