package org.hcmiu.vnu.vietherb.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Entity (name = "HERB")
@XmlRootElement
public class Herb {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name= "ID")
	@XmlElement 
	private int id;
	
	@Column (name= "SCIENTIFIC_NAME")
	private String scientificName;

	@Embedded 
	private SingleTerm name;
	
//	public Herb(int id, String name) {
//		this.id = id;
//		this.scientificName = name;
//
//	}
	
	public Herb() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

}