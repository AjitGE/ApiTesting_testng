package com.cs.ExcelRead;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import cucumber.api.Scenario;

public class ExcelRead {
	static Logger log =LogManager.getLogger(ExcelRead.class);
	static Scenario scenario;
	static String path;
	static FileInputStream fIP;
    static XSSFWorkbook workBook;
    static XSSFSheet spreadsheet;
    static Row row;
    static Iterator<String> s;
    static Cell cell;
    static String cellData;
    static List<String> data;
    static String sheetName ;
    final static String  testColumnName="test";
    static LinkedHashMap<String, LinkedHashMap<Integer, List<String>>> outerMap;
	public static ArrayList<String> tags= new ArrayList<String>();
	static String cellValue;
	
	 
		   		
	

	public static String getTestId(String methodName) throws Exception {
		boolean b=false;
		String mName="";
			if(methodName.startsWith("test")) {
				mName=methodName.substring(5);
			  b=true;
			  
			 }
		
		 if (!b) {
				throw new Exception("TestId is missing! Please use methodname tag in feature file:");
			}
		return mName;
		
			}
     
		

	public static String getFileSeparator() {
		return System.getProperty("file.separator");
	}
	
	
	public static HashMap<String, LinkedHashMap<Integer, List<String>>> loadExcelFileData(String path)
    {
		
        // Used the LinkedHashMap and LikedList to maintain the order
        outerMap = new LinkedHashMap<String, LinkedHashMap<Integer, List<String>>>();

        LinkedHashMap<Integer, List<String>> hashMap = new LinkedHashMap<Integer, List<String>>();
        
        // Create an ArrayList to store the data read from excel sheet.
        // List sheetData = new ArrayList();
        
       
        Path fPath=Paths.get(path.replace("\\", getFileSeparator()));
       
        try
        {
        	File fileName = fPath.toAbsolutePath().toFile();
        	 hashMap = new LinkedHashMap<Integer, List<String>>();
        	fIP = new FileInputStream(fileName);
            // Create an excel workbook from the file system
            workBook = new XSSFWorkbook(fIP);
            // Get the first sheet on the workbook.
            for (int i = 0; i < workBook.getNumberOfSheets(); i++)
            {
                XSSFSheet sheet = workBook.getSheetAt(i);
               
                // XSSFSheet sheet = workBook.getSheetAt(0);
                sheetName = workBook.getSheetName(i);

                Iterator<Row> rows = sheet.iterator();
                while (rows.hasNext())
                {
                     row = rows.next();
                    Iterator<Cell> cells = row.iterator();

                    data = new LinkedList<String>();
                   
                    
                    while (cells.hasNext())
                    {   
                    	
                         cell =  cells.next();
                        switch(cell.getCellType()) {
                        case BOOLEAN: 
                        String b=String.valueOf(cell.getBooleanCellValue()); 
                        data.add(b); 
                        break; 
                        case NUMERIC: 
                         String values =String.valueOf((int)cell.getNumericCellValue()); 
                         data.add(values);
                         break; 
                        case STRING: 
                        String s=cell.getStringCellValue(); 
                        data.add(s); 
                        break;
                        case FORMULA: 
                         String f=cell.getStringCellValue(); 
                            data.add(f);
                             break;
                        case BLANK: 
                            String g=cell.getStringCellValue()+"NA"; 
                               data.add(g);
                                break;
						default:
							break;
                        
                        }
                      
                        
                    }
              
					hashMap.put(row.getRowNum(), data);
              
                }
                outerMap.put(sheetName, hashMap);
                log.info("loading excel file data from excel file named: "+ fileName.getName().toString());
            }
        
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (fIP != null)
            {
                try
                {
                    fIP.close();
                    log.info("Excel file is closed..... " );

                }
                catch (IOException e)
                {
                    
                    e.printStackTrace();
                }
            }
        }
  
        return outerMap;

    }

	public static String getdata(String url) throws Exception {
		
		 StackTraceElement[] stackTrace = new Throwable().getStackTrace();
		String testIdNumber=ExcelRead.getTestId(stackTrace[3].getMethodName());
		int columnOfTestId,columnofUrl;
		final String  testColumnName="test";
		
		LinkedHashMap<Integer, List<String>> hashMap = new LinkedHashMap<Integer, List<String>>();
		if(outerMap.isEmpty()){
			throw new Exception("Exception occured while reading :\n"
					    + "you can check for below soltions: \n"
					    + "1. file path is not correct.\n"
					    + "2. use '//' in windows and '/' for linux as file separator \n"
					    + "3. or may be specified data is not present in excel \n" );
		}
		else{
			for (int i = 0; i < workBook.getNumberOfSheets(); i++)
            {
				XSSFSheet sheet = workBook.getSheetAt(i);
			hashMap=outerMap.get(sheet.getSheetName());			
			columnOfTestId=hashMap.get(0).indexOf(testColumnName);
			columnofUrl=hashMap.get(0).indexOf(url);
			
			for(int j=1; j<hashMap.keySet().size();j++)
			{
					if(hashMap.get(j).get(columnOfTestId).equals(testIdNumber))
					{
						cellValue=hashMap.get(j).get(columnofUrl);
						break;
					
					}
					 
			}
			
		}
		
	}
		log.info("Data from excel is: "+ cellValue);
		return cellValue;
		
	}
	
	
		
	
	
}
		

	

		
		
		
		
	


