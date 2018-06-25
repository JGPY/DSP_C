package vip.iotworld.utils;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * jxl读excel
 * 
 * @author liubing
 * 
 */

//java jxl工具包读取excel：不支持读取 excel 2007 文件(*.xlsx)，只支持 excel 2003 (*.xls)
public class JxlReadDemo {
	public static void main(String[] args) throws BiffException, IOException {

		String Path = "D:\\Program Files\\Java\\eclipse-workspace\\AutoExcel\\files";
		String[] fileName = GetFileName.getFileName(Path);
		File xlsFile = new File(Path +"\\"+ fileName[0]);
		
		// 获得工作簿对象
		Workbook workbook = Workbook.getWorkbook(xlsFile);
		// 获得所有工作表
		Sheet[] sheets = workbook.getSheets();
		// 遍历工作表
		if (sheets != null) {
			for (Sheet sheet : sheets) {
				// 获得行数
				int rows = sheet.getRows();
				// 获得列数
				int cols = sheet.getColumns();
				// 读取数据
				for (int row = 0; row < rows; row++) {
					for (int col = 0; col < cols; col++) {
						System.out.printf("%10s", sheet.getCell(col, row).getContents());
					}
					System.out.println();
				}
			}
		}
		workbook.close();
	}
}
