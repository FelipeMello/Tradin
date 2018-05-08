/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TradeTransaction;

import Companies.CompositeCompany;
import Products.Products;
import java.util.ArrayList;
import java.util.List;
import Memento.*;

/**
 *
 * @author Felipe, Luciene and Vagner
 */
public class Transaction {


    int canSellAmount = 0;
    int canBuyAmount = 0;
    //Using memento design pattern
    private Originator originator = new Originator();
    private CareTaker carer = new CareTaker(); // singleton

    public static Transaction instance = null;
    private ArrayList <CompositeCompany> buyers = new ArrayList<>(); 
    private ArrayList <CompositeCompany> sellers = new ArrayList<>();

    

    /**
     * This method takes an ArrayList of CompositeCompany and it calls the
     * doTrade method to execute the trades
     *
     * @param companies List of CompositeCompany 
     */
    //This method takes an array list of compositeCompany
    //then it loops's through and set each company as seller and as a buyer
    //the call the doTrade method 6 times passing 6 different combinations
    public void startTransactions(List<CompositeCompany> companies) {

            //Setting every company as a buyer and as seller
            for(int i =0; i<companies.size(); i++){
                getBuyers().add(companies.get(i));
                getSellers().add(companies.get(i));
            }
            //As we have 3 companies and they have to attempt to buy and sell with each other
            //we are going to have 3 sets of 2
    
            //first set of Combination
            doTrade(getBuyers().get(0), getSellers().get(1));
            doTrade(getBuyers().get(0), getSellers().get(2));
            
            //Second set of Combination
            doTrade(getBuyers().get(1), getSellers().get(0));
            doTrade(getBuyers().get(1), getSellers().get(2));
            
            
            //Third set of Combination
            doTrade(getBuyers().get(2), getSellers().get(0));
            doTrade(getBuyers().get(2), getSellers().get(1));
    
    }

    /**
     *
     * @param buying takes a CompositeCompany that wants to buy products
     * @param selling takes a CompositeCompany that wants to sell products
     */
    public void doTrade(CompositeCompany buying, CompositeCompany selling) {
        Products product = null;

        //loop through each depot at the the company that is selling products
        for (int s = 0; s < selling.getListOfDepots().size(); s++) {

            //if depot can sell products go to the next looop
            if (true == canSell(selling, s)) {
                //check how many products it can sell
                int maxProductCanSell = howManyProductItCanSell(selling, s);

                //try to sell all the products
                for (int p = 0; p < maxProductCanSell; p++) {
                    product = getProduct(selling, s);
                    //loop trough can buy and check if can buy
                    //check if depot canBuyTheProduct
                    
                    //try to sell to every depot of the buyer company
                    for (int b = 0; b < buying.getListOfDepots().size(); b++) {
                        //if depot can buy continue
                        if (canBuy(buying, b, product) == true) {
                            //do the trade 
                            trade(buying, b, selling, s, product);
                            //save the transaction
                            saveTransaction(buying, b, selling, s, product);
                        }
                    }
                }

                //get the first product to sell
                //try to sell these products till is qual to zero
                //check who can buy
            }
        }
    }

    /**
     * This method saves every single transaction
     * @param buyer takes a CompositeCompany buyer
     * @param buyerDepotN takes a depot number Integer
     * @param seller takes a CompositeCompany seller
     * @param sellerDepotN takes a depot number Integer
     * @param product takes a Product
     */
    //Every time a transaction happens I set the originator with the values of 
    //of the transaction then I save it in the CareTaker list
    public void saveTransaction(CompositeCompany buyer, int buyerDepotN, CompositeCompany seller, int sellerDepotN, Products product) {

        //Buyer name
        getOriginator().setBuyer(buyer);
        //depot number
        getOriginator().setBuyerDepotN(buyerDepotN);

        //product bough
        getOriginator().setProduct(product);
        //product Price
        getOriginator().setCostOfProducts(product.getProductPrice());
        //delivery price
        getOriginator().setCostOfDeliviery(product.getDeliveryPrice());
        //product total price
        getOriginator().setTotalCost(product.getTotalPrice());

        //Seller name
        getOriginator().setSeller(seller);
        //depot number
        getOriginator().setSellerDepotN(sellerDepotN);

        getCarer().addMemento(originator.storeInMemento());

    }

    /**
     * do the trade
     * @param buyer Object Type of CompsiteCompany
     * @param buyerDepotNumber Integer depot number
     * @param seller Object type of CompositeCompany
     * @param sellerDepotNumber Integer depot number
     * @param product Object Type of Products
     */
    public void trade(CompositeCompany buyer, int buyerDepotNumber, CompositeCompany seller, int sellerDepotNumber, Products product) {
        Trade trade = new Trade(buyer, buyerDepotNumber, seller, sellerDepotNumber, product);
        trade.trade();
    }

    /**
     * @param buying Object type of CompositeCompany
     * @param depot Integer depot number
     * @param product Object type of Products
     * @return boolean whether the depot can buy or not
     */
    public boolean canBuy(CompositeCompany buying, int depot, Products product) {
        Buyer buyer = new Buyer(buying, depot, product);
        return buyer.depotCanBuy();

    }

    /**
     *
     * @param selling takes a type of CompositeCompany object
     * @param depot takes an integer for the depot number
     * @return a boolean whether the depot can sell or not
     */
    public boolean canSell(CompositeCompany selling, int depot) {
        Seller seller = new Seller(selling, depot);

        return seller.depotCanSell();
    }

    /**
     *
     * @param selling Object type of CompsiteCompany
     * @param depotNumber Integer depot Number
     * @return a product from the seller 
     */
    public Products getProduct(CompositeCompany selling, int depotNumber) {
        Products product = null;
        switch (selling.getCompanyName()) {
            case "BigA":
                product = selling.getListOfDepots().get(depotNumber)
                        .getListOfProducts().getProductsA().get(1);
                

            case "BigB":
                product = selling.getListOfDepots().get(depotNumber)
                        .getListOfProducts().getProductsB().get(1);
                
            case "BigC":
                product = selling.getListOfDepots().get(depotNumber)
                        .getListOfProducts().getProductsC().get(1);
               
        }
        return product;
    }

    /**
     *
     * @param selling Object type of CompsiteCompany
     * @param depotNumber Integer depot number
     * @return the amount of product that a depot can sell
     */
    public int howManyProductItCanSell(CompositeCompany selling, int depotNumber) {
        int howMany = 0;
        
        switch (selling.getCompanyName()) {
            //get currentProducts check the size of the list
            //subtract the currentProducts by the minAmount of products
            //then set howMany to it.
            case "BigA":
                int currentProducts = selling.getListOfDepots().get(depotNumber)
                        .getListOfProducts().getProductsA().size();
                int minStock = selling.getListOfDepots().get(depotNumber)
                        .getListOfProducts().getProductAMin();
                if (currentProducts > minStock) {
                    howMany = currentProducts - minStock;
                } else {
                    howMany = 0;
                }
                

            case "BigB":
                currentProducts = selling.getListOfDepots().get(depotNumber)
                        .getListOfProducts().getProductsB().size();
                minStock = selling.getListOfDepots().get(depotNumber)
                        .getListOfProducts().getProductBMin();
                if (currentProducts > minStock) {
                    howMany = currentProducts - minStock;
                } else {
                    howMany = 0;
                }
                
            case "BigC":
                currentProducts = selling.getListOfDepots().get(depotNumber)
                        .getListOfProducts().getProductsC().size();
                minStock = selling.getListOfDepots().get(depotNumber)
                        .getListOfProducts().getProductCMin();
                if (currentProducts > minStock) {
                    howMany = currentProducts - minStock;
                } else {
                    howMany = 0;
                }
                

        }
        return howMany;
    }

    /**
     * @return the originator
     */
    public Originator getOriginator() {
        return originator;
    }

    /**
     * @param originator the originator to set
     */
    public void setOriginator(Originator originator) {
        this.originator = originator;
    }

    /**
     * @return the carer
     */
    public CareTaker getCarer() {
        return carer;
    }

    /**
     * 
     * @param buyer Object type of CompsiteCompany
     * @param buyerDepot Integer depot number
     * @param seller Object type of CompsiteCompany
     * @param sellerDepot Integer depot number
     */
    public static void printDetails(CompositeCompany buyer, int buyerDepot, CompositeCompany seller, int sellerDepot) {
        System.out.println("-----------------------------------------");
        System.out.println(
                "Buyer : " + buyer.getCompanyName() + "\t Balance : "
                + buyer.getListOfDepots().get(buyerDepot).getCurrentBalance() + "\n"
                + buyer.getListOfDepots().get(buyerDepot).showProductsInStock());

        System.out.println("-----------------------------------------");
        System.out.println(
                "Seller : " + seller.getCompanyName() + "\t Balance : "
                + seller.getListOfDepots().get(buyerDepot).getCurrentBalance() + "\n"
                + seller.getListOfDepots().get(buyerDepot).showProductsInStock());
        System.out.println("-----------------------------------------");
    }

    /**
     * @return the buyers
     */
    public ArrayList<CompositeCompany> getBuyers() {
        return buyers;
    }

    /**
     * @param buyers the buyers to set
     */
    public void setBuyers(ArrayList<CompositeCompany> buyers) {
        this.buyers = buyers;
    }

    /**
     * @return the sellers
     */
    public ArrayList<CompositeCompany> getSellers() {
        return sellers;
    }

    /**
     * @param sellers the sellers to set
     */
    public void setSellers(ArrayList<CompositeCompany> sellers) {
        this.sellers = sellers;
    }
}
