package com.bestcollab.collaboard.model;

import java.util.Date;
import java.util.HashSet;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a card within a column of a board
 * It is linked to a set of labels
 * 
 * @author karth
 *
 */
@Getter
public class Card {
	
	@Setter(AccessLevel.NONE)
	private UUID id = UUID.randomUUID();
	
	private String cardName;
	private HashSet<Label> labels = new HashSet<Label>();
	
	@Setter(AccessLevel.NONE)
	private transient BasicBoard associatedBoard;
	private String description;
	
	@Setter(AccessLevel.NONE)
	private transient Column associatedColumn;

	@CreatedDate
	@Setter(AccessLevel.NONE)
	private Date creationDate;

	@LastModifiedDate
	@Setter(AccessLevel.NONE)
	private Date modificationDate;

	public Card(String cardName, HashSet<Label> labels, BasicBoard associatedBoard, Column associatedColumn) {
		this.cardName = cardName;
		if(labels!=null)
			this.labels = labels;
		this.associatedBoard = associatedBoard;
		this.associatedColumn = associatedColumn;

		associatedBoard.associateCard(this);
		associatedColumn.addCard(this);

		creationDate = new Date();
	}

	public Card addLabel(Label label) {
		this.getLabels().add(label);
		return this;
	}

	public Card removeLabel(Label label) {
		this.getLabels().remove(label);
		return this;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
}
