/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TradeTransaction;

import Companies.CompositeCompany;

/**
 * The Facade Design pattern decouples or separates the client from all of the
 * sub componenents
 *
 * @author Felipe, Luciene and Vagner
 *
 * reference http://www.newthinktank.com
 */
public class TradeFacade {

    private String userInput;
    private CompositeCompany user;
    private CompositeCompany company1;
    private CompositeCompany company2;
    TransactionMaker transactionMaker;

    /**
     * Initialize the companies and start to trade automatically
     */
    public TradeFacade() {
        user = new CompositeCompany("BigA");
        company1 = new CompositeCompany("BigB");
        company2 = new CompositeCompany("BigC");
    }

    ;
    
    /**
     * Initialized the companies and set the company that the user wants to trade
     * Overloading the constructor in case the user chooses a company to 
     * trade as.
     * @param companyUserWantsToTrade String 
     */
    public TradeFacade(String companyUserWantsToTrade) {
        this.userInput = companyUserWantsToTrade;
        setCompanies();
    }

    /**
     * Starting making the trades among the companies
     */
    public void startTrading() {
        transactionMaker = new TransactionMaker(getUser(), getCompany1(), getCompany2());
        transactionMaker.trade();
    }

    /**
     * Print the transactions overview of the companies The amount of trades,
     * revenue, Income, Outcome, products sold, products bought
     */
    public void printTransactionsOverview() {
        transactionMaker.printTransactionsOverview();
    }

    public void printUserTransactionsOverview() {
        transactionMaker.printUserTransactionsOverview();
    }

    public void printTheMostIncome() {
        transactionMaker.printTheMostProfit();
    }

    public void printTheMostOutcome() {
        transactionMaker.printTheMostLoss();
    }

    /**
     * @param user the user to set
     */
    private void setCompanies() {
        switch (getUserInput()) {
            case "BigA":
                user = new CompositeCompany("BigA");
                company1 = new CompositeCompany("BigB");
                company2 = new CompositeCompany("BigC");
                break;
            case "BigB":
                company1 = new CompositeCompany("BigA");
                user = new CompositeCompany("BigB");
                company2 = new CompositeCompany("BigC");
                break;
            case "BigC":
                company1 = new CompositeCompany("BigA");
                company2 = new CompositeCompany("BigB");
                user = new CompositeCompany("BigC");
                break;
        }
    }

    /**
     * @return the companyUserWantsToTrade
     */
    public String getUserInput() {
        return userInput;
    }

    /**
     * @return the user
     */
    public CompositeCompany getUser() {
        return user;
    }

    /**
     * @return the company1
     */
    private CompositeCompany getCompany1() {
        return company1;
    }

    /**
     * @return the company2
     */
    private CompositeCompany getCompany2() {
        return company2;
    }

}
