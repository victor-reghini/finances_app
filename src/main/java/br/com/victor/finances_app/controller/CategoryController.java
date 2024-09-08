package br.com.victor.finances_app.controller;

import br.com.victor.finances_app.dto.CategoryDTO;
import br.com.victor.finances_app.entity.Category;
import br.com.victor.finances_app.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    CategoryDTO create(@RequestBody @Valid Category category){
        return new CategoryDTO().fromCategory(categoryService.create(category));
    }

    @PutMapping
    CategoryDTO update(@RequestBody @Valid Category category){
        return new CategoryDTO().fromCategory(categoryService.update(category));
    }

    @GetMapping(path = "/list")
    List<CategoryDTO> getAll(@RequestParam Long userId){
        return categoryService.getAll(userId).stream().map(category -> new CategoryDTO().fromCategory(category)).toList();
    }

    @GetMapping(path = "/{id}")
    Optional<CategoryDTO> getUser(@PathVariable Long id){
        return Optional.ofNullable(new CategoryDTO().fromCategory(categoryService.getById(id).get()));
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable Long id){
        categoryService.delete(id);
    }
}
