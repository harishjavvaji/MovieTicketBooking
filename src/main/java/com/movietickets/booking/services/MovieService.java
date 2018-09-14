package com.movietickets.booking.services;

import com.movietickets.booking.models.Movie;
import com.movietickets.booking.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    JdbcTemplate jdbcTemplate;

    public MovieService(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Movie> getAllMovies(){
        List<Movie> movies=new ArrayList<>();
        movieRepository.findAll().forEach(new Consumer<Movie>() {
            @Override
            public void accept(Movie movie) {
                movies.add(movie);
            }
        });
        return movies;
    }

    public Movie getMovie(Movie movie) {

        String sql = "select * from moviesdata where moviename = (?)";

        return jdbcTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, movie.getMovieName());
            }
        }, new ResultSetExtractor<Movie>() {
            @Override
            public Movie extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                Movie movie1 = new Movie();

                while (resultSet.next()) {
                    movie1.setMovieName(resultSet.getString("moviename"));
                    movie1.setActorName(resultSet.getString("actorname"));
                    movie1.setGenre(resultSet.getString("genre"));
                    movie1.setLength(resultSet.getString("length"));
                }

                return movie1;
            }
        });

    }



}

