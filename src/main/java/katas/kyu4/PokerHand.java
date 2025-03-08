package katas.kyu4;

/*
A famous casino is suddenly faced with a sharp decline of their revenues. They decide to offer Texas hold'em also online.
Can you help them by writing an algorithm that can rank poker hands?
Task

Create a poker hand that has a method to compare itself to another poker hand:

Result PokerHand.compareWith(PokerHand hand);

A poker hand has a constructor that accepts a string containing 5 cards:

PokerHand hand = new PokerHand("KS 2H 5C JD TD");

The characteristics of the string of cards are:

    Each card consists of two characters, where
    The first character is the value of the card: 2, 3, 4, 5, 6, 7, 8, 9, T(en), J(ack), Q(ueen), K(ing), A(ce)
    The second character represents the suit: S(pades), H(earts), D(iamonds), C(lubs)
    A space is used as card separator between cards

The result of your poker hand compare can be one of these 3 options:

public enum Result
{
    WIN,
    LOSS,
    TIE
}

Notes

https://en.wikipedia.org/wiki/Texas_hold_%27em

    Apply the Texas Hold'em rules for ranking the cards.
    Low aces are valid in this kata.
    There is no ranking for the suits.

If you finished this kata, you might want to continue with Sortable Poker Hands

 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PokerHand {
    public enum Result { TIE, WIN, LOSS }
    public enum Suit { Spade, Heart, Diamond, Club }
    public enum Figure { One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace }

    public enum HandValue { HighCard, Pair, TwoPairs, ThreeOfaKind,
        Straight, Flush, FullHouse, FourOfaKind, StraightFlush, RoyalFlush }

    public record Card(Figure figure, Suit suit) {
        public Card(String in) {
            this(toFigure(in.substring(0, 1)), toType(in.substring(1, 2)));
        }

        private static Figure toFigure(String s) {
            return switch(s) {
                case "1" -> Figure.One;
                case "2" -> Figure.Two;
                case "3" -> Figure.Three;
                case "4" -> Figure.Four;
                case "5" -> Figure.Five;
                case "6" -> Figure.Six;
                case "7" -> Figure.Seven;
                case "8" -> Figure.Eight;
                case "9" -> Figure.Nine;
                case "T" -> Figure.Ten;
                case "J" -> Figure.Jack;
                case "Q" -> Figure.Queen;
                case "K" -> Figure.King;
                case "A" -> Figure.Ace;
                default -> throw new IllegalArgumentException("Unexpected value: " + s);
            };
        }

        private static Suit toType(String s) {
            return switch(s) {
                case "S" -> Suit.Spade;
                case "H" -> Suit.Heart;
                case "D" -> Suit.Diamond;
                case "C" -> Suit.Club;
                default -> throw new IllegalStateException("Unexpected value: " + s);
            };
        }
    }

    boolean allFollow;
    boolean allSameSuit;
    Map<Figure, Long> figureCount;

    public List<Card> cards;
    PokerHand(String hand)
    {
        cards = Arrays.stream(hand.split(" "))
                .map(Card::new)
                .sorted(Comparator.comparing(
                        Card::figure).thenComparing(Card::suit))
                .toList();

        figureCount = cards.stream().collect(Collectors.groupingBy(Card::figure, Collectors.counting()));
        allFollow = true;
        int oldValue = cards.getFirst().figure().ordinal();
        for (int i=1; i < cards.size(); i++)  {
            // check for Ace
            if(allFollow && (i == cards.size() -1) && (cards.get(i).figure() == Figure.Ace) && oldValue == 2) {
                break;
            }
            if( cards.get(i).figure().ordinal() != oldValue + 1) {
                allFollow = false;
                break;
            }
            oldValue = cards.get(i).figure().ordinal();

        }

        allSameSuit = true;
        Suit startSuit = cards.getFirst().suit();
        for (int i=1; i < cards.size(); i++)  {
            if (cards.get(i).suit != startSuit) {
                allSameSuit = false;
                break;
            }
        }

    }

    public Result compareWith(PokerHand other) {
        HandValue otherValue = other.getHandValue();
        if (this.getHandValue().ordinal() > otherValue.ordinal()) {
            return Result.WIN;
        } else if (this.getHandValue().ordinal() < otherValue.ordinal()){
            return Result.LOSS;
        }
        for (int i=4; i > -1 ; i--) {
            if (this.cards.get(i).figure().ordinal() > other.cards.get(i).figure().ordinal()) {
                return Result.WIN;
            } else if (this.cards.get(i).figure().ordinal() < other.cards.get(i).figure().ordinal()) {
                return Result.LOSS;
            }
        }
        return Result.TIE;
    }


    public HandValue getHandValue() {
        if (allFollow && allSameSuit && cards.getLast().figure == Figure.Ace) {
            return HandValue.RoyalFlush;
        }
        if (allFollow && allSameSuit) {
            return HandValue.StraightFlush;
        }

        long figureValues = 0;
        boolean threofakind = false;
        int nbpairs = 0;
        for (long count : figureCount.values()) {
            if (count == 4) {
                return HandValue.FourOfaKind;
            }
            if (count == 2 || count == 3) {
                if (figureValues == 0) {
                    figureValues = count;
                }
                else {
                    if (figureValues == 2 && count == 3 || figureValues == 3 && count == 2) {
                        return HandValue.FullHouse;
                    }
                }
            }
            if (count == 3 ){
                threofakind = true;
            }
            if (count == 2) {
                nbpairs++;
            }
        }

        if (allSameSuit) {
            return HandValue.Flush;
        }

        if (allFollow) {
            return HandValue.Straight;
        }

        if (threofakind) {
            return HandValue.ThreeOfaKind;
        }

        if (nbpairs == 2) {
            return HandValue.TwoPairs;
        }
        if (nbpairs == 1) {
            return HandValue.Pair;
        }

        return HandValue.HighCard;
    }
}

//1 Royal flush 	Highest straight of the same suit
// all same type, fisrt is As, all follow

// StraightFlush Straight of the same suit
// all same type , all follow

// Four cards of the same value
// samefigure=4

//Full house 	Combination of three of a kind and a pair
//

//Flush 	5 cards of the same suit, not in sequential order
// all same type = 5

// Straight
// all follow

// Three of a kind 	Three cards with the same value
// samefigure = 3

//Two pairs

//Pair 	Two cards with the same value
// samefigure = 2


// High card
// highest figure
