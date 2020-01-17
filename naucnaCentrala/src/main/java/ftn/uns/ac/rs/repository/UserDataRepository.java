package ftn.uns.ac.rs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.ac.rs.model.UserData;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {
	List<UserData> findByUsername(String username);
}
