package ftn.uns.ac.rs.model;

import java.io.Serializable;
import java.sql.Blob;

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
public class ArticleData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private MagazineData magazine;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private UserData autor;
	
	@Column(nullable=false,length=100)
	private String procesID;
	
	@Column
	private String naziv;
	
	@Column
	private String pojmovi;
	
	@Column
	private String oblast;
	
	@Column
	private Blob pdf;
	
	@Column
	private String apstrakt;
	
	@Column
	private Boolean pregled;
	
	@Column
	private Boolean tematika;
	
	@Column
	private Boolean tematikaOdbijen;
	
	@Column
	private Boolean tehnickiOdbijen;
	

	@Column
	private Boolean formatiranje;
	
	@Column
	private Boolean ispravkaPDF;
	
	@Column
	private String komentar;
	
	@Column
	private String urednikOblasti;
	
	@Column
	private Boolean urednikIzbor;
	
	@Column
	private Long vremeCekanjaNaIspravku;
	
	@Column
	private String recenzenti;
	
	@Column
	private Boolean recenzentiPregled;
	
	@Column
	private String komentarR;
	
	@Column
	private String preporuka;
	
	@Column
	private Boolean urednikPregledaRecenziju;
	
	@Column
	private Boolean odobren;
	
	@Column
	private Boolean odbijen;
}
