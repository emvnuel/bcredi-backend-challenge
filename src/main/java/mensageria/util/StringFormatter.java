package mensageria.util;

import java.util.List;

public class StringFormatter {

    public static String format(List<String> strings) {
        String formatted = "";

        for (String string : strings) {
            if (strings.indexOf(string) == strings.size() - 1)
                formatted += string;

            else
                formatted += string+",";
        }

        return formatted;
    }
}