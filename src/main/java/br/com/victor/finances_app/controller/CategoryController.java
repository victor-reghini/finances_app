package br.com.victor.finances_app.controller;

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
    Category create(@RequestBody @Valid Category category){
        return categoryService.create(category);
    }

    @PutMapping
    Category update(@RequestBody @Valid Category category){
        return categoryService.update(category);
    }

    @GetMapping(path = "/list")
    List<Category> getAll(){
        return categoryService.getAll();
    }

    @GetMapping(path = "/{id}")
    Optional<Category> getUser(@PathVariable Long id){
        return categoryService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable Long id){
        categoryService.delete(id);
    }
}
