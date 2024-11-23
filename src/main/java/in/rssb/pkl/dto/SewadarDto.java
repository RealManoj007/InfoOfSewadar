package in.rssb.pkl.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SewadarDto {
	private String firstName;	
	private String lastName;
	private String gender;
	private String country;
	private Integer age;
	private LocalDate dateOfVisit;
	private Long IdOfSewadar;
}
