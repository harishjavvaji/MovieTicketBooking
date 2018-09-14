package com.movietickets.booking.services;

import com.movietickets.booking.models.Movie;
import com.movietickets.booking.models.Theatre;
import com.movietickets.booking.repositories.MovieRepository;
import com.movietickets.booking.repositories.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
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
public class TheatreService {
    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    MovieService movieService;

    JdbcTemplate jdbcTemplate;
    public TheatreService(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Theatre> getAllTheatres(){
        List<Theatre> theatres=new ArrayList<>();
        theatreRepository.findAll().forEach(new Consumer<Theatre>() {
            @Override
            public void accept(Theatre theatre) {
                theatres.add(theatre);
            }
        });
        return theatres;
    }


    public List<Theatre> requiredTheatres(Movie movie) {

        String sql = "select * from theatredata where moviename = (?)";

        return jdbcTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, movie.getMovieName());
            }

    }, new RowMapper<Theatre>() {
            @Override
            public Theatre mapRow(ResultSet resultSet, int i) throws SQLException {
                Theatre theatre = new Theatre();



                    theatre.setTheatreName(resultSet.getString("theatrename"));
                    theatre.setCity(resultSet.getString("city"));
                    theatre.setTime(resultSet.getString("time"));
                    theatre.setZipcode(resultSet.getInt("zipcode"));

                return theatre;

            }
        });

    }

    public List<Movie> getMovies(Theatre theatre) {
        String sql = "select * from theatredata where theatrename = (?)";

        List<Movie> movieList = new ArrayList<>();

        List<Movie> movies =  jdbcTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, theatre.getTheatreName());
            }

        }, new RowMapper<Movie>() {
            @Override
            public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
                Movie movie = new Movie();

                movie.setMovieName(resultSet.getString("moviename"));

                return movie;

            }
        });

        for (int i = 0; i < movies.size(); i++) {


            movieList.add(movieService.getMovie(movies.get(i)));
        }

        return movieList;
    }
}
