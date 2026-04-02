package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderss {

	// =========================
	// Data Provider for full user data
	// =========================
	@DataProvider(name = "Data")
	public String[][] getAllData() throws Exception {

		String path = System.getProperty("user.dir")+"//testData//Book1.xlsx";
		ExecelUtility xl = new ExecelUtility(path);

		int rownum = xl.getRowCount("Sheet1");
		int colcount = xl.getCellCount("Sheet1", 1);

		String apidata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				apidata[i - 1][j] = xl.getCellData("Sheet1", i, j);
			}
		}

		return apidata;
	}

	// =========================
	// Data Provider for usernames only
	// =========================
	@DataProvider(name = "UserNames")
	public String[] getUserNames() throws Exception {

		String path = System.getProperty("user.dir") + "//testData//Book1.xlsx";
		ExecelUtility xl = new ExecelUtility(path);

		int rownum = xl.getRowCount("Sheet1");

		String apidata[] = new String[rownum];

		for (int i = 1; i <= rownum; i++) {
			apidata[i - 1] = xl.getCellData("Sheet1", i, 1);
		}

		return apidata;
	}

}
