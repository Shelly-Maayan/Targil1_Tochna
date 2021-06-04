
public enum Shape {
    /**
     * Matches each shape to its symbol
     */
    Spades {
        public String toString() {
            return "♠";
        }
    },
    Diamonds {
        public String toString() {
            return "♦";
        }
    },
    Clubs {
        public String toString() {
            return "♣";
        }
    },
    Hearts {
        public String toString() {
            return "♥";
        }
    }
}
