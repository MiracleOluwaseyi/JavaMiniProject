package cardGame;

import exceptions.StakeUnderflowException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeskOfCardsTest {
    CardDeck cardDeck;
    @BeforeEach
    void setUp(){
        cardDeck = new CardDeck(4);
    }

    @Test
    void cardDeckHasFixedSize(){
        assertEquals(4, cardDeck.getSize());
    }

    @Test
    void pushOneElementPushedShouldBeLast(){
        Card card = Card.createCircleValue(3);
        cardDeck.push(card);
        assertSame(card, cardDeck.peek());
    }

    @Test
    void pushTwicePopOncePeekShouldReturnFirstElement(){
        Card firstCard = Card.createTrianglesValue(5);
        Card secondCard = Card.createCircleValue(7);
        cardDeck.push(firstCard);
        cardDeck.push(secondCard);
        Card poppedCard = cardDeck.pop();

        assertSame(secondCard, poppedCard);
        assertSame(firstCard, cardDeck.peek());
    }

    @Test
    void pushIntoFullDeckThrowsStakeOverflowException() {
        Card card = Card.createTrianglesValue(4);
        for (int i = 0; i < 4; i++) {
            cardDeck.push(card);
        }
        assertTrue(cardDeck.isFull());
    }

    @Test
    void popEmptyCardDeckThrowsStakeUnderflowException(){
        assertTrue(cardDeck.isEmpty());
        assertThrows(StakeUnderflowException.class,()->cardDeck.pop());
    }

    @Test
    void cardDeckCanBeShuffled(){
        Card firstCard = Card.createCrossesValue(5);
        Card secondCard = Card.createTrianglesValue(7);
        Card thirdCard = Card.createCircleValue(5);
        Card forthCard = Card.createSquaresValue(7);
        cardDeck.push(firstCard);
        cardDeck.push(secondCard);
        cardDeck.push(thirdCard);
        cardDeck.push(forthCard);
        assertSame(forthCard,cardDeck.peek());

        cardDeck.shuffleCardDeck();

        assertNotSame(forthCard,cardDeck.peek());

    }

    @Test
    void cardDeckCanBePopulated(){
        assertNotNull(CardDeck.createFullCardDeck());
    }



}
