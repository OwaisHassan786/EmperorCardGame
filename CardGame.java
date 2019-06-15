import java.util.Random;
import java.util.Scanner;

/*

Bug Documentation

1) there is a bug where choosing a card on the slave side ends up putting you on the emperor side and asking you to choose your card



 */

//now we have 2 methods playtheslave(); and emperorsturn(); and i want to make them so that their is a choice to which one you play
public class CardGame {
    static int numberx = 5;  //numberx runs the game 5 times
    static int userTeamPick;
    static int cardLimiter = 0;


    public static void main(String[] args) {


        int numberOfCards = 7;
        if (numberOfCards > 6) {
            numberOfCards--;
            //System.out.println("your number of cards is " +numberOfCards);


        }
        pickYourSide();


    }


    public static void typeOfCard() {

        Random card = new Random();
        int number = 0;


        for (int counter = 1; counter <= 3; counter++) {        //randomizer that picks the enemy side card
            number = 1 + card.nextInt(2);
        }

        if (number == 1) {               //cause of the Bug 1)   // &&  userTeamPick == 1
            System.out.println("your are playing on the emperor side");

        }
        if (number == 2) {
            //System.out.println("You are playing on the slave side ");
            //  slavesTurn();
            // numberx--;
        }
        if (number == 1) {

            emperorsTurn();
            numberx--;


        }


    }

    public static void winOrLose() {
        int wincounter = 0;
        String win = "You won the round";
        String lose = "You lose the round ";

        if (wincounter > 0) {
            System.out.println(win);
        } else if (wincounter == 0) {
            System.out.print(lose);
        }


    }

    public static void emperorsTurn() {

        Random cards = new Random();
        int computerinput = 0;
        int numberx = 5;

        for (int counter = 1; counter <= 3; counter++) {
            computerinput = 1 + cards.nextInt(2);
        }


        Scanner sc = new Scanner(System.in);
        System.out.println("Please pick the card you are playing. \n if you are playing the Emperor press 1, if you are playing the citizen press 2 ");
        int userinput = sc.nextInt();

        if (userinput == 1 && computerinput == 1 && cardLimiter == 0) {
            System.out.println("you have played the emperor! \n the emperor is defeated by the slave");
                cardLimiter++;
                if ((userinput == 1 && computerinput == 1 && cardLimiter == 1)) {
                    System.out.println("you cannot play the emperor this turn \n you have played the citizen instead");
            }

        } else if (userinput == 1 && computerinput == 2) {
            System.out.println("you have played the emperor the emperor defeats the citizen");

            winOrLose();
            wincounter();
            numberx--;
        } else if (userinput == 2) { //when the user input is 2
            if (computerinput == 1) {
                System.out.println("you have played the citizen, this defeats the slave");
                wincounter();
            } else if (computerinput == 2) {
                System.out.println("you have played the citizen, this ties with the citizen");
            }
            //print out something else if number is not 1,2 or 3
        }
    }

    public static void wincounter() {
        int i = 0;
        if (i < 1) i++;

        System.out.println("you have won " + i + " number of draws");
    }


    public static void slavesTurn() {
        Random cards = new Random();
        int computerinput = 0;
        int numberx = 5;

        for (int counter = 1; counter <= 3; counter++) {
            computerinput = 1 + cards.nextInt(2);
        }


        Scanner sc = new Scanner(System.in);
        System.out.println("Please pick the card you are playing. \n if you are playing the Slave press 3, if you are playing the citizen press 4 ");
        int userinput = sc.nextInt();

        if (userinput == 3 && computerinput == 1) {
            System.out.println("you have played the slave! \n the emperor is defeated by the slave");

        } else if (userinput == 3 && computerinput == 2) {
            System.out.println("you have played the slave loses to the citizen");
            if (userinput == 4 && computerinput == 1) {
                System.out.println("you have played the citizen, this is defeated by the slave");
            } else if (userinput == 4 && computerinput == 2) {

                System.out.println("the citizen ties with the citizen");
            }

            winOrLose();
            wincounter();
            numberx--;
        }
    }


    public static void playTheGame() {
        while (numberx > 0) {
            typeOfCard();
        }
    }

    public static void pickYourSide() {
        Scanner sc = new Scanner(System.in);
        System.out.println("press 1 to play on the emperor side and press 2 to play on  the slave \n To view the rules please visit this website: https://tobakumokushirokukaiji.fandom.com/wiki/E_Card ");
        int userTeamPick = sc.nextInt();

        if (userTeamPick == 1) {
            typeOfCard();
            while (numberx > 0) {
                typeOfCard();
            }

        } else if (userTeamPick == 2) {
            slavesTurn();
        }
        while (numberx > 0 && userTeamPick == 1) {                 //create a loop here that works for repeating both variables
            typeOfCard();
        }
        while (numberx > 0 && userTeamPick == 2) {
            slavesTurn();
        }

    }
}





//6/10/2019 7:55 PM

// All i need to do at this point is program the slave side to play and                                           \\
//make it so that the slave and emperor can only be played once while the other cards can only be played twice      \\
//include the rules                                                                                                   \\








