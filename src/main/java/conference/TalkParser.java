package conference;

import org.apache.commons.lang3.StringUtils;

public class TalkParser {

    public static final String MINUTE_ABBREVIATION = "min";

    public Talk parseLine(String line) {
        if (line.isEmpty())throw new NoContentInLineException();
        if (line.split(" ").length <= 1) throw new MalformedLineException();
        String title = extractTitle(line);
        int duration = extractDuration(line);

        return new Talk(title, duration);

    }

    private int extractDuration(String line) {
        int lastIndex = line.lastIndexOf(" ");
        String durationPart = line.substring(lastIndex);
        int minutes = extractMinutes(durationPart);

        return minutes;

    }

    private boolean isValidDuration(String durationPart) {
        return durationPart.contains(MINUTE_ABBREVIATION) && containsMinutes(durationPart);

    }

    private boolean containsMinutes(String durationPart) {
        String[] splitWords = durationPart.split(MINUTE_ABBREVIATION);
        return splitWords.length == 1 && StringUtils.isNumeric(splitWords[0].trim());
    }

    private int extractMinutes(String durationPart) {
        if (!isValidDuration(durationPart)){
            throw new NoDurationException();
        }

        int minuteIndexInString = durationPart.lastIndexOf(MINUTE_ABBREVIATION);
        String minutesPart = durationPart.substring(0, minuteIndexInString);
        return Integer.parseInt(minutesPart.trim());
    }

    private String extractTitle(String line) {
        int lastIndex = line.lastIndexOf(" ");
        return line.substring(0, lastIndex);
    }

}
