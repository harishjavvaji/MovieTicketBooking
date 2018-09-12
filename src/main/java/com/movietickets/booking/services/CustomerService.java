package com.movietickets.booking.services;

import com.movietickets.booking.models.Customer;
import com.movietickets.booking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    JdbcTemplate jdbcTemplate;

    public CustomerService(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Customer>  getAllCustomers(){
        List<Customer> customers=new ArrayList<>();
        customerRepository.findAll().forEach(new Consumer<Customer>() {
            @Override
            public void accept(Customer customer) {
                customers.add(customer);
            }
        });
        return customers;
    }


    public void createCustomer(Customer customer){
         customerRepository.save(customer);
    }

    public Customer getCustomer(Customer customer) {
        return customerRepository.findById(customer.getUserName()).get();

    public int registerCustomer(Customer customer) {

        String sql =
                "insert into customerdata(firstname, lastname, email, username, password) values (?,?,?,?,?)";
        return jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement=
                        connection.prepareStatement(sql);
                preparedStatement.setString(1,customer.getFirstName());
                preparedStatement.setString(2, customer.getLastName());
                preparedStatement.setString(3, customer.getEmail());
                preparedStatement.setString(4, customer.getUserName());
                preparedStatement.setString(5, customer.getPassword());

                return preparedStatement;
            }
        });

    }

    public Customer validateCustomer(Customer customer) {

        String sql = "select username, password from customerdata where username = (?)";
//
//        return jdbcTemplate.query(sql, new ResultSetExtractor<Customer>() {
//            @Override
//            public Customer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//                Customer customer1 = new Customer();
//
//                customer1.setUserName(resultSet.getString("username")) ;
//                customer1.setPassword(resultSet.getString("password"));
//
//                return customer1;
//            }
//        });


        return jdbcTemplate.query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, customer.getUserName());

                return preparedStatement;
            }
        }, new ResultSetExtractor<Customer>() {
            @Override
            public Customer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                Customer customer1 = new Customer();

                while (resultSet.next()) {

                    customer1.setUserName(resultSet.getString("username"));
                    customer1.setPassword(resultSet.getString("password"));

                }
                return customer1;

            }
        });
    }

}