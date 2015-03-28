package model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private Publisher publisher;
	private String name;
	private Set<Script> scripts = new HashSet<Script>(0);

	// Constructors

	/** default constructor */
	public Magazine() {
	}

	/** minimal constructor */
	public Magazine(Integer id, Publisher publisher) {
		this.id = id;
		this.publisher = publisher;
	}

	/** full constructor */
	public Magazine(Integer id, Publisher publisher, String name,
			Set<Script> scripts) {
		this.id = id;
		this.publisher = publisher;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Publisher_id", nullable = false)
	public Publisher getPublisher() {
		return this.publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "magazine")
	public Set<Script> getScripts() {
		return this.scripts;
	}

	public void setScripts(Set<Script> scripts) {
		this.scripts = scripts;
	}

}