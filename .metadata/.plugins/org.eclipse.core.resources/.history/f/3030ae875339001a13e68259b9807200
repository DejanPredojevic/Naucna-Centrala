package ftn.uns.ac.rs.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class UserData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(nullable=false,length=100)
	private String ime;
	
	@Column(nullable=false,length=100)
	private String prezime;
	
	@Column(nullable=false,length=100)
	private String grad;
	
	@Column(nullable=false,length=100)
	private String titula;
	
	@Column(nullable=false,length=100)
	private String email;
	
	@Column(nullable=false,length=100)
	private Boolean recenzent;
	
	@Column(nullable=false,length=100)
	private Boolean odobrenRecenzent;
	
	@Column(nullable=false,length=100)
	private String username;
	
	@Column(nullable=false,length=100)
	private String password;
	
	@Column(nullable=false,length=100)
	private String scientificArea;

}
