package katas.fundamentals.kyu6;

import katas.kyu6.HighestScoringWord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HighestScoringWordTest {

    @Test
    public void sampleTests() {
        assertEquals("taxi", HighestScoringWord.high("man i need a taxi up to ubud"));
        assertEquals("volcano", HighestScoringWord.high("what time are we climbing up to the volcano"));
        assertEquals("semynak", HighestScoringWord.high("take me to semynak"));
    }

    @Test
    public void edgeCaseTests() {
        assertEquals("aa", HighestScoringWord.high("aa b"));
        assertEquals("b", HighestScoringWord.high("b aa"));
        assertEquals("bb", HighestScoringWord.high("bb d"));
        assertEquals("d", HighestScoringWord.high("d bb"));
        assertEquals("aaa", HighestScoringWord.high("aaa b"));
    }

    @Test
    public  void testWordValue() {
        assertEquals(1, HighestScoringWord.wordValue("a"));
        assertEquals(2, HighestScoringWord.wordValue("b"));
        assertEquals(27, HighestScoringWord.wordValue("az"));
        assertEquals(8, HighestScoringWord.wordValue("abad"));
    }
}