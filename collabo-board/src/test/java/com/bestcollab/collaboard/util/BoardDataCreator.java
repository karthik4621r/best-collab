package com.bestcollab.collaboard.util;

import com.bestcollab.collaboard.model.BasicBoard;
import com.bestcollab.collaboard.model.Card;
import com.bestcollab.collaboard.model.Column;
import com.bestcollab.collaboard.model.Label;

public class BoardDataCreator {

	public static void createTestData(BasicBoard board) {
		
			Column column1 = new Column("col1", board);
			Column column2 = new Column("col2", board);

			
			Card card1 = new Card("card1",null,board,column1);
			Card card2 = new Card("card2",null,board,column1);
			Card card3 = new Card("card3",null,board,column2);

			Label label1 = new Label("label1");
			Label label2 = new Label("label2");
			Label label3 = new Label("label3");
			Label label4 = new Label("label4");
			
			card1.addLabel(label1);
			card1.addLabel(label2);
			card1.addLabel(label3);
			card2.addLabel(label3);
			card2.addLabel(label4);
		
	}
}
