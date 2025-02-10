package katas.fundamentals;

/*
You probably know the "like" system from Facebook and other pages. People can "like" blog posts, pictures or other items. We want to create the text that should be displayed next to such an item.

Implement the function which takes an array containing the names of people that like an item. It must return the display text as shown in the examples:

[]                                -->  "no one likes this"
["Peter"]                         -->  "Peter likes this"
["Jacob", "Alex"]                 -->  "Jacob and Alex like this"
["Max", "John", "Mark"]           -->  "Max, John and Mark like this"
["Alex", "Jacob", "Mark", "Max"]  -->  "Alex, Jacob and 2 oth

 */
public class WhoLikesIt {
    public static String whoLikesIt(String... names) {
        //Do your magic here
        final String LIKES_THIS = " likes this";
        final String LIKE_THIS = " like this";
        final String AND = " and " ;

        return switch (names.length) {
            case 0 -> "no one likes this";
            case 1 -> names[0] + LIKES_THIS;
            case 2 -> names[0] + AND + names[1] + LIKE_THIS;
            case 3 -> names[0] + ", " + names[1] + AND + names[2] + LIKE_THIS;
            default -> names[0] + ", " + names[1] + AND + (names.length - 2) + " others" + LIKE_THIS;
        };

    }
}

/*
class Solution {
   public static String whoLikesIt(String... names) {
       return switch (names.length){
           case 0 ->  "no one likes this";
           case 1 ->  String.format("%s likes this", names[0]);
           case 2 ->  String.format("%s and %s like this", names[0], names[1]);
           case 3 -> String.format("%s, %s and %s like this", names[0], names[1], names[2]);
           default -> String.format("%s, %s and %d others like this", names[0], names[1], names.length - 2);
        };
    }
}
 */
