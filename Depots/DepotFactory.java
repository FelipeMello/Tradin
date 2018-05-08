
package Depots;

/**
 * This class is a Factory Design Pattern used to produce depots
 * It gets a plain depot and labels with the name of a company 
 * @author Felipe, Luciene and Vagner
 */
public class DepotFactory {
    
    /**
     * Makes the depot to an specific company a required
     * @param companyName - String with the name of the company ("BigA, BigB or BigC")
     * @return a new Depot
     */
    
    public Depots makeDepot(String companyName) {
        return new Depot(companyName);
    }

}
