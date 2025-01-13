package br.edu.ufrn.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufrn.models.Manufacturer;
import br.edu.ufrn.models.Medication;

public class MedicationDao implements Dao<Medication> {
    @Override
    public Medication findById(Long id) {
        Medication medication = null;
        String sql = "select * from medication where id = ?";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet= null;

        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id.intValue());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                medication = new Medication();
                medication.setId(resultSet.getLong("id"));
                medication.setName(resultSet.getString("name"));
                medication.setPrice(resultSet.getDouble("price"));
                medication.setExpirationDate(resultSet.getDate("expiration_date"));
                
                Long manufacturerId = resultSet.getLong("manufacturer_id");
                ManufacturerDao manufacturerDao = new ManufacturerDao();
                Manufacturer manufacturer = manufacturerDao.findById(manufacturerId);
                medication.setManufacturer(manufacturer);
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
        return medication;
    }

    @Override
    public List<Medication> findAll() {

        List<Medication> medications = new ArrayList<Medication>();
        String sql = "select * from medication"; 
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet= null;

        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Medication medication = new Medication();
                medication.setId(resultSet.getLong("id"));
                medication.setName(resultSet.getString("name"));
                medication.setPrice(resultSet.getDouble("price"));
                medication.setExpirationDate(resultSet.getDate("expiration_date"));
                
                Long manufacturerId = resultSet.getLong("manufacturer_id");
                ManufacturerDao manufacturerDao = new ManufacturerDao();
                Manufacturer manufacturer = manufacturerDao.findById(manufacturerId);
                medication.setManufacturer(manufacturer);

                medications.add(medication);
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
        return medications;
    }

    @Override
    public boolean save(Medication medication) {
        String sql = "insert into medication (name, price, expiration_date, manufacturer_id) values (?, ?, ?, ?)"; 
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        
        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, medication.getName());
            preparedStatement.setDouble(2, medication.getPrice());
            preparedStatement.setDate(3, new java.sql.Date(medication.getExpirationDate().getTime()));
            preparedStatement.setLong(4, medication.getManufacturer().getId());
            
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
    public boolean update(Medication medication, String[] params) {
        String sql = "update medication set name = ?, price = ?, expiration_date = ?, manufacturer_id = ? where id = ?"; 
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        
        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, medication.getName());
            preparedStatement.setDouble(2,  medication.getPrice());
            preparedStatement.setDate(3, new java.sql.Date(medication.getExpirationDate().getTime()));
            preparedStatement.setLong(4, medication.getManufacturer().getId());
            preparedStatement.setLong(5, medication.getId());
            
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
        String sql = "delete from medication where id = ?"; 
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
