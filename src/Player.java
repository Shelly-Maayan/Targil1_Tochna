import java.util.ArrayList;

public class Player {
    private String name;
    private Deck playCards;
    private Deck winCards;

    public Player(String name) {
        this.name = name;
        this.playCards = new Deck(false);
        this.winCards = new Deck(false);
    }

    public void addToPlayCards(Card card) {
        this.playCards.addCard(card);
    }

    public void addToWinCards(Card card) {
        this.winCards.addCard(card);
    }

    public Card drawCard() {
        if (this.playCards.isEmpty()) {
            this.winCards.shuffle();
            int size = this.winCards.getCardList().size();

            for (int i = 0; i < size ; i++)
                this.playCards.addCard(this.winCards.removeBottomCard());
        }
        return this.playCards.removeTopCard();
    }

    public boolean outOfCards() {
        return (this.playCards.isEmpty() && this.winCards.isEmpty());
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void setPlayerName (String name) {
        this.name = name;
    }

    public String getPlayerName() {
        return this.name;
    }
}
