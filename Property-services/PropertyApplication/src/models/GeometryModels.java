package models;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeometryModels 
{
    PropertyView property ;
    
    BigDecimal[] latitude;
    
    BigDecimal[] longitude;

    public GeometryModels() {
    }


    public GeometryModels(PropertyView property, BigDecimal[] latitude, BigDecimal[] longitude) 
    {
        setProperty(property);
        setLatitude(latitude);
        setLongitude(longitude);
    }



    public boolean insertAdress(Connection connection, boolean closeable) 
    {
        String insertPropertySQL = "INSERT INTO property (address) VALUES (?)";
        String insertGeometrySQL = "INSERT INTO property_geometry (property_id, property_latitude, property_longitude) VALUES (?, ?, ?)";
    
        try 
        {
            // Start a transaction
            connection.setAutoCommit(false);
    
            // Step 1: Insert the address into the property table
            try (PreparedStatement propertyStatement = connection.prepareStatement(insertPropertySQL, PreparedStatement.RETURN_GENERATED_KEYS)) 
            {
                propertyStatement.setString(1, property.getAddress());
                int rowsAffected = propertyStatement.executeUpdate();
    
                if (rowsAffected == 0) 
                {
                    // Insertion failed
                    connection.rollback(); // Rollback the transaction
                    return false;
                }
    
                // Get the generated property_id
                try (ResultSet generatedKeys = propertyStatement.getGeneratedKeys()) 
                {
                    if (generatedKeys.next()) 
                    {
                        int propertyId = generatedKeys.getInt(1);
    
                        // Step 2: Insert latitude and longitude into the property_geometry table
                        try (PreparedStatement geometryStatement = connection.prepareStatement(insertGeometrySQL)) 
                        {
                            for (int i = 0; i < this.getLatitude().length; i++) {
                                geometryStatement.setInt(1, propertyId);
                                geometryStatement.setBigDecimal(2, this.getLatitude()[i]);
                                geometryStatement.setBigDecimal(3, this.getLongitude()[i]);
                                geometryStatement.executeUpdate();
                            }
    
                            // Commit the transaction
                            connection.commit();
                            return true;
                        }
                    } else {
                        // Insertion failed
                        connection.rollback(); // Rollback the transaction
                        return false;
                    }
                }
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions and rollback the transaction
            try 
            {
                connection.rollback();
            } 
            catch (SQLException rollbackException) 
            {
                // Handle rollback exception
                rollbackException.printStackTrace();
            }
    
            e.printStackTrace();
        } 
        finally 
        {
            try 
            {
                // Restore auto-commit mode
                connection.setAutoCommit(true);
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    
        return false;
    }
    

    public static GeometryModels [] selectAllByCardID(Connection connection ,String cardID ,boolean closeable) throws Exception
    {
        try
        {
            PropertyView [] properties = PropertyView.selectFromPropertyView(connection ,cardID ,closeable);

            GeometryModels [] geom = new GeometryModels [properties.length];

            for(int i =0 ;i< properties.length ;i++)
            {
                geom[i] = GeometryModels.selectGeomByProperty(connection ,properties[i],closeable ) ;
            }

            return geom ;
        }
        catch(Exception e)
        {
            throw new Exception("error during selecting all property");
        }
        finally
        {
            if(closeable) connection.close();
        }
    }

    public static GeometryModels selectGeomByProperty(Connection connection, PropertyView property, boolean closeable) throws SQLException 
    {
        GeometryModels geom = new GeometryModels();
        geom.setProperty(property);
    
        // Define the SQL query to retrieve latitude and longitude for the given property
        String sql = "SELECT property_latitude, property_longitude FROM property_geometry WHERE property_id = ?";
    
        try (PreparedStatement statement = connection.prepareStatement(sql)) 
        {
            statement.setInt(1, property.getPropertyId()); // Assuming property_id is the primary key of the PropertyView
    
            try (ResultSet resultSet = statement.executeQuery()) 
            {
                List<BigDecimal> latitudeList = new ArrayList<>();
                List<BigDecimal> longitudeList = new ArrayList<>();
    
                while (resultSet.next()) 
                {
                    BigDecimal latitude = resultSet.getBigDecimal("property_latitude");
                    BigDecimal longitude = resultSet.getBigDecimal("property_longitude");
    
                    latitudeList.add(latitude);
                    longitudeList.add(longitude);
                }
    
                geom.setLatitude(latitudeList.toArray(new BigDecimal[0]));
                geom.setLongitude(longitudeList.toArray(new BigDecimal[0]));
    
                return geom;
            } 
            catch (SQLException e) 
            {
                // Handle any errors that occur during result set retrieval
                e.printStackTrace();
                throw e; 
            }
        } 
        catch (SQLException e) 
        {
            // Handle any errors that occur during query execution
            e.printStackTrace();
            throw e;
        }
        finally 
        {
            if(closeable) connection.close();
        }
    
    }

    public PropertyView getProperty() 
    {
        return property;
    }

    public void setProperty(PropertyView property) 
    {
        this.property = property;
    }

    public BigDecimal[] getLatitude() 
    {
        return latitude;
    }

    public void setLatitude(BigDecimal[] latitude) 
    {
        this.latitude = latitude;
    }

    public BigDecimal[] getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal[] longitude) {
        this.longitude = longitude;
    }

        







}
