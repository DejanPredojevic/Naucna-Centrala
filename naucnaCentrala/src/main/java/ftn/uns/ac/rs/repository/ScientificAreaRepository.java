package ftn.uns.ac.rs.repository;

import org.springframework.stereotype.Repository;

import ftn.uns.ac.rs.model.ScientificArea;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ScientificAreaRepository extends JpaRepository<ScientificArea, Long> {

}
