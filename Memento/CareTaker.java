/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memento;

import java.util.ArrayList;

/**
 * This class takes care of the saving part of the Memento state were all the
 * Memento states are saved
 *
 * @author Felipe , Luciene and Vagner.
 */
public class CareTaker {

    private final ArrayList<Memento> saveTransactions = new ArrayList<>();
    
    //singleton
    private static CareTaker careTaker = new CareTaker();
    //Making the constructor private so this class can't be instatiated
    public CareTaker() {}
    
    /**
     *
     * @return CareTaker
     */
    public static CareTaker getCareTaker(){
        return careTaker;
    }
    
    /**
     * 
     * @param save 
     * Adds memento to the ArrayList
     */
    public void addMemento(Memento save) {
        saveTransactions.add(save);
    }

    /**
     *
     * @param index Integer
     * @return the memento requested from the ArrayList
     */
    public Memento getMemento(int index) {
        return saveTransactions.get(index);
    }

    /**
     *
     * @param index Integer
     * @return a string with the buyer name
     */
    public String getBuyerName(int index) {
        return saveTransactions.get(index).getBuyer().getCompanyName();
    }

    /**
     *
     * @param index Integer
     * @return a string with the seller name
     */
    public String getSellerName(int index) {
        return saveTransactions.get(index).getSeller().getCompanyName();
    }

    /**
     *
     * @return the ArrayList of Memento
     */
    public ArrayList<Memento> getSaveTransactions() {
        return saveTransactions;
    }

}
