package br.edu.ufrn.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufrn.models.Sale;
import br.edu.ufrn.models.Employee;
import br.edu.ufrn.models.Client;

public class SaleDao implements Dao<Sale> {
    @Override
    public Sale findById(Long id) {
        Sale sale = null;
        String sql = "select * from sale where id = ?";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet= null;

        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id.intValue());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                sale = new Sale();
                sale.setId(resultSet.getLong("id"));
                sale.setDate(resultSet.getDate("date"));
                sale.setTotalValue(resultSet.getDouble("total_value"));
                
                Long employeeId = resultSet.getLong("employee_id");
                EmployeeDao employeeDao = new EmployeeDao();
                Employee employee = employeeDao.findById(employeeId);
                sale.setEmployee(employee);

                Long clientId = resultSet.getLong("client_id");
                ClientDao clientDao = new ClientDao();
                Client client = clientDao.findById(clientId);
                sale.setClient(client);
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
        return sale;
    }

    @Override
    public List<Sale> findAll() {

        List<Sale> sales = new ArrayList<Sale>();
        String sql = "select * from sale"; 
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet= null;

        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Sale sale = new Sale();
                sale.setId(resultSet.getLong("id"));
                sale.setDate(resultSet.getDate("date"));
                sale.setTotalValue(resultSet.getDouble("total_value"));
                
                Long employeeId = resultSet.getLong("employee_id");
                EmployeeDao employeeDao = new EmployeeDao();
                Employee employee = employeeDao.findById(employeeId);
                sale.setEmployee(employee);

                Long clientId = resultSet.getLong("client_id");
                ClientDao clientDao = new ClientDao();
                Client client = clientDao.findById(clientId);
                sale.setClient(client);

                sales.add(sale);
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
        return sales;
    }

    @Override
    public boolean save(Sale sale) {
        String sql = "insert into sale (date, total_value, employee_id, client_id) values (?, ?, ?, ?)"; 
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        
        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setDate(1, new java.sql.Date(sale.getDate().getTime()));
            preparedStatement.setDouble(2, sale.getTotalValue());
            preparedStatement.setLong(3, sale.getEmployee().getId());
            preparedStatement.setLong(4, sale.getClient().getId());
            
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
    public boolean update(Sale sale, String[] params) {
        String sql = "update sale set date = ?, total_value = ?, employee_id = ?, client_id = ? where id = ?"; 
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        
        try {
            conn = DBconnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setDate(1, new java.sql.Date(sale.getDate().getTime()));
            preparedStatement.setDouble(2, sale.getTotalValue());
            preparedStatement.setLong(3, sale.getEmployee().getId());
            preparedStatement.setLong(4, sale.getClient().getId());
            preparedStatement.setLong(5, sale.getId());
            
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
        String sql = "delete from sale where id = ?"; 
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

