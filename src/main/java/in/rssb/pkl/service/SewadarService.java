package in.rssb.pkl.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.http.HttpResponse;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import in.rssb.pkl.config.SewadarExcelConfig;
import in.rssb.pkl.entity.Sewadar;
import in.rssb.pkl.repository.SewadarRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class SewadarService {

	@Autowired
	private SewadarRepository sewadarRepository;
	
	public void save(MultipartFile file) {
		try {
			List<Sewadar> listOfSewedar = SewadarExcelConfig.convertExcelToListOfSewedar(file.getInputStream());
			sewadarRepository.saveAll(listOfSewedar);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public List<Sewadar> getAllSewadar() {
		return sewadarRepository.findAll();
	}
	
	public void  generateExcel(HttpServletResponse response) throws IOException {
		List<Sewadar> listOfSewadar = sewadarRepository.findAll();
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("sewadarInfo");
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("Sno");
		row.createCell(1).setCellValue("idofsewadar");
		row.createCell(2).setCellValue("firstname");
		row.createCell(3).setCellValue("lastname");
		row.createCell(4).setCellValue("gender");
		row.createCell(5).setCellValue("age");
		row.createCell(6).setCellValue("country");
		row.createCell(7).setCellValue("dateofsewadar");
		
		int dataRowIndex = 1;
		
		for(Sewadar sewadar : listOfSewadar) {
			HSSFRow dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(sewadar.getSno());
			dataRow.createCell(1).setCellValue(sewadar.getIdofsewadar());
			dataRow.createCell(2).setCellValue(sewadar.getFirstname());
			dataRow.createCell(3).setCellValue(sewadar.getLastname());
			dataRow.createCell(4).setCellValue(sewadar.getGender());
			dataRow.createCell(5).setCellValue(sewadar.getAge());
			dataRow.createCell(6).setCellValue(sewadar.getCountry());
			dataRow.createCell(7).setCellValue(sewadar.getDateofsewadar());
			dataRowIndex++;
		}
		ServletOutputStream ops = response.getOutputStream();
		workbook.write(ops);
		ops.close();
	}
	
}
