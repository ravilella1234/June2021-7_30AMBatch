package excelDataDriven;

public class ExcelOperations 
{

	public static void main(String[] args) throws Exception 
	{
		ExcelAPI e1 = new ExcelAPI("C:\\Users\\DELL\\Desktop\\testdata2.xlsx");
		
		int rowsCount = e1.getRowCount("login");
		System.out.println(rowsCount);
		
		int colCount = e1.columnCount("login");
		System.out.println(colCount);
		
		System.out.println(e1.getCellData("login", 0, 1));
		System.out.println(e1.getCellData("login", "UserName", 1));

		e1.setCellData("login", 4, 4, "Failed");
	}

}
