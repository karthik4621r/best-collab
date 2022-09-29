package com.bestcollab.collaboard.model;

import java.util.Date;
import java.util.HashSet;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
@Setter
public class Card {

	private UUID id = UUID.randomUUID();
	private String cardName;
	private HashSet<Label> labels = new HashSet<Label>();
	private transient BasicBoard associatedBoard;
	private String description;
	private transient Column associatedColumn;
	
	@CreatedDate
	private Date creationDate;
	
	@LastModifiedDate
	private Date modificationDate;
	
	public Card(String cardName, HashSet<Label> labels, BasicBoard associatedBoard, Column associatedColumn) {
		this.cardName = cardName;
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
}
