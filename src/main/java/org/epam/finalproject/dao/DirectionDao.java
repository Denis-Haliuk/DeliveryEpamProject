package org.epam.finalproject.dao;

import org.epam.finalproject.entity.Direction;
import org.epam.finalproject.entity.User;
import org.epam.finalproject.util.DBUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DirectionDao {

    public static DirectionDao instance;

    public static synchronized DirectionDao getInstance() {
        if (instance == null) {
            instance = new DirectionDao();
        }
        return instance;
    }

    private DirectionDao() {

    }

    DataSource dataSource = DBUtil.getInstance().dataSource;

    public List<Direction> findAllDirections(String sort){
        List<Direction> directions = new ArrayList<>();
        if (sort == null){
            sort = "ASC";
        }
        String query = "SELECT * FROM directions ORDER BY price " + sort;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Direction direction = new Direction();
                direction.setDirection(resultSet.getString("direction"));
                direction.setPrice(resultSet.getInt("price"));
                directions.add(direction);
            }

            return directions;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
