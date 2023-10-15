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

    public BankAccountTransaction(){}

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
    public boolean insertTransaction(MysqlConnection mysqlConnection, boolean closeConnection) throws Exception {
        Connection connection = mysqlConnection.connectToDatabase();
        String insertQuery = "INSERT INTO bankaccounttransaction (card_id, amount, transaction_date) VALUES (?, ?, ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) 
        {
            preparedStatement.setString(1, cardId);
            preparedStatement.setDouble(2, amount);
            preparedStatement.setTimestamp(3, transactionDate);
            preparedStatement.executeUpdate();

            return true ;
        } 
        finally 
        {
            if (closeConnection) 
            {
                connection.close();
                return false ;
            }
        }
    }

    public static double getTotalAmountByCardId(MysqlConnection mysqlConnection, String cardId, boolean closeConnection) throws Exception {
        Connection connection = mysqlConnection.connectToDatabase();
        String selectQuery = "SELECT SUM(amount) AS total_amount FROM bankaccounttransaction WHERE card_id = ?";
        double totalAmount = 0.0;
    
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, cardId);
            ResultSet resultSet = preparedStatement.executeQuery();
    
            if (resultSet.next()) {
                totalAmount = resultSet.getDouble("total_amount");
            }
        } finally {
            if (closeConnection) {
                connection.close();
            }
        }
    
        return totalAmount;
    }
    

    public int getTransactionId() {
        return transactionId;
    }

    public String getCardId() {
        return cardId;
    }

    public double getAmount() {
        return amount;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }
}
