import data.DataLibrary;
import data.DataLibraryMetadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Main {
    public static void main(String[] args) {
        DataLibraryMetadata meta = new DataLibraryMetadata();
        for (Method method : meta.getExposedMethods()) {
            //System.out.println(method.getName());
        }

        for (Method method : meta.getMethodsThatReturnType("string", "int")) {
            System.out.println(method);
        }

    }
}
