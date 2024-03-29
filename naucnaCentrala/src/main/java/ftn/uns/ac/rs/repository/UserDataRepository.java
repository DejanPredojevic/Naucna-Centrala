package ftn.uns.ac.rs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.ac.rs.model.UserData;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {
	UserData findByUsername(String username);
	List<UserData> findByRole(String role);
	
}
