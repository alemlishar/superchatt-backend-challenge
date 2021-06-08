package challenge_superchat.dk.chattmodel;
import javax.persistence.*;

@Entity
@Table(name = "Contacts")
public class User {

	
	@Id
	@Column(name = "idUser")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idUser;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	
	public long getId() {
		return idUser;
	}

	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}
		
	public void setId(long id) {
		this.idUser = id;
	}

}
