package Depots;

import Products.CompositeProducts;
import java.util.ArrayList;
// import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * This classes builds group of Depots and gives names property and rules for max
 * and min cash allowance
 * Also it is organize the products in each depots according to the depot's 
 * company 
 * @author Felipe, Luciene and Vagner
 */
public abstract class Depots {
    
    private final String companyName;
    private int currentBalance, maxCashAllowance, minCashAllowance;
    private final List<CompositeProducts> listOfProducts;
    private final CompositeProducts createProducts;
    private int startBalance = 0;
    private int income = 0;
    private int outcome = 0;
    private int productsSold = 0;
    private int productsBought = 0;
        /**
         * Constructor that specifies information for this specific depot
         * gets the name of the company that owns the depot and creates a list of 
         * products based on the products name
         * @param companyName String with name of the company 
         */
        public Depots(String companyName){
            Random rand = new Random();  // Used for assign numbers randomly
           
            this.companyName = companyName;
            
            maxCashAllowance = 100;  // As Program requerement, max of initial cash
            minCashAllowance = 50;   // As Program requerement, min of cash
            startBalance = rand.nextInt(50)+50; // random int for starter cash
            currentBalance = startBalance;      
            listOfProducts = new ArrayList<>(); // holds all products of a depot
            createProducts = new CompositeProducts(companyName); //
        }
        /**
         * Gets the value of how much money a depot started with and
         * @return startBalance as in a int to the method that called it
         */
        public int getStartBalance(){
            return startBalance;
        }
        /**
         * Pays for a transaction whenever a product is purchased and add the 
         * value was spent on the outcome variable
         * @param amount the price paid for the product 
         */
        public void pay(int amount){
            productsBought++;
            //if statment checks if the depot can buy
            // if after purchase the depot still have the min CashAllowance, the
            // transaction is alloweded
            if((getCurrentBalance() - amount )>= getMinCashAllowance()){
                setCurrentBalance(currentBalance - amount);
                outcome += amount;
            // if not, depot can not buy and gets an error
            }else{
                System.out.println("Something went wrong at pay class Depots"+""
                        + "\tCurrent Balance : "+getCurrentBalance()+"\tProduct Price :"+amount);
            }
        }
        /**
         * Receives the money whenever a depot sells a product and add the total
         * value of the product that was sold into the income
         * @param amount the price received for a sale
         */
        public void sold(int amount){
            productsSold++;
            // the anount received is added on income variable
            setCurrentBalance(getCurrentBalance()+amount);
            income +=amount;
        }

        /**
         * Gets the number of product was sold
         * @return the amount of products was sold
         */
        public int getHowManyProductsSold(){
            return productsSold;
        }

        /**
         * Gets the number of product was purchased
         * @return how many products this depot bought
         */
        public int getHowManyProductBought(){
            return productsBought;
        }
        /**
         * Gets the amount made by the depots
         * @return how much money came in 
         */
        public int getIncome(){
            return income;
        }
        /**
         * Gets the amount spent by the depots
         * @return how much money went out 
         */
        public int getOutcome(){
            return outcome;
        }
        /**
         * Gets the name of the company that owns the group of depot
         * @return the companyName
         */
        public String getCompanyName() {
            return companyName;
        }

        /**
         * Gets the amount of money a company depot has
         * @return the currentBalance
         */
        public int getCurrentBalance() {
            return currentBalance;
        }
        /**
         * Gets the value of max cash the company can start with
         * @return the maxCashAllowance
         */
        public int getMaxCashAllowance() {
            return maxCashAllowance;
        }
        /**
         * Gets the value of min cash the company can have
         * @return the minCashAllowance
         */
        public int getMinCashAllowance() {
            return minCashAllowance;
        }

        /**
         * Gets the list of products stored in a depot and
         * @return the createProducts 
         */
        public CompositeProducts getListOfProducts() {
            return createProducts;
        }

        /**
         * Gets the price of the product A that is stored in a list
         * @param depotIndex  - the position of the depotA in the CompanyA list of depots
         * @param productIndex - the position of the productA in the depotA list of product
         * @return a int with the price
         */
        public int getProductsAPrice(int depotIndex, int productIndex){
            return getTotalPrice(depotIndex, productIndex);
        }
       /**
         * Gets the price of the product B that is stored in a list
         * @param depotIndex  - the position of the depotB in the CompanyB list of depots
         * @param productIndex - the position of the productB in the depotB list of product
         * @return a int with the price
         */
        public int getProductsBPrice(int depotIndex, int productIndex){
            return getTotalPrice(depotIndex, productIndex);
        }
       /**
         * Gets the price of the product C that is stored in a list
         * @param depotIndex  - the position of the depotC in the CompanyC list of depots
         * @param productIndex - the position of the productC in the depotC list of product
         * @return a int with the price
         */
        public int getProductsCPrice(int depotIndex, int productIndex){
            return getTotalPrice(depotIndex, productIndex);
        }

            /////////////// check it ///////////////////////////////////////
        private int getTotalPrice(int depotIndex, int productIndex){
            return listOfProducts.get(depotIndex).getProductsA().get(productIndex).getTotalPrice();
        }

        /**
         * Sets a current balance after a sale or purchase
         * @param amount int holds the current amount of money the depot has
         */
        private void setCurrentBalance(int amount){
            currentBalance = amount;
        }
        /**
         * Displays the number of each products stored in a depot
         * @return a string with the result
         */
        
        public String showProductsInStock(){
            return "Products A : "+createProducts.getProductsA().size()+
                    "\nProducts B : "+createProducts.getProductsB().size()+
                    "\nProducts C : "+createProducts.getProductsC().size();


        }

}
