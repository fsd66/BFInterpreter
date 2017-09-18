package net.fsd66.brainfuck.testers;

import net.fsd66.brainfuck.BrainfuckFileParser;
import net.fsd66.brainfuck.BrainfuckInterpreter;

public class BrainfuckParsingTester {
    public static void main(String[] args) {
        BrainfuckFileParser parser = new BrainfuckFileParser("data/test1.txt", BrainfuckInterpreter.LEGAL_CHARACTERS);
        parser.parseString();
        BrainfuckInterpreter interpreter = new BrainfuckInterpreter(parser.getOutput());
        interpreter.execute();
    }
}
