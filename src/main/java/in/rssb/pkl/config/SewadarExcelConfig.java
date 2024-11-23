package in.rssb.pkl.config;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import in.rssb.pkl.entity.Sewadar;

public class SewadarExcelConfig {

	//check file is excel or not
	public static boolean checkExcelForma(MultipartFile file) {
		String contentType= file.getContentType();
		if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else if(contentType.equals("application/vnd.ms-excel")) {
        	return true;
        }else if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
        	return true;
        }else {
            return false;
        }
	}
	
	//convert excel to list of sewadar
	public static List<Sewadar> convertExcelToListOfSewedar(InputStream file){
		List<Sewadar> listOfSewadar= new ArrayList<>();
		try {
			HSSFWorkbook xssfWorkbook = new HSSFWorkbook(file);
			HSSFSheet sheet = xssfWorkbook.getSheet("Sheet1");
			int rowNumber = 0;
			Iterator<Row> iterator = sheet.iterator();
			while(iterator.hasNext()) {
				Row row = iterator.next();
				System.err.println(row.getRowNum());
				System.err.println(row.getSheet());
				if(rowNumber==0) {
					rowNumber++;
					continue;
				}
				Iterator<Cell> cells = row.iterator();
				int cid=0;
				Sewadar sewadar=new Sewadar();
				
				while(cells.hasNext()) {
					Cell cell = cells.next(); //ek cell nikalo
					switch (cid) {
					case 0: sewadar.setSno((int)cell.getNumericCellValue()); break;
					case 1: sewadar.setFirstname(cell.getStringCellValue()); break;
					case 2: sewadar.setLastname(cell.getStringCellValue()); break;
					case 3: sewadar.setGender(cell.getStringCellValue()); break;
					case 4: sewadar.setCountry(cell.getStringCellValue()); break;
					case 5: sewadar.setAge((int) cell.getNumericCellValue()); break;
					case 6: sewadar.setDateofsewadar(cell.getStringCellValue()); break;
					case 7: sewadar.setIdofsewadar((long) cell.getNumericCellValue()); break;
					default:  break;
					}
					cid++;
				}
				listOfSewadar.add(sewadar);
			}
		}catch (Exception e) {
            e.printStackTrace();
        }
        return listOfSewadar;
	} 
	
}
