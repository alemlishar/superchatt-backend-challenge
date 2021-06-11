package challenge_superchat.dk.chattmodel;

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

	
	
	public Message(Message context) {
        this.id = context.getId();
        this.messageBody = context.getMessageBody();
        this.conversations = context.getConversations();
        this.idReciepnt = context.getIdReciepnt();
        this.idSender = context.getIdSender();
        
    }
	public Message(String msgBody,  Conversations conversation, long sid, long rid) {
        this.conversations =  conversation;
        this.messageBody = msgBody;
        this.idSender = sid;
        this.idReciepnt = rid;
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
	
   // @OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(fetch = FetchType.LAZY)//, targetEntity = Conversations.class)     
	@JoinColumn(name = "idc")
    private Conversations conversations;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
		return conversations;
	}
	public void setConversations(Conversations conversations) {
		this.conversations = conversations;
	}

	

	
	
	
}
