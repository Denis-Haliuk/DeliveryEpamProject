package org.epam.finalproject.dao;

import org.epam.finalproject.entity.Direction;
import org.epam.finalproject.entity.Tariff;
import org.epam.finalproject.util.DBUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TariffDao {
    public static TariffDao instance;

    public static synchronized TariffDao getInstance() {
        if (instance == null) {
            instance = new TariffDao();
        }
        return instance;
    }

    private TariffDao() {

    }

    DataSource dataSource = DBUtil.getInstance().dataSource;

    public List<Tariff> findAllTariffs(String sort){
        List<Tariff> tariffs = new ArrayList<>();
        if (sort == null){
            sort = "ASC";
        }
        String query = "SELECT * FROM cargo_types ORDER BY price " + sort;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Tariff tariff = new Tariff();
                tariff.setCargoType(resultSet.getString("type"));
                tariff.setPrice(resultSet.getInt("price"));
                tariffs.add(tariff);
            }

            return tariffs;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
