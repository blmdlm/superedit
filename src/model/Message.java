package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "message", catalog = "mydb")
public class Message implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer sendid;
	private Integer sendrole;
	private Integer recvid;
	private Integer recvrole;
	private String content;
	private Date time;
	private Integer state;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** minimal constructor */
	public Message(Integer state) {
		this.state = state;
	}

	/** full constructor */
	public Message(Integer sendid, Integer sendrole, Integer recvid,
			Integer recvrole, String content, Date time, Integer state) {
		this.sendid = sendid;
		this.sendrole = sendrole;
		this.recvid = recvid;
		this.recvrole = recvrole;
		this.content = content;
		this.time = time;
		this.state = state;
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

	@Column(name = "sendid")
	public Integer getSendid() {
		return this.sendid;
	}

	public void setSendid(Integer sendid) {
		this.sendid = sendid;
	}

	@Column(name = "sendrole")
	public Integer getSendrole() {
		return this.sendrole;
	}

	public void setSendrole(Integer sendrole) {
		this.sendrole = sendrole;
	}

	@Column(name = "recvid")
	public Integer getRecvid() {
		return this.recvid;
	}

	public void setRecvid(Integer recvid) {
		this.recvid = recvid;
	}

	@Column(name = "recvrole")
	public Integer getRecvrole() {
		return this.recvrole;
	}

	public void setRecvrole(Integer recvrole) {
		this.recvrole = recvrole;
	}

	@Column(name = "content", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "time", length = 10)
	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name = "state", nullable = false)
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}