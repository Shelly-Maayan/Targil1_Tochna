import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cardList;

    public static final int MAX_CARD = 13;
    public static final int ITERATE = 50;

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

    public void addCard(Card card) {
        this.cardList.add(card);
    }

    public Card removeTopCard() {
        int cardListSize = this.cardList.size() - 1;
        Card tempCard = cardList.get(cardListSize);
        this.cardList.remove(cardListSize);
        return tempCard;
    }

    public Card removeBottomCard() {
        Card tempCard = cardList.get(0);
        this.cardList.remove(0);
        return tempCard;
    }

    public boolean isEmpty() {
        if (this.cardList.size() == 0)
            return true;

        return false;
    }

    private void swapCards(int firstIndex, int secondIndex) {
        Card tempCard = this.cardList.get(firstIndex);
        this.cardList.set(firstIndex, this.cardList.get(secondIndex));
        this.cardList.set(secondIndex, tempCard);
    }

    public void shuffle() {
        for (int i = 0; i < ITERATE; i++) {
            int firstIndex = Main.rnd.nextInt(this.cardList.size());
            int secondIndex = Main.rnd.nextInt(this.cardList.size());
            swapCards(firstIndex, secondIndex);
        }
    }

    public ArrayList<Card> getCardList() {
        return this.cardList;
    }
}
