package com.bestcollab.collaboard.display;

import com.bestcollab.collaboard.json.JsonConverter;
import com.bestcollab.collaboard.model.BasicBoard;

public class JsonViewer {

	public static String viewBoardAsJson(BasicBoard board) {
		return JsonConverter.getJson(board);
	}
}
