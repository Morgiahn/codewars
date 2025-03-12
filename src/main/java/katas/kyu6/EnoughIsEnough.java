package katas.kyu6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Enough is enough!

Alice and Bob were on a holiday. Both of them took many pictures of the places they've been, and now they want to show Charlie their entire collection.
However, Charlie doesn't like these sessions, since the motif usually repeats.
He isn't fond of seeing the Eiffel tower 40 times.
He tells them that he will only sit for the session if they show the same motif at most N times.

Luckily, Alice and Bob are able to encode the motif as a number.

Can you help them to remove numbers such that their list contains each number only up to N times, without changing the order?
Task

Given a list and a number, create a new list that contains each number of list at most N times, without reordering.

For example if the input number is 2, and the input list is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2], drop the next [1,2] since this would lead to 1 and 2 being in the result 3 times, and then take 3, which leads to [1,2,3,1,2,3].
With list [20,37,20,21] and number 1, the result would be [20,37,21].

 */
public class EnoughIsEnough {
    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        //Code here ;)
        Map<Integer, Integer> counts = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < elements.length; i++) {
            counts.put(elements[i], counts.getOrDefault(elements[i], 0) + 1);
            if (counts.get(elements[i]) <= maxOccurrences) {
                result.add(elements[i]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}


/*

public class EnoughIsEnough {
	public static int[] deleteNth(int[] elements, int maxOccurrences) {
		Map<Integer, Integer> occurrence = new HashMap<>();
		return IntStream.of(elements)
			.filter(motif -> occurrence.merge(motif, 1, Integer::sum) <= maxOccurrences)
			.toArray();
	}
}





private static boolean shouldAdd(final Map<Integer, Integer> counts, final int element, final int maxOcurrences) {
        if (counts.getOrDefault(element, 0) < maxOcurrences) {
            counts.merge(element, 1, Integer::sum);
            return true;
        }
        return false;
    }

    static int[] deleteNth(final int[] elements, final int maxOcurrences) {
		    final Map<Integer, Integer> counts = new HashMap<>();
        return Arrays.stream(elements)
            .filter(element -> shouldAdd(counts, element, maxOcurrences))
            .toArray();
	  }






	  
 */
