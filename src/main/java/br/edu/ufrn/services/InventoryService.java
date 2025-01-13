package br.edu.ufrn.services;

import java.util.List;
import br.edu.ufrn.models.Inventory;
import br.edu.ufrn.repository.InventoryDao;

public class InventoryService {

    private InventoryDao inventoryDao;

    public InventoryService() {
        this.inventoryDao = new InventoryDao();
    }

    public Inventory getInventoryById(Long id) {
        return inventoryDao.findById(id);
    }

    public List<Inventory> getAll() {
        return inventoryDao.findAll();
    }

    public boolean save(Inventory inventory) {
        return inventoryDao.save(inventory);
    }

    public boolean update(Inventory inventory, String[] params) {
        return inventoryDao.update(inventory, params);
    }

    public boolean delete(Long id) {
        return inventoryDao.delete(id);
    }
}