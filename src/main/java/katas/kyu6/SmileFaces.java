package katas.kyu6;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Given an array (arr) as an argument complete the function countSmileys that should return the total number of smiling faces.

Rules for a smiling face:

    Each smiley face must contain a valid pair of eyes. Eyes can be marked as : or ;
    A smiley face can have a nose but it does not have to. Valid characters for a nose are - or ~
    Every smiling face must have a smiling mouth that should be marked with either ) or D

No additional characters are allowed except for those mentioned.

Valid smiley face examples: :) :D ;-D :~)
Invalid smiley faces: ;( :> :} :]
 */



public class SmileFaces {


    static final Pattern pattern = Pattern.compile("(^[;:]{1}[-~]{0,1}[)D]$)");

    public static int countSmileys(List<String> arr) {
        return (int) arr.stream()
                .filter(SmileFaces::isSmiley)
                .count();
    }

    static boolean isSmiley(String smiley) {
        return pattern.matcher(smiley).find();
    }
}
/*

  public static int countSmileys(List<String> arr) {
    return (int)arr.stream().filter( x -> x.matches("[:;][-~]?[)D]")).count();
  }


  return arr.stream().mapToInt( w -> w.matches("^[:;][-~]?[)D]$") ? 1 : 0 ).sum();



  public static int countSmileys(List<String> arr) {
      Pattern smilieyPattern = Pattern.compile("^(:|;)?(~|-)?(\\)|D)?$");

      return (int) arr.stream()
       .filter(smilieyPattern.asPredicate())
       .count();
  }


 */
