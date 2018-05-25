import conference.NoContentInLineException;
import conference.Talk;
import conference.TalkParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParserTest {
    private TalkParser talkParser = new TalkParser();

    @Test
    public void emptyLineReturnsNoContentException(){
        assertThrows(NoContentInLineException.class,
                () -> talkParser.parseLine(""));
    }

    @Test
    public void lineReturnsTalk(){
        Talk talk = talkParser.parseLine("Writing Fast Tests Against Enterprise Rails 60min");

        assertEquals("Writing Fast Tests Against Enterprise Rails", talk.getTitle());
        assertSame(60, talk.getDuration());
    }

}
