package cardGame;

public class Card {

    private final Suit suit;
    private final int value;

    private Card(Suit suit, int value) {
        this.suit = suit;
        this.value = value;

    }

    public static Card createCircleValue(int value) {
        return new Card(Suit.CIRCLES, value);
    }

    public static Card createTrianglesValue(int value) {
        return new Card(Suit.TRIANGLES, value);
    }

    public static Card createCrossesValue(int value) {
        return new Card(Suit.CROSSES, value);
    }

    public static Card createSquaresValue(int value) {
        return new Card(Suit.SQUARES, value);
    }

    public static Card createStarsValues(int values) {
        return new Card(Suit.STARS, values);
    }

    public static Card createWhotsValues(int values) {
        return new Card(Suit.WHOTS, values);
    }

    public Suit getSuit() {
        return suit;
    }
    @Override
    public boolean equals(Object obj){
        if (!this.getClass().equals(obj.getClass())){
            return false;
        }
        Card cardToCompare = (Card) obj;
        return this.value == cardToCompare.value || this.suit == cardToCompare.suit;
    }
}
