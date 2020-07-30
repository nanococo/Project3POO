package ServerApp.CommandManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sebas
 * Utils for commands
 */
public class CommandUtil {


    /**
     * @author sebas
     * @param args is string from commmand line as arguments
     * @return String[] of divided arguments
     */
    public static String[] tokenizerArgs(String args) {
        List<String> tokens = new ArrayList<>();
        char[] charArray = args.toCharArray();
        StringBuilder contact = new StringBuilder();
        boolean inText = false;

        for (char c : charArray) {
            if (c == ' ' && !inText) {
                if (contact.length() != 0) {
                    tokens.add(contact.toString());
                    contact = new StringBuilder();
                }
            } else if (c == '"') {
                if (inText) {   tokens.add(contact.toString());
                    contact = new StringBuilder();
                    inText = false;
                } else {
                    inText = true;
                }
            } else {
                contact.append(c);
            }
        }
        if (contact.toString().trim().length() != 0) {
            tokens.add(contact.toString().trim());
        }

        String[] argsArray = new String[tokens.size()];
        argsArray = tokens.toArray(argsArray);
        return argsArray;
    }
}

