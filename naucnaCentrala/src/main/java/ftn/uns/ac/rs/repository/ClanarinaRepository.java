package ftn.uns.ac.rs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.uns.ac.rs.model.Clanarina;
import ftn.uns.ac.rs.model.MagazineData;
import ftn.uns.ac.rs.model.UserData;

public interface ClanarinaRepository extends JpaRepository<Clanarina, Long>{
	List<Clanarina> findByKorisnikAndMagazine(UserData userData,MagazineData magazineData);
}
