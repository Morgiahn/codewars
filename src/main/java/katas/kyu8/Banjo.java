package katas.kyu8;
/*
Create a function which answers the question "Are you playing banjo?".
If your name starts with the letter "R" or lower case "r", you are playing banjo!

The function takes a name as its only argument, and returns one of the following strings:

name + " plays banjo"
name + " does not play banjo

 */
public class Banjo {
    public static String areYouPlayingBanjo(String name) {
        // Program me!
        return name.toLowerCase().startsWith("r") ? name + " plays banjo" : name + " does not play banjo";
    }
}
