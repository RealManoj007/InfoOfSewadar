package in.rssb.pkl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import in.rssb.pkl.config.SewadarExcelConfig;
import in.rssb.pkl.entity.Sewadar;
import in.rssb.pkl.service.SewadarService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin("*")
public class SewadarController {

	@Autowired
	private SewadarService sewadarService;
	
	@PostMapping("/sewadar/upload")
	public ResponseEntity<?> upload(@RequestParam ("file") MultipartFile file){
		System.err.println("file received "+file);
		if(SewadarExcelConfig.checkExcelForma(file)) {
			sewadarService.save(file);
			return ResponseEntity.ok("Fiel is saved to DB");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file again");
	}
	
	@GetMapping("/sewadar")
    public List<Sewadar> getAllSewadar() {
        return sewadarService.getAllSewadar();
    }
	
	@GetMapping("/excel")
	public void generateExcelSheet(HttpServletResponse response) throws Exception{
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=listOfSewader.xls";
		response.setHeader(headerKey, headerValue);
		sewadarService.generateExcel(response);
	}
}
