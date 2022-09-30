package com.bestcollab.collaboard.model;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a label associated with a Card which can be managed using a unique ID whose name can be changed later on
 * 
 * @author karth
 *
 */
@Getter
@Setter
public class Label {
	@Setter(AccessLevel.NONE)
	private UUID id = UUID.randomUUID();
	private String name;
	private String description;
	
	public Label(String name) {
		this.name = name;
	}
}
