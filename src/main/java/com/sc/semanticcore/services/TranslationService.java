package com.sc.semanticcore.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.semanticcore.model.TranslationEntry;
import com.sc.semanticcore.repository.TranslationRepository;

@Service
public class TranslationService {

	@Autowired
	TranslationRepository translationRepository;
	
	
	public List<TranslationEntry> findByLanguageAndClusterLabels(String language, String clusterLabel) {
		return translationRepository.findByLanguageAndClusterLabels(language, clusterLabel);
	}
	
	public List<TranslationEntry> getClusterByKeyword(String language, String keyword) {
		List<String> cluster = translationRepository.findClusterByKeyword(language, keyword);
		for(String entry: cluster) {
			if(!entry.equals("-1")) {
				return translationRepository.findByLanguageAndClusterLabels(language, entry);
			}
		}
		return new ArrayList<TranslationEntry>();
	}
	
}
