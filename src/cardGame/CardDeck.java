package cardGame;

import java.security.SecureRandom;

public class CardDeck {
    private int lastPushedLocation = -1;
    private Card[] cards;
    private final SecureRandom secureRandom = new SecureRandom();


    public CardDeck(int numberOfCards) {
        cards = new Card[numberOfCards];
    }

    public static CardDeck createFullCardDeck() {
        CardDeck cardDeck = new CardDeck(54);
        for (Suit suit : Suit.values()) {
            switch (suit) {
                case TRIANGLES:
                    for (int i = 1; i <= 14; i++) {
                        if (i == 6 || i == 9) {
                            continue;
                        }
                        cardDeck.push(Card.createTrianglesValue(i));
                    }
                    break;
                case CIRCLES:
                    for (int i = 1; i <= 14; i++) {
                        if (i == 6 || i == 9) {
                            continue;
                        }
                        cardDeck.push(Card.createCircleValue(i));
                    }
                    break;
                case SQUARES:
                    for (int i = 1; i <= 14; i++) {
                        if (i == 4 || i == 6 || i == 8 || i == 9 || i == 12) {
                            continue;
                        }
                        cardDeck.push(Card.createSquaresValue(i));
                    }
                    break;
                case STARS:
                    for (int i = 1; i <= 8; i++) {
                        if (i == 6) {
                            continue;
                        }
                        cardDeck.push(Card.createStarsValues(i));
                    }
                    break;
                case CROSSES:
                    for (int i = 1; i <= 14; i++) {
                        if (i == 4 || i == 6 || i == 8 || i == 9 || i == 12) {
                            continue;
                        }
                        cardDeck.push(Card.createCrossesValue(i));
                    }
                    break;
                case WHOTS:
                    for (int i = 1; i <= 5; i++) {
                        cardDeck.push(Card.createTrianglesValue(i));
                    }
            }
        }
        return cardDeck;
    }

    public int getSize() {
        return cards.length;
    }

    public void push(Card card) {
        lastPushedLocation++;
        cards[lastPushedLocation] = card;
    }

    public Card peek() {
        return cards[lastPushedLocation];
    }

    public Card pop() {
        return cards[lastPushedLocation--];
    }

    public boolean isFull() {
        return lastPushedLocation == getSize() - 1;
    }

    public boolean isEmpty() {
        return lastPushedLocation == -1;
    }

    public void shuffleCardDeck() {
        int store1;
        Card store2;
        for (int i = 0; i < cards.length; i++){
            store1 = secureRandom.nextInt(cards.length);
            store2 = cards[i];
            cards[i] = cards[store1];
            cards[store1] = store2;
        this.cards = cards;
        }
    }
}
