package ftn.uns.ac.rs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.ac.rs.model.MagazineData;

@Repository
public interface MagazineDataRepository extends JpaRepository<MagazineData, Long>  {
	MagazineData findByProcesID(String procesID);

}
