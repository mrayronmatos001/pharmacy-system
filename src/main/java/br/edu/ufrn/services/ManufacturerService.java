package br.edu.ufrn.services;

import java.util.ArrayList;
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

    public Manufacturer getManufacturerByName(String name) {
        List<Manufacturer> manufacturers = manufacturerDao.findAll();
        Manufacturer manufacturer = null;
        for (Manufacturer manuf : manufacturers) {
            if (name.equals(manuf.getName())) {
                manufacturer = manuf;
                break;
            }
        }
        return manufacturer;
    }

    public List<Manufacturer> getAll() {
        return manufacturerDao.findAll();
    }

    public List<String> getAllNames() {
        List<Manufacturer> manufacturers = manufacturerDao.findAll();
        List<String> manufacturerNames = new ArrayList<>();
        for (Manufacturer manufacturer : manufacturers) {
            manufacturerNames.add(manufacturer.getName());
        }
        return manufacturerNames;
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

