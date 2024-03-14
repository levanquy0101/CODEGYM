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
    private final String SELECT_ALL= "select * from customer";
    private final String INSERT= "insert into customer (name, email, country) value (?, ?, ?)";
    private final String UPDATE= "update customer set name= ?, email= ?, country= ? where id= ?";
    private final String DELETE= "delete from customer where id= ?";
    private final String SELECT_BY_ID= "select * from customer where id= ?";

    private Connection getConnection() throws SQLException, ClassNotFoundException {
//        try{
//            Context initContext = new InitialContext();
//            Context envContext  = (Context)initContext.lookup("java:/comp/env");
//            DataSource ds = (DataSource)envContext.lookup("jdbc/quoc");
//            Connection conn = ds.getConnection();
//            return conn;
//        }
//        catch (NamingException e){
//            e.printStackTrace();
//        }
//        return null;

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/user_demo", "root", "12345");
    }

    public void save(Customer customer){
        try(Connection connection= getConnection();
                PreparedStatement preparedStatement= connection.prepareStatement(customer.getId()> 0? UPDATE: INSERT)){
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getCountry());
            if(customer.getId()>0)
                preparedStatement.setInt(4, customer.getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException| ClassNotFoundException e){
            e.printStackTrace();
        }

//        if(customer.getId()> 0){
//            // update
//            try(PreparedStatement preparedStatement= getConnection().prepareStatement(UPDATE)) {
//                preparedStatement.setString(1, customer.getName());
//                preparedStatement.setString(2, customer.getEmail());
//                preparedStatement.setString(3, customer.getCountry());
//                preparedStatement.setInt(4, customer.getId());
//                preparedStatement.executeUpdate();
//            }
//            catch (SQLException e){
//                e.printStackTrace();
//            }
//        }
//        else {
//            // create
//            try(PreparedStatement preparedStatement= getConnection().prepareStatement(INSERT)) {
//                preparedStatement.setString(1, customer.getName());
//                preparedStatement.setString(2, customer.getEmail());
//                preparedStatement.setString(3, customer.getCountry());
//                preparedStatement.executeUpdate();
//            }
//            catch (SQLException e){
//                e.printStackTrace();
//            }
//        }
    }

    public List<Customer> getAll(){
        List<Customer> customers= new ArrayList<>();

        try(Connection connection= getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_ALL)) {
           ResultSet resultSet= preparedStatement.executeQuery();

           while (resultSet.next()){
//               int id= resultSet.getInt(1);
//               String name= resultSet.getString(2);
//               String email= resultSet.getString(3);
//               String country= resultSet.getString(4);
//               Customer customer= new Customer(id, name, email, country);

               customers.add(getCustomer(resultSet));
           }
        }
        catch (SQLException| ClassNotFoundException e){
            e.printStackTrace();
        }

        return customers;
    }

    public void delete(int id){
        try(Connection connection= getConnection();
                PreparedStatement preparedStatement= connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
        }
        catch (SQLException| ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Customer getById(int id){
        try (Connection connection= getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement(SELECT_BY_ID)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                return getCustomer(resultSet);
            }
        }
        catch (SQLException| ClassNotFoundException e){
            e.printStackTrace();
        }

        return null;
    }

    private Customer getCustomer(ResultSet resultSet) throws SQLException{
        int id= resultSet.getInt(1);
        String name= resultSet.getString(2);
        String email= resultSet.getString(3);
        String country= resultSet.getString(4);
        Customer customer= new Customer(id, name, email, country);
        return customer;
    }
}
