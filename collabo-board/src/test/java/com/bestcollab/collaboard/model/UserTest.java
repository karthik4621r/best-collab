package com.bestcollab.collaboard.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class UserTest {
	
	User user1;
	User user2;
	Card card1;
	Card card2;
	BasicBoard board;

	@Before
	public void setUp() throws Exception {
		user1 = new User("user1");
		user2 = new User("user2");
		
		card1 = Mockito.mock(Card.class);
		card2 = Mockito.mock(Card.class);
		
		board = Mockito.mock(BasicBoard.class);
	}

	/**
	 * Verify if the viewed list of each of the users are having the right set of cards
	 */
	@Test
	public void testAddCardToViewedList() {
		//When
		user1.addCardToViewedList(card1, board);
		user2.addCardToViewedList(card2, board);
		
		//Then
		HashSet<Card> cardsSeenByUser1 = user1.getBoardVsCardsSeen().get(board);
		HashSet<Card> cardsSeenByUser2 = user2.getBoardVsCardsSeen().get(board);
		assertTrue(cardsSeenByUser1.contains(card1));
		assertTrue(!cardsSeenByUser2.contains(card1));
		assertTrue(cardsSeenByUser2.contains(card2));
		assertTrue(!cardsSeenByUser1.contains(card2));

	}

	@Test
	public void testGetCardsSeen() {
		//Given
		user1.addCardToViewedList(card1, board);

		//When
		HashSet<Card> cardsSeen = user1.getCardsSeen(board);
		
		//Then
		assertTrue(cardsSeen.contains(card1));
	}
}
