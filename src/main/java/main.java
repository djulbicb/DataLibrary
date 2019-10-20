import data.DataLibrary;

class Main {
    public static void main(String[] args) {
        DataLibrary data = DataLibrary.getEnglishData();
        data.getFirstNameMale();
        data.getFirstNameFemale();
        data.getAgeTeen();
        data.getSentence();
        data.getImgUrlRandom(300);
        data.getCountryRandom();


        System.out.println(data.getDouble(300, 1000));
    }
}
