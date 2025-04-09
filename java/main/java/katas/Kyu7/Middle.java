package katas.Kyu7;
/*
You are going to be given a non-empty string. Your job is to return the middle character(s) of the string.

    If the string's length is odd, return the middle character.
    If the string's length is even, return the middle 2 characters.

Examples:

"test" --> "es"
"testing" --> "t"
"middle" --> "dd"
"A" --> "A"


 */
public class Middle {

    public static String getMiddle(String word) {
        //Code goes here!
        int middle =  word.length() / 2;
        int start = middle;
        int end = middle + 1;
        if (word.length() % 2 == 0) {
            start = middle -1;
        }
        return word.substring(start, end);
    }

}
