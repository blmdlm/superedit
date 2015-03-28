package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Author entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "author", catalog = "mydb")
public class Author implements java.io.Serializable {

	// Fields

	private Integer id;
	private String email;
	private String password;
	private Integer gender;
	private String name;
	private String phone;
	private String address;
	private Date registertime;
	private Set<Script> scripts = new HashSet<Script>(0);

	// Constructors

	/** default constructor */
	public Author() {
	}

	/** full constructor */
	public Author(String email, String password, Integer gender, String name,
			String phone, String address, Date registertime, Set<Script> scripts) {
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.registertime = registertime;
		this.scripts = scripts;
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

	@Column(name = "gender")
	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "phone", length = 45)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "address", length = 65535)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "registertime", length = 10)
	public Date getRegistertime() {
		return this.registertime;
	}

	public void setRegistertime(Date registertime) {
		this.registertime = registertime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "author")
	public Set<Script> getScripts() {
		return this.scripts;
	}

	public void setScripts(Set<Script> scripts) {
		this.scripts = scripts;
	}

}