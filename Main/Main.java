package Main;

import TradeTransaction.TradeFacade;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This is the main class for the program It is the only place where the program
 * interacts directly with the end user to get instruction on how it should
 * execute
 *
 * @author Felipe
 * @author Luciene
 * @author Vagner
 */
public class Main {
    //to read the user input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    TradeFacade tradeFacade;  // Facade where the code is hiden
    boolean inputOk;          // to validate the user input
    int option;               // just to hold the user input

    /**
     * Constructor calls the methods greet() and printMenu()
     */
    public Main() { // here is where the magic starts (:
        greet();          // calls the method to greet the user
        printMenu();      // calls the mthod print menu to print the menu

    }

    /**
     * Main that creates a new instance of the program
     * @param args arguments
     */
    public static void main(String[] args) {
        new Main();
    }

    /**
     * Prints the menu
     */
    public void printMenu() {
        option = 0;        // variable with menu options identifier
        inputOk = false;  // validates the input

        do {
            try {
                // Prints the menu options on screen 
                menuOptions();
                // reads user input and stores in a variable
                option = Integer.parseInt(br.readLine());

                // depending on user choise the system can run
                switch (option) {
                    case 1: // 1 - autonomously, the end user will only watch the trade
                        inputOk = true;
                        tradeFacade = new TradeFacade();// initializes a new facade
                        tradeFacade.startTrading();// start trade autonomously
                        tradeFacade.printTransactionsOverview();// prints all transactions
                        tradeFacade.printTheMostIncome();
                        tradeFacade.printTheMostOutcome();
                        //trade automatically
                        again();// call the method again to check if the user want's to trade again
                        break;

                    case 2: // the user will select a company to trade as
                        inputOk = true;
                        companies();// the method companies is called
                        break;

                    default: // if the input is none of the cases repeat this method
                        inputOk = false;
                        // prints a invalid message if user typed any other number besides 1 or 2    
                        System.out.println("Please enter '1' or '2' the input you enter ' " + option + " '  is not a valid input");

                        break;
                }
            } catch (IOException | NumberFormatException e) {
                inputOk = false;
            }
        } while (inputOk != true);

    }

    /**
     * This method is called when the user wants to print the menu options
     */
    public void menuOptions() {
        System.out.println(""
                + "Press 1 to trade autonomously"
                + "\nPress 2 to choose a company to trade");
    }

    /**
     * This method used to greet the user when the program starts
     */
    public void greet() {
        System.out.println("Welcome to Comercial Trading Mark's CA");
    }

    /**
     * This method lets the user to choose a company that he/she wants to trade as.
     * This method also prints every transaction of the company that the users choose to trade as.
     */
    public void companies() {
        option = 0;
        inputOk = false;
        do {
            try {
                // Menu options
                System.out.println("Press 1 to trade as BigA");
                System.out.println("Press 2 to trade as BigB");
                System.out.println("Press 3 to trade as BigC");
                // reads user choise and stores in a variable
                option = Integer.parseInt(br.readLine());
                // If chosen 1, the user will trade as Big A
                // and see all transactions made by Big A
                switch (option) {
                    case 1:
                        tradeFacade = new TradeFacade("BigA");
                        executeTradeFacade();
                        inputOk = true;
                        break;
                    case 2:
                        tradeFacade = new TradeFacade("BigB");
                        executeTradeFacade();
                        inputOk = true;
                        break;
                    case 3:
                        tradeFacade = new TradeFacade("BigC");
                        executeTradeFacade();
                        inputOk = true;
                        break;
                    default:
                        inputOk = false;
                        break;
                }

            } catch (IOException | NumberFormatException e) {
                inputOk = false;
            }
        } while (inputOk != true);

    }

    /**
     * This method executes the method startTrading() and printUserTransactionsOverview() from the class TradeFacade,
     * then it calls the method again from its own class
     */
    public void executeTradeFacade() {
        tradeFacade.startTrading();
        tradeFacade.printUserTransactionsOverview();
        again();
    }
    /**
     * This method asks the user if he/she wants to trade again, the it
     * either call the printMenu() or finishes the program.
     */
    public void again() {
        int option = 0;
        inputOk = false;
        do {
            try {
                System.out.println("Would you like to trade again ?"
                        + "\nPress 1 for YES"
                        + "\t\tPress 2 for NO");
                option = Integer.parseInt(br.readLine());

                switch (option) {
                    case 1:
                        printMenu(); // send the user back to the menu
                        inputOk = true;
                        //call the menu
                        break;
                    case 2:

                        //Finish the program
                        System.out.println("Thanks for teaching us Design Patterns"
                                + "\n**** - Enjoy the Summer! - ****"
                                + "\n\n Kind Regards : Felipe, Luciene and Vagner");
                        System.exit(0);
                        inputOk = true;
                        break;
                    //finito
                    default:
                        //repeat
                        System.out.println("'" + option + "' This option  is not valid, Please enter a valid option '1' or '2' ");
                        inputOk = false;
                        break;
                }
            } catch (IOException | NumberFormatException e) {
                inputOk = false;
            }
        } while (inputOk != true);

    }

}
