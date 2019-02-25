package Activity2;

/**
 * Created by Teacher on 1/7/2019.
 */
import java.util.List;
import java.util.ArrayList;

/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class Deck {

    /**
     * cards contains all the cards in the deck.
     */
    private List<Card> cards;

    /**
     * size is the number of not-yet-dealt cards.
     * Cards are dealt from the top (highest index) down.
     * The next card to be dealt is at size - 1.
     */
    private int size;


    /**
     * Creates a new <code>Deck</code> instance.<BR>
     * It pairs each element of ranks with each element of suits,
     * and produces one of the corresponding card.
     * @param ranks is an array containing all of the card ranks.
     * @param suits is an array containing all of the card suits.
     * @param values is an array containing all of the card point values.
     */
    public Deck(String[] ranks, String[] suits, int[] values) {
        List<Card> deck = new ArrayList<>();
        for (int a = 0; a < suits.length; a++)
        {
            for (int i = 0; i < ranks.length; i++){
                deck.add(new Card(ranks[i], suits[a], values[i]));
            }
        }
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
    }


    /**
     * Determines if this deck is empty (no undealt cards).
     * @return true if this deck is empty, false otherwise.
     */
    public boolean isEmpty() {
        if (cards.size() == 0){
            return true;
        }
        else
        {
            return false;
        }
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
    }

    /**
     * Accesses the number of undealt cards in this deck.
     * @return the number of undealt cards in this deck.
     */
    public int size() {
        return cards.size();
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
    }

    /**
     * Randomly permute the given collection of cards
     * and reset the size to represent the entire deck.
     */
    public void shuffle() {
        //goes through the whole list of cards, swapping them into different indexes
        int n;
        List<Card> temp = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++){
            n = (int)(Math.random() * cards.size() + 1);
            temp.add(cards.get(i));
            cards.remove(i);
            cards.add(n,temp.get(0));
        }
		/* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
    }

    /**
     * Deals a card from this deck.
     * @return the card just dealt, or null if all the cards have been
     *         previously dealt.
     */
    public Card deal() {
        //removes the card at the very end of the deck and adds it to the discard pile
        //returns the card
        //index of last is list.size() -1
        List<Card> discard = new ArrayList<>();
        discard.add(cards.get(cards.size()-1));
        cards.remove(cards.size()-1);
        return discard.get(discard.size()-1);
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
    }

    /**
     * Generates and returns a string representation of this deck.
     * @return a string representation of this deck.
     */
    @Override
    public String toString() {
        String rtn = "size = " + size + "\nUndealt cards: \n";

        for (int k = size - 1; k >= 0; k--) {
            rtn = rtn + cards.get(k);
            if (k != 0) {
                rtn = rtn + ", ";
            }
            if ((size - k) % 2 == 0) {
                // Insert carriage returns so entire deck is visible on console.
                rtn = rtn + "\n";
            }
        }

        rtn = rtn + "\nDealt cards: \n";
        for (int k = cards.size() - 1; k >= size; k--) {
            rtn = rtn + cards.get(k);
            if (k != size) {
                rtn = rtn + ", ";
            }
            if ((k - cards.size()) % 2 == 0) {
                // Insert carriage returns so entire deck is visible on console.
                rtn = rtn + "\n";
            }
        }

        rtn = rtn + "\n";
        return rtn;
    }
}

