package br.edu.ufrn.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufrn.models.Client;

public class ClientDao implements Dao<Client> {

    @Override
    public Client findById(Long id) {
        Client client = null;
        String sql = "SELECT * FROM client WHERE id = ?";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id.intValue());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                client = new Client();
                client.setId(resultSet.getLong("id"));
                client.setName(resultSet.getString("name"));
                client.setCpf(resultSet.getString("cpf"));
                client.setTelphone(resultSet.getString("telephone"));
                client.setAddress(resultSet.getString("address"));
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

        return client;
    }

     @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM client";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getLong("id"));
                client.setName(resultSet.getString("name"));
                client.setCpf(resultSet.getString("cpf"));
                client.setTelphone(resultSet.getString("telephone"));
                client.setAddress(resultSet.getString("address"));
                clients.add(client);
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

        return clients;
    }

    @Override
    public boolean save(Client client) {
        String sql = "INSERT INTO client (name, cpf, telephone, address) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getCpf());
            preparedStatement.setString(3, client.getTelphone());
            preparedStatement.setString(4, client.getAddress());
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
    public boolean update(Client client, String[] params) {
        String sql = "UPDATE client SET name = ?, cpf = ?, telephone = ?, address = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        boolean isUpdated = false;

        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, params[0]);
            preparedStatement.setString(2, client.getCpf());
            preparedStatement.setString(3, client.getTelphone());
            preparedStatement.setString(4, client.getAddress());
            preparedStatement.setLong(5, client.getId());

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
        String sql = "DELETE FROM client WHERE id = ?";
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


