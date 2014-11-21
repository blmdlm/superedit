package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "message", catalog = "mydb")
public class Message implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer sendid;
	private Integer sendstate;
	private Integer recvid;
	private Integer recvstate;
	private String content;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** minimal constructor */
	public Message(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Message(Integer id, Integer sendid, Integer sendstate,
			Integer recvid, Integer recvstate, String content) {
		this.id = id;
		this.sendid = sendid;
		this.sendstate = sendstate;
		this.recvid = recvid;
		this.recvstate = recvstate;
		this.content = content;
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

	@Column(name = "sendid")
	public Integer getSendid() {
		return this.sendid;
	}

	public void setSendid(Integer sendid) {
		this.sendid = sendid;
	}

	@Column(name = "sendstate")
	public Integer getSendstate() {
		return this.sendstate;
	}

	public void setSendstate(Integer sendstate) {
		this.sendstate = sendstate;
	}

	@Column(name = "recvid")
	public Integer getRecvid() {
		return this.recvid;
	}

	public void setRecvid(Integer recvid) {
		this.recvid = recvid;
	}

	@Column(name = "recvstate")
	public Integer getRecvstate() {
		return this.recvstate;
	}

	public void setRecvstate(Integer recvstate) {
		this.recvstate = recvstate;
	}

	@Column(name = "content", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}