package ftn.uns.ac.rs.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class MagazineData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(nullable=false,length=100)
	private String naziv;
	
	@Column(nullable=false,length=100)
	private Long isdn;
	
	@Column(nullable=false,length=100)
	private String naucneOblasti;
	
	@Column(nullable=false,length=100)
	private String glavniUrednik;
	
	@Column(nullable=false,length=100)
	private Boolean aktivnost;
	
	@Column(nullable=false,length=100)
	private String procesID;
	
	@Column(nullable=false)
	private Boolean openAccess;
	
	@Column
	private String recenzenti;
	
	@Column
	private String urednici;
	
	@Column
	private String komentar;
	
	@Column
	private Boolean proveraPodataka;
	
	@Column
	private Boolean publishMagazina;
	
	
	
}
