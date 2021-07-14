package framework;

import java.util.HashMap;
import java.util.Map;

import utility.ExcelReader;

public class EnvScop {
	private String envFile = System.getProperty("user.dir") + "/input/config.xlsx";
	private ExcelReader excelData;
	private Map<String, String> globalData;
	private Map<String, String> envData;
	
	public EnvScop() {
		this.excelData = new ExcelReader(envFile);
		this.globalData = new HashMap<String, String>();
		this.envData = new HashMap<String, String>();
		try {
			this.readGlobelData();
			this.readEnvData();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void readGlobelData() throws Exception {
		String[][] data = excelData.read("global").asArray();
		for (int i = 0; i < data.length; ++i) {
			this.globalData.put(data[i][0], data[i][1]);
		}
	}

	public Map<String, String> global() {
		return this.globalData;
	}
	
	public String global(String dataName) {
		return this.globalData.get(dataName);
	}

	private void readEnvData() throws Exception {
		String[][] data = excelData.read(this.global("Enviorment")).asArray();
		for (int i = 0; i < data.length; ++i) {
			this.envData.put(data[i][0], data[i][1]);
		}
	}
	
	public Map<String, String> env() {
		return this.globalData;
	}

	public String env(String dataName) {
		return this.envData.get(dataName);
	}
	
}
