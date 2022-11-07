package com.sc.semanticcore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sc.semanticcore.model.TranslationEntry;

@Repository
public interface TranslationRepository extends JpaRepository<TranslationEntry, Long>{
	
	@Query("SELECT t FROM TranslationEntry t WHERE t.language = :language and t.clusterLabels = :clusterLabel")
	List<TranslationEntry> findByLanguageAndClusterLabels(@Param("language") String language,
														  @Param("clusterLabel") String clusterLabels);
	
	@Query("SELECT t.clusterLabels FROM TranslationEntry t WHERE t.language = :language and t.translated = :translated")
	List<String> findClusterByKeyword(@Param("language") String language,
								@Param("translated") String keyWord);
	
	
	
	List<TranslationEntry> findAll();
	Optional<TranslationEntry> findById(Long id);
}
