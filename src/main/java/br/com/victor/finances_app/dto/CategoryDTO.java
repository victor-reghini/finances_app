package br.com.victor.finances_app.dto;

import br.com.victor.finances_app.entity.Category;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class CategoryDTO implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String categoryType;
    private String user;

    public CategoryDTO fromCategory(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.id = category.getId();
        categoryDTO.name = category.getName();
        categoryDTO.description = category.getDescription();
        categoryDTO.categoryType = category.getCategoryType();
        categoryDTO.user = category.getUser().getName();
        return categoryDTO;
    }
}
