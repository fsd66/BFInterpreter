package net.fsd66.brainfuck.testers;

import net.fsd66.brainfuck.BrainfuckFileParser;
import net.fsd66.brainfuck.BrainfuckInterpreter;

public class BrainfuckTester {
    public static void main(String[] args) {
        String code = "++++++[>++++++++++<-]>+++++."; /* This is supposed to print the letter 'A' to the console */
        BrainfuckInterpreter interpreter = new BrainfuckInterpreter(code);
        interpreter.execute();
    }
}
