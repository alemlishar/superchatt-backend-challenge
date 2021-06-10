package challenge_superchat.dk.chattmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Conversations")
public class Conversations {
	
	
	public Conversations () { }
	
	@Id
	@Column(name = "idc")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idc;	
	
	@Column(name = "senderid")
	private long idSender;
	
	@Column(name = "recieverid")
	private long idReciepnt;

	
	
	public long getId() {
		return idc;
	}

	public void setId(long id) {
		this.idc = id;
	}

	public long getIdSender() {
		return idSender;
	}

	public void setIdSender(long idSender) {
		this.idSender = idSender;
	}

	public long getIdReciepnt() {
		return idReciepnt;
	}

	public void setIdReciepnt(long idReciepnt) {
		this.idReciepnt = idReciepnt;
	}

	
	
}
