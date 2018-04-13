package com.square.rbc.apppropapi.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.springframework.util.Base64Utils;

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
	
}
