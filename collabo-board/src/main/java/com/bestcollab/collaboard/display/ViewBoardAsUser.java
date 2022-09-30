package com.bestcollab.collaboard.display;

import java.util.HashSet;

import com.bestcollab.collaboard.model.BasicBoard;
import com.bestcollab.collaboard.model.Card;
import com.bestcollab.collaboard.model.User;

public class ViewBoardAsUser {

	/**
	 * Simulate a user viewing all the cards in the board
	 * 
	 * @param board
	 * @param loggedInUser
	 */
	public static void view(BasicBoard board, User loggedInUser) {
		HashSet<Card> cardsInBoard = board.getAssociatedCards();

		//Simulate card view --- Just for test puproses
		System.out.println("Viewing as "+ loggedInUser.getName());
		System.out.println("Cards in board : " );
		for(Card card : cardsInBoard) {
			System.out.println("Viewing card: "+ card.getCardName());
		}

		//Update seen cards for a user
		System.out.println("Adding newly viewed cards to the user's 'Seen' list");
		for(Card card : cardsInBoard) {
			loggedInUser.addCardToViewedList(card, board);
		}
	}
}
