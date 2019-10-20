package data;

import java.io.*;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.List;

class ResourceUtility {

    private static String getPathMain() {
        String appPath = System.getProperty("user.dir");
        return appPath + "/src/main/";
    }

    public static String getPathResources() {
        return getPathMain() + "resources/";
    }

    public static String getPathJar() throws URISyntaxException {
        CodeSource codeSource = ResourceUtility.class.getProtectionDomain().getCodeSource();
        File jarFile = new File(codeSource.getLocation().toURI().getPath());
        return jarFile.getParentFile().getPath() + "/";
    }

    public static List<String> readLinesFromResources(String resourceFilePath) throws IOException {
        List<String> allLines = new ArrayList<>();

        InputStream resourceAsStream = ResourceUtility.class.getClassLoader().getResourceAsStream(resourceFilePath);
        if (resourceAsStream != null) {
            BufferedReader br = new BufferedReader(new InputStreamReader(resourceAsStream));
            String line;

            while ((line = br.readLine()) != null) {
                allLines.add(line);
            }
        } else {
            throw new IllegalArgumentException(String.format("Resource %s wasn't found", resourceFilePath));
        }
        return allLines;
    }

    public static String readLinesFromResourcesAsString(String fileName) throws IOException {
        List<String> allLines = readLinesFromResources(fileName);
        StringBuilder sb = new StringBuilder();

        for (String line : allLines) {
            sb.append(line).append("\n");
        }

        return sb.toString();
    }
}