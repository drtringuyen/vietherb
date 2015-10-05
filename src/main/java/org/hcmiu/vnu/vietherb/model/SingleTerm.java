package org.hcmiu.vnu.vietherb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SingleTerm {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="NAME_ID")
	private int id;

	@Column (name="CONTENT")
	private String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isEnglish() {
		return isEnglish;
	}

	public void setEnglish(boolean isEnglish) {
		this.isEnglish = isEnglish;
	}

	private boolean isEnglish;

	public SingleTerm(String content, boolean isEnglish) {
		this.content = content;
		this.isEnglish = isEnglish;
	}

	public SingleTerm() {

	}

}
