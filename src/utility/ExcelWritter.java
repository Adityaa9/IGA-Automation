package utility;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ExcelWritter {
	
	private String filePath;
	private HSSFWorkbook workbook;
	
	public ExcelWritter(String filePath) {
		this.filePath = filePath;
		this.workbook = new HSSFWorkbook();;
	}
	
	public void createSheet(String sheetName, String[][] content) {
		HSSFSheet sheet = this.workbook.createSheet(sheetName);
		for(int i=0; i<content.length; ++i) {
			HSSFRow rowhead = sheet.createRow((short)i);
			for(int j=0; j<content[0].length; ++j) {
				rowhead.createCell(j).setCellValue(content[i][j]);  
			}
		}
	}
	
	public void save() throws IOException {
		FileOutputStream fileOut = new FileOutputStream(this.filePath);  
		this.workbook.write(fileOut);  
		fileOut.close();  
		workbook.close();  
	}
}
