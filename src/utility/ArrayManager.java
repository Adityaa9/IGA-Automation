package utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayManager {

	public static Object[][] arrayTOObject(String[][] arrayBucket) {
		int rowLength = arrayBucket.length;
		Object[][] obj = new Object[rowLength-1][1];
		for (int i = 1; i<rowLength; ++i) {
			Map<Object, Object> datamap = new HashMap<Object, Object>();
			for (int j = 0; j < arrayBucket[0].length; ++j) {
				datamap.put(arrayBucket[0][j], arrayBucket[i][j]);
			}
			obj[i-1][0] = datamap;
		}
		return obj;
	}
	
	public static String[][] listToArray(List<String[]> listBucket) {
		String[][] returnBucket = new String[listBucket.size()][listBucket.get(0).length];
		for(int i=0; i<listBucket.size(); ++i) {
			for(int j=0; j<listBucket.get(i).length; ++j) {
				returnBucket[i][j] = listBucket.get(i)[j];
			}
		}
		return returnBucket;
	}
	
	public static int getColumnIndex(String[][] arrayBucket, String columnName) {
		for(int i=0; i<arrayBucket[0].length; ++i) {
			if(arrayBucket[0][i].equals(columnName)) {
				return i;
			}
		}
		return -1;
	}
	
	public static String[][] filter(String[][] arrayBucket, String filterByColumn, String filterByValue) {
		List<String[]> excludeArray = new ArrayList<String[]>();
		int columnIndex = ArrayManager.getColumnIndex(arrayBucket, filterByColumn);
		excludeArray.add(arrayBucket[0]);
		for(int i=1; i<arrayBucket.length; ++i) {
			if(arrayBucket[i][columnIndex].equals(filterByValue)) {
				excludeArray.add(arrayBucket[i]);
			}
		}
		return ArrayManager.listToArray(excludeArray);
	}
	
	public static Object[][] rowReverse(Object[][] dataBucket){
		Object[][] rev = new Object[dataBucket.length][dataBucket[0].length];
		for(int i=0; i<dataBucket.length; ++i) {
			rev[i] = dataBucket[dataBucket.length-1-i];
		}
		return rev;
	}
	
}
