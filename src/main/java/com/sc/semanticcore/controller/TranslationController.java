package com.sc.semanticcore.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sc.semanticcore.model.TranslationEntry;
import com.sc.semanticcore.repository.TranslationRepository;
import com.sc.semanticcore.services.TranslationService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TranslationController {

	@Autowired
	TranslationService translationService;

	@GetMapping("/translations/{language}/{clusterLabel}")
	public ResponseEntity<List<TranslationEntry>> getEntriesByLanguageAndCluster(
			@PathVariable("language") String language, @PathVariable("clusterLabel") String clusterLabel) {
			List<TranslationEntry> translations = translationService.findByLanguageAndClusterLabels(language, clusterLabel);
			if(translations.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<List<TranslationEntry>>(translations, HttpStatus.OK);
			}
	}

	@GetMapping("/translations/{language}")
	public ResponseEntity<List<TranslationEntry>> getClusterByKeyword(
			@PathVariable("language") String language, @RequestParam(required = false) String keyword) {
			List<TranslationEntry> cluster = translationService.getClusterByKeyword(language, keyword);
			if(cluster.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<List<TranslationEntry>>(cluster, HttpStatus.OK);
			}
	}

	

	
}
