package com.Test.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {

	static Properties properties;

	public static String loadPropertyFile(String propertyFilename, String Key) throws IOException {
		File file = new File(propertyFilename);

		FileInputStream fis = new FileInputStream(file);
		properties = new Properties();
		properties.load(fis);
		System.out.println(properties.getProperty(Key));
		return properties.getProperty(Key);

	}
}
