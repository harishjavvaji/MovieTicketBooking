package com.movietickets.booking.services;

import com.movietickets.booking.models.Customer;
import com.movietickets.booking.models.Ticket;
import com.movietickets.booking.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    JdbcTemplate jdbcTemplate;

    public TicketService(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Ticket> getAllTickets(){
        List<Ticket> tickets= new ArrayList<>();
        ticketRepository.findAll().forEach(new Consumer<Ticket>() {
            @Override
            public void accept(Ticket ticket) {
                tickets.add(ticket);
            }
        });
        return tickets;
    }

    public void createTicket(Ticket ticket){
        ticketRepository.save(ticket);
    }


    public void deleteTicket(String userName){
        ticketRepository.deleteById(userName);
    }

    public Ticket getTicket(Customer customer) {

        String sql = "select * from ticketdata where username = (?)";

        return jdbcTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, customer.getUserName());
            }
        }, new ResultSetExtractor<Ticket>() {
            @Override
            public Ticket extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                Ticket ticket = new Ticket();

                while (resultSet.next()) {

                    ticket.setNumberOfAdultTickets(resultSet.getInt("numberofadulttickets"));
                    ticket.setNumberOfChildTickets(resultSet.getInt("numberofchildtickets"));
                    ticket.setTotalPrice(resultSet.getInt("totalprice"));
                    ticket.setUserName(resultSet.getString("username"));
                    ticket.setId(resultSet.getInt("id"));
                }

                return ticket;
            }
        });

    }

    public Ticket bookTicket(Ticket ticket) {
        KeyHolder holder = new GeneratedKeyHolder();

        String sql =
                "insert into ticketdata(numberofadulttickets, adultticketprice, childticketprice, " +
                        "totalprice, numberofchildtickets, username, moviename, theatrename) values (?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql, new String[]{"id"});
                preparedStatement.setInt(1, ticket.getNumberOfAdultTickets());
                preparedStatement.setDouble(2, ticket.getAdultTicketPrice());
                preparedStatement.setDouble(3, ticket.getChildTicketPrice());
                preparedStatement.setDouble(4, ticket.getTotalPrice());
                preparedStatement.setInt(5, ticket.getNumberOfChildTickets());
                preparedStatement.setString(6, ticket.getUserName());
                preparedStatement.setString(7, ticket.getMovieName());
                preparedStatement.setString(8, ticket.getTheatreName());
                return preparedStatement;
            }
        }, holder);

        ticket.setId(holder.getKey().intValue());
        return ticket;



    }

}
