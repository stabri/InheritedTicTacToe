package com.wojnar.IOstrems;

import com.wojnar.Players.Player;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by bartomiej on 29.06.17.
 */
public class OutputController {
    private  OutputStream output;

    public OutputController(OutputStream output) {
        this.output=output;
    }

     void writeOut(String message) {
        try {
            String nLineMessage = message.concat("\n");
            output.write(nLineMessage.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void printWelcomeMessage() {
        writeOut("Welcome to TicTacToe game");
    }

    public void printMenuMessage() {
        writeOut("Press:");
        writeOut("1 - to play BO3");
        writeOut("0 - exit game");
    }

    public void printPlayerNameSelectionMessage(int playerNumber) {
        writeOut("Please choose name for player " + playerNumber);
    }
    public void printCharacterSelectionMessage() {
        writeOut("Please claim the character: O or X");
    }

    public void printWrongCharacterSelection() {
        writeOut("Unavailable characters selected. Chose X or O");
    }

    public void printBoardSizeSelectionMessage(String axis) {
       writeOut("How many fields board should have in " + axis + " axis");
    }
    public void printToSmallBoardSizeMessage(String axis) {
        writeOut("Board size " + axis + " is too small. Setting up as default 3 ...");
    }
    public void printSelectingSequenceLengthMessage() {
        writeOut("How long character sequence should be");
    }
    public void printSequenceLengthTooBigMessage() {
        writeOut("Sequence length is bigger than shorter side of board. Setting it as this side value");
    }
    public void printSequenceLengthTooSmallMessage() {
        writeOut("Sequence length is smaller than default 3 value. Setting it as this value");
    }
    public void printCharacterPlacingMessage(Player player) {
        writeOut("Where would " + player.getName() + " place his character");
    }
    public void printChoosingCoordinateMessage(String coordinate, int sideSize) {
        writeOut("Please select " + coordinate + " coordinate: (From 1 to " + sideSize + ")"); }

    public void printBO3WonMessage(List<Player> players) {
        writeOut(players.get(0).getName() + " score after 3 rounds - "+ players.get(0).getScore() +
        " and "+players.get(1).getName() + " score after 3 rounds - "+ players.get(1).getScore());
    }

    public void printOneGameWonMessage(Player player) {
            writeOut(player.getName() + " won match!");
    }

    public void fieldBusy() {
        writeOut("Chosen field is occupied. Chose free field (number from playBoard):");
    }
    public void fieldNonExist() { writeOut("Only number from playBoard !!!! ");
    }
    public void printWrongSequence() {
        writeOut("Wrong !!! It must be number");
    }
    public void printWrongSequence(int i) {
        writeOut("Wrong !!! It must be number, at least "+i);
    }
    public void printWrongSequence(int width, int height) {
        writeOut("Wrong !! Sequence can't be longr than width - " + width +
        "or height - "+height);
    }
    public void printInputMismachExMessage() {
        writeOut("Wrong field !!!! Try again !! Chose field number from PlayBoard!!");
    }

    public void printGodbayMessage() {
        writeOut("See You.");
    }
}
