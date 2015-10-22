package com.vtcintecom.strickeforce.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.vtcintecom.strickeforce.entity.Login;

public class DataLogin {

	private ArrayList<Login> arrayList = new ArrayList<Login>();
	private File excel;

	public DataLogin() {
		// TODO Auto-generated constructor stub
		excel = new File("Data_Test.xlsx");
	}

	public static void main(String[] args) {
		DataLogin data = new DataLogin();
		data.write();

	}

	public ArrayList<Login> getLogin() throws IOException {
		FileInputStream fis = new FileInputStream("Data_Test.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheetAt(0);
		for (int rows = 1; rows < sheet.getPhysicalNumberOfRows(); rows++) {
			Login login = new Login();

			Cell cell_id = sheet.getRow(rows).getCell(0);
			Cell cell_user = sheet.getRow(rows).getCell(1);
			Cell cell_pass = sheet.getRow(rows).getCell(2);
			Cell cell_expect = sheet.getRow(rows).getCell(3);
			Cell cell_img_exp = sheet.getRow(rows).getCell(4);

			login.setId(cell_id.getNumericCellValue());
			login.setUsername(cell_user.getStringCellValue());
			login.setPassword(cell_pass.getStringCellValue());
			login.setExpect(cell_expect.getStringCellValue());
			login.setImg_expect(cell_img_exp.getStringCellValue());

			arrayList.add(login);

		}
		return arrayList;
	}

	public void write() {
		try {
			FileInputStream fis = new FileInputStream("Data_Test.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			XSSFSheet sheet = wb.getSheetAt(0);

			Map<String, Object[]> data = new HashMap<String, Object[]>();
			data.put("4", new Object[] { 7d, "Sonya", "75K", "Sales", "Rupert" });
			data.put("7", new Object[] { 45d, "Kris", "95K", "Sales", "Rupert" });
			data.put("43", new Object[] { 70d, "Davi", "075K", "Sales", "Rupert" });
			data.put("8", new Object[] { 327d, "Dave", "975K", "Sales", "Rupert" });

			Set<String> newRows = data.keySet();
			// int rownum = sheet.getPhysicalNumberOfRows();
			int rownum = 1;
			for (String key : newRows) {
				Row row = sheet.createRow(rownum++);
				Object[] objArr = data.get(key);
				int cellnum = 4;
				for (Object obj : objArr) {
					Cell cell = row.createCell(cellnum++);
					if (obj instanceof String) {
						cell.setCellValue((String) obj);
					} else if (obj instanceof Boolean) {
						cell.setCellValue((Boolean) obj);
					} else if (obj instanceof Date) {
						cell.setCellValue((Date) obj);
					} else if (obj instanceof Double) {
						cell.setCellValue((Double) obj);
					}
				}
			}

			FileOutputStream os = new FileOutputStream(excel);
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