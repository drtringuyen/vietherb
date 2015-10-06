package org.hcmiu.vnu.vietherb.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Term {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name= "ID")
	private int id;
	
	
	private Herb herb;
	
	@Column (name= "ENGLISH")
	private String english;
	
	@Column (name= "VIETNAMESE")
	private String vietnamese;
	
	public Term(String englishContent, String vietnameseContent) {
		this.english=englishContent;
		this.vietnamese=vietnameseContent;
	}
	
	public Term(){
		
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STOCK_ID", nullable = false)
	public Herb getHerb() {
		return this.herb;
	}

	public int getId() {
		return id;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getVietnamese() {
		return vietnamese;
	}

	public void setVietnamese(String vietnamese) {
		this.vietnamese = vietnamese;
	}
}
