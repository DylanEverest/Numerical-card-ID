package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import databaseconnectivity.MysqlConnection;

public class BankAccountTransaction {

    @SuppressWarnings("unused")
    private int transactionId;
    private String cardId;
    private double amount;
    private Timestamp transactionDate;

    public BankAccountTransaction(int transactionId,String cardId ,double amount,Timestamp transactionDate) 
    {
        setTransactionId(transactionId);
        setCardId(cardId);
        setAmount(amount);
        setTransactionDate(transactionDate);
    }

    public void setTransactionId(int transactionId) 
    {
        this.transactionId = transactionId;
    }

    public void setCardId(String cardId) 
    {
        this.cardId = cardId;
    }

    public void setAmount(double amount) 
    {
        this.amount = amount;
    }

    public void setTransactionDate(Timestamp transactionDate) 
    {
        this.transactionDate = transactionDate;
    }

    // Méthode pour insérer une transaction dans la base de données
    public void insertTransaction(MysqlConnection mysqlConnection, boolean closeConnection) throws Exception {
        Connection connection = mysqlConnection.connectToDatabase();
        String insertQuery = "INSERT INTO bankaccounttransaction (card_id, amount, transaction_date) VALUES (?, ?, ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) 
        {
            preparedStatement.setString(1, cardId);
            preparedStatement.setDouble(2, amount);
            preparedStatement.setTimestamp(3, transactionDate);
            preparedStatement.executeUpdate();
        } 
        finally 
        {
            if (closeConnection) 
            {
                connection.close();
            }
        }
    }

    // Méthode pour récupérer toutes les transactions pour une carte spécifique
    public static BankAccountTransaction getTransactionsByCardId(MysqlConnection mysqlConnection, String cardId, boolean closeConnection) throws Exception 
    {
        Connection connection = mysqlConnection.connectToDatabase();
        String selectQuery = "SELECT * FROM bankaccounttransaction WHERE card_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) 
        {
            preparedStatement.setString(1, cardId);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
          
            int transactionId = resultSet.getInt("transaction_id");
            double amount = resultSet.getDouble("amount");
            Timestamp transactionDate = resultSet.getTimestamp("transaction_date");
          
            BankAccountTransaction transaction = new BankAccountTransaction(transactionId ,cardId ,amount,transactionDate);

            return transaction;
            
        } 
        finally 
        {
            if (closeConnection) 
            {
                connection.close();
            }
        }

    }
}
