package utilities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.*;

public class DataReader {
	//public static HashMap<String, String> storeValues = new HashMap();
	
	public static List<HashMap<String,String>> data(String filePath, String sheetName) throws Exception {
		List<HashMap<String, String>> mydata = new ArrayList<>();
		
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet =	workbook.getSheet(sheetName);
		XSSFRow headerRow = sheet.getRow(0);
		XSSFRow row = sheet.getRow(0);
		int totalRows = sheet.getPhysicalNumberOfRows();
		int totalCells =	row.getPhysicalNumberOfCells();
		System.out.println(totalRows+"\t"+totalCells);
		
		for(int i=1; i<totalRows; i++) {
			XSSFRow currentRow = sheet.getRow(i);
			HashMap<String, String> currentHashMap = new HashMap<String, String>();
			for(int j=0; j<currentRow.getPhysicalNumberOfCells(); j++) {
				XSSFCell currentCell	= currentRow.getCell(j);
				currentHashMap.put(headerRow.getCell(j).toString(), currentCell.toString());
				System.out.print(currentCell.toString()+"\t");
			}
			mydata.add(currentHashMap);
			System.out.println();
		}
		workbook.close();
		fis.close();
	return mydata;
	}
}
