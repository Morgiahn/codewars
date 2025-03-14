package katas.kyu5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        public String toString() {
            return dir;
        }
    }

    public static String[] dirReduc(String[] arr) {
        // Your code here.
        int oldLength = 0;
        int length =  arr.length;;
        while (length != oldLength) {
            oldLength = arr.length;
            arr = DirReduction.reduction(arr);
            length = arr.length;
        }
        return arr;
    }

    public static String[] reduction (String[] arr) {
        List<Dir> dirs = Arrays.stream(arr).map(Dir::new).toList();
        List<Dir> reducedDirs = new ArrayList<>();
        int i=0;
        while (i < dirs.size()) {
            if (i == dirs.size() -1) {
                reducedDirs.add(dirs.get(i));
                break;
            }
            if (dirs.get(i).isOpposite(dirs.get(i +1 ))) {
                i += 2;
            }
            else  {
                reducedDirs.add(dirs.get(i));
                i++;
            }
        }
        return reducedDirs.stream().map(Dir::dir).toArray(String[]::new);
    }








}

/*import java.util.Stack;

public class DirReduction {
    public static String[] dirReduc(String[] arr) {
        final Stack<String> stack = new Stack<>();

        for (final String direction : arr) {
            final String lastElement = stack.size() > 0 ? stack.lastElement() : null;

            switch(direction) {
                case "NORTH": if ("SOUTH".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
                case "SOUTH": if ("NORTH".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
                case "EAST":  if ("WEST".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
                case "WEST":  if ("EAST".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
            }
        }
        return stack.stream().toArray(String[]::new);
    }
}
*/

/*

    public static String[] reduction (String[] arr) {
        List<Dir> dirs = Arrays.stream(arr).map(Dir::new).toList();
        List<Dir> reducedDirs = new ArrayList<>();
        int i=0;
        while (i < dirs.size()) {
            if (i == dirs.size() -1) {
                reducedDirs.add(dirs.get(i));
                break;
            }
            if (dirs.get(i).isOpposite(dirs.get(i +1 ))) {
                i += 2;
            }
            else  {
                reducedDirs.add(dirs.get(i));
                i++;
            }
        }
        return reducedDirs.stream().map(Dir::dir).toArray(String[]::new);
    }

 */

/*
public class DirReduction {

  public static String[] dirReduc(String[] a) {
    Stack<String> result = new Stack<String>();
    for (int i = 0; i < a.length; i++) {
      if (result.size() > 0) {
        switch (a[i]) {
          case "NORTH":
            if (result.peek() == "SOUTH") result.pop();
            else result.push(a[i]);
            break;
          case "SOUTH":
            if (result.peek() == "NORTH") result.pop();
            else result.push(a[i]);
            break;
          case "EAST":
            if (result.peek() == "WEST") result.pop();
            else result.push(a[i]);
            break;
          case "WEST":
            if (result.peek() == "EAST") result.pop();
            else result.push(a[i]);
            break;
        }
      }
      else result.push(a[i]);
    }
    return result.toArray(new String[result.size()]);
  }

}
 */