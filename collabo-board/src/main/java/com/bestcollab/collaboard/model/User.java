package com.bestcollab.collaboard.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


/**
 * Represents a user who has access to a board
 * 
 * @author karth
 *
 */
@Getter
public class User {
	
	//Holds the set of cards already seen by a user in a board
	@Setter(AccessLevel.NONE)
	private HashMap<BasicBoard, HashSet<Card>> boardVsCardsSeen = new HashMap<>();
	
	@Setter(AccessLevel.NONE)
	private UUID id = UUID.randomUUID();
	
	private String name;
	
	public User(String name) {
		this.name = name;
	}
	
	/**
	 * Update the list of cards already viewed
	 * @param card
	 * @param board
	 * @return User
	 */
	public void addCardToViewedList(Card card, BasicBoard board) {
		HashSet<Card> cardsSeen = boardVsCardsSeen.get(board);
		if(cardsSeen == null) {
			cardsSeen = new HashSet<Card>();
			boardVsCardsSeen.put(board, cardsSeen);
		}
		cardsSeen.add(card);
	}
	
	/**
	 * Get the list of cards already viewed by a user
	 * @param board
	 * @return
	 */
	public HashSet<Card> getCardsSeen(BasicBoard board){
		return boardVsCardsSeen.get(board);
	}
}
