package lt.msi2015.category;

import lt.msi2015.util.Dto;

public class NewCategoryDto extends Dto {
	
	public String name;
	
	public NewCategoryDto() {
		
	}

	public NewCategoryDto(String name) {
		super();
		this.name = name;
	}
	
}
