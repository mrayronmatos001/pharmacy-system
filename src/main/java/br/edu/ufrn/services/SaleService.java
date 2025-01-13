package br.edu.ufrn.services;

import java.util.List;

import br.edu.ufrn.models.Sale;
import br.edu.ufrn.repository.SaleDao;

public class SaleService {

    private SaleDao saleDao;

    public SaleService() {
        this.saleDao = new SaleDao();
    }

    public Sale getSaleById(Long id) {
        return saleDao.findById(id);
    }

    public List<Sale> getAll() {
        return saleDao.findAll();
    }

    public boolean save(Sale sale) {
        return saleDao.save(sale);
    }

    public boolean update(Sale sale, String[] params) {
        return saleDao.update(sale, params);
    }

    public boolean delete(Long id) {
        return saleDao.delete(id);
    }
}

