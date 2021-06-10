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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "messages")
public class Message {

	
	
	public Message(Message context) {
        this.id = context.getIdMsg();
        this.messageBody = context.getMessageBody();
        this.Conversations = context.getConversations();
        this.idReciepnt = context.getIdReciepnt();
        this.idSender = context.getIdSender();
        
    }
	public Message(long id, String msgBody,  Conversations conversation) {
        this.id = id;
        
        this.messageBody = msgBody;
        this.Conversations = conversation;
        
    }
	
	public Message() { }
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "message")
	private String messageBody;
	
	
	@Column(name = "senderid")
	private long idSender;
	
	@Column(name = "recieverid")
	private long idReciepnt;
	
    @OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Conversations.class)     
	@JoinColumn(name = "idc")
    Conversations Conversations;

	public long getIdMsg() {
		return id;
	}
	public void setIdMsg(long idMsg) {
		this.id = idMsg;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
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
	public Conversations getConversations() {
		return Conversations;
	}
	public void setConversations(Conversations conversations) {
		Conversations = conversations;
	}

	
	
	
	
}
