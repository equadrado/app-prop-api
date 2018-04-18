package com.square.rbc.apppropapi.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.springframework.util.Base64Utils;

import com.google.gson.Gson;

/**
 * 
 * @author equadrado
 *
 */
public class Utility {

	/**
	 * 
	 * @param string
	 * @return
	 */
	public static Object stringToSerializable(String string) {
		Object object = null;
		try {
			byte[] data = Base64Utils.decodeFromString(string);
			ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
			
			object = ois.readObject();

			ois.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return object;
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	public static String serializableToString(Serializable object) {
		String string = "";
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);

			oos.writeObject(object);
			oos.close();

			string = Base64Utils.encodeToString(baos.toByteArray());
		} catch (Exception ex) {
		}

		return string;
	}
	
	/**
	 * 
	 * @param object
	 * @return
	 */
	public static String objectToJson(Object object) {
		Gson gson = new Gson();

		// Java object to JSON, and assign to a String
		String jsonInString = gson.toJson(object);

		return jsonInString;
	}
	
	/**
	 * 
	 * @param json
	 * @param cls represents the class type to convert the json data. Must be called as "ClassName.class"
	 * @return
	 */
	public static Object jsonToObject(String json, Class<?> cls) {
		Gson gson = new Gson();
		
		// JSON to Java object (of "cls" Type), read it from a Json String.
		Object object = gson.fromJson(json, cls);
		
		return object;	
	}
}
