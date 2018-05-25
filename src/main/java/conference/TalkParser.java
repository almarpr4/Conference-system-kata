package conference;

public class TalkParser {
    public Talk parseLine(String line) {
        if (line.isEmpty())throw new NoContentInLineException();
        String title = extractTitle(line);
        int duration = extractDuration(line);

        return new Talk(title, duration);

    }

    private int extractDuration(String line) {
        int lastIndex = line.lastIndexOf(" ");
        String durationPart = line.substring(lastIndex);

        int minuteIndexInString = durationPart.lastIndexOf("min");
        String minutesPart = durationPart.substring(0, minuteIndexInString);
        int minutes = Integer.parseInt(minutesPart.trim());

        return minutes;

    }

    private String extractTitle(String line) {
        int lastIndex = line.lastIndexOf(" ");
        return line.substring(0, lastIndex);
    }

}
