package in.rssb.pkl.entity;

import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class Sewadar {
	@jakarta.persistence.Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer sno;
	private String firstname;	
	private String lastname;
	private String gender;
	private String country;
	private Integer age;
	private String dateofsewadar;
	private Long idofsewadar;
	
	public Sewadar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sewadar(Integer sno, String firstname, String lastname, String gender, String country, Integer age,
			String dateofsewadar, Long idofsewadar) {
		super();
		this.sno = sno;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.country = country;
		this.age = age;
		this.dateofsewadar = dateofsewadar;
		this.idofsewadar = idofsewadar;
	}

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDateofsewadar() {
		return dateofsewadar;
	}

	public void setDateofsewadar(String date) {
		this.dateofsewadar = date;
	}

	public Long getIdofsewadar() {
		return idofsewadar;
	}

	public void setIdofsewadar(Long idofsewadar) {
		this.idofsewadar = idofsewadar;
	}

	@Override
	public String toString() {
		return "Sewadar [sno=" + sno + ", firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender
				+ ", country=" + country + ", age=" + age + ", dateofsewadar=" + dateofsewadar + ", idofsewadar="
				+ idofsewadar + "]";
	}
}
