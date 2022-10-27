package com.unosquare.utils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtil {
	public static JSONObject read_json_file(String filename) {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		try {
			Reader reader = new FileReader(filename);
			jsonObject = (JSONObject) parser.parse(reader);
			System.out.println(jsonObject);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	public static void write_json_file(String filename, JSONObject json) {
		try {
			FileWriter file = new FileWriter(filename);
			file.write(json.toJSONString());
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
