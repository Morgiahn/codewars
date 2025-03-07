package katas.fundamentals.kyu5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/*
Once upon a time, on a way through the old wild mountainous west,…

… a man was given directions to go from one point to another. The directions were "NORTH", "SOUTH", "WEST", "EAST". Clearly "NORTH" and "SOUTH" are opposite, "WEST" and "EAST" too.

Going to one direction and coming back the opposite direction right away is a needless effort. Since this is the wild west, with dreadful weather and not much water, it's important to save yourself some energy, otherwise you might die of thirst!
How I crossed a mountainous desert the smart way.

The directions given to the man are, for example, the following (depending on the language):

["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"].
or
{ "NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST" };
or
[North, South, South, East, West, North, West]

You can immediately see that going "NORTH" and immediately "SOUTH" is not reasonable, better stay to the same place! So the task is to give to the man a simplified version of the plan. A better plan in this case is simply:

["WEST"]
or
{ "WEST" }
or
[West]

Other examples:

In ["NORTH", "SOUTH", "EAST", "WEST"], the direction "NORTH" + "SOUTH" is going north and coming back right away.

The path becomes ["EAST", "WEST"], now "EAST" and "WEST" annihilate each other, therefore, the final result is [] (nil in Clojure).

In ["NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"], "NORTH" and "SOUTH" are not directly opposite but they become directly opposite after the reduction of "EAST" and "WEST" so the whole path is reducible to ["WEST", "WEST"].
Task

Write a function dirReduc which will take an array of strings and returns an array of strings with the needless directions removed (W<->E or S<->N side by side).

    The Haskell version takes a list of directions with data Direction = North | East | West | South.
    The Clojure version returns nil when the path is reduced to nothing.
    The Rust version takes a slice of enum Direction {North, East, West, South}.
    The OCaml version takes a list of type direction = | North | South | East | West.

See more examples in "Sample Tests:"
Notes

    Not all paths can be made simpler. The path ["NORTH", "WEST", "SOUTH", "EAST"] is not reducible. "NORTH" and "WEST", "WEST" and "SOUTH", "SOUTH" and "EAST" are not directly opposite of each other and can't become such. Hence the result path is itself : ["NORTH", "WEST", "SOUTH", "EAST"].
    if you want to translate, please ask before translating.


 */
public class DirReduction {

    record Dir(String dir) {
        public boolean isOpposite(Dir dir1) {
            return switch (dir1.dir) {
                case "NORTH" -> this.dir.equals("SOUTH");
                case "SOUTH" -> this.dir.equals("NORTH");
                case "EAST" -> this.dir.equals("WEST");
                case "WEST" -> this.dir.equals("EAST");
                default -> false;
            };
        }
    }

    public static String[] dirReduc(String[] arr) {
        // Your code here.
        String[] reduced = arr;
        int oldLength = reduced.length;
        int length = 0;
        while (length != oldLength) {
            oldLength = reduced.length;
            reduced = DirReduction.reduction(arr);
            length = reduced.length;
            arr = reduced;
        }

        return reduced;
    }

    public static String[] reduction (String[] arr) {
//        if (arr.length == 0) {
//            return arr;
//        }
        List<Dir> dirs = Arrays.stream(arr).map(Dir::new).toList();
        List<Dir> reducedDirs = new ArrayList<>();
//        boolean lastIsOpp = false;
//        for (int i = 0; i < dirs.size() -1; i++) {
//            lastIsOpp = false;
//
//            if (dirs.get(i).isOpposite(dirs.get(i+1))) {
//                i += 1;
//                if (i == dirs.size() -1) {
//                    lastIsOpp = true;
//                }
//                continue;
//            }
//            reducedDirs.add(dirs.get(i));
//        }
//        if (!lastIsOpp) {
//            reducedDirs.add(dirs.getLast());
//        }
//        return reducedDirs.stream().map(Dir::dir).toArray(String[]::new);

        Iterator<Dir> it = dirs.iterator();
        while (it.hasNext()) {
            Dir d1 = it.next();
            Dir d2 = it.hasNext() ? it.next() : null;
            if (d2 != null && d1.isOpposite(d2)) {
//                it.next();
            } else {
                reducedDirs.add(d1);
            }


        }
        return reducedDirs.stream().map(Dir::dir).toArray(String[]::new);
    }



}
