package framework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


import utility.ArrayManager;
import utility.ExcelWritter;

public class Setup {

	public static void main(String[] args) throws IOException {
		String xmlFolder = System.getProperty("user.dir") + File.separator + "DriverXML";
		String testscripfolder = System.getProperty("user.dir") + File.separator + "src/testscripts/";
		
		//delete existing XML's
		Arrays.stream(new File(xmlFolder).listFiles()).forEach(File::delete);
		
		//get all test script files
		List<File> allScripts = Files.walk(Paths.get(testscripfolder))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());
		
		//create xml files
		String xmlTemplate = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<!DOCTYPE suite SYSTEM \"https://testng.org/testng-1.0.dtd\">\r\n"
				+ "<suite name=\"Suite\">\r\n"
				+ "  <test thread-count=\"5\" name=\"Test\">\r\n"
				+ "    <classes>\r\n"
				+ "      <class name=\"testscripts.%s\"/>\r\n"
				+ "    </classes>\r\n"
				+ "  </test> <!-- Test -->\r\n"
				+ "</suite> <!-- Suite -->\r\n";
		for(int i=0; i<allScripts.size(); ++i) {
			String name = allScripts.get(i).toString().replace(testscripfolder.replace("/", "\\"), "");
			 try {
				 String addName = name.replace("\\", "_").replace(".java", ".xml");
			      FileWriter myWriter = new FileWriter(xmlFolder+"/"+addName);
			      myWriter.write(String.format(xmlTemplate, name.replace("\\", ".").replace(".java", "")));
			      myWriter.close();
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
		}
		
		//create helper
		String helperFile = System.getProperty("user.dir") + File.separator + "input/helper.xls"; 
		Path fileToDeletePath = Paths.get(helperFile);
		try {
			Files.delete(fileToDeletePath);
		}catch(Exception e) {
			
		}
		
		ExcelWritter helper = new ExcelWritter(helperFile);
		List<String[]> testDataMapping = new ArrayList<String[]>();
		testDataMapping.add(new String[] {"ScriptName","TestDataFile","TestDataSheet"});
		for(int i=0; i<allScripts.size(); ++i) {
			String name = allScripts.get(i).toString().replace(testscripfolder.replace("/", "\\"), "");
			String scriptName = name.replace("\\", ".").replace(".java", "");
			testDataMapping.add(new String[] {"testscripts."+scriptName,"",""});
		}
		helper.createSheet("TestDataMapping", ArrayManager.listToArray(testDataMapping));
		
		testDataMapping = new ArrayList<String[]>();
		testDataMapping.add(new String[] {"ScriptName","TestCasePOMFileName","RunFlag"});
		for(int i=0; i<allScripts.size(); ++i) {
			String name = allScripts.get(i).toString().replace(testscripfolder.replace("/", "\\"), "");
			String scriptName = name.replace("\\", ".").replace(".java", "");
			String xmlName = name.replace("\\", "_").replace(".java", "");
			testDataMapping.add(new String[] {"testscripts."+scriptName,xmlName,""});
		}
		helper.createSheet("TestScriptRun", ArrayManager.listToArray(testDataMapping));
		helper.save();
		
		System.out.println("Pre-Requisite setting completed");
	}
}
