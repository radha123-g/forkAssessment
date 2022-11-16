package com.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class FileUtilty {
	/**
	 * this method is used to get common data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyValue(String key) throws IOException {
		FileInputStream fileinputstream = new FileInputStream("./src/test/resources/commondata.properties.txt");
		Properties properties = new Properties();
		properties.load(fileinputstream);
		String value = properties.getProperty(key);
		return value;
	}
}
