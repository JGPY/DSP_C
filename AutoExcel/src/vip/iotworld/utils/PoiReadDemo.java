package vip.iotworld.utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Poi写Excel
 * 
 * @author jianggujin
 * 
 */
public class PoiReadDemo {
	public static void main(String[] args) throws IOException, InvalidFormatException {

		String Path = "D:\\Program Files\\Java\\eclipse-workspace\\AutoExcel\\files";
		String[] fileName = GetFileName.getFileName(Path);
		File xlsFile = new File(Path + "\\" + fileName[0]);
		// 获得工作簿
		Workbook workbook = WorkbookFactory.create(xlsFile);
		// 获得工作表个数
		int sheetCount = workbook.getNumberOfSheets();
		System.out.println("获得工作表个数"+sheetCount);
		// 遍历工作表
		for (int i = 0; i < 1; i++) {
			Sheet sheet = workbook.getSheetAt(i);
			// 获得行数
			int rows = sheet.getLastRowNum() + 1;
			// 获得列数，先获得一行，在得到改行列数
			Row tmp = sheet.getRow(0);
			if (tmp == null) {
				continue;
			}
			int cols = tmp.getPhysicalNumberOfCells();
			// 读取数据
			for (int row = 0; row < rows; row++) {
				Row r = sheet.getRow(row);
				for (int col = 0; col < cols; col++) {
					System.out.printf("%10s", r.getCell(col).getStringCellValue());
				}
				System.out.println();
			}
		}
		
		
		
	}
}