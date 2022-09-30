package com.bestcollab.collaboard.model;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BasicBoardTest {
	
	BasicBoard board;
	Column column;
	Card card;
	Label label;
	HashSet<Column> columns = new HashSet<>();

	
	//Given
	@Before
	public void setup() {
		board = new BasicBoard("board1");
		column = Mockito.mock(Column.class);
		card = Mockito.mock(Card.class);
		label = Mockito.mock(Label.class);
		columns.add(column);
	}

	@Test
	public void testAssociateCard() {
		
		//When
		board.associateCard(card);
		
		//Then
		assertTrue(board.getAssociatedCards().contains(card));
	}

	@Test
	public void testAssociateColumn() {
				
		//When
		board.associateColumn(column);
		
		//Then
		assertTrue(board.getColumns().contains(column));
				
	}

	@Test
	public void testAssociateLabel() {
		//When
		board.associateLabel(label);
		
		//Then
		assertTrue(board.getEnabledLabels().contains(label));
	}

	@Test
	public void testSetColumns() {		
		//When
		board.setColumns(columns);
		
		//Then
		assertTrue(board.getColumns().containsAll(columns));
	}

	@Test
	public void testSetEnabledLabels() {
		//When
		board.associateLabel(label);
		
		//Then
		assertTrue(board.getEnabledLabels().contains(label));
	}

}
