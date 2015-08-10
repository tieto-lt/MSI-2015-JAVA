package lt.msi2015.applicationSettings;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lt.msi2015.util.Dto;

@Entity
public class ApplicationSettings extends Dto {

	/**
	 * 
	 */
	@Id
	@NotNull
	private String property;
	
	@NotNull
	private Integer value;

	
	/*
	 * For mapping JSON -> Java
	 */
	public ApplicationSettings() {
		
	}

	public ApplicationSettings(String property, Integer value) {
		this.property = property;
		this.value = value;
	}

	
	/*
	 * Getters and setters
	 */
	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}