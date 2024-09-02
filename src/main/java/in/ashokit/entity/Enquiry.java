package in.ashokit.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="enquiry_tbl")
public class Enquiry {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer enqId;
	
	private String stuName;
	private Long studentPhno;
	private String courseName;
	private String classMode;
	private String enqStatus;
	private LocalDate createdDate;
	private LocalDate updatedDate;
	
	// counsellor_id
	@ManyToOne
	@JoinColumn(name="counsellorId")
	private Counsellor counsellor;

	public Enquiry()
	{
		
	}
	public Integer getEnqId() {
		return enqId;
	}

	public void setEnqId(Integer enqId) {
		this.enqId = enqId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Long getStudentPhno() {
		return studentPhno;
	}

	public void setStudentPhno(Long studentPhno) {
		this.studentPhno = studentPhno;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getClassMode() {
		return classMode;
	}

	public void setClassMode(String classMode) {
		this.classMode = classMode;
	}

	public String getEnqStatus() {
		return enqStatus;
	}

	public void setEnqStatus(String enqStatus) {
		this.enqStatus = enqStatus;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Counsellor getCounsellor() {
		return counsellor;
	}

	public void setCounsellor(Counsellor counsellor) {
		this.counsellor = counsellor;
	}

	
	
	
}
