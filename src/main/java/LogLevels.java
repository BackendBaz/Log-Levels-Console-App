import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogLevels {

    private static boolean checkLogFormatting(String logMessage) {
        // the correct ptr -> [...]: ...
        Pattern pattern = Pattern.compile("^\\[[^:\\[\\]]+]: [^:\\[\\]]+$");
        Matcher matcher = pattern.matcher(logMessage);
        return !matcher.find();
    }
    
    public static String message(String logLine) {
        if (checkLogFormatting(logLine)) return "";
        String[] messageWithLevel = logLine.split(":");
        return messageWithLevel[1].trim();
    }

    public static String logLevel(String logLine) {
        if (checkLogFormatting(logLine)) return "";
        String[] messageWithLevel = logLine.split(":");
        return messageWithLevel[0]
                .replace("[", "")
                .replace("]", "")
                .toLowerCase()
                .trim();
    }

    public static String reformat(String logLine) {
        String level = logLevel(logLine), message = message(logLine);
        if (level.isEmpty() && message.isEmpty()) return "";
        return String.format("%s (%s)", message, level);
    }
}
