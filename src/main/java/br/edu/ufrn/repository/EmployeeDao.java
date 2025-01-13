package br.edu.ufrn.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufrn.models.Employee;

public class EmployeeDao implements Dao<Employee> {

    @Override
    public Employee findById(Long id) {
        Employee employee = null;
        String sql = "SELECT * FROM employee WHERE id = ?";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id.intValue());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setName(resultSet.getString("name"));
                employee.setCpf(resultSet.getString("cpf"));
                employee.setTelephone(resultSet.getString("telephone"));
                employee.setAddress(resultSet.getString("address"));
                employee.setRole(resultSet.getString("role"));
                employee.setUsername(resultSet.getString("username"));
                employee.setPassword(resultSet.getString("password"));
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

        return employee;
    }

     @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setName(resultSet.getString("name"));
                employee.setCpf(resultSet.getString("cpf"));
                employee.setTelephone(resultSet.getString("telephone"));
                employee.setAddress(resultSet.getString("address"));
                employee.setRole(resultSet.getString("role"));
                employee.setUsername(resultSet.getString("username"));
                employee.setPassword(resultSet.getString("password"));
                employees.add(employee);
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

        return employees;
    }

    @Override
    public boolean save(Employee employee) {
        String sql = "INSERT INTO employee (name, cpf, telephone, address, role, username, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getCpf());
            preparedStatement.setString(3, employee.getTelephone());
            preparedStatement.setString(4, employee.getAddress());
            preparedStatement.setString(5, employee.getRole());
            preparedStatement.setString(6, employee.getUsername());
            preparedStatement.setString(7, employee.getPassword());

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
    public boolean update(Employee employee, String[] params) {
        String sql = "UPDATE employee SET name = ?, cpf = ?, telephone = ?, address = ?, role = ?, username = ?, password = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        boolean isUpdated = false;

        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getCpf());
            preparedStatement.setString(3, employee.getTelephone());
            preparedStatement.setString(4, employee.getAddress());
            preparedStatement.setString(5, employee.getRole());
            preparedStatement.setString(6, employee.getUsername());
            preparedStatement.setString(7, employee.getPassword());
            preparedStatement.setLong(8, employee.getId());

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
        String sql = "DELETE FROM employee WHERE id = ?";
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



