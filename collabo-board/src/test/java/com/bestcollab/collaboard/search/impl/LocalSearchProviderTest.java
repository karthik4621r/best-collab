package com.bestcollab.collaboard.search.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import com.bestcollab.collaboard.model.BasicBoard;
import com.bestcollab.collaboard.model.Card;
import com.bestcollab.collaboard.model.Column;
import com.bestcollab.collaboard.model.Label;
import com.bestcollab.collaboard.model.User;
import com.bestcollab.collaboard.search.SearchProvider;

/**
 * Component test for search provider
 * 
 * @author karth
 *
 */
public class LocalSearchProviderTest {
	
	BasicBoard board;
	User user;
	Column column;
	HashSet<Card> cardsInBoard = new HashSet<>();
	HashSet<Card> cardsWithLabels = new HashSet<>();
	
	HashSet<Card> cardsViewedByUser = new HashSet<>();
	HashSet<Card> cardsNotViewedByUser = new HashSet<>();


	Card cardWithNoLabel;
	SearchProvider searchProvider;
	
	Date intermediateTime;
	

	@Before
	public void setUp() throws Exception {
		createTestBoardData();
		searchProvider = new LocalSearchProvider();
	}
	
	private void createTestBoardData() {
		user = new User("User1");

		board = new BasicBoard("myBoard");
		column = new Column("col1", board);
		
		Card card1 = new Card("card1",null,board,column);
		Card card2 = new Card("card2",null,board,column);
		cardWithNoLabel = new Card("card3",null,board,column);

		Label label1 = new Label("label1");
		Label label2 = new Label("label2");
		Label label3 = new Label("label3");
		Label label4 = new Label("label4");
		
		card1.addLabel(label1);
		card1.addLabel(label2);
		card1.addLabel(label3);
		card2.addLabel(label3);
		card2.addLabel(label4);
		
		user.addCardToViewedList(card1, board);
		user.addCardToViewedList(card2, board);
		
		cardsWithLabels.add(card1);
		cardsWithLabels.add(card2);
		
		cardsInBoard.add(card1);
		cardsInBoard.add(card2);
		cardsInBoard.add(cardWithNoLabel);
		
		
		cardsViewedByUser.add(card1);
		cardsViewedByUser.add(card2);
		
		cardsNotViewedByUser.add(cardWithNoLabel);

	}
	
	@Test
	public void testGetCardsWithLabels() {
		assertTrue(searchProvider.getCardsWithLabels(board).containsAll(cardsWithLabels));
	}

	@Test
	public void testGetCardsInColumn() {
		assertTrue(searchProvider.getCardsInColumn(column).containsAll(cardsInBoard));
	}

	@Test
	public void testGetCardsCreatedAfter() throws InterruptedException {
		Thread.sleep(1);
		intermediateTime = new Date();
		Thread.sleep(1);
		Card latestCard = new Card("cardLatest",null,board,column);
		assertTrue(searchProvider.getCardsCreatedAfter(intermediateTime, board).contains(latestCard));
		assertTrue(!searchProvider.getCardsCreatedAfter(intermediateTime, board).contains(cardWithNoLabel));

	}

	@Test
	public void testGetLatestModifiedCards() {
		assertTrue(searchProvider.getLatestModifiedCards(board, user).containsAll(cardsNotViewedByUser));
		assertTrue(!searchProvider.getLatestModifiedCards(board, user).containsAll(cardsViewedByUser));
	}

}
