package challenge_superchat.dk.chattmodel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idMsg;

	@Column(name = "messageBody")
	private String messageBody;
	
    @JoinColumn(name = "idConv")	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Conversations Conversations;

	public long getId() {
		return idMsg;
	}

	
	public String getMessagetext() {
		return messageBody;
	}

	public void setMessagetext(String messagetext) {
		this.messageBody = messagetext;
	}
	
	
	public Conversations getConversationList() {
		return Conversations;
	}

	public void setConversationList(Conversations conversationList) {
		this.Conversations = conversationList;
	}
	
	
	
}
