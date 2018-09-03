package com.flight.testdata;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jopendocument.dom.spreadsheet.MutableCell;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

public class TestData {
	public List<String> readinputdata(int setcol, int setrow) {

		//Creating File object of .ods file
		File file = new File("C:\\Users\\user\\Desktop\\Selenium\\b2cinputdata.ods");
		List<String> templist = new ArrayList<String>();
		Sheet sheet;

		try {
			//Getting the 0th sheet for reading input data.
			sheet = SpreadSheet.createFromFile(file).getSheet(0);

			MutableCell<SpreadSheet> cell = null;

			//Iterating through each row
			for(int rowidx = 1, i = 0; rowidx <= setrow; rowidx++, i++){
				cell = sheet.getCellAt(setcol, rowidx);
				if(cell.getValue().toString().startsWith("\"")) {
					templist.add(i, cell.getValue().toString().replaceAll("\"", "")); 
				}else {
					templist.add(i, cell.getValue().toString());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return templist;
	}

}
