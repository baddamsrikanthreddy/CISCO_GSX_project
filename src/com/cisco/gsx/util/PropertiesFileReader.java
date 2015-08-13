/**
 * 
 */
package com.cisco.gsx.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileReader {

	private static PropertiesFileReader INSTANCE = null;
	static Properties properties = new Properties();

	private PropertiesFileReader() {

	}

	public static synchronized PropertiesFileReader getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PropertiesFileReader();
		}
		return INSTANCE;
	}

	public Properties readProperties(String name) {

		InputStream in = null;

		try {
			if (null != name) {
				in = this.getClass().getResourceAsStream("/resources/" + name);

				properties.load(in);
				System.out.println("Properties File Loadded successfully : "
						+ name);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	public static String getKeyValue(String key) {
		String value = null;
		if (null != key && !"".equalsIgnoreCase(key)) {
			value = (String) properties.get(key);
		}
		return value;
	}

}
