import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogLevels {

    private static boolean checkLogFormatting(String logMessage) {
        // the correct ptr -> [...]: ...
        Pattern pattern = Pattern.compile("^\\[[^:\\[\\]]+]: [^:\\[\\]]+$");
        Matcher matcher = pattern.matcher(logMessage);
        return matcher.find();
    }
    
    public static String message(String logLine) {
        if (!checkLogFormatting(logLine)) return "";
        String[] messageWithLevel = logLine.split(":");
        return messageWithLevel[1].trim();
    }

    public static String logLevel(String logLine) {
        throw new UnsupportedOperationException("Please implement the (static) LogLevels.logLevel() method");
    }

    public static String reformat(String logLine) {
        throw new UnsupportedOperationException("Please implement the (static) LogLevels.reformat() method");
    }
}
