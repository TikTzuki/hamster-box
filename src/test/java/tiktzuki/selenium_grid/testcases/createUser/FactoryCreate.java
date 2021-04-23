package tiktzuki.selenium_grid.testcases.createUser;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import tiktzuki.selenium_grid.testcases.login.TestLogin;
import tiktzuki.selenium_grid.utils.Constant;
import tiktzuki.selenium_grid.utils.ExcelUtils;

public class FactoryCreate {
	@Factory(dataProvider="dataModifyLogin")
	public Object[] createInstances(String usename, String phonenumber, String email, String password, String bl1, String bl2, String bl3) {
		
		return new Object[] {new Create(usename, phonenumber, email, password, bl1, bl2, bl3)};
	}
	
	@DataProvider(name = "dataModifyLogin")
	public Object[][] dataMethod(){
		Object[][] arrayObjects = Login();
		return arrayObjects;
	}

	private Object[][] Login() {
		// Setup data for test
				ExcelUtils excelUtil = new ExcelUtils(Constant.Path_TestData+Constant.File_Create, "Sheet1");
				String[][] excelData = null;
				int totalRows = excelUtil.getRowCount();
				int totalCols = excelUtil.getColCont();
				excelData = new String[totalRows-1][totalCols-1];
				
				int startRow = 1;
				int startCol = 1;
				
				for(int i = startRow; i < totalRows; i++) {
					for(int j = startCol; j < totalCols; j++) {
						try {
							excelData[i-1][j-1] = excelUtil.getCellData(i, j).toString();
							System.out.print("\t"+excelData[i-1][j-1]);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					System.out.println();
				}
				return excelData;
	}
}
