package sample;

import java.sql.*;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    private Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" +
                dbPort + "/" + dbName;

        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);

        return dbConnection;
    }

    public void chekContract(String numberContract, String dataContract) {
        int id = -1;
        int numContract = Integer.parseInt(numberContract);
        String query = "SELECT id FROM " + Const.TABLE_NAME + " WHERE " + Const.TABLE_NUMBER_CONTRACT + " = " + numContract;
        try {
            Statement statement = getDbConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            if (id != -1) {
                changeContract(numberContract, dataContract);
            } else {
                addContract(numberContract, dataContract);
            }
            dbConnection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void changeContract(String numberContract, String dataContract) {
        String insert = "UPDATE " + Const.TABLE_NAME + " SET " + Const.TABLE_DATA_CHANGE
                + " = ? " + "WHERE " + Const.TABLE_NUMBER_CONTRACT + " = ?";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, dataContract);
            prSt.setString(2, numberContract);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Обновилась дата договора " + numberContract);
    }

    private void addContract(String numberContract, String dataContract) {
        String insert = "INSERT INTO " + Const.TABLE_NAME + "("
                + Const.TABLE_DATA + "," + Const.TABLE_NUMBER_CONTRACT
                + "," + Const.TABLE_DATA_CHANGE + ")" + "VALUES(?,?,?)";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, dataContract);
            prSt.setString(2, numberContract);
            prSt.setString(3, dataContract);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Добавлен новый договор");
    }
}
