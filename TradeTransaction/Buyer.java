package TradeTransaction;

import Companies.CompositeCompany;
import Products.Products;

/**
 * This class analyzes the depots to evaluate whether the company can buy or not
 * Checks if the depot has enough money to pay and if has enough space to store
 * a new product according the rules set
 *
 * @author Felipe, Luciene and Vagner
 */
public class Buyer {

    private CompositeCompany buyer;
    private int buyerDepotNumber;
    private Products product;

    /**
     * Constructor for the class that gets the parameters to process buyer
     * conditions
     *
     * @param buyer the company which wants to buy
     * @param buyerDepotNumber the depot where the new product will storage
     * @param product the product on sale
     */
    public Buyer(CompositeCompany buyer, int buyerDepotNumber, Products product) {
        this.buyer = buyer;
        this.buyerDepotNumber = buyerDepotNumber;
        this.product = product;
    }

    /**
     * Runs the methods that checks both conditional if depot has money if depot
     * has storage capacity
     * @return boolean whether a depotCanBuy can buy or not
     */
    public boolean depotCanBuy() {
        return buyerHasMoney() == true && buyerHasStorage() == true;
    }

    /**
     * Checks if the depot has enough money to buy a product trading rules for
     * minimum cash allowance. Analyzes the depot current balance and the Price
     * of the Product the depot wants to buy
     *
     * @return a boolean true or false indicating if can buy or not
     */
    public boolean buyerHasMoney() {
        // access the lists of depots of the company that wants to buy and gets
        // the min Cash allowace the depot can have
        // For our project it is required at least 50
        int minCashAllowance;
        minCashAllowance = getBuyer().getListOfDepots().get(buyerDepotNumber)
                .getMinCashAllowance();
        // access the lists of depots of the company that wants to buy and the
        // gets the current balance of the depot 
        int currentBalance;
        currentBalance = getBuyer().getListOfDepots().get(buyerDepotNumber)
                .getCurrentBalance();
        // gets the price of the product on sale
        int productPrice;
        productPrice = getProduct().getTotalPrice();

        // after that checks if the depot will still mantain the min cash 
        // allowance after buy the product
        // if yes, returns true. If not, return false
        return (currentBalance - productPrice) >= minCashAllowance;
    }

    /**
     * Checks if a depot has enough space for a new product under the program
     * stock rules Analyzes the maximum number of product the depot can have in
     * stock
     *
     * @return a boolean whether true if there is enough storage and false if
     * there isn't
     */

    public boolean buyerHasStorage() {
        // switch statement considering the type of product on sales
        switch (getProduct().getProductName()) {
            // if the company wants to buy product A
            case "productA":
                // gets the current size of the list of storage for Product A
                int listSize = getBuyer().getListOfDepots().get(getBuyerDepotNumber()).getListOfProducts()
                        .getProductsA().size();
                // gets the max stock of Product A allowed
                int maxStorage = getBuyer().getListOfDepots().get(getBuyerDepotNumber()).getListOfProducts()
                        .getProductAMax();

                return listSize < maxStorage;

            // if the company wants to buy Product B
            case "productB":
                // gets the current size of the list of storage for Product B                
                listSize = getBuyer().getListOfDepots().get(getBuyerDepotNumber()).getListOfProducts().getProductsB().size();
                // gets the max stock of Product B allowed
                maxStorage = getBuyer().getListOfDepots().get(getBuyerDepotNumber()).getListOfProducts().getProductBMax();
                return listSize < maxStorage;

            // if the company wants to buy product C  
            case "productC":
                // gets the current size of the list of storage for Product C                
                listSize = getBuyer().getListOfDepots().get(getBuyerDepotNumber()).getListOfProducts().getProductsC().size();
                // gets the max stock of Product C allowed
                maxStorage = getBuyer().getListOfDepots().get(getBuyerDepotNumber()).getListOfProducts().getProductCMax();
                if (listSize < maxStorage) {
                    return true;
                }
        }
        return false;
    }

    /**
     * CompositeCompany
     * @return the buyer
     */
    public CompositeCompany getBuyer() {
        return buyer;
    }

    /**
     * Sets a company as a buyer
     * @param buyer the buyer to set
     */
    public void setBuyer(CompositeCompany buyer) {
        this.buyer = buyer;
    }

    /**
     * Gets one depot to try to buy
     *
     * @return the buyerDepotNumber
     */
    public int getBuyerDepotNumber() {
        return buyerDepotNumber;
    }

    /**
     * Sets a depot as a buyer
     * @param buyerDepotNumber the buyerDepotNumber to set
     */
    public void setBuyerDepotNumber(int buyerDepotNumber) {
        this.buyerDepotNumber = buyerDepotNumber;
    }

    /**
     * Gets one product to try to sell
     *
     * @return the product
     */
    public Products getProduct() {
        return product;
    }

    /**
     * Sets the product to be sold
     *
     * @param product the product on sale
     */
    public void setProduct(Products product) {
        this.product = product;
    }
}
