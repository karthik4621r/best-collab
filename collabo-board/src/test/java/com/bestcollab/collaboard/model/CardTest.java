package com.bestcollab.collaboard.model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CardTest {

	BasicBoard board;
	Column column;
	Card cardX;
	Label label;
	HashSet<Label> labels;

	//Given
	@Before
	public void setUp() throws Exception {
		board = Mockito.mock(BasicBoard.class);		
		column = Mockito.mock(Column.class);
		cardX = new Card("cardX", null, board, column);
		
		label = Mockito.mock(Label.class);
		labels = new HashSet<>();
		labels.add(label);
	}

	@Test
	public void testCardCreation() {
		//When
		Card card = new Card("card1", null, board, column);

		//Then
		verifyIfCardAssociatedToBoard(card);
		verifyIfCardAssociatedToColumn(card);
	}
	
	@Test
	public void testCardCreationWithLabels() {
		//When
		Card card = new Card("card1", labels, board, column);

		//Then
		verifyIfCardAssociatedToBoard(card);
		verifyIfCardAssociatedToColumn(card);
		assertTrue(card.getLabels().contains(label));
	}

	@Test
	public void testAddLabel() {
		//When
		cardX.addLabel(label);

		//Then
		assertTrue(cardX.getLabels().contains(label));
	}
	
	@Test
	public void testRemoveLabel() {
		//When
		cardX.removeLabel(label);

		//Then
		assertTrue(!cardX.getLabels().contains(label));
	}

	@Test
	public void testSetDescription() {
		//When
		cardX.setDescription("desc");
		
		//Then
		assertEquals(cardX.getDescription(), "desc");
	}

	@Test
	public void testSetCardName() {
		//When
		cardX.setCardName("cardName");
		
		//Then
		assertEquals(cardX.getCardName(), "cardName");
	}

	private void verifyIfCardAssociatedToColumn(Card card) {
		verify(column, times(1)).addCard(card);
		assertEquals(card.getAssociatedColumn(), column);
	}

	private void verifyIfCardAssociatedToBoard(Card card) {
		verify(board, times(1)).associateCard(card);
		assertEquals(card.getAssociatedBoard(), board);

	}
}
