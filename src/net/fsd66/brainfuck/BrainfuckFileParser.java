package net.fsd66.brainfuck;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class BrainfuckFileParser {
    private char[] legalChars;
    private String path;
    private String output;

    public BrainfuckFileParser(String path, char[] legalChars) {
        this.path = path;
        this.legalChars = legalChars;
        this.output = "";
    }

    public void parseString() {
        String line = "";
        try {
            FileReader fileReader = new FileReader(new File(path));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                output += line;
            }

        } catch (FileNotFoundException e) {
            System.err.println("Could not find file " + "\"path\"");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private LinkedList<Character> convertStringToList(String string) {
        LinkedList<Character> characterList = new LinkedList<Character>();
        for(char character : string.toCharArray()) {
            characterList.add(character);
        }
        return characterList;
    }

    private String convertListToString(List<Character> characterList) {
        String output = "";
        for(Character characters : characterList) {
            output.concat(characters.toString());
        }
        return output;
    }

    public char[] getLegalChars() {
        return legalChars;
    }

    public void setLegalChars(char[] legalChars) {
        this.legalChars = legalChars;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
