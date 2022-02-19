package workshop.PlainTextToHtml;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaintextToHtmlConverter {
    private final List<NormalResponse> matchers;
    private final symbolNewLinePattern newLineMatcher;

    public PlaintextToHtmlConverter() {
        this.matchers = new ArrayList<>(Arrays.asList(  new symbolAmpercentPattern(),
                                                        new symbolGreaterThenPattern(),
                                                        new symbolLessThenPattern(),
                                                        new notMatchedPattern()));
        this.newLineMatcher = new symbolNewLinePattern();
    }

    public PlaintextToHtmlConverter(List<NormalResponse> matchers, symbolNewLinePattern newLineMatcher) {
        this.matchers = matchers;
        this.newLineMatcher = newLineMatcher;
    }

    public String toHtml() throws Exception {
        String text = read();
        return basicHtmlEncode(text);
    }

    protected String read() throws IOException {
        Path filePath = Paths.get("sample.txt");
        byte[] fileByteArray = Files.readAllBytes(filePath);
        return new String(fileByteArray);
    }

    private String basicHtmlEncode(String source) {
        List<String> result = new ArrayList<>();
        List<String> convertedLine = new ArrayList<>();

        for (char characterToConvert: source.toCharArray()) {
            for (NormalResponse matcher: matchers) {
                if (matcher.match(characterToConvert)) {
                    matcher.addToList(convertedLine);
                    break;
                }
            }
            if (newLineMatcher.match(characterToConvert)){
                addANewLine(result, convertedLine);
            }
        }

        addANewLine(result, convertedLine);
        return String.join("<br />", result);
    }

    //stringfy convertedLine array and push into result
    //reset convertedLine
    private void addANewLine(List<String> result, List<String> convertedLine) {
        String line = String.join("", convertedLine);
        result.add(line);
        convertedLine.clear();
    }
}
