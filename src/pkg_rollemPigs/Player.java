/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_rollemPigs;

import dicetestpackage.DieLabel;

/**
 * Used as the player class in the dice game 'Pigs'. This class will keep track of
 * the players score, active status, and any actions that the players takes.
 * 
 * @author josephrunser
 */
public class Player {
    
    // Is the name of the player.
    private String name = "";
    
    // Die objects that are used as safety.
    private DieLabel dieOne;
    private DieLabel dieTwo;
    
    // Keep tracks of the scores.
    private int gameScore;
    private int turnScore;
    
    // Keep track of the turn status of the player, true if the player is active
    // false otherwise.
    private boolean isActive;
    
    
    /**
     * The constructor for Player class. It will initialize each player with 0 in
     * both gameScore and turnScore as well as setting the players turnStatus to 
     * false (i.e. it is not currently their turn).
     */
    Player() { 
        
        dieOne = new DieLabel();
        dieTwo = new DieLabel();
        
        turnScore = 0;
        gameScore = 0;
        
        isActive = false;
    }
    
    /**
     * The constructor for Player class which allows the user to initialize the 
     * class with a player name set. It will also initialize each player with 0 
     * in both gameScore and turnScore as well as setting the players turnStatus 
     * to false (i.e. it is not currently their turn).
     * 
     * @param name As string that should hold the name of the player.
     */
    Player(String name) {
        
        this.name = name;
        
        dieOne = new DieLabel();
        dieTwo = new DieLabel();
        
        turnScore = 0;
        gameScore = 0;
        
        isActive = false;
    }
    
    /**
     * This will roll the dice objects that are passed as parameters.
     * 
     * @param dieOne A dice object that is to be rolled.
     * @param dieTwo Another dice object that is to be rolled.
     * 
     * @return The integer value that is the sum of the faces of the two dice objects.
     */
    public int rollDie(DieLabel dieOne, DieLabel dieTwo) {
        
        this.dieOne = dieOne;
        this.dieTwo = dieTwo;
                
        this.dieOne.rollDie();
        this.dieTwo.rollDie();
        
        turnScore += this.dieOne.getDieValue();
        turnScore += this.dieTwo.getDieValue();
        
        return turnScore;
        
    }
    
    /**
     * This will tell if the turn score is lost in accordance with the rules of 
     * the dice game 'Pigs'. It will also set the turnScore to 0.
     * 
     * @return True if the turn score is lost and false otherwise.
     */
    public boolean isTurnScoreLost() {
        
        if(dieOne.getDieValue() == 1 || dieTwo.getDieValue() == 1) {
            isActive = false;
            turnScore = 0;
            
            return true;
        }
        
        return false;
        
    }
    
    
    /**
     * This will return a weather the game score is lost or not in accordance with
     * the rules of the dice game 'Pigs'. It also sets the gameScore and turnScore
     * to 0.
     * 
     * @return True if the game score is lost and false otherwise.
     */
    public boolean isGameScoreLost() {
                
        if(dieOne.getDieValue() == 1 && dieTwo.getDieValue() == 1) {
            isActive = false;
            gameScore = 0;
            turnScore = 0;
            
            return true;
        }
        
        return false;
        
    }
    
    /**
     * Determines weather the player has won the game or not, in accordance with
     * the rules of the dice game 'Pigs'.
     * 
     * @return True if the game score is greater than or equal to 100 and false if
     * otherwise.
     */
    public boolean hasWon() {
        
        return (gameScore >= 100);
        
    }
    
    /**
     * Will add the turnScore to the gameScore if the player is active.
     * 
     * @return True if the score is successfully added and false if otherwise.
     */
    public boolean addTurnScoreToGameScore() {
        
        if(isActive) {
            gameScore += turnScore;
            isActive = false;
            
            turnScore = 0;
            
            return true;
        }
        
        return false;
        
    }
    
    /**
     * A getter for the turn score.
     * 
     * @return Will return the players current turn score.
     */
    public int getTurnScore() {
        
        return turnScore;
        
    }
    
    /**
     * A getter for the game score.
     * 
     * @return The players current game score.
     */
    public int getGameScore() {
        
        return gameScore;
        
    }
    
    /**
     * Reset the game. It will set the gameScore and turnScore to 0.
     * 
     */
    public void reset() {
        
        turnScore = 0;
        gameScore = 0;
        
    }
    
    /**
     * Getter for the playerName.
     * 
     * @return A String containing the players name.
     */
    public String getName() {
        
        return name;
        
    }
    
    /**
     * Setter for the playerName.
     * 
     * @param name String that will represent the players name.
     */
    public void setName(String name) {
        
        this.name = name;
        
    }
    
    /**
     * Getter to see weather the player is currently active or not.
     * 
     * @return True if the player is active false if otherwise.
     */
    public boolean getTurnStatus() {
        
        return isActive;
        
    }
    
    /**
     * Sets the players turn status to true (active). 
     */
    public void setTurnStatusTrue() {
        
        isActive = true;
        
    }
    
    /**
     * Sets the players turn status to false (inactive).
     */
    public void setTurnStatusFalse() {
        
        isActive = false;
        
    }
    
}