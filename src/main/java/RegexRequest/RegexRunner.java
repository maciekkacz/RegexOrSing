package RegexRequest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexRunner {

    public static void main(String[] args) {
        String textToSearch = "Jan Kowalski, ur. 20.02.1987 r., " +
                "zam. ul. Jutrzenki 105, 02-716 Warszawa, " +
                "odwiedził stany: CA i AL," +
                "e-mail: janekk87@gmail.com," +
                "kom.: (+48) 789-215-618, " +
                "hobby: kung fu, wieprzowina, Xiaomi";
        String regexPostCode = " \\d{2}-\\d{3} ";
        String regexStates = "AK|AL|AR|AZ|CA|CO|CT";
        String regexStatesShortened = "[A][KLRZ]|[C][AOT]";
        String regexHobby = "hobby: .*";

        printRegexResults(regexPostCode, textToSearch);
        printRegexResults(regexStates, textToSearch);
        printRegexResults(regexStatesShortened, textToSearch);
        printRegexResults(regexHobby, textToSearch);
    }

    public static void printRegexResults(String regexStr, String textStr) {
        Pattern regex = Pattern.compile(regexStr);
        Matcher matcher = regex.matcher(textStr);

        while(matcher.find()) {
            if(matcher.group().length() != 0) {
                System.out.println(matcher.group().trim());
            }

            System.out.println("Start index: " + matcher.start());
            System.out.println("End index: " + matcher.end());
        }
    }

}
