package com.sc.semanticcore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="translation_data")
public class TranslationEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long index;
	
	private String label;
	
	private String translated;
	
	private String nounClass;
	
	private String clusterLabels;
	
	private String language;
}
