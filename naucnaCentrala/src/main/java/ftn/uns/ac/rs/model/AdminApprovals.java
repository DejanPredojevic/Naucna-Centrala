package ftn.uns.ac.rs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class AdminApprovals {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(nullable=false,length=100)
	private String procesID;
	
	@Column(nullable=false,length=100)
	private String username;
	
	@Column(nullable=false,length=100)
	private String status;
}