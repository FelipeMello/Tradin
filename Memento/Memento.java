/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memento;

import Products.Products;
import Companies.CompositeCompany;


/**
 * The memento Design Pattern stores an objects state at a point in time
 * so it can be returned to that state later. It simply allows you to keep track
 * of the states of the object and undo and redo changes of an object.
 * @ref http://www.newthinktank.com/2012/10/memento-design-pattern-tutorial/
 * 
 * @author Felipe, Luciene and Vagner.
 */
//I am actually using the memento to save the state of very transaction.
class Memento {
    /**
     * pass the buyer
     * pass the seller
     * pass the product
     * 
     */
    //the buyer, seller, product , buterDepotN, sellerDepotN stored in memento Object
     private CompositeCompany buyer, seller;
     private Products product;
     private String productName;
     
        private int buyerDepotN, sellerDepotN,
            productPrice,
            costOfDelivery,
            totalCost;
 
    public Memento(CompositeCompany buyer, CompositeCompany seller,
            int buyerDepotN, int sellerDepotN,
            Products product){
       
       this.buyer = buyer;
       this.seller = seller;
       
       this.buyerDepotN = buyerDepotN;
       this.sellerDepotN = sellerDepotN;
       
       this.productName = product.getProductName();
       this.productPrice = product.getProductPrice();
       this.costOfDelivery = product.getDeliveryPrice();
       this.totalCost = product.getTotalPrice();
       
}
    /**
     * 
     * @return the info about the Save Class 
     */
    @Override
    public String toString(){
        return "Buyer : "+getBuyer().getCompanyName()+"\tDepot number : "+getBuyerDepotN()+
              "\tSeller : "+getSeller().getCompanyName()+"\t Depot Number : "+getSellerDepotN()+
              "\tProduct name : "+getProductName()+
              "\tProduct price : "+getProductPrice()+
                "\tCost of Delivery : "+getCostOfDelivery()+
                "\tTotal Cost : \t"+getTotalCost();
                
    }

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
     * @return the productPrice
     */
    public int getProductPrice() {
        return productPrice;
    }

    /**
     * @param productPrice the productPrice to set
     */
    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * @return the costOfDelivery
     */
    public int getCostOfDelivery() {
        return costOfDelivery;
    }

    /**
     * @param costOfDelivery the costOfDelivery to set
     */
    public void setCostOfDelivery(int costOfDelivery) {
        this.costOfDelivery = costOfDelivery;
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

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

}