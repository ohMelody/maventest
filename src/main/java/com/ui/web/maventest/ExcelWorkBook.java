package com.ui.web.maventest;
//读取excel数据。进行参数化

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class ExcelWorkBook {

/*
 */
	private List<String> list = new ArrayList<String>();
	Workbook workbook;
	String username;
	String resource = "C:\\Users\\admin.DESKTOP-CV0PJ4O\\Desktop\\test.xls";
	public List<String> readUsername(String resource){
		List<String> userList = new ArrayList<String>();
		try {
			Workbook workbook = Workbook.getWorkbook(new File(resource));
			Sheet sheet = workbook.getSheet(0);
			
			int rows = sheet.getRows();
			int cols = sheet.getColumns();
			
			for(int i=1;i<rows;i++) {
				String username = sheet.getCell(0,i).getContents();
				userList.add(username);
				System.out.println(username);
			}
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return userList;
		
	}
	public List<String> readPassword(String resource){
		List<String>  userPassword = new ArrayList<String>();
		Workbook workbook;
		try {
			workbook = Workbook.getWorkbook(new File(resource));
			Sheet sheet = workbook.getSheet(0);
			int rows = sheet.getRows();
			for(int i=1;i<rows;i++) {
				String userpassword = sheet.getCell(1, i).getContents();
				userPassword.add(userpassword);
				System.out.println(userpassword);
			}
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userPassword;
		
	}
	public List<String> getList(){
		return list;
	}

}
