package com.ra.model.service;

import com.ra.model.dao.CategoryDAOImpl;
import com.ra.model.dao.CategoryDao;
import com.ra.model.entity.Category;

import javax.swing.*;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryDao categoryDao = new CategoryDAOImpl();

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public boolean saveOrUpdate(Category category, Integer id) {
        return categoryDao.saveOrUpdate(category, id);
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
