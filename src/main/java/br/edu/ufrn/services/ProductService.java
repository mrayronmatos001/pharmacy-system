package br.edu.ufrn.services;

import java.util.List;

import br.edu.ufrn.models.Product;
import br.edu.ufrn.repository.ProductDao;

public class ProductService {

    private ProductDao productDao;

    public ProductService() {
        this.productDao = new ProductDao();
    }

    public Product getProductById(Long id) {
        return productDao.findById(id);
    }

    public List<Product> getAll() {
        return productDao.findAll();
    }

    public boolean save(Product product) {
        return productDao.save(product);
    }

    public boolean update(Product product, String[] params) {
        return productDao.update(product, params);
    }

    public boolean delete(Long id) {
        return productDao.delete(id);
    }
}

