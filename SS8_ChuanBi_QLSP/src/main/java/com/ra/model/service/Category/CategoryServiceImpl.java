package com.ra.model.service.Category;

import com.ra.model.dao.Category.CategoryDAO;
import com.ra.model.dao.Category.CategoryDAOImpl;

import com.ra.model.entity.Category;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryDAO categoryDao = new CategoryDAOImpl();

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public boolean saveOrUpdate(Category category, Integer id) {
        return categoryDao.saveOrUpDate(category, id);
    }

    @Override
    public Category findById(Integer integer) {
        return categoryDao.findById(integer);
    }

    @Override
    public void delete(Integer integer) {
        categoryDao.delete(integer);
    }

    @Override
    public int getNewId() {
        return 0;
    }

    @Override
    public List<Category> finByName(String name) {
        return null;
    }
}
