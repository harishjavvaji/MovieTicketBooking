package com.movietickets.booking.services;

import com.movietickets.booking.models.Payment;
import com.movietickets.booking.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    JdbcTemplate jdbcTemplate;

    public PaymentService(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Payment> getAllPayments(){
        List<Payment> payments=new ArrayList<>();
        paymentRepository.findAll().forEach(new Consumer<Payment>() {
            @Override
            public void accept(Payment payment) {
                payments.add(payment);
            }
        });
        return payments;
    }

    public Payment createPayment(Payment payment){
        return paymentRepository.save(payment);
    }

    public Payment getPayment(Payment payment) {
        String sql = "select * from paymentdata where username = (?)";

        return jdbcTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, payment.getUserName());
            }
        }, new ResultSetExtractor<Payment>() {
            @Override
            public Payment extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                Payment payment1 = new Payment();

                while (resultSet.next()) {
                    payment1.setCardHolderName(resultSet.getString("cardholdername"));
                    payment1.setCardNumber(resultSet.getString("cardnumber"));
                    payment1.setMonth(resultSet.getInt("month"));
                    payment1.setYear(resultSet.getInt("year"));
                    payment1.setUserName(resultSet.getString("username"));
                }

                return payment1;
            }
        });
    }
}

