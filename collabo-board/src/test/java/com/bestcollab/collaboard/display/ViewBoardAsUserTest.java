package com.bestcollab.collaboard.display;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import com.bestcollab.collaboard.model.BasicBoard;
import com.bestcollab.collaboard.model.Card;
import com.bestcollab.collaboard.model.Column;
import com.bestcollab.collaboard.model.User;

/**
 * Component test to test the board viewing functionality
 * @author karth
 *
 */
public class ViewBoardAsUserTest {
	BasicBoard board;
	User user;
	Column column;
	HashSet<Card> cards = new HashSet<>();
	
	
	@Before
	public void setUp() throws Exception {
		createTestBoardData();
		user = new User("user1");
	}

	private void createTestBoardData() {
		board = new BasicBoard("myBoard");
		column = new Column("col1", board);
		
		Card card1 = new Card("card1",null,board,column);
		Card card2 = new Card("card2",null,board,column);
		cards.add(card1);
		cards.add(card2);
	}

	@Test
	public void testUsersViewedListBeforeView() {
		//When
		HashSet<Card> cardsSeen = user.getCardsSeen(board);
		
		//Then
		assertNull(cardsSeen);
	}

	@Test
	public void testUsersViewedListAfterView() {
		
		//Given
		ViewBoardAsUser.view(board, user);
		Card card3 = new Card("card3",null,board,column);
		
		//When
		HashSet<Card> cardsSeen = user.getCardsSeen(board);
				
		//Then
		// The cards 1 & 2 should be seen. But card 3 which was created after user viewed it should not be seen yet.
		assertTrue(cardsSeen.containsAll(cards));
		assertTrue(!cardsSeen.contains(card3));
	}
	
	@Test
	public void testUsersViewedListAfter2Views() {
		
		//Given
		ViewBoardAsUser.view(board, user);
		Card card3 = new Card("card3",null,board,column);
		
		//When
		ViewBoardAsUser.view(board, user);
		HashSet<Card> cardsSeen = user.getCardsSeen(board);
				
		//Then
		// The cards 1 & 2 & 3 should be seen
		assertTrue(cardsSeen.contains(card3));
	}
}
