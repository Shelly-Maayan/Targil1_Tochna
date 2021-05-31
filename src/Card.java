public class Card {
    private int cardNumber;
    private Shape shape;
    private String image;

    public static final int ACE = 1;
    public static final int PRINCE = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;


    public Card(int cardNumber, Shape shape) {
        this.cardNumber = cardNumber;
        this.shape = shape;

        switch (cardNumber) {
            case ACE:
                this.image = "Ace of " + this.shape;
                break;
            case PRINCE:
                this.image = "Jack of " + this.shape;
                break;
            case QUEEN:
                this.image = "Queen of " + this.shape;
                break;
            case KING:
                this.image = "King of " + this.shape;
                break;
            default:
                this.image = cardNumber + " of " + this.shape;
                break;
        }
    }

    public int compare(Card other) {
        if (this.cardNumber < other.cardNumber)
            return -1;

        else if(this.cardNumber == other.cardNumber)
            return 0;

        return 1;
    }
    @Override
    public String toString() {
        return this.image;
    }

    public int getCardNumber() {
        return this.cardNumber;
    }
}
