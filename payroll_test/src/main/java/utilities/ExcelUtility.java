package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public int rowCount, columnCount;
	public Object logInData[][];
	
	public void readExcel(String ExcelPath, String sheetName) throws IOException {
		
		FileInputStream file= new FileInputStream(ExcelPath);
	      XSSFWorkbook wb = new XSSFWorkbook(file);
	      XSSFSheet sheet = wb.getSheet(sheetName);
	      
	      int rowCount = sheet.getLastRowNum();
	      int column = sheet.getRow(0).getLastCellNum();
	      
	      logInData = new Object[rowCount][column];
	      for (int i = 1; i <= rowCount; i++)
	      {
	          XSSFRow row = sheet.getRow(i);
	          for (int j = 0; j < column; j++) 
	          {
	              logInData[i-1][j]= row.getCell(j).getStringCellValue();
	        	  
	}
	      }
	}
	
	public static final String getExcelPath() {
		
		final String excelPath=System.getProperty("user.dir")+"\\src\\test\\resources\\resourceForTest\\Book1.xlsx";
		return excelPath;
		
	}
	
   public static final String getSheetName() {
		
		final String sheetName="Login Details";
		return sheetName;
		
	}
   
   /*public void readExcel() throws IOException {
		
		FileInputStream file= new FileInputStream("F:\\excelread\\Book1.xlsx");
	      XSSFWorkbook wb = new XSSFWorkbook(file);
	      XSSFSheet sheet = wb.getSheet("Login Details");
	      
	      int rowCount = sheet.getLastRowNum();
	      int column = sheet.getRow(0).getLastCellNum();
	      
	      logInData = new Object[rowCount+1][column];
	      for (int i = 1; i <= rowCount; i++)
	      {
	          XSSFRow row = sheet.getRow(i);
	          for (int j = 0; j < column; j++) 
	          {
	              logInData[i][j]= row.getCell(j).getStringCellValue();
	        	  
	}
	      }
	}*/
	
}
		


