package katas.rankup.brainluck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Inspired from real-world Brainf**k, we want to create an interpreter of that language which will support the following instructions:
https://en.wikipedia.org/wiki/Brainfuck

    > increment the data pointer (to point to the next cell to the right).
    < decrement the data pointer (to point to the next cell to the left).
    + increment (increase by one, truncate overflow: 255 + 1 = 0) the byte at the data pointer.
    - decrement (decrease by one, treat as unsigned byte: 0 - 1 = 255 ) the byte at the data pointer.
    . output the byte at the data pointer.
    , accept one byte of input, storing its value in the byte at the data pointer.
    [ if the byte at the data pointer is zero, then instead of moving the instruction pointer forward to the next command,
    jump it forward to the command after the matching ] command.
    ] if the byte at the data pointer is nonzero, then instead of moving the instruction pointer forward to the next command,
    jump it back to the command after the matching [ command.

The function will take in input...

    the program code, a string with the datauence of machine instructions,
    the program input, a string, possibly empty, that will be interpreted as an array of bytes
     using each character's ASCII code and will be consumed by the , instruction

... and will return ...

    the output of the interpreted code (always as a string), produced by the . instruction.

Implementation-specific details for this Kata:

    Your memory tape should be large enough - the original implementation had 30,000 cells but a few thousand should suffice for this Kata
    Each cell should hold an unsigned byte with wrapping behavior (i.e. 255 + 1 = 0, 0 - 1 = 255), initialized to 0
    The memory pointer should initially point to a cell in the tape with a sufficient number (e.g. a few thousand or more) of cells to its right.
    For convenience, you may want to have it point to the leftmost cell initially
    You may assume that the , command will never be invoked when the input stream is exhausted
    Error-handling, e.g. unmatched square brackets and/or memory pointer going past the leftmost cell is not required in this Kata.
    If you see test cases that require you to perform error-handling then please open an Issue in the Discourse for this Kata
    (don't forget to state which programming language you are attempting this Kata in).


 */
public class BrainLuck {

    // > increment the data pointer (to point to the next cell to the right).
    static final char INC = '>';
    
    // < decrement the data pointer (to point to the next cell to the left).
    static final char DEC = '<';
    
    // + increment (increase by one, truncate overflow: 255 + 1 = 0) the byte at the data pointer.
    static final char INCZ = '+';
    
    //- decrement (decrease by one, treat as unsigned byte: 0 - 1 = 255 ) the byte at the data pointer.
    static final char DECZ = '-';
    
    //. output the byte at the data pointer.
    static final char OUT = '.';
    
    //, accept one byte of input, storing its value in the byte at the data pointer.
    static final char STO = ',';
    
    // [ if the byte at the data pointer is zero, then instead of moving the instruction pointer
    //  forward to the next command,
    //  jump it forward to the command after the matching ] command.
    static final char JFINZ = '[';
    
    //] if the byte at the data pointer is nonzero, then instead of moving the instruction pointer
    // forward to the next command,
    //   jump it back to the command after the matching [ command.
    static final char JBINZ = ']';

    Character[] instructions;
    Character[] memory;
    StringBuilder screen;
    Integer instrPtr = 0;
    Integer dataPtr = 0;

    public BrainLuck(String code) {
        instructions = toCharArray(code);
        instrPtr = 0;
    }

    public static Character[] toCharArray(String data) {
        return (Character[]) data.chars()
                .mapToObj( i -> (char) i)
                .toArray(Character[]::new);
    }

    public String process(String input) {
        memory = new Character[10_0000];
        Arrays.fill(memory, '\0');
        screen = new StringBuilder();
        while( instrPtr < instructions.length) {
            switch (instructions[instrPtr]) {
                case INC:
                    instrPtr++;
                    dataPtr++;
                    break;
                case DEC:
                    instrPtr++;
                    dataPtr--;
                    break;
                case INCZ:
                    instrPtr++;
                    int inc  = memory[dataPtr] + 1;
                    memory[dataPtr] =  (char) (inc > 255 ? 0 : inc);
                    break;
                case DECZ:
                    instrPtr++;
                    int dec  = memory[dataPtr] - 1;
                    memory[dataPtr] =  (char) (dec < 0 ? 255 : dec);
                    break;
                case OUT:
                    instrPtr++;
                    screen.append(memory[dataPtr]);
                    break;
                case STO:
                    instrPtr++;
                    memory[dataPtr] = input.charAt(0);
                    input = input.substring(1, input.length());
                    break;
                case JFINZ:
                    if (memory[dataPtr] == 0) {
                        instrPtr = movePointerForward(instrPtr, instructions);
                    } else {
                        instrPtr++;
                    }
                    break;
                case JBINZ:
                    if (memory[dataPtr] != 0) {
                        instrPtr = movePointerBackward(instrPtr, instructions);
                    } else {
                        instrPtr++;
                    }
                    break;
            }
        }
        return screen.toString();
    }
    
    public static Integer movePointerForward(int pointer, Character[] instructions) {
        return movePointer(JFINZ, JBINZ, pointer, instructions);
    }
    public static int movePointerBackward(int pointer, Character[] instructions) {
        return movePointer(JBINZ, JFINZ, pointer, instructions);
    }

    static Integer movePointer(char FWD, char BCK, int pointer, Character[] instructions) {
        int stack = 0;
        int i = pointer;
        while ( (FWD == JFINZ && i < instructions.length) // forward exit
                || (FWD == JBINZ && i >= 0 )   ) { // backward exit
            if (instructions[i] ==  FWD) { stack++; }
            if (instructions[i] == BCK) { stack--; }
            if (stack==0 && instructions[i] == BCK) {
                return i;
            }
            i += FWD == JFINZ ? 1 : -1;
        }
        return pointer;
    }
}
