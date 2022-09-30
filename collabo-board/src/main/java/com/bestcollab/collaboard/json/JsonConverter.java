package com.bestcollab.collaboard.json;

import com.google.gson.Gson;

public class JsonConverter {

	public static String getJson(Object object) {
		Gson gson = new Gson();
		String json = gson.toJson(object);
		return json;
	}

}
