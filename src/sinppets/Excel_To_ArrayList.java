package sinppets;

import java.util.ArrayList;

import utilities.ExcelRead;

public class Excel_To_ArrayList {
int rowCountCaseNo;
ArrayList<String> caseNoList;
	
//	load the case no. from the testData Excel file to ArrayList
	public void loadArrayList() {
		try {
			rowCountCaseNo = ExcelRead.getRowCount("caseNo");
			caseNoList = new ArrayList<String>();

			for (int i = 0; i <= rowCountCaseNo; i++) {
				caseNoList.add(ExcelRead.getData(i, 0, "caseNo"));
			}
			System.out.println("ArrayList size: " + caseNoList.size());
		} catch (Exception e) {
			System.out.println("Failed to read case no. from excel sheet");
		}
	}
}
