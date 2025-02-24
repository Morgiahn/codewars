package katas.fundamentals.easy;

import java.util.stream.Collectors;

public class SquareDigit {

    public int squareDigits(int n) {

        String value =  String.valueOf(n)
                .chars()
                .mapToObj(c -> c-48)
                .map(i -> i*i)
                .map(String::valueOf)
                .collect(Collectors.joining());

        return Integer.parseInt(value);
    }
}