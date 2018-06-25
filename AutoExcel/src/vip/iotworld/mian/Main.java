package vip.iotworld.mian;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import vip.iotworld.dao.InforExcel;
import vip.iotworld.dao.Student;
import vip.iotworld.utils.GetFileName;

public class Main {
	
	public static void main(String[] args) {
		String Path = "D:\\Program Files\\Java\\eclipse-workspace\\AutoExcel\\files";
		String[] fileName = GetFileName.getFileName(Path);
		File xlsFile = null;
		int position = 15-1; 
		int add = 0;
		for(String name :fileName){	
			xlsFile= new File(Path + "\\" + name);
			Workbook workbook = null;
			// 获得工作簿
			try {
				workbook = WorkbookFactory.create(xlsFile);
			} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 获得第一个工作表
			Sheet sheet = workbook.getSheetAt(0);
			//获取Excel信息
			InforExcel inforExcel = new InforExcel();
			inforExcel.setTitleCH(sheet.getRow(5-1).getCell(3).getStringCellValue());
			inforExcel.setTitleEN(sheet.getRow(6-1).getCell(3).getStringCellValue());
			//getStringCellValue() 报异常 Cannot get a sting value from a numeric cell，
			inforExcel.setPhone(sheet.getRow(9-1).getCell(4).getNumericCellValue());			
			inforExcel.setEmail(sheet.getRow(10-1).getCell(4).getStringCellValue());
			inforExcel.setTeacher(sheet.getRow(10-1).getCell(0).getStringCellValue());
			System.out.println(name+inforExcel);
			//参赛学生并不固定，所以先算出总共行rows，然后逆推参赛人数。然而很不幸，每个人的发来的文件行数并不准确，没时间纠结原因，所以直接从A12开始，逐行判断，字符"注"截止
			// 获得行数
//			int rows = sheet.getLastRowNum()-10;
//			System.out.println(name+"行数："+rows);
			//规定参赛人数不超过6人
			List<Student> students = new ArrayList<Student>();
			for(int i=0; i<6; i++) {
				String college = sheet.getRow(14-1).getCell(1-1).getStringCellValue();
				System.out.println(college);
				String regex = "红色注明";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(college);				
						
				if (!matcher.find()) {
					
					Student student = new Student();
					student.setCollege(sheet.getRow(13+i-1).getCell(1-1).getStringCellValue());
					student.setMajor(sheet.getRow(13+i-1).getCell(3-1).getStringCellValue());
					student.setGrade(sheet.getRow(13+i-1).getCell(5-1).getStringCellValue());
					student.setName(sheet.getRow(13+i-1).getCell(7-1).getStringCellValue());
					student.setStudentNumber(sheet.getRow(13+i-1).getCell(8-1).getNumericCellValue());
					student.setPhone(sheet.getRow(13+i-1).getCell(9-1).getNumericCellValue());
					//student.setWeChat(sheet.getRow(13+i-1).getCell(10-1).getStringCellValue());
					student.setEmail(sheet.getRow(13+i-1).getCell(11-1).getStringCellValue());
					System.out.println(student);
					students.add(student);
				}else {
					break;
				}
			}
			
			//写入表格中
//			String[] fileName2 = GetFileName.getFileName(Path);
//			File xlsFile2 = null;
//			// 创建工作薄
//			HSSFWorkbook workbook2 = new HSSFWorkbook(xlsFile2);
//			// 创建工作表
//			HSSFSheet sheet2 = workbook.createSheet("sheet1");
			add = add+1;
		}
			
	}
}
