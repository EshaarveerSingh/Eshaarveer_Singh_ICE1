/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Random;
import java.util.Scanner;

public class CardTrick {
    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random rand = new Random();

        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(rand.nextInt(13) + 1); 
            c.setSuit(Card.SUITS[rand.nextInt(Card.SUITS.length)]);
            magicHand[i] = c;
        }

        Card luckyCard = new Card();
        luckyCard.setValue(2);  
        luckyCard.setSuit("Clubs"); 
        magicHand[6] = luckyCard;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a card value (1-13):");
        int userValue = scanner.nextInt();
        System.out.println("Enter a suit (Clubs, Diamonds, Hearts, Spades):");
        String userSuit = scanner.next();
       
        for (Card card : magicHand) {
            System.out.println(card.getSuit() + " " + card.getValue());
        }
        
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userValue && card.getSuit().equalsIgnoreCase(userSuit)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Card found in the magic hand!");
        } else {
            System.out.println("Card not found.");
        }

        scanner.close();
    }
}
