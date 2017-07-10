package com.paul.IOStreams;

import com.paul.board.AvailableMarks;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by paul on 04.07.17.
 */
public class InputController {
    private Scanner entry;
    private OutputController out;


    public InputController(InputStream in, OutputController outputController) {
        this.entry = new Scanner(in);
        this.out = outputController;
    }

    public String playerName() {
        String playerName = entry.next();
        return playerName.trim();
    }

    public AvailableMarks choseMark() {
        try{
            String mark =entry.next();
            if(mark.equalsIgnoreCase(AvailableMarks.O.getCharacter()))
                return AvailableMarks.O;
            else if(mark.equalsIgnoreCase(AvailableMarks.X.getCharacter()))
                return AvailableMarks.X;
            else
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException iae){
            out.writeOut("printWrongCharacterSelection");
            return choseMark();
        }
    }
    public int takeNumberFromUser() {
        String userInput = entry.next();
        try {
            return Integer.parseInt(userInput);
        }catch (NumberFormatException nfe){
            out.writeOut("printWrongSequence");
            return takeNumberFromUser();
        }
    }

    private int takeNumberFromUser(int minSize){
        String userInput = Integer.toString(takeNumberFromUser());
        try {
            if (Integer.parseInt(userInput) < minSize)
                throw new InputMismatchException();
            return Integer.parseInt(userInput);
        }catch (InputMismatchException ime ) {
            out.writeOut("printWrongSequence");
            System.out.println(minSize);
            return takeNumberFromUser(minSize);
        }
    }

    public int takeNumberFromUser(int width, int height) {
        String userInput = Integer.toString(takeNumberFromUser(3));
        try {
            if (Integer.parseInt(userInput) >width ||
                    Integer.parseInt(userInput) > height)
                throw new IllegalArgumentException();
                return Integer.parseInt(userInput);
        }catch (IllegalArgumentException iae){
            out.writeOut("printWrongSequenceHeightWidth");
            System.out.println(width+"x"+height);
            return takeNumberFromUser(width,height);
        }
    }


    public int getWidth() {
        out.writeOut("printBoardSizeSelectionMessage");
        System.out.println(" OX");
        return takeNumberFromUser(3);
    }

    public int getHeight() {
        out.writeOut("printBoardSizeSelectionMessage");
        System.out.println(" OY");
        return takeNumberFromUser(3);
    }
}
