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
 * Magazine entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "magazine", catalog = "mydb")
public class Magazine implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set<Script> scripts = new HashSet<Script>(0);

	// Constructors

	/** default constructor */
	public Magazine() {
	}

	/** minimal constructor */
	public Magazine(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Magazine(Integer id, String name, Set<Script> scripts) {
		this.id = id;
		this.name = name;
		this.scripts = scripts;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "magazine")
	public Set<Script> getScripts() {
		return this.scripts;
	}

	public void setScripts(Set<Script> scripts) {
		this.scripts = scripts;
	}

}