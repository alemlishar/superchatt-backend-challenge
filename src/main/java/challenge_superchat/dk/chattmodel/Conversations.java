package challenge_superchat.dk.chattmodel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Conversations")
public class Conversations {
	
	
	public Conversations () { }
	
	
	public Conversations(long idc, long idSender, long idReciepnt, List<Message> messages) {
		super();
		this.idc = idc;
		this.idSender = idSender;
		this.idReciepnt = idReciepnt;
		this.messages = messages;
	}


	@Id
	@Column(name = "idc")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idc;	
	
	@Column(name = "senderid")
	private long idSender;
	
	@Column(name = "recieverid")
	private long idReciepnt;

    @OneToMany(mappedBy="conversations")
    private List<Message> messages;

	public long getIdc() {
		return idc;
	}

	public void setIdc(long idc) {
		this.idc = idc;
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

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	
	


	
}
