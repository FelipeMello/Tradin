package Companies;

import Depots.Depot;
import Depots.DepotFactory;
import Depots.Depots;
import java.util.LinkedList;
import java.util.List;

/**
 * This class is a Composite Design that has as interface CompanyInterface
 * Its job is compose a company, give name, a group of depots,
 * get revenue, also to have all information about, initial revenue, 
 * actual revenue, total sold, total bought
 * @author Felipe, Luciene and Vagner
 */
public class CompositeCompany implements CompaniesInterface {
    
    private final DepotFactory depotFactory;        // create a depot Factory
    private Depot depot;                            // create a depot from the factory
    private final LinkedList<Depots> listOfDepots;  // list is a linked list to group the depots
    private final String companyName;               // String with a company name
    
    /**
     * This is the constructor to composite a specific company
     * @param companyName String type 
     */
        
    public CompositeCompany(String companyName){
        depotFactory = new DepotFactory();  // instantiate a empty depot factory
        listOfDepots = new LinkedList<>();  // instantiate a empty list
        this.companyName = companyName;     // assign the param as the company name 
        generateDepots(companyName);        // generate all depots for the company just created
        
    }

    /**
     * Generates depots and adds to the specific company
     * It runs the createDepots() method to assign the depot created to an 
     * specific company
     * @param companyName BigA, BigB or BigC 
     */
    private void generateDepots(String companyName){
        // Switch statement to generate the depots according the company 
        //name that  has being created
        switch(companyName){
            case "BigA":
                createAListOfDepots(getListOfDepots(), getDepot(),companyName, 100);
                break;
            case "BigB":
                createAListOfDepots(getListOfDepots(), getDepot(),companyName, 100);
                break;
            case "BigC":
                createAListOfDepots(getListOfDepots(), getDepot(),companyName, 100);
                break;
        }
        
    }
    /**
     * Organizes the depots in lists groups depending on the company they
     * will belong to. 
     * @param list - A list to hold a group of depots
     * @param depot - an individual depot
     * @param companyName - the name of the company that the depot belongs to
     * @param numberOfDepots - the number of depots a company has
     */
    private void createAListOfDepots(List<Depots> list, Depots depot, String companyName, int numberOfDepots){
        // each time this for loop runs, the individual depot is made within 
        // the fabric and labeled with the name the company it belongs to
        // after the depot is added to the list of group of depots
        // as per program requeriment, each company must have 100 depot each
        for(int i=0; i < numberOfDepots;i++){
            depot = getDepotFactory().makeDepot(companyName);
            list.add(depot);
        }
    }
    /**
     * Gets a specific depot
     * @return 
     */
    private Depot getDepot(){
        return depot;
    }

    /**
     * Gets a list containing all Depots
     * @return a list of depots
     */
    @Override
    public List<Depots> getListOfDepots() {
        return listOfDepots;
    }

    /**
     * Gets a factory of general depots
     * @return a DepotFactory Object
     */
    private DepotFactory getDepotFactory() {
        return depotFactory;
    }

    /**
     * Overrides the method from the interface to customize as needed
     * @return a String with the company name
     */
    @Override
    public String getCompanyName() {
        return companyName;
    }
    /**
     * Overrides the method from the interface to get revenue from a company
     * @return an integer with the company revenue value
     */
    @Override
    public int getRevenue(){
        int revenue =0;
        for(int i=0; i< listOfDepots.size(); i++){
            revenue += listOfDepots.get(i).getCurrentBalance();
        }
        return revenue;
        
    }
    /**
    * Overrides the method from the interface to get the initial revenue 
    * a company had when started trading
    * @return an integer with the total value of money a company had before 
    * starting  to trade on the market.
    */
    @Override
    public int getStartRevenue(){
        int startRevenue =0;
        // a for loop goes throught the list of company depots getting
        // the amount each one have and adding to the total revenue
        for(int i=0; i < listOfDepots.size(); i++){
            startRevenue += listOfDepots.get(i).getStartBalance();
        }
        return startRevenue;
    }
    
    /**
     * Overrides a method from interface to get the income amount of a specific
     * company
     * @return an integer with the total amount of profit.
     */
    @Override
    public int getIncome(){
        int income =0;
        // a for loop goes throught the list of company depots getting
        // the amount sold by each one and adding to the total income
        for(int i=0; i< listOfDepots.size();i++){
            income += listOfDepots.get(i).getIncome();
        }
        return income;
    }
    
    /**
     * Overrides a method from interface to get the outcome amount of a specific
     * @return an integer with the total amount of spent
     */
    @Override
    public int getOutcome(){
        int outcome =0;
        // a for loop goes throught the list of company depots getting
        // the amount paid by each one and adding to the total outcome
        for(int i=0; i< listOfDepots.size();i++){
            outcome += listOfDepots.get(i).getOutcome();
        }
        return outcome;
    }
    /**
     * Gets the total of products sold by a specific company
     * @return an integer with the quantity of how many products was sold 
     */
    @Override
    public int getTotalSold(){
        int totalSold = 0;
        // a for loop goes throught the list of company depots getting
        // the number of products sold by each depot and adding to total sold
        for(int i=0; i< listOfDepots.size(); i++){
            totalSold += listOfDepots.get(i).getHowManyProductsSold();
        }
        return totalSold;
    }
    /**
     * Gets the total of products a specific company bought
     * @return an integer with the quantity of how many products was bought
     */
    @Override
    public int getTotalBought(){
        // a for loop goes throught the list of company depots getting
        // the number of products bought by each depot and adding to total bought
        int totalBought = 0;
        for(int i=0; i< listOfDepots.size(); i++){
            totalBought += listOfDepots.get(i).getHowManyProductBought();
        }
        return totalBought;
        
    }
    
    /**
     * gets the price of a specific product
     * @param productType - the product name
     * @param depotIndex - depot where the product is stored in
     * @param productIndex - the reference of the product within the depot
     * @return a integer with the Product price
     */
    
    @Override
    public int getProductPrice(String productType, int depotIndex, int productIndex){
        switch(productType){
            case "productA":
                return listOfDepots.get(depotIndex).getListOfProducts().getProductsA().get(productIndex).getProductPrice();
                
            case "productB":
                return listOfDepots.get(depotIndex).getListOfProducts().getProductsB().get(productIndex).getProductPrice();
                
            case "productC":
                return listOfDepots.get(depotIndex).getListOfProducts().getProductsC().get(productIndex).getProductPrice();
                
        }
     return 0;
    }
}
