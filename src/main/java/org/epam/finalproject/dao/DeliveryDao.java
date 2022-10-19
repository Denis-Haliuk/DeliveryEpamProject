package org.epam.finalproject.dao;

import org.epam.finalproject.entity.Delivery;
import org.epam.finalproject.util.DBUtil;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDao {
    public static DeliveryDao instance;

    public static synchronized DeliveryDao getInstance() {
        if (instance == null) {
            instance = new DeliveryDao();
        }
        return instance;
    }

    private DeliveryDao() {

    }

    DataSource dataSource = DBUtil.getInstance().dataSource;

    String query = "insert into deliveries values (default, ?,?,?,?,?,?,?,?,?,?,?) ";

    public void createDelivery(Delivery delivery) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, delivery.getUserId());
            preparedStatement.setInt(2, delivery.getDirectionId());
            preparedStatement.setInt(3, delivery.getTypeId());
            preparedStatement.setInt(4, delivery.getWeight());
            preparedStatement.setString(5, delivery.getFullName());
            preparedStatement.setLong(6, delivery.getSenderPhone());
            preparedStatement.setString(7, delivery.getReceiverName());
            preparedStatement.setLong(8, delivery.getReceiverPhone());
            preparedStatement.setString(9, delivery.getReceiverAddress());
            preparedStatement.setDate(10, new Date(new java.util.Date().getTime()));
            preparedStatement.setInt(11, 1);
            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int state, int idDelivery) {

        String query = "UPDATE deliveries set idstate = (?) where iddeliveries = (?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, state);
            preparedStatement.setInt(2, idDelivery);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Delivery> findAll() {
        List<Delivery> deliveries = new ArrayList<>();

        String query = "SELECT * FROM deliveries";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Delivery delivery = new Delivery();
                delivery.setId(resultSet.getInt("iddeliveries"));
                delivery.setDirectionId(resultSet.getInt("direction_id"));
                delivery.setUserId(resultSet.getInt("user_id"));
                delivery.setDate(resultSet.getDate("date"));
                delivery.setWeight(resultSet.getInt("weight"));
                delivery.setTypeId(resultSet.getInt("type_id"));
                delivery.setFullName(resultSet.getString("full_name"));
                delivery.setSenderPhone(resultSet.getLong("sender_phone"));
                delivery.setReceiverName(resultSet.getString("receiver_name"));
                delivery.setReceiverPhone(resultSet.getLong("receiver_phone"));
                delivery.setReceiverAddress(resultSet.getString("receiver_address"));
                delivery.setStateId(resultSet.getInt("idstate"));
                deliveries.add(delivery);
            }

            return deliveries;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Delivery> findAllByUserId(int userId) {
        List<Delivery> deliveries = new ArrayList<>();

        String query = "SELECT * FROM deliveries WHERE user_id = (?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                Delivery delivery = new Delivery();
                delivery.setId(resultSet.getInt("iddeliveries"));
                delivery.setDirectionId(resultSet.getInt("direction_id"));
                delivery.setUserId(resultSet.getInt("user_id"));
                delivery.setDate(resultSet.getDate("date"));
                delivery.setWeight(resultSet.getInt("weight"));
                delivery.setTypeId(resultSet.getInt("type_id"));
                delivery.setFullName(resultSet.getString("full_name"));
                delivery.setSenderPhone(resultSet.getLong("sender_phone"));
                delivery.setReceiverName(resultSet.getString("receiver_name"));
                delivery.setReceiverPhone(resultSet.getLong("receiver_phone"));
                delivery.setReceiverAddress(resultSet.getString("receiver_address"));
                delivery.setStateId(resultSet.getInt("idstate"));
                deliveries.add(delivery);
            }

            return deliveries;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
