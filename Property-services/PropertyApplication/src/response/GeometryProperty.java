package response;

import java.math.BigDecimal;

public class GeometryProperty 
{
    BigDecimal [] longitudes;

    BigDecimal [] latitudes ;

    PropertyResponse property;
    
    
    public GeometryProperty() 
    {
    }

    public GeometryProperty(String [] latitudes ,String [] longitudes) 
    {
        BigDecimal [] latitudes0 = new BigDecimal [latitudes.length] ;
        BigDecimal [] longitudes0 = new BigDecimal [longitudes.length] ;

        for (int i = 0; i < latitudes.length; i++)
        {
            latitudes0[i] = new BigDecimal (latitudes[i]);            
            longitudes0[i] =new BigDecimal(longitudes[i]);
        }

        setLatitudes(latitudes0);
        setLongitudes(longitudes0);

    }

    public BigDecimal[] getLongitudes() 
    {
        return longitudes;
    }

    public void setLongitudes(BigDecimal[] longitudes) 
    {
        this.longitudes = longitudes;
    }

    public BigDecimal[] getLatitudes() 
    {
        return latitudes;
    }

    public void setLatitudes(BigDecimal[] latitudes) 
    {
        this.latitudes = latitudes;
    }

    public PropertyResponse getProperty() {
        return property;
    }

    public void setProperty(PropertyResponse property) {
        this.property = property;
    }

}
