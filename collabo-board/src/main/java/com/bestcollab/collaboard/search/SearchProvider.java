package com.bestcollab.collaboard.search;

import java.util.Date;
import java.util.HashSet;

import com.bestcollab.collaboard.model.BasicBoard;
import com.bestcollab.collaboard.model.Card;
import com.bestcollab.collaboard.model.Column;
import com.bestcollab.collaboard.model.User;

public interface SearchProvider {

	/**
	 * Get Cards which have at least one label assigned
	 * 
	 * @param board
	 * @return
	 */
	HashSet<Card>  getCardsWithLabels(BasicBoard board);

	/**
	 * Get all cards created after a specific time
	 * 
	 * @param date
	 * @param board
	 * @return
	 */
	HashSet<Card> getCardsCreatedAfter(Date date, BasicBoard board);

	/**
	 * Get the cards that are to be highlighted for a user
	 * @param board
	 * @param user
	 * @return
	 */
	HashSet<Card> getLatestModifiedCards(BasicBoard board, User user);
	
	/**
	 * Get all cards in a specific column of a board
	 * 
	 * @param column
	 * @return
	 */
	HashSet<Card> getCardsInColumn(Column column);
}
