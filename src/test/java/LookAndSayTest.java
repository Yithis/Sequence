import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LookAndSayTest {
    @Test
    public void test() {
        LookAndSay lookAndSay = new LookAndSay(3);
        String[] expected = {"3", "13", "1113", "3113", "132113", "1113122113", "311311222113", "13211321322113",
                "1113122113121113222113", "31131122211311123113322113", "132113213221133112132123222113",
                "11131221131211132221232112111312111213322113", "31131122211311123113321112131221123113111231121123222113"
        };
        Object[] result = lookAndSay.getStream().limit(13).toArray();
        for (int i = 0; i < 13; i++) {
            assertEquals(result[i], expected[i]);
        }
    }
}