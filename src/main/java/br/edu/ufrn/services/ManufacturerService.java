package br.edu.ufrn.services;

import java.util.List;
import br.edu.ufrn.models.Manufacturer;
import br.edu.ufrn.repository.ManufacturerDao;

public class ManufacturerService {

    private ManufacturerDao manufacturerDao;

    public ManufacturerService() {
        this.manufacturerDao = new ManufacturerDao();
    }

    public Manufacturer getManufactureById(Long id) {
        return manufacturerDao.findById(id);
    }

    public List<Manufacturer> getAll() {
        return manufacturerDao.findAll();
    }

    public boolean save(Manufacturer manufacturer) {
        return manufacturerDao.save(manufacturer);
    }

    public boolean update(Manufacturer manufacturer, String[] params) {
        return manufacturerDao.update(manufacturer, params);
    }

    public boolean delete(Long id) {
        return manufacturerDao.delete(id);
    }
}

