import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cardList;

    /** Constants declaration */
    public static final int MAX_CARD = 13;
    public static final int ITERATE = 50;

    /**
     * Constructor for deck.
     *
     * Creates a new deck
     *
     * @param init boolean which defines if deck should be full or empty
     */
    public Deck(boolean init) {
        this.cardList = new ArrayList<Card>();
        if (init) {
            for (int i = 0; i < Shape.values().length; i++) {
                for (int j = 1; j <= MAX_CARD; j++) {
                    Card card = new Card(j, Shape.values()[i]);
                    this.cardList.add(card);
                }
            }
        }
    }

    /**
     * Adds new card to deck
     *
     * @param card a new card to be added to deck
     */
    public void addCard(Card card) {
        this.cardList.add(card);
    }

    /**
     * Removes top card from deck
     * */
    public Card removeTopCard() {
        int cardListSize = this.cardList.size() - 1;
        Card tempCard = cardList.get(cardListSize);
        this.cardList.remove(cardListSize);
        return tempCard;
    }

    /**
     * Removes bottom card from deck- so we could switch between
     * win cards and play cards and keep their order
     */
    public Card removeBottomCard() {
        Card tempCard = cardList.get(0);
        this.cardList.remove(0);
        return tempCard;
    }

    /**
     * Checks if deck is empty and no cards left
     */
    public boolean isEmpty() {
        if (this.cardList.size() == 0)
            return true;

        return false;
    }

    /**
     * Swaps between two cards (used when shuffling)
     *
     * @param firstIndex index of first card to be switched
     * @param secondIndex index of second card to be switched
     */
    private void swapCards(int firstIndex, int secondIndex) {
        Card tempCard = this.cardList.get(firstIndex);
        this.cardList.set(firstIndex, this.cardList.get(secondIndex));
        this.cardList.set(secondIndex, tempCard);
    }

    /**
     * Shuffles deck of cards
     */
    public void shuffle() {
        for (int i = 0; i < ITERATE; i++) {
            int firstIndex = Main.rnd.nextInt(this.cardList.size());
            int secondIndex = Main.rnd.nextInt(this.cardList.size());
            swapCards(firstIndex, secondIndex);
        }
    }

    /**
     * Returns list of cards in deck
     */
    public ArrayList<Card> getCardList() {
        return this.cardList;
    }
}
