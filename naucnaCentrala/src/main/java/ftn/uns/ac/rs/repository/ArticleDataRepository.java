package ftn.uns.ac.rs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.uns.ac.rs.model.ArticleData;

public interface ArticleDataRepository extends JpaRepository<ArticleData, Long>{
	ArticleData findByProcesID(String procesID);
	List<ArticleData> findByPregled(Boolean pregled);
	List<ArticleData> findByIspravkaPDF(Boolean pregled);
	List<ArticleData> findByRecenzentiPregled(Boolean pregled);
	List<ArticleData> findByUrednikPregledaRecenziju(Boolean urednikPregledaRecenziju);
	
	List<ArticleData> findByUrednikOblastiAndUrednikIzbor(String urednik,Boolean urednikIzbor);
}
