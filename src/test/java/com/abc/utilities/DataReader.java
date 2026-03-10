package com.abc.utilities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.*;

public class DataReader {
    public static List<HashMap<String, String>> data(String filePath, String sheetName) throws Exception {
        List<HashMap<String, String>> myData = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            XSSFRow headerRow = sheet.getRow(0);
            int totalRows = sheet.getPhysicalNumberOfRows();

            for (int i = 1; i < totalRows; i++) {
                XSSFRow currentRow = sheet.getRow(i);
                if (currentRow == null) continue;
                HashMap<String, String> currentHashMap = new HashMap<>();
                for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
                    XSSFCell currentCell = currentRow.getCell(j);
                    currentHashMap.put(headerRow.getCell(j).toString(), currentCell != null ? currentCell.toString() : "");
                }
                myData.add(currentHashMap);
            }
        }
        return myData;
    }

    public static HashMap<String, String> data(String filePath, String sheetName, String tcNo) throws Exception {
        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            XSSFRow headerRow = sheet.getRow(0);
            int totalRows = sheet.getPhysicalNumberOfRows();
            HashMap<String, String> resultData = null;
            for (int i = 1; i < totalRows; i++) {
                XSSFRow currentRow = sheet.getRow(i);
                if (currentRow == null) continue;
                String currentTcNo = currentRow.getCell(0).toString();
                if (currentTcNo.equalsIgnoreCase(tcNo)) {
                    resultData = new HashMap<>();
                    for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
                        XSSFCell currentCell = currentRow.getCell(j);
                        resultData.put(headerRow.getCell(j).toString(), currentCell != null ? currentCell.toString() : "");
                    }
                    break;
                }
            }
            return resultData;
        }
    }
}
