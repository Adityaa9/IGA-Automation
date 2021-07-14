package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private String filePath;
	private File file;

	private FileInputStream fis;
	private XSSFWorkbook wb;
	private XSSFSheet sheet;
	private Iterator<Row> itr;

	private String[][] arrayBucket;
	private List<List<String>> listBucket;

	public ExcelReader(String filePath) {
		this.filePath = filePath;
		this.file = new File(this.filePath);
	}

	private void readPreReq() throws Exception {
		this.fis = new FileInputStream(this.file);
		this.wb = new XSSFWorkbook(this.fis);
	}

	private void readData() {
		this.itr = sheet.iterator();
		this.listBucket = new ArrayList<List<String>>();
		while (itr.hasNext()) {
			Row row = itr.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			List<String> rowBucket = new ArrayList<String>();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cell.getCellType()) {
				case STRING:
					rowBucket.add(cell.getStringCellValue());
					break;
				case NUMERIC:
					rowBucket.add(cell.getNumericCellValue() + "");
					break;
				default:
				}
			}
			this.listBucket.add(rowBucket);
		}
		this.toArray();
	}

	private void toArray() {
		this.arrayBucket = new String[this.listBucket.size()][this.listBucket.get(0).size()];
		for (int i = 0; i < this.listBucket.size(); ++i) {
			for (int j = 0; j < this.listBucket.get(i).size(); ++j) {
				this.arrayBucket[i][j] = this.listBucket.get(i).get(j);
			}
		}
	}

	public ExcelReader read(String sheetName) throws Exception {
		this.readPreReq();
		this.sheet = wb.getSheet(sheetName);
		this.readData();
		return this;
	}

	public ExcelReader read(int sheetIndex) throws Exception {
		this.readPreReq();
		this.sheet = wb.getSheetAt(sheetIndex);
		this.readData();
		return this;
	}

	public List<List<String>> asList() {
		return this.listBucket;
	}

	public String[][] asArray() {
		return this.arrayBucket;
	}

	public Object[][] asObjectArray() {
		return ArrayManager.arrayTOObject(this.arrayBucket);
	}
	
	public void print() {
		for (int i = 0; i < this.arrayBucket.length; ++i) {
			for (int j = 0; j < this.arrayBucket[i].length; ++j) {
				System.out.print(this.arrayBucket[i][j] + "\t\t");
			}
			System.out.println();
		}
	}
	
	

}