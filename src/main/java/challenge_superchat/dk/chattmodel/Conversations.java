package challenge_superchat.dk.chattmodel;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Conversations")
public class Conversations {
	
	@Id
	@Column(name = "idConv")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idConv;	
	
	@Column(name = "msgid")
	private String idMessage;
	
	@Column(name = "senderid")
	private String idSender;
	
	@Column(name = "recieverid")
	private String idReciepnt;

	@OneToMany(fetch = FetchType.LAZY,mappedBy="Conversations")
    private Set<Message> messagesList;
	
	public long getId() {
		return idConv;
	}

	public void setId(long id) {
		this.idConv = id;
	}

	public String getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(String idMessage) {
		this.idMessage = idMessage;
	}

	public String getIdSender() {
		return idSender;
	}

	public void setIdSender(String idSender) {
		this.idSender = idSender;
	}

	public String getIdReciepnt() {
		return idReciepnt;
	}

	public void setIdReciepnt(String idReciepnt) {
		this.idReciepnt = idReciepnt;
	}

	public Set<Message> getMessages() {
		return messagesList;
	}

	public void setMessages(Set<Message> messages) {
		this.messagesList = messages;
	}


	
}
