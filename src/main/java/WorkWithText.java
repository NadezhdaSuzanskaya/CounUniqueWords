import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class WorkWithText {
    Logger LOGGER = LogManager.getLogger();

    public String readFromFile(File fileout) throws IOException {
        String content = "";
        try {
            content = FileUtils.readFileToString(fileout, Charset.forName("UTF-8"));
            System.out.println(content);
            LOGGER.info("File info:" + content);

        } catch (IOException exp) {
            LOGGER.error("Problem with reading the file :" + exp.getMessage());
        }
        return content;
    }

    private String gettextWithoutPunctuationMarks(String text) {
        String textWithoutPunctuationMarks = StringUtils.replaceEach(text,
                new String[]{",", ".", "!", "?", "\r\n"},
                new String[]{"", "", "", "", ""}).toLowerCase();
        LOGGER.info("textWithoutPunctuationMarks:" + textWithoutPunctuationMarks);
        return textWithoutPunctuationMarks;
    }
    
    public String getcountUniqueWords(String text) {
        String[] words2 = StringUtils.split(gettextWithoutPunctuationMarks(text), " ");
        String counOfWords;
        counOfWords = String.valueOf(Arrays.stream(words2).distinct().count());
        LOGGER.info("counOfWords:" + counOfWords);
        return counOfWords;
    }

    public String getArrayOfUniqueWords(String text) {
        String[] words2 = StringUtils.split(gettextWithoutPunctuationMarks(text), " ");
        String arrayOfWords;
        arrayOfWords = String.valueOf(Arrays.stream(words2).distinct().toList());
        LOGGER.info("WORDS2 []:" + Arrays.stream(words2).distinct().toList());
        return arrayOfWords;
    }

    public void writeTextInFile(File filein, String textToFile) throws IOException {
        try {
            FileUtils.write(filein, textToFile, Charset.forName("UTF-8"));
        } catch (IOException exp) {
            LOGGER.error("Problem with writing to the file :" + exp.getMessage());
        }
    }
}
