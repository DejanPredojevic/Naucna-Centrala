package ftn.uns.ac.rs.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Clanarina {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(nullable=false,length=100)
	private String naziv;
	
	@Column(nullable=false,length=100)
	private Boolean urednik;
	
	@Column
	protected Date datumDo;
	
	@Column
	private int cena;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private UserData korisnik;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private MagazineData magazine;

}