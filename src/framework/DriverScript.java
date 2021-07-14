package framework;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.testng.TestNG;
import org.testng.annotations.Test;

import utility.ExcelReader;

public class DriverScript {

	@SuppressWarnings("rawtypes")
	@Test(priority = -1)
	public void DriverScriptTrig() throws Exception {
		// Read Run Data from Excel
		String currentDir = System.getProperty("user.dir") + File.separator;
		String driverFile = currentDir+"/input/config.xlsx";
		ExcelReader excel = new ExcelReader(driverFile);
		Object[][] driverData = excel.read("TestDataMapping").asObjectArray();

		// Create TestNG Object
		TestNG testNGSet = new TestNG();

		// Adding POM.XML path to suit list
		List<String> suitNamesSet = new ArrayList<String>();
		Map mapSet;
		for (int i = 0; i < driverData.length; ++i) {
			mapSet = (Map) driverData[i][0];
			if (mapSet.get("RunFlag").toString().toUpperCase().equals("Y")) {
				String[] allItem = mapSet.get("ScriptName").toString().split("\\.");
				suitNamesSet.add((String) currentDir+"DriverXML/"+allItem[allItem.length-1]+".xml");
			}
		}

		// setting testing Suit
		testNGSet.setTestSuites(suitNamesSet);

		// Running suit
		testNGSet.run();
		
		//get all results
		ArrayList<File> directories = new ArrayList<File>(Arrays.asList(new File(ReportsLib.resultLoc+"\\").listFiles(File::isDirectory)));
		indexMaker ind = new indexMaker(ReportsLib.resultLoc+"\\index.html");
		for(int i=0; i<directories.size(); ++i) {
			String separator = "\\";
			String[] arrValues = directories.get(i).toString().split(Pattern.quote(separator));
			ind.addLink("hyper_"+i,arrValues[arrValues.length - 1]+"/Result.html", arrValues[arrValues.length - 1]);
		}
		ind.saveFile();
	}

}
