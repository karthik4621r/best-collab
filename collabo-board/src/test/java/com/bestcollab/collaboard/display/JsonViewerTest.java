package com.bestcollab.collaboard.display;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.bestcollab.collaboard.model.BasicBoard;
import com.bestcollab.collaboard.util.BoardDataCreator;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonViewerTest {
	
	private static final String BOARD_NAME = "innov_board";
	BasicBoard board;

	@Before
	public void setUp() throws Exception {
		board = new BasicBoard(BOARD_NAME);
		BoardDataCreator.createTestData(board);
	}

	@Test
	public void testViewBoardAsJson() {
		//When
		String boardJsonString = JsonViewer.viewBoardAsJson(board);
		System.out.println(boardJsonString);
		
		//Then
		JsonObject boardJson = JsonParser.parseString(boardJsonString).getAsJsonObject();
		BasicBoard deserializedBoard = new Gson().fromJson(boardJson, BasicBoard.class);
		
		//Perform further assertions similar to the below one
		assertEquals(deserializedBoard.getColumns().size(), board.getColumns().size());

	}

}
