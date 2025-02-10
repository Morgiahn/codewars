package katas.fundamentals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeFormatterTest {

    @Test
    public void exampleTests() {
        assertEquals("1 second", TimeFormatter.formatDuration(1));
        assertEquals("1 minute and 2 seconds", TimeFormatter.formatDuration(62));
        assertEquals("2 minutes", TimeFormatter.formatDuration(120));
        assertEquals("1 hour", TimeFormatter.formatDuration(3600));
        assertEquals("1 hour, 1 minute and 2 seconds", TimeFormatter.formatDuration(3662));
    }

    @Test
    public void year_second() {
        assertEquals("1 year and 1 second", TimeFormatter.formatDuration(31536001));
    }

    @Test
    public void year_minute() {
        assertEquals("1 year and 1 minute", TimeFormatter.formatDuration(31536060));
    }

}
