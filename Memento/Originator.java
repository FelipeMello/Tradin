/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memento;

import Companies.CompositeCompany;
import Products.Products;

/**
 *
 * @author Felipe, Lucience and vagner
 */
public class Originator {
    
    private CompositeCompany buyer, seller;
    private Products product;
    
    private int buyerDepotN,
            sellerDepotN,
            costOfProducts,
            costOfDeliviery,
            totalCost;
            
    /**
     * 
     * @param newTransaction 
     * sets values for the transaction
     */
    public void setTransaction(Memento newTransaction){
        
        this.setBuyer(newTransaction.getBuyer());
        this.setSeller(newTransaction.getSeller());
        
        this.setBuyerDepotN(newTransaction.getBuyerDepotN());
        this.setSellerDepotN(newTransaction.getSellerDepotN());
        
        this.setCostOfProducts(newTransaction.getProduct().getProductPrice());
        this.setCostOfDeliviery(newTransaction.getProduct().getDeliveryPrice());
        this.setTotalCost(newTransaction.getProduct().getTotalPrice());
        
        
    }
    
    /**
     * Creates a new Memento with a new transaction
     * @return new Memento
     */
    public Memento storeInMemento(){
        return new Memento(getBuyer(), getSeller(), getBuyerDepotN(), getSellerDepotN(), 
                getProduct());
    }

//
//    /**
//     * @return the totalAmountCost
//     */
//    public int getTotalAmountCost() {
//        return totalAmountCost;
//    }
//
//    /**
//     * @param totalAmountCost the totalAmountCost to set
//     */
//    public void setTotalAmountCost(int totalAmountCost) {
//        this.totalAmountCost = totalAmountCost;
//    }

    /**
     * @return the buyer
     */
    public CompositeCompany getBuyer() {
        return buyer;
    }

    /**
     * @param buyer the buyer to set
     */
    public void setBuyer(CompositeCompany buyer) {
        this.buyer = buyer;
    }

    /**
     * @return the seller
     */
    public CompositeCompany getSeller() {
        return seller;
    }

    /**
     * @param seller the seller to set
     */
    public void setSeller(CompositeCompany seller) {
        this.seller = seller;
    }

    /**
     * @return the product
     */
    public Products getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Products product) {
        this.product = product;
    }

    /**
     * @return the buyerDepotN
     */
    public int getBuyerDepotN() {
        return buyerDepotN;
    }

    /**
     * @param buyerDepotN the buyerDepotN to set
     */
    public void setBuyerDepotN(int buyerDepotN) {
        this.buyerDepotN = buyerDepotN;
    }

    /**
     * @return the sellerDepotN
     */
    public int getSellerDepotN() {
        return sellerDepotN;
    }

    /**
     * @param sellerDepotN the sellerDepotN to set
     */
    public void setSellerDepotN(int sellerDepotN) {
        this.sellerDepotN = sellerDepotN;
    }

    /**
     * @return the costOfProducts
     */
    public int getCostOfProducts() {
        return costOfProducts;
    }

    /**
     * @param costOfProducts the costOfProducts to set
     */
    public void setCostOfProducts(int costOfProducts) {
        this.costOfProducts = costOfProducts;
    }

    /**
     * @return the costOfDeliviery
     */
    public int getCostOfDeliviery() {
        return costOfDeliviery;
    }

    /**
     * @param costOfDeliviery the costOfDeliviery to set
     */
    public void setCostOfDeliviery(int costOfDeliviery) {
        this.costOfDeliviery = costOfDeliviery;
    }

    /**
     * @return the totalCost
     */
    public int getTotalCost() {
        return totalCost;
    }

    /**
     * @param totalCost the totalCost to set
     */
    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
