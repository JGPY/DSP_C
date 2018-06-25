package vip.iotworld.utils;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * jxl写Excel
 * 
 * @author liubing
 * 
 */
public class JxlWriteDemo
{
   public static void main(String[] args) throws IOException, WriteException
   {
	  
	  String Path = "D:\\Program Files\\Java\\eclipse-workspace\\AutoExcel\\files";
	  String [] fileName = GetFileName.getFileName(Path);
      File xlsFile = new File(Path+fileName[0]);
      // 创建一个工作簿
      WritableWorkbook workbook = Workbook.createWorkbook(xlsFile);
      // 创建一个工作表
      WritableSheet sheet = workbook.createSheet("sheet1", 0);
      for (int row = 0; row < 10; row++)
      {
         for (int col = 0; col < 10; col++)
         {
            // 向工作表中添加数据
            sheet.addCell(new Label(col, row, "data" + row + col));
         }
      }
      workbook.write();
      workbook.close();
   }
}