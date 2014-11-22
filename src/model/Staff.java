package model;

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

/**
 * Staff entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "staff", catalog = "mydb")
public class Staff implements java.io.Serializable {

	// Fields

	private Integer id;
	private String email;
	private String password;
	private Integer parentid;
	private Integer character;
	private Integer authority;
	private String name;
	private Integer gender;
	private String phonenum;
	private String address;
	private Set<Proofread> proofreads = new HashSet<Proofread>(0);
	private Set<Audit> audits = new HashSet<Audit>(0);
	private Set<Arrange> arranges = new HashSet<Arrange>(0);
	private Set<Compose> composes = new HashSet<Compose>(0);

	// Constructors

	/** default constructor */
	public Staff() {
	}
	
	/**自定义的构造器 */
	public Staff(String email, String password, Integer parentid,
			Integer character, Integer authority, String name, Integer gender,
			String phonenum, String address){
		super();
		this.email = email;
		this.password = password;
		this.parentid = parentid;
		this.character = character;
		this.authority = authority;
		this.name = name;
		this.gender = gender;
		this.phonenum = phonenum;
		this.address = address;
	}
	
	/** full constructor */
	public Staff(String email, String password, Integer parentid,
			Integer character, Integer authority, String name, Integer gender,
			String phonenum, String address, Set<Proofread> proofreads,
			Set<Audit> audits, Set<Arrange> arranges, Set<Compose> composes) {
		this.email = email;
		this.password = password;
		this.parentid = parentid;
		this.character = character;
		this.authority = authority;
		this.name = name;
		this.gender = gender;
		this.phonenum = phonenum;
		this.address = address;
		this.proofreads = proofreads;
		this.audits = audits;
		this.arranges = arranges;
		this.composes = composes;
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

	@Column(name = "parentid")
	public Integer getParentid() {
		return this.parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	@Column(name = "character")
	public Integer getCharacter() {
		return this.character;
	}

	public void setCharacter(Integer character) {
		this.character = character;
	}

	@Column(name = "authority")
	public Integer getAuthority() {
		return this.authority;
	}

	public void setAuthority(Integer authority) {
		this.authority = authority;
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

	@Column(name = "phonenum", length = 45)
	public String getPhonenum() {
		return this.phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	@Column(name = "address", length = 45)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "staff")
	public Set<Proofread> getProofreads() {
		return this.proofreads;
	}

	public void setProofreads(Set<Proofread> proofreads) {
		this.proofreads = proofreads;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "staff")
	public Set<Audit> getAudits() {
		return this.audits;
	}

	public void setAudits(Set<Audit> audits) {
		this.audits = audits;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "staff")
	public Set<Arrange> getArranges() {
		return this.arranges;
	}

	public void setArranges(Set<Arrange> arranges) {
		this.arranges = arranges;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "staff")
	public Set<Compose> getComposes() {
		return this.composes;
	}

	public void setComposes(Set<Compose> composes) {
		this.composes = composes;
	}

}