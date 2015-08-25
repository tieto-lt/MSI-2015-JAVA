package lt.msi2015.category;

import lt.msi2015.util.Dto;

public class CategoryDto extends Dto {
	public Long id;
	public String name;
	public Boolean enabled;
	
	public CategoryDto() {
		
	}
	
	public CategoryDto(Long id, String name, Boolean enabled) {
		this.id = id;
		this.name = name;
		this.enabled = enabled;
	}	
	
	
}
