package com.bestcollab.collaboard.search.impl;

import java.util.Date;
import java.util.HashSet;

import com.bestcollab.collaboard.model.BasicBoard;
import com.bestcollab.collaboard.model.Card;
import com.bestcollab.collaboard.model.Column;
import com.bestcollab.collaboard.model.User;
import com.bestcollab.collaboard.search.SearchProvider;
/**
 * A search service which can serve data
 * @author karth
 *
 */
public class LocalSearchProvider implements SearchProvider{

	@Override
	public HashSet<Card> getCardsWithLabels(BasicBoard board){
		HashSet<Card> cards = board.getAssociatedCards();
		HashSet<Card> cardsWithLabels = new HashSet<>();

		for(Card card: cards) {
			if(!card.getLabels().isEmpty())
				cardsWithLabels.add(card);
		}
		return cardsWithLabels;
		
	}
	
	@Override
	public HashSet<Card> getCardsInColumn(Column column){
		HashSet<Card> cards = column.getCards();
		return cards;
	}
	
	@Override
	public HashSet<Card> getCardsCreatedAfter(Date date, BasicBoard board){
		HashSet<Card> associatedCards = board.getAssociatedCards();
		HashSet<Card> cardsCreatedAfter = new HashSet<>();
		for(Card card: associatedCards) {
			if (card.getCreationDate().compareTo(date) > 0) {
				cardsCreatedAfter.add(card);
			}
		}
		return cardsCreatedAfter;
	}
	
	@Override
	public HashSet<Card> getLatestModifiedCards(BasicBoard board, User user) {
		HashSet<Card> cards = board.getAssociatedCards();
		cards.removeAll(user.getCardsSeen(board));
		return cards;	
	}
}
