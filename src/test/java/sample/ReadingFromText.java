package sample;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

public class ReadingFromText {
	@Test
	public void read() {

		File file = null;
		FileReader reader = null;
		BufferedReader bf = null;
		try {
			file = new File("D:\\selenium_classes\\testng.txt");
			reader = new FileReader(file);
			bf = new BufferedReader(reader);
			String st = "";

			while ((st = bf.readLine()) != null) {
				System.out.println(st);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void read2(){

		File file = null;
		FileInputStream reader = null;
		BufferedInputStream bf = null;
		try {
			file = new File("D:\\selenium_classes\\testng.txt");
			reader = new FileInputStream(file);
			bf = new BufferedInputStream(reader);
			String st = "";

			
			int temp = 0;
			char a = 0;
			while( (temp =  bf.read()) != -1){
				a =(char) temp;
				System.out.print(a);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
