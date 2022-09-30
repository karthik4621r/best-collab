package com.bestcollab.collaboard.model;

import java.util.HashSet;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a Collaboration board which has a set of columns and unique ID
 * It also holds the reference to the set of labels used and cards in it for easy lookup
 * 
 * @author karth
 *
 */

@Getter
@Setter
public class BasicBoard {
	@Setter(AccessLevel.NONE)
	private UUID id = UUID.randomUUID();
	
	private String boardName;
	private HashSet<Column> columns = new HashSet<Column>();
	
	@Setter(AccessLevel.NONE)
	private transient HashSet<Label> enabledLabels = new HashSet<Label>();
	
	@Setter(AccessLevel.NONE)
	private transient HashSet<Card> associatedCards = new HashSet<Card>();
	
	public BasicBoard(String boardName) {
		this.boardName = boardName;
	}
	
	public BasicBoard associateCard(Card card) {
		this.associatedCards.add(card);
		return this;
	}
	
	public BasicBoard associateColumn(Column column) {
		columns.add(column);
		return this;
	}
	
	public BasicBoard associateLabel(Label label) {
		this.enabledLabels.add(label);
		return this;
	}
}
