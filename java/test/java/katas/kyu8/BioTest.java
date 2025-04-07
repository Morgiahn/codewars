package katas.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BioTest {

        @Test
        public void testDna() throws Exception {
            Bio b = new Bio();
            assertEquals("UUUU", b.dnaToRna("TTTT"));
        }

        @Test
        public void testDna2() throws Exception {
            Bio b = new Bio();
            assertEquals("GCAU", b.dnaToRna("GCAT"));
        }

}
