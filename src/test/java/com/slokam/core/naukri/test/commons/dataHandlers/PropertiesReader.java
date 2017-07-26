package com.slokam.core.naukri.test.commons.dataHandlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

Properties pro = null;
	
	
	public PropertiesReader(){
		init();
	}
	private void init() {

		// Create file object
		File file = new File("D:\\application.properties");
		FileInputStream is = null;
		
		try {
			is = new FileInputStream(file);
			pro = new Properties();
			pro.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	public String getProp(String key) {
		return pro.getProperty(key);
	}
	
}
