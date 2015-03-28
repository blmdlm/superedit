package model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Publisher entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "publisher", catalog = "mydb")
public class Publisher implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set<Magazine> magazines = new HashSet<Magazine>(0);
	private Set<Staff> staffs = new HashSet<Staff>(0);

	// Constructors

	/** default constructor */
	public Publisher() {
	}

	/** minimal constructor */
	public Publisher(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Publisher(Integer id, String name, Set<Magazine> magazines,
			Set<Staff> staffs) {
		this.id = id;
		this.name = name;
		this.magazines = magazines;
		this.staffs = staffs;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "publisher")
	public Set<Magazine> getMagazines() {
		return this.magazines;
	}

	public void setMagazines(Set<Magazine> magazines) {
		this.magazines = magazines;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "publisher")
	public Set<Staff> getStaffs() {
		return this.staffs;
	}

	public void setStaffs(Set<Staff> staffs) {
		this.staffs = staffs;
	}

}