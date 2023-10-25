package Property;

public class GeometryProperty 
{
    double [] longitudes;

    double [] latitudes ;

    
    
    
    public GeometryProperty(String [] latitudes ,String [] longitudes) 
    {
        double [] latitudes0 = new double [latitudes.length] ;
        double [] longitudes0 = new double [longitudes.length] ;

        for (int i = 0; i < latitudes.length; i++)
        {
            latitudes0[i] =Double.parseDouble(latitudes[i]);            
            longitudes0[i] =Double.parseDouble(longitudes[i]);
        }

        setLatitudes(latitudes0);
        setLongitudes(longitudes0);

    }

    public double[] getLongitudes() 
    {
        return longitudes;
    }

    public void setLongitudes(double[] longitudes) 
    {
        this.longitudes = longitudes;
    }

    public double[] getLatitudes() 
    {
        return latitudes;
    }

    public void setLatitudes(double[] latitudes) 
    {
        this.latitudes = latitudes;
    }

}
