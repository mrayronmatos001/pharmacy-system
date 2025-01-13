package br.edu.ufrn.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufrn.models.Inventory;
import br.edu.ufrn.models.Supplier;
import br.edu.ufrn.models.Medication;

public class InventoryDao implements Dao<Inventory> {

    @Override
    public Inventory findById(Long id) {
        Inventory inventory = null;
        String sql = "SELECT * FROM inventory WHERE id = ?";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id.intValue());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                inventory = new Inventory();
                inventory.setId(resultSet.getLong("id"));
                inventory.setQty(resultSet.getInt("qty"));
                inventory.setPrice(resultSet.getDouble("price"));

                Long supplierId = resultSet.getLong("supplier_id");
                SupplierDao supplierDao = new SupplierDao();
                Supplier supplier = supplierDao.findById(supplierId);
                inventory.setSupplier(supplier);

                Long medicationId = resultSet.getLong("medication_id");
                MedicationDao medicationDao = new MedicationDao();
                Medication medication = medicationDao.findById(medicationId);
                inventory.setMedication(medication);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return inventory;
    }

     @Override
    public List<Inventory> findAll() {
        List<Inventory> inventories = new ArrayList<>();
        String sql = "SELECT * FROM inventory";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Inventory inventory = new Inventory();
                inventory.setId(resultSet.getLong("id"));
                inventory.setQty(resultSet.getInt("qty"));
                inventory.setPrice(resultSet.getDouble("price"));

                Long supplierId = resultSet.getLong("supplier_id");
                SupplierDao supplierDao = new SupplierDao();
                Supplier supplier = supplierDao.findById(supplierId);
                inventory.setSupplier(supplier);

                Long medicationId = resultSet.getLong("medication_id");
                MedicationDao medicationDao = new MedicationDao();
                Medication medication = medicationDao.findById(medicationId);
                inventory.setMedication(medication);
                inventories.add(inventory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return inventories;
    }

    @Override
    public boolean save(Inventory inventory) {
        String sql = "INSERT INTO inventory (qty, price, supplier_id, medication_id) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, inventory.getQty());
            preparedStatement.setDouble(2, inventory.getPrice());
            preparedStatement.setLong(3, inventory.getSupplier().getId());
            preparedStatement.setLong(4, inventory.getMedication().getId());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean update(Inventory inventory, String[] params) {
        String sql = "UPDATE inventory SET qty = ?, price = ?, supplier_id = ?, medication_id = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        boolean isUpdated = false;

        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, inventory.getQty());
            preparedStatement.setDouble(2, inventory.getPrice());
            preparedStatement.setLong(3, inventory.getSupplier().getId());
            preparedStatement.setLong(4, inventory.getMedication().getId());

            isUpdated = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return isUpdated;
    }


    @Override
    public boolean delete(Long id) {
        String sql = "DELETE FROM inventory WHERE id = ?";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        boolean isDeleted = false;

        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            isDeleted = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return isDeleted;
    }

}

