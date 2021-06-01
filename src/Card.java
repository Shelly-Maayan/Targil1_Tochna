public class Card {
    private int cardNumber;
    private Shape shape;
    private String image;

    /** Constants declaration */
    public static final int ACE = 1;
    public static final int PRINCE = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;

    /**
     * Constructor for card.
     *
     * Creates a new card
     *
     * @param cardNumber card number between 1-13
     * @param shape shape of card out of four shapes
     */
    public Card(int cardNumber, Shape shape) {
        this.cardNumber = cardNumber;
        this.shape = shape;

        /** Matches image to card */
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

    /**
     * Compares two card and determines which card won
     *
     * Returns 0 if two card are equal, -1 if other card is bigger and 1 otherwise
     *
     * @param other another card, to compare to current card
     */
    public int compare(Card other) {
        if (this.cardNumber < other.cardNumber)
            return -1;

        else if(this.cardNumber == other.cardNumber)
            return 0;

        return 1;
    }

    /**
     * Returns current card number
     */
    public int getCardNumber() {
        return this.cardNumber;
    }

    /**
     * Print method for card object
     */
    @Override
    public String toString() {
        return this.image;
    }
}
