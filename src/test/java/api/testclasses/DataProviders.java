package api.testclasses;

import java.io.File;
import org.testng.annotations.DataProvider;

import common.utils.ExcelReader;

public class DataProviders {

	@DataProvider(name="data")
	public String[][] getpostdata(){
		File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Data Source\\dataset.xlsx");
		String name = "Sheet1";
		return ExcelReader.getExcelData(f, name);
	}

}
