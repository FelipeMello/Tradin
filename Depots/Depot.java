/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Depots;

/**
 * This class creates a concrete depot
 * @author Felipe, Luciene and Vagner
 */
public class Depot extends Depots{
    
    /**
     * This is the constructor to create this depot according to a company name
     * @param companyName String with company name that owns the depot
     */
    public Depot(String companyName) {
        super(companyName); // get for the parent class
    }
    
}
