package workshop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlaintextToHtmlConverter {
    int i;
    List<String> convertedLine;
    String characterToConvert;

    public String toHtml() throws Exception {
        String text = read();
        String htmlLines = basicHtmlEncode(text);
        return htmlLines;
    }

    protected String read() throws IOException {
        return new String(Files.readAllBytes(Paths.get("sample.txt")));
    }

    private String basicHtmlEncode(String source) {

        i = 0;
        List<String> result = new ArrayList<>();
        convertedLine = new ArrayList<>();
        characterToConvert = stashNextCharacterAndAdvanceThePointer(source);

        while (i <= source.length()) {
            switch (characterToConvert) {
                case "<":
                    convertedLine.add("&lt;");
                    break;
                case ">":
                    convertedLine.add("&gt;");
                    break;
                case "&":
                    convertedLine.add("&amp;");
                    break;
                case "\n":
                    addANewLine(result);
                    break;
                default:
                    pushACharacterToTheOutput();
            }

            if (i >= source.length()) break;

            characterToConvert = stashNextCharacterAndAdvanceThePointer(source);
        }
        addANewLine(result);
        String finalResult = String.join("<br />", result);
        return finalResult;
    }

    //pick the character from source string
    //and increment the pointer
    private String stashNextCharacterAndAdvanceThePointer(String source) {
        char c = source.charAt(i);
        i += 1;
        return String.valueOf(c);
    }

    //stringfy convertedLine array and push into result
    //reset convertedLine
    private void addANewLine(List<String> result) {
        String line = String.join("", convertedLine);
        result.add(line);
        convertedLine = new ArrayList<>();
    }

    private void pushACharacterToTheOutput() {
        convertedLine.add(characterToConvert);
    }
}
