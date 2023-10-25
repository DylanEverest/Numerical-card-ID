package models;

import java.math.BigDecimal;
import java.sql.Connection;

public class GeometryModels 
{
    PropertyView property ;
    
    BigDecimal[] latitude;
    
    BigDecimal[] longitude;

    public GeometryModels(PropertyView property, BigDecimal[] latitude, BigDecimal[] longitude) 
    {
        setProperty(property);
        setLatitude(latitude);
        setLongitude(longitude);
    }


    public boolean insert(Connection connection , boolean closeable)
    {

        
        return true;
    }

    public GeometryModels [] selectAllByCardID(Connection connection ,String cardID ,boolean closeable) throws Exception
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

    public static GeometryModels selectGeomByProperty(Connection connection , PropertyView property ,boolean closeable)
    {

        return null;
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
