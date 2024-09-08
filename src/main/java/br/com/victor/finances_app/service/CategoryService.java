package br.com.victor.finances_app.service;

import br.com.victor.finances_app.entity.Category;
import br.com.victor.finances_app.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository expenseGroupRepository){
        this.categoryRepository = expenseGroupRepository;
    }

    public Category create(Category category){
        return categoryRepository.save(category);
    }

    public Category update(Category category){
        return categoryRepository.save(category);
    }

    public List<Category> getAll(Long userId){
        return categoryRepository.getAllCategoriesByUserId(userId);
    }

    public Optional<Category> getById(Long id){
        return categoryRepository.findById(id);
    }

    public void delete(Long id){
        categoryRepository.deleteById(id);
    }
}
