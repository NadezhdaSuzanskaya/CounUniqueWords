import java.io.File;
import java.io.IOException;

public class CountUniqueWords {
    public static void main(String[] args) throws IOException {
        File fileout = new File("src/main/resources/FirstTextFile.txt");
        File filein = new File("src/main/resources/SecondTextFile.txt");

        WorkWithText workWithText = new WorkWithText();
        String textFromFile = workWithText.readFromFile(fileout);
        String countOfWords = workWithText.getcountUniqueWords(textFromFile);
        String arrayOfWords = workWithText.getArrayOfUniqueWords(textFromFile);
        String textToFile;
        textToFile = "Count of unique words:\n " + countOfWords + "\n Unique words: \n" + arrayOfWords;
        workWithText.writeTextInFile(filein, textToFile);

    }
}
