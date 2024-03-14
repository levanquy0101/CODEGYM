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
    private final String INSERT= "insert into customer (name, email, country) value (?, ?, ?)";
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
            addUserTransaction(customer, new int[]{1,2,3});
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

    public void addUserTransaction(Customer customer, int[] permisions) {

        Connection conn = null;

        // for insert a new user

        PreparedStatement pstmt = null;

        // for assign permision to user

        PreparedStatement pstmtAssignment = null;

        // for getting user id

        ResultSet rs = null;

        try {

            conn = getConnection();

            // set auto commit to false

            conn.setAutoCommit(false);

            // Insert user

            pstmt= getConnection().prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getEmail());
            pstmt.setString(3, customer.getCountry());
            int rowAffected = pstmt.executeUpdate();

            // get user id
            rs = pstmt.getGeneratedKeys();

            int userId = 0;

            if (rs.next()){
                userId = rs.getInt(1);
            }

            if (rowAffected == 1) {

                // assign permision to user

                String sqlPivot = "INSERT INTO user_permision(user_id,permision_id) "

                        + "VALUES(?,?)";

                pstmtAssignment = conn.prepareStatement(sqlPivot);

                for (int permisionId : permisions) {

                    pstmtAssignment.setInt(1, userId);

                    pstmtAssignment.setInt(2, permisionId);

                    pstmtAssignment.executeUpdate();

                }

                conn.commit();


                // good practice to set it back to default true

                conn.setAutoCommit(true);
            }
            else {
                conn.rollback();
            }

        } catch (SQLException | ClassNotFoundException ex) {

            // roll back the transaction

            try {

                if (conn != null)

                    conn.rollback();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

            System.out.println(ex.getMessage());

        }
        finally {
            try {
                if (rs != null) rs.close();

                if (pstmt != null) pstmt.close();

                if (pstmtAssignment != null) pstmtAssignment.close();

                if (conn != null) conn.close();

            } catch (SQLException e) {

                System.out.println(e.getMessage());
            }
        }
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
