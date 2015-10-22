package com.vtcintecom.strickeforce.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.vtcintecom.strickeforce.entity.Login;
import com.vtcintecom.strickeforce.entity.Register;

public class DataRegister {

	public DataRegister() {
	}

	public static void main(String[] args) {
		DataRegister data = new DataRegister();
		ArrayList<Register> list = data.getRegister();
		data.write(list);
	}

	public ArrayList<Register> getRegister() {
		ArrayList<Register> list = new ArrayList<Register>();
		FileInputStream fis;
		try {
			fis = new FileInputStream("Data_Test.xlsx");

			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(1);
			for (int rows = 1; rows < sheet.getPhysicalNumberOfRows(); rows++) {
				Register reg = new Register();

				Cell cell_id = sheet.getRow(rows).getCell(0);
				Cell cell_user = sheet.getRow(rows).getCell(1);
				Cell cell_pass = sheet.getRow(rows).getCell(2);
				Cell cell_confirm_pass = sheet.getRow(rows).getCell(3);
				Cell cell_expect = sheet.getRow(rows).getCell(4);
				Cell cell_img_exp = sheet.getRow(rows).getCell(5);
				Cell cell_result1 = sheet.getRow(rows).getCell(6);
				Cell cell_result2 = sheet.getRow(rows).getCell(7);

				reg.setId(cell_id.getNumericCellValue());
				reg.setUsername(cell_user.getStringCellValue());
				reg.setPassword(cell_pass.getStringCellValue());
				reg.setConfirm_pass(cell_confirm_pass.getStringCellValue());
				reg.setExpect(cell_expect.getStringCellValue());
				reg.setImg_expect(cell_img_exp.getStringCellValue());
				reg.setResult1(cell_result1.getStringCellValue());
				reg.setResult2(cell_result2.getStringCellValue());
				list.add(reg);

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void write(ArrayList<Register> list) {
		try {
			FileInputStream fis = new FileInputStream("Data_Test.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			XSSFSheet sheet = wb.getSheetAt(4);
			int introw = 1;
			for (Register reg : list) {
				Row row = sheet.createRow(introw++);

				Cell cell_id = row.createCell(0);
				Cell cell_username = row.createCell(1);
				Cell cell_pass = row.createCell(2);
				Cell cell_confirm_pass = row.createCell(3);
				Cell cell_expect = row.createCell(4);
				Cell cell_img_expect = row.createCell(5);
				Cell cell_result1 = row.createCell(6);
				Cell cell_result2 = row.createCell(7);

				cell_id.setCellValue((Double) reg.getId());
				cell_username.setCellValue((String) reg.getUsername());
				cell_pass.setCellValue((String) reg.getPassword());
				cell_confirm_pass.setCellValue((String) reg.getConfirm_pass());
				cell_expect.setCellValue((String) reg.getExpect());
				cell_img_expect.setCellValue((String) reg.getImg_expect());
				cell_result1.setCellValue((String) reg.getResult1());
				cell_result2.setCellValue((String) reg.getResult2());

			}

			FileOutputStream os = new FileOutputStream("Data_Test.xlsx");
			wb.write(os);
			os.close();
			wb.close();
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("finished write file");
	}

}
