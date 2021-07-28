package mg.meddoc.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class User{
	@Id
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "users-sequence"
		)
		@SequenceGenerator(
		name = "pharmacie-sequence",
		sequenceName = "seq_users",
		allocationSize = 1,
		initialValue = 2
		)
	@Column(name = "id_users")
	private long idUsers;
	/*
	 * @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utilisateur")
	private long idUtilisateur;
	 */

	//@NotBlank
    //@Size(min=3, max = 50)
	@Column(name = "username")
	private java.lang.String username;
    //@NotBlank
    //@Size(min=3, max = 50)
	@Column(name = "email")
    private String email;
    //@NotBlank
    //@Size(min=3, max = 50)
	@Column(name = "password")
	@JsonIgnoreProperties
    private String password;
    //@NaturalId
    //@NotBlank
    //@Size(max = 50)
    //@Email
	@Column(name = "firstname")
    private String firstname;
    //@NotBlank
    //@Size(min=6, max = 100)
    //private String password;
	@Column(name = "lastname")
    private String lastname;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", 
    	joinColumns = @JoinColumn(name = "user_id"), 
    	inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    
    
    public User() {}
    
	/**
	 * @param idUsers
	 * @param username
	 * @param email
	 * @param password
	 * @param firstname
	 * @param lastname
	 * @param roles
	 */
	public User( String username, String email,  String firstname, String lastname, String password
			) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		//this.roles = roles;
	}

	/**
	 * @return the idUsers
	 */
	public long getIdUsers() {
		return idUsers;
	}

	/**
	 * @param idUsers the idUsers to set
	 */
	public void setIdUsers(long idUsers) {
		this.idUsers = idUsers;
	}

	/**
	 * @return the username
	 */
	public java.lang.String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(java.lang.String username) {
		this.username = username;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}