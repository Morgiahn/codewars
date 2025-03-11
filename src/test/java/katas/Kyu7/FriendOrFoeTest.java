package katas.Kyu7;

import katas.Kyu7.FriendOrFoe;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FriendOrFoeTest {

    @Test
    void testFriend() {
        assertEquals(List.of("Ryan", "Yous"), FriendOrFoe.friend(List.of("Ryan", "Kieran", "Jason", "Yous")), "Input: [\"Ryan\", \"Kieran\", \"Jason\", \"Yous\"]");
        assertEquals(List.of(), FriendOrFoe.friend(List.of("Peter", "Stephen", "Joe")), "Input: [\"Peter\", \"Stephen\", \"Joe\"]");
    }
}
