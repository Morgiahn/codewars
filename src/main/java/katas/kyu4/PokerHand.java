package katas.kyu4;

/*
A famous casino is suddenly faced with a sharp decline of their revenues. They decide to offer Texas hold'em also online. Can you help them by writing an algorithm that can rank poker hands?
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

public class PokerHand {
    public enum Result { TIE, WIN, LOSS }
    public enum Type { Spade, Heart, Diamond, Club }
//    record Card(String fisrt, Color second ) {}

    public enum HandValue { HighCard, Pair, TwoPairs, ThreeOfaKind,
        Straight, Flush, FullHouse, FourOfaKind, StraightFlush, RoyalFlush }

    public record Card(String figure, String type) {
        public Card(String in) {
            this(in.substring(0, 1), in.substring(1, 2));
        }
    }

    public List<Card> cards;
    PokerHand(String hand)
    {
        cards = Arrays.stream(hand.split(" ")).map(Card::new).sorted().toList();
    }

    public Result compareWith(PokerHand other) {
        HandValue otherValue = other.handValue();
        return Result.TIE;
    }


    public HandValue getHandValue() {
        boolean sameColor = false;
        int sameFigure = 0;
        int sameType = 0;

        for(Card card: this.cards.sort(Comparator.comparing(cards::getType))) {
            String color = card.type;
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
}
