package cardGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class cardTest {

    @Test
    void circleCardCanBeCreated() {
        Card card = Card.createCircleValue(2);
        assertSame(Suit.CIRCLES, card.getSuit());
    }

    @Test
    void trianglesCardCanBeCreated() {
        Card card = Card.createTrianglesValue(4);
        assertSame(Suit.TRIANGLES, card.getSuit());
    }

    @Test
    void crossesCardCanBeCreated() {
        Card card = Card.createCrossesValue(2);
        assertSame(Suit.CROSSES, card.getSuit());
    }

    @Test
    void squaresCardCanBeCreated() {
        Card card = Card.createSquaresValue(6);
        assertSame(Suit.SQUARES, card.getSuit());
    }

    @Test
    void starsCardCanBeCreated() {
        Card card = Card.createStarsValues(1);
        assertSame(Suit.STARS, card.getSuit());
    }

    @Test
    void whotsCardCanBeCreated() {
        Card card = Card.createWhotsValues(7);
        assertSame(Suit.WHOTS, card.getSuit());
    }

    @Test
    void testSameCardValueEquals() {
        Card kingOfSpade = Card.createTrianglesValue(13);
        Card kingOfHeart = Card.createCrossesValue(13);
        assertEquals(kingOfHeart, kingOfSpade);
        assertEquals(kingOfSpade, kingOfHeart);
    }

    @Test
    void testSameSuitValuesEquals(){
        Card kingOfSpade = Card.createTrianglesValue(13);
        Card queenOfSpade = Card.createCrossesValue(13);

        assertEquals(queenOfSpade, kingOfSpade);
        assertEquals(kingOfSpade, queenOfSpade);

        CardDeck cardDeck = new CardDeck(2);
        assertNotEquals(kingOfSpade, cardDeck);
    }
}