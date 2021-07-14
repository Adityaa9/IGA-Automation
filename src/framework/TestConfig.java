package framework;

import utility.ArrayManager;
import utility.ExcelReader;

public class TestConfig {

	private String testconfigFile;
	
	public TestConfig() {
		this.testconfigFile = System.getProperty("user.dir")+"/input/config.xlsx";
	}
	
	public Object[][] getTestData(String className) throws Exception {
		ExcelReader excel=new ExcelReader(this.testconfigFile);
		Object[][] testDataBucket = null;
		String[][] mapping = excel.read("TestDataMapping").asArray();
		int i;
		for(i=1; i<mapping.length; ++i) {
			if(mapping[i][0].trim().equals(className)) {
				break;
			}
		}
		if(i<mapping.length) {
			ExcelReader testData = new ExcelReader(System.getProperty("user.dir")+"/input/TestData/"+mapping[i][1].trim()+".xlsx");
			String[][] testDataBuckettemp = testData.read(mapping[i][2]).asArray();
			testDataBuckettemp = ArrayManager.filter(testDataBuckettemp, "RunFlag", "Y");
			testDataBucket = ArrayManager.arrayTOObject(testDataBuckettemp);
		}
		return testDataBucket;
	}
	 
	
}
