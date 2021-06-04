public class WarGame {
    private Player firstPlayer;
    private Player secondPlayer;
    private Deck firstPack;
    private Deck secondPack;

    private static final int WAR_ROUNDS = 3;

    /**
     * Constructor for war game.
     * Initialize two players and their temporary decks
     * @param player1 name of player1
     * @param player2 name of player2
     */
    public WarGame(String player1, String player2) {
        this.firstPlayer = new Player(player1);
        this.secondPlayer = new Player(player2);
        this.firstPack = new Deck(false);
        this.secondPack = new Deck(false);
    }

    /**
     * Initialize the game and sets players' turns
     */
    public void initializeGame() {
        System.out.println("Initializing the game...");
        Deck mainCards = new Deck(true);
        mainCards.shuffle();
        Player[] playersTurns = new Player[2];
        playersTurns[0] = firstPlayer;
        playersTurns[1] = secondPlayer;
        int curr_turn = 1;
        if (firstPlayer.getPlayerName().compareTo(secondPlayer.getPlayerName()) < 0)
            curr_turn = 0;

        while (!(mainCards.isEmpty())) {
            playersTurns[curr_turn].addToPlayCards(mainCards.removeTopCard());
            curr_turn = 1 - curr_turn;
        }
    }

    /**
     * Runs the game
     * Returns the winner's name
     */
    public String start() {
        initializeGame();
        int countRounds = 1;
        Player firstAbc = firstPlayer;
        Player secondAbc = secondPlayer;
        Deck firstPackAbc = this.firstPack;
        Deck secondPackAbc = this.secondPack;

        /** Checks who starts to play */
        if (firstPlayer.getPlayerName().compareTo(secondPlayer.getPlayerName()) > 0) {
            firstAbc = secondPlayer;
            secondAbc = firstPlayer;
            firstPackAbc = this.secondPack;
            secondPackAbc = this.firstPack;

        }

        /** Runs until a player is out of cards */
        while (!firstAbc.outOfCards() && !secondAbc.outOfCards()) {
            System.out.println("------------------------- Round number " + countRounds + " -------------------------");
            Card currFirstCard = firstAbc.drawCard();
            Card currSecondCard = secondAbc.drawCard();
            boolean inWar = false;

            firstPackAbc.addCard(currFirstCard);
            secondPackAbc.addCard(currSecondCard);

            System.out.println(firstAbc.getPlayerName() + " drew " + currFirstCard);
            System.out.println(secondAbc.getPlayerName() + " drew " + currSecondCard);

            /** Manages war- until cards are different */
            while (currFirstCard.compare(currSecondCard) == 0) {
                inWar = true;
                System.out.println("Starting a war...");
                for (int i = 0; i < WAR_ROUNDS; i++) {
                    if (firstAbc.outOfCards())
                        return secondAbc.getPlayerName();
                    if (secondAbc.outOfCards())
                        return firstAbc.getPlayerName();
                    currFirstCard = firstAbc.drawCard();
                    currSecondCard = secondAbc.drawCard();
                    firstPackAbc.addCard(currFirstCard);
                    secondPackAbc.addCard(currSecondCard);


                    if(i < WAR_ROUNDS - 1) {
                        System.out.println(firstAbc + " drew a war card");
                        System.out.println(secondAbc + " drew a war card");
                    }
                    else {
                        System.out.println(firstAbc.getPlayerName() + " drew " + currFirstCard);
                        System.out.println(secondAbc.getPlayerName()+ " drew " + currSecondCard);
                    }

                }
            }

            Player curr_winner = firstAbc;

            if (currFirstCard.compare(currSecondCard) < 0) {
                curr_winner = secondAbc;
            }

            if (!inWar)
                System.out.println(curr_winner.getPlayerName() + " won");
            else
                System.out.println(curr_winner.getPlayerName() + " won the war");

            /** Adds card to winner- always adds second pack first */
            while (!secondPackAbc.isEmpty() && !firstPackAbc.isEmpty()) {
                curr_winner.addToWinCards(secondPackAbc.removeTopCard());
                curr_winner.addToWinCards(firstPackAbc.removeTopCard());
            }

            countRounds++;
        }
       if (firstAbc.outOfCards())
           return secondAbc.getPlayerName();
       return firstAbc.getPlayerName();
    }
}