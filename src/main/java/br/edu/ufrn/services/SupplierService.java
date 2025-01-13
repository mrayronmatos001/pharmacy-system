package br.edu.ufrn.services;

import java.util.List;

import br.edu.ufrn.models.Supplier;
import br.edu.ufrn.repository.SupplierDao;

public class SupplierService {

    private SupplierDao supplierDao;

    public SupplierService() {
        this.supplierDao = new SupplierDao();
    }

     public Supplier getSupplierById(Long id) {
        return supplierDao.findById(id);
    }

    public List<Supplier> getAll() {
        return supplierDao.findAll();
    }

    public boolean save(Supplier supplier) {
        return supplierDao.save(supplier);
    }

    public boolean update(Supplier supplier, String[] params) {
        return supplierDao.update(supplier, params);
    }

    public boolean delete(Long id) {
        return supplierDao.delete(id);
    }
}

