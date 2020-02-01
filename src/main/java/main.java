import data.DataLibrary;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Main {
    public static void main(String[] args) {
        DataLibrary data = DataLibrary.getEnglishData();
        data.getNameMale();
        data.getNameFemale();
        data.getAgeTeen();
        data.getSentence();
        String imgUrlSquare = data.getImgUrlSquare(300);
        data.getCountryRandom();

        System.out.println(data.getImagePlaceholderSquare(300));

        for (Method method : data.getExposedMethods()) {
            System.out.println(method);
        }


    }
}
