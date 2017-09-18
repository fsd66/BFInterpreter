package net.fsd66.brainfuck;

import java.util.Scanner;
import java.util.Stack;

public class BrainfuckInterpreter {
    public static final char INCREMENT = '+';
    public static final char DECREMENT = '-';
    public static final char MOVE_RIGHT = '>';
    public static final char MOVE_LEFT = '<';
    public static final char PRINT = '.';
    public static final char READ = ',';
    public static final char START_LOOP = '[';
    public static final char END_LOOP = ']';
    public static final char[] LEGAL_CHARACTERS = {INCREMENT, DECREMENT, MOVE_LEFT, MOVE_RIGHT, PRINT, READ, START_LOOP, END_LOOP};
    
    private int[] data;
    private int dataPointer;
    private String input;
    private int codePointer;
    private char[] inputCharacterArray;
    private Scanner scanner;

    private Stack<Integer> lastLoopStartIndexStack;

    public BrainfuckInterpreter(String input) {
        this.input = input;
        this.inputCharacterArray = this.input.toCharArray();
        this.data = new int[30000];
        this.dataPointer = 0;
        this.codePointer = 0;
        this.scanner = new Scanner(System.in);

        this.lastLoopStartIndexStack = new Stack<Integer>();
    }

    public void execute() {
        while(codePointer < inputCharacterArray.length) {
            //System.out.println("Current instruction: " + inputCharacterArray[codePointer] + ", Current data value: " + data[dataPointer]);
            step();
        }
    }

    public void increment() {
        data[dataPointer]++;
    }

    public void decrement() {
        data[dataPointer]--;
    }

    public void nextCell() {
        dataPointer++;
    }

    public void previousCell() {
        dataPointer--;
    }

    public void printCell() {
        System.out.print((char) data[dataPointer]);
    }

    public void readInput() {
        char input = scanner.nextLine().charAt(0);
        data[dataPointer] = (int) input;
    }

    public void storeLoop() {
        if(data[dataPointer] != 0) {
            lastLoopStartIndexStack.push(codePointer);
        }
        else {
            skipToCorrespondingEndBracket();
        }
    }

    private void skipToCorrespondingEndBracket() {
        int countEndBracketsToSkip = 0;
        for(int i = codePointer + 1; i < input.length(); i++) {
            if(input.charAt(i) == END_LOOP) {
                if(countEndBracketsToSkip == 0) {
                    codePointer = i;
                    return;
                }
                else {
                    countEndBracketsToSkip--;
                }
            }
            else if (input.charAt(i) == START_LOOP) {
                countEndBracketsToSkip++;
            }
        }
    }

    public void recallLoop() {
        codePointer = lastLoopStartIndexStack.pop();
    }

    public void step() {

        switch(inputCharacterArray[codePointer]) {
            case INCREMENT: {
                increment();
                break;
            }
            case DECREMENT: {
                decrement();
                break;
            }
            case MOVE_RIGHT: {
                nextCell();
                break;
            }
            case MOVE_LEFT: {
                previousCell();
                break;
            }
            case PRINT: {
                printCell();
                break;
            }
            case READ: {
                readInput();
                break;
            }
            case START_LOOP: {
                storeLoop();
                break;
            }
            case END_LOOP: {
                recallLoop();
                codePointer--;
                break;
            }
            default: {
                break;
            }
        }
        codePointer++;
    }
}
