import data.DataLibrary;

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

    }
}
