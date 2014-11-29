package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Staff entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "staff", catalog = "mydb")
public class Staff implements java.io.Serializable {

	// Fields

	private Integer id;
	private Publisher publisher;
	private String email;
	private String password;
	private Integer parentid;
	private Integer role;
	private Integer level;
	private String name;
	private Integer gender;
	private String phone;

	// Constructors

	/** default constructor */
	public Staff() {
	}

	/** minimal constructor */
	public Staff(Publisher publisher) {
		this.publisher = publisher;
	}

	/** full constructor */
	public Staff(Publisher publisher, String email, String password,
			Integer parentid, Integer role, Integer level, String name,
			Integer gender, String phone) {
		this.publisher = publisher;
		this.email = email;
		this.password = password;
		this.parentid = parentid;
		this.role = role;
		this.level = level;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Publisher_id", nullable = false)
	public Publisher getPublisher() {
		return this.publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "parentid")
	public Integer getParentid() {
		return this.parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	@Column(name = "role")
	public Integer getRole() {
		return this.role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	@Column(name = "level")
	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "gender")
	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Column(name = "phone", length = 45)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", publisher=" + publisher + ", email="
				+ email + ", password=" + password + ", parentid=" + parentid
				+ ", role=" + role + ", level=" + level + ", name=" + name
				+ ", gender=" + gender + ", phone=" + phone + "]";
	}

}