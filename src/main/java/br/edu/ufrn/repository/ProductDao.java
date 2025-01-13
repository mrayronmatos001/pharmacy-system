package br.edu.ufrn.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufrn.models.Product;
import br.edu.ufrn.models.Medication;
import br.edu.ufrn.models.Prescription;
import br.edu.ufrn.models.Sale;
import br.edu.ufrn.models.Inventory;

public class ProductDao implements Dao<Product> {

    @Override
    public Product findById(Long id) {
        Product product = null;
        String sql = "select * from product where id = ?";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet= null;

        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id.intValue());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                product = new Product(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getInt("bottle_qty"), resultSet.getString("unit"), resultSet.getDouble("unit_value"), resultSet.getDouble("price"), 0);
                
                Long medicationId = resultSet.getLong("medication_id");
                MedicationDao medicationDao = new MedicationDao();
                Medication medication = medicationDao.findById(medicationId);
                product.setMedication(medication);

                Long prescriptionId = resultSet.getLong("prescription_id");
                PrescriptionDao prescritionDao = new PrescriptionDao();
                Prescription prescription = prescritionDao.findById(prescriptionId);
                product.setPrescription(prescription);

                Long saleId = resultSet.getLong("sale_id");
                SaleDao saleDao = new SaleDao();
                Sale sale = saleDao.findById(saleId);
                product.setSale(sale);

                Long inventoryId = resultSet.getLong("inventory_id");
                InventoryDao inventoryDao = new InventoryDao();
                Inventory inventory = inventoryDao.findById(inventoryId);
                product.setInventory(inventory);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return product;
    }

    @Override
    public List<Product> findAll() {

        List<Product> products = new ArrayList<Product>();
        String sql = "select * from product";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet= null;

        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Product product = new Product(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getInt("bottle_qty"), resultSet.getString("unit"), resultSet.getDouble("unit_value"), resultSet.getDouble("price"), 0);
                
                Long medicationId = resultSet.getLong("medication_id");
                MedicationDao medicationDao = new MedicationDao();
                Medication medication = medicationDao.findById(medicationId);
                product.setMedication(medication);

                Long prescriptionId = resultSet.getLong("prescription_id");
                PrescriptionDao prescritionDao = new PrescriptionDao();
                Prescription prescription = prescritionDao.findById(prescriptionId);
                product.setPrescription(prescription);

                Long saleId = resultSet.getLong("sale_id");
                SaleDao saleDao = new SaleDao();
                Sale sale = saleDao.findById(saleId);
                product.setSale(sale);

                Long inventoryId = resultSet.getLong("inventory_id");
                InventoryDao inventoryDao = new InventoryDao();
                Inventory inventory = inventoryDao.findById(inventoryId);
                product.setInventory(inventory);

                products.add(product);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return products;
    }

    @Override
    public boolean save(Product product) {
        String sql = "insert into product (name, bottle_qty, unit, unit_value, price, medication_id, prescription_id, sale_id, inventory_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        
        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getBottleQty());
            preparedStatement.setString(3, product.getUnit());
            preparedStatement.setDouble(4, product.getUnitValue());
            preparedStatement.setDouble(5, product.getPrice());
            preparedStatement.setLong(6, product.getMedication().getId());
            preparedStatement.setLong(7, product.getPrescription().getId());
            preparedStatement.setLong(8, product.getSale().getId());
            preparedStatement.setLong(9, product.getInventory().getId());
            
            preparedStatement.execute();
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
                return true;
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean update(Product product, String[] params) {
        String sql = "update product set name = ?, bottle_qty = ?, unit = ?, unit_value = ?, price = ?, medication_id = ?, prescription_id = ?, sale_id = ?, inventory_id = ? where id = ?"; 
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        
        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getBottleQty());
            preparedStatement.setString(3, product.getUnit());
            preparedStatement.setDouble(4, product.getUnitValue());
            preparedStatement.setDouble(5, product.getPrice());
            preparedStatement.setLong(6, product.getMedication().getId());
            preparedStatement.setLong(7, product.getPrescription().getId());
            preparedStatement.setLong(8, product.getSale().getId());
            preparedStatement.setLong(9, product.getInventory().getId());
            preparedStatement.setLong(10, product.getId());
            
            preparedStatement.execute();
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
                return true;
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        String sql = "delete product sale where id = ?"; 
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        
        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
                return true;
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}


