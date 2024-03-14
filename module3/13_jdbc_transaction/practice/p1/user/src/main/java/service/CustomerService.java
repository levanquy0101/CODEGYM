package service;

import model.Customer;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private final String SELECT_ALL = "select * from customer";
    private final String UPDATE = "update customer set name= ?, email= ?, country= ? where id= ?";
    private final String DELETE = "delete from customer where id= ?";

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/user_demo", "root", "12345");
    }

    public void save(Customer customer) {
        if (customer.getId() > 0) {
            // update
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(UPDATE)) {
                preparedStatement.setString(1, customer.getName());
                preparedStatement.setString(2, customer.getEmail());
                preparedStatement.setString(3, customer.getCountry());
                preparedStatement.setInt(4, customer.getId());
                preparedStatement.executeUpdate();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            // create
            String query = "{CALL insert_user(?,?,?)}";

            // try-with-resource statement will auto close the connection.

            try (Connection connection = getConnection();

                 CallableStatement callableStatement = connection.prepareCall(query);) {

                callableStatement.setString(1, customer.getName());

                callableStatement.setString(2, customer.getEmail());

                callableStatement.setString(3, customer.getCountry());

                System.out.println(callableStatement);

                callableStatement.executeUpdate();

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customers.add(getCustomer(resultSet));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return customers;
    }

    public void delete(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Customer getById(int id) {
        Customer customer = null;

        String query = "{CALL get_user_by_id(?)}";

        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object

             CallableStatement callableStatement = connection.prepareCall(query);) {

            callableStatement.setInt(1, id);

            // Step 3: Execute the query or update query

            ResultSet rs = callableStatement.executeQuery();

            // Step 4: Process the ResultSet object.

            while (rs.next()) {

                String name = rs.getString("name");

                String email = rs.getString("email");

                String country = rs.getString("country");

                customer = new Customer(id, name, email, country);

            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return customer;
    }

    private Customer getCustomer(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        String email = resultSet.getString(3);
        String country = resultSet.getString(4);
        Customer customer = new Customer(id, name, email, country);
        return customer;
    }
}
