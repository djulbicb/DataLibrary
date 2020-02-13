package data;

import annotations.ExposeToApi;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class DataLibraryMetadata {

    private static List<Method> exposedMethods;

    public DataLibraryMetadata() {

    }

    /**
     * Get methods which are part of DataLibrary API
     * @return
     */
    public List<Method> getExposedMethods(){
        if (exposedMethods == null){
            List<Method> methods = new ArrayList<>();
            for (Method method : DataLibrary.class.getMethods()) {
                if (method.isAnnotationPresent(ExposeToApi.class)){
                    methods.add(method);
                }
            }
            exposedMethods = methods;
        }
        return exposedMethods;
    }

    /**
     * Provide simple name of class like string, int, float and it will give you methods that return any of specified types
     * @param expectedTypes expected return type as string, like int, float, boolean...
     * @return
     */
    public List<Method> getMethodsThatReturnType(String... expectedTypes){
        List<Method> returnList = new ArrayList<>();
        for (Method method : getExposedMethods()) {

            for (String type : expectedTypes) {
                if (method.getReturnType().getSimpleName().toString().equalsIgnoreCase(type)){
                    System.out.println("yes");
                    returnList.add(method);
                }
            }
        }
        return returnList;
    }
}
