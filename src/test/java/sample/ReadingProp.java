package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadingProp {
	Properties pro = null;
	
	
	public ReadingProp(){
		init();
	}
	public void init() {

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
	public static void main(String[] args) {

		ReadingProp prop = new ReadingProp();
		
		System.out.println(prop.getProp("url"));
		System.out.println(prop.getProp("browser"));
	}
}
