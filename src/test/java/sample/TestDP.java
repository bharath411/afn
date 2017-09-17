package sample;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDP {

	/*
	 * @Test public void login1(){ String username = "a"; String password = "b";
	 * //logic for login... System.out.println(username);
	 * System.out.println(password); }
	 * 
	 * @Test public void login2(){ String username = "d"; String password = "c";
	 * //logic for login... System.out.println(username);
	 * System.out.println(password); }
	 */

	@DataProvider(name = "dp")
	public Object[][] datap() {

		Object[][] obj = new Object[10][2];
		obj[0][0] = "a";
		obj[0][1] = "b";

		obj[1][0] = "c";
		obj[1][1] = "d";

		obj[2][0] = "e";
		obj[2][1] = "f";

		obj[3][0] = "g";
		obj[3][1] = "h";

		return obj;
	}

	

	@DataProvider(name = "dp_list")
	public Object[][] datap_fromList() {

		DataHandle dh = new DataHandle();
		List<List<String>> inputList = dh.getData();
		int rows = inputList.size();

		Object[][] obj = new Object[rows][2];

		for (int i = 0; i < inputList.size(); i++) {
			List<String> li = inputList.get(i);
			obj[i][0] = li.get(0);
			obj[i][1] = li.get(1);
		}
		return obj;
	}
	
	
	
	@DataProvider(name = "dp_map_list")
	public Object[][] datap_fromMap_List() {

		DataHandle dh = new DataHandle();
		Map<Integer,List<String>> inputMap = dh.getMapData();
		int rows = inputMap.size();

		Object[][] obj = new Object[rows][2];
		
		Set<Integer> set = inputMap.keySet();
		
		for (Integer key : set) {
			List<String> list= inputMap.get(key);
			obj[key][0] = list.get(0);
			obj[key][1] = list.get(1);
		}
		
		return obj;
	}
	
	@Test(dataProvider = "dp_excel1")
	public void login(String username, String password) {
		// logic for login...
		if (username == null) {
			Assert.fail();
		}
		System.out.println(username);
		System.out.println(password);
	}
	@DataProvider(name = "dp_excel1")
	public Object[][] datap_excel1() {
		ExcelData_Both exc  = new ExcelData_Both();
		int rows = exc.getTotalNumberOfRows();
		Object[][] obj = new Object[rows-1][2];
		
		for (int i = 1; i < rows; i++) {
			obj[i-1][0]= exc.getData(i, 0);
			obj[i-1][1]= exc.getData(i, 1);
		}
		
		return obj;
	}
	
	
}
