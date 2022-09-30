package com.bestcollab.collaboard.model;

import java.util.HashSet;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a column within a board and holds a set of cards
 * 
 * @author karth
 *
 */
@Getter
@Setter
public class Column {
	@Setter(AccessLevel.NONE)
	private UUID id = UUID.randomUUID();
	private String columnHeader;
	private HashSet<Card> cards = new HashSet<Card>();
	
	@Setter(AccessLevel.NONE)
	private transient  BasicBoard associatedBoard;
	
	public Column(String columnHeader, BasicBoard board) {
		this.columnHeader = columnHeader;
		this.associatedBoard = board;
		associatedBoard.associateColumn(this);
	}
	
	public Column addCard(Card card ) {
		this.cards.add(card);
		this.associatedBoard.associateCard(card);
		return this;
	}
}
