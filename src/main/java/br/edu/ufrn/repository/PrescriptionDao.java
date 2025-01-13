package br.edu.ufrn.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufrn.models.Prescription;

public class PrescriptionDao implements Dao<Prescription> {

    @Override
    public Prescription findById(Long id) {
        Prescription prescription = null;
        String sql = "SELECT * FROM prescription WHERE id = ?";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id.intValue());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                prescription = new Prescription();
                prescription.setId(resultSet.getLong("id"));
                prescription.setDoctorName(resultSet.getString("doctor_name"));
                prescription.setExpirationDate(resultSet.getDate("expiration_date"));
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

        return prescription;
    }

     @Override
    public List<Prescription> findAll() {
        List<Prescription> prescriptions = new ArrayList<>();
        String sql = "SELECT * FROM prescription";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Prescription prescription = new Prescription();
                prescription.setId(resultSet.getLong("id"));
                prescription.setDoctorName(resultSet.getString("doctor_name"));
                prescription.setExpirationDate(resultSet.getDate("expiration_date"));
                prescriptions.add(prescription);
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

        return prescriptions;
    }

    @Override
    public boolean save(Prescription prescription) {
        String sql = "INSERT INTO prescription (doctor_name, expiration_date) VALUES (?, ?)";
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, prescription.getDoctorName());
            preparedStatement.setDate(2, new java.sql.Date(prescription.getExpirationDate().getTime()));
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
    public boolean update(Prescription prescription, String[] params) {
        String sql = "UPDATE prescription SET doctor_name = ?, expiration_date = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        boolean isUpdated = false;

        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, params[0]);
            preparedStatement.setDate(2, new java.sql.Date(prescription.getExpirationDate().getTime()));
            preparedStatement.setLong(3, prescription.getId());

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
        String sql = "DELETE FROM prescription WHERE id = ?";
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

