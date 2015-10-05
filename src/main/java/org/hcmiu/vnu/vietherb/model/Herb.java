package org.hcmiu.vnu.vietherb.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "HERB")
@XmlRootElement
public class Herb {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "HERB_ID")
	@XmlElement
	private int id;

	@Column(name = "SCIENTIFIC_NAME")
	private String scientificName;
	
	@OneToMany (cascade=CascadeType.ALL)
	@JoinTable(joinColumns=@JoinColumn(name="HERB_ID"),
				inverseJoinColumns=@JoinColumn(name="NAME_ID"))
	@XmlElement
	Collection<SingleTerm> trivalNames = new ArrayList<SingleTerm>();

	public Herb(String scientificName) {
		this.scientificName=scientificName;
	}

	public Herb() {
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

	public void setTrivalName(SingleTerm name) {
		this.trivalNames.add(name);
	}

	public Collection<SingleTerm> getTrivalNames() {
		return trivalNames;
	}

}