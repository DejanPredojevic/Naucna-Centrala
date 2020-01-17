package ftn.uns.ac.rs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.ac.rs.model.AdminApprovals;

@Repository
public interface AdminRepository extends JpaRepository<AdminApprovals, Long> {
	List<AdminApprovals> findByStatus(String status);
	List<AdminApprovals> findByProcesID(String procesID);
}
