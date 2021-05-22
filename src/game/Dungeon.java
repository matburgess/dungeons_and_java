package game;

import utility.File;
import utility.FileIO;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * Class which initiates the application, Dungeons and Java.
 *
 * @author Matt Burgess
 * @version ver1.0.0
 */
public class Dungeon
{
    private Game currentGame;

    /**
     * Default constructor which creates the object of the Dungeon class.
     *
     */
    public Dungeon()
    {
        this.currentGame = null;
    }

    /**
     * Print the application welcome messages to the console.
     *
     */
    public void applicationWelcome()
    {
        printGameBanner();
        printDungeonIntroduction();
    }

    /**
     * Accessor method to get the current game.
     *
     * @return                          The current game being played in the applicaiton.
     */
    public Game getCurrentGame()
    {
        return this.currentGame;
    }

    /**
     * Method to begin the program.
     *
     * @param args                      An array of strings represnting command line arguments.
     */
    public static void main(String[] args)
    {
        Dungeon newDungeon = new Dungeon();
        newDungeon.applicationWelcome();
        newDungeon.playNewGame();
    }

    /**
     * Method to play a new game of Dungeons and Java.
     *
     */
    public void playNewGame()
    {
        setCurrentGame(Game.getGame());
        this.currentGame.startGame();
        writeGameResultToOutput(currentGame.getGameResultString());
    }

    /**
     * Print the welcome message to the console.
     *
     */
    public static void printDungeonIntroduction()
    {
        System.out.println("Welcome to the game, Dungeons and Java.");
        System.out.println();
        System.out.println("In this text-based adventure game, you, a brave and noble warrior, will");
        System.out.println("enter the dungeon of the infamous villian, NullPointerException, in search of fame and fortune.");
        System.out.println();
        System.out.println("It won't be easy. You'll encounter all manner of dangerous monstrosities, ");
        System.out.println("with only the thought of lunch on their minds.");
        System.out.println();
        System.out.println("Will you emerge triumphant and etch your name in to the history books? Or, will you");
        System.out.println("be another, lost to the lure of treasure and the promise of fame?");
        System.out.println();
        System.out.println("Let's find out...");
        System.out.println();
    }

    /**
     * Print the application banner to the console.
     *
     */
    public static void printGameBanner()
    {
        System.out.println();
        System.out.println("***********************************");
        System.out.println();
        System.out.println("        Dungeons and Java   ");
        System.out.println();
        System.out.println("***********************************");
        System.out.println();
        System.out.println();
        System.out.println("Type 'quit' at any time to quit");
        System.out.println();
    }

    /**
     * Mutator method for the game being played within the application.
     *
     * @param game                      Accepts the game being played in the application as a Game object.
     */
    public void setCurrentGame(Game game)
    {
        this.currentGame = game;
    }

    /**
     * Write the result of the game to an output file.
     *
     * @param gameResult                Accepts game results as a string.
     */
    public void writeGameResultToOutput(String gameResult)
    {
        FileIO.writeFile(File.OUTPUT, gameResult);
    }

}