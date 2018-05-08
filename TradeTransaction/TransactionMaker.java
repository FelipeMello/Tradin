/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TradeTransaction;

import Companies.CompositeCompany;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felip
 */
public class TransactionMaker {

    private List<CompositeCompany> companies;
    private Transaction transaction;
    private CompositeCompany user, company1, company2;

    /**
     * This constructor takes 3 CompositeCompany
     *
     * @param user CompositeCompany the user
     * @param company1 CompositeCompany
     * @param company2 CompositeCompany
     */
    public TransactionMaker(CompositeCompany user, CompositeCompany company1, CompositeCompany company2) {

        this.user = user;
        this.company1 = company1;
        this.company2 = company2;

        companies = new ArrayList<>();
        companies.add(user);
        companies.add(company1);
        companies.add(company2);

        transaction = new Transaction();
    }

    /**
     * this method will call the method transactions from the Transactions class
     */
    public void trade() {
        getTransaction().startTransactions(getCompanies());
    }

    /**
     * This method will print the revenue, income, outcome, products sold and
     * products bough from the companies in the list
     */
    public void printTransactionsOverview() {
        for (int i = 0; i < getCompanies().size(); i++) {
            printTransactions(getCompanies().get(i));
        }
    }

    /**
     * This method will print the start revenue, revenue after trades, Income,
     * Outcome and how many products was sold and bought.
     */
    public void printUserTransactionsOverview() {
        printDetailedTransactions(getUser());
        printTransactions(getUser(), "User Transactions");
    }

    /**
     * Print the company with the most income
     */
    public void printTheMostProfit() {
        int mostIncome = 0;
        int currentIncome = 0;
        int companyIndex = 0;
        for (int i = 0; i < getCompanies().size(); i++) {
            currentIncome = getCompanies().get(i).getIncome();
            if (currentIncome > mostIncome) {
                mostIncome = currentIncome;
                companyIndex = i;
            }
        }

        printTransactions(getCompanies().get(companyIndex), "Most Profit");
    }

    /**
     * Print the company with the most loss
     */
    public void printTheMostLoss() {
        int lessIncome = 0;
        int currentIncome = 0;
        int companyIndex = 0;
        for (int i = 0; i < getCompanies().size(); i++) {
            currentIncome = getCompanies().get(i).getOutcome();
            if (currentIncome > lessIncome) {
                lessIncome = currentIncome;
                companyIndex = i;
            }
        }

        printTransactions(getCompanies().get(companyIndex), "Most Loss");
    }

    /**
     *
     * @param company takes a CompositeCompany object and look for it on our
     * memento list
     */
    public void printDetailedTransactions(CompositeCompany company) {
        for (int i = 0; i < getTransaction().getCarer().getSaveTransactions().size(); i++) {
            if (getTransaction().getCarer().getBuyerName(i).equals(company.getCompanyName())
                    || getTransaction().getCarer().getSellerName(i).equals(company.getCompanyName())) {
                System.out.println("Transaction : '" + (i + 1) + "' " + getTransaction().getCarer().getMemento(i));
            }

        }
    }
    
    /**
     *
     * @param company this method takes a compositeCompany and it will print the
     * transactions of that company
     * @param message type of String
     */
    public void printTransactions(CompositeCompany company, String message) {
        
        System.out.println("##################################################################################################################################################");
            System.out.println("####################################\t\t" + message + "\t\t##########################################################################");
        
        printTransactions(company);
    }
    /**
     * 
     * Overloading the method printTransactions
     * @param company Object type of CompsiteCompany
     */
    public void printTransactions(CompositeCompany company) {
        int totalTrade = company.getTotalSold() + company.getTotalBought();
        System.out.println("##################################################################################################################################################");

        System.out.println("###  " + company.getCompanyName()
                + " # Total trades : " + totalTrade
                + " # Current Revenue : " + company.getRevenue()
                + "\t# Total purchase :'" + company.getTotalBought()
                + "' Price :" + company.getOutcome()
                + "\t#\t Total sold :'" + company.getTotalSold()
                + "' Profit : " + company.getIncome()
                + " ###");
        System.out.println("##################################################################################################################################################\n");

    }


    /**
     * @return the companies
     */
    private List<CompositeCompany> getCompanies() {
        return companies;
    }

    /**
     * @return the transaction
     */
    private Transaction getTransaction() {
        return transaction;
    }

    /**
     * @return the user
     */
    public CompositeCompany getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(CompositeCompany user) {
        this.user = user;
    }

}
