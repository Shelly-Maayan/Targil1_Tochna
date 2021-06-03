import java.util.ArrayList;

public class Player {
    private String name;
    private Deck playCards;
    private Deck winCards;

    /**
     * Constructor for player.
     *
     * Resets two decks of player to be empty
     *
     * @param name name of new player
     */
    public Player(String name) {
        this.name = name;
        this.playCards = new Deck(false);
        this.winCards = new Deck(false);
    }

    /**
     * Adds a card to play cards deck
     *
     * @param card card to be added to play cards
     */
    public void addToPlayCards(Card card) {
        this.playCards.addCard(card);
    }

    /**
     * Adds a card to win cards deck
     *
     * @param card card to be added to win cards
     */
    public void addToWinCards(Card card) {
        this.winCards.addCard(card);
    }

    /**
     * Draws a card from play cards, and returns the selected card
     */
    public Card drawCard() {

        /** If there's no play cards, shuffles win cards and uses them */
        if (this.playCards.isEmpty()) {
            this.winCards.shuffle();

            while(!this.winCards.isEmpty())
                this.playCards.addCard(this.winCards.removeBottomCard());
        }
        return this.playCards.removeTopCard();
    }

    /**
     * Returns whether the player is out of cards
     */
    public boolean outOfCards() {
        return (this.playCards.isEmpty() && this.winCards.isEmpty());
    }

    /**
     * Print method for player object
     */
    @Override
    public String toString() {
        return this.name;
    }

    /**
     * Returns player's name
     */
    public String getPlayerName() {
        return this.name;
    }

    public void getWinCards() {
        for (int i=0; i < this.winCards.getCardList().size(); i++)  {
            System.out.println(this.winCards.getCardList().get(i));
        }
    }

    public void getplayCards() {
        for (int i=0; i < this.playCards.getCardList().size(); i++)  {
            System.out.println(this.playCards.getCardList().get(i));
        }
    }
}
