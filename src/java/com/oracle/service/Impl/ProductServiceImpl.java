package com.oracle.service.Impl;

import com.oracle.dao.ProductDao;
import com.oracle.domain.Product;
import com.oracle.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        List<Product> products=productDao.findAll();
        return products;
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }

    @Override
    public void delete(int id) {
        productDao.delete(id);
    }
}
