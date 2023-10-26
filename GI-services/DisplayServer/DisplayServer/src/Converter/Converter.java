package Converter;

import java.math.BigDecimal;

import WebserviceModule.response.GeometryProperty;

public class Converter 
{
    public static String getArrayMap(GeometryProperty geometry) {
        StringBuilder arrayMap = new StringBuilder("[");
        
        BigDecimal[] latitudes = geometry.getLatitudes();
        BigDecimal[] longitudes = geometry.getLongitudes();
        
        if (latitudes.length == longitudes.length) {
            for (int i = 0; i < latitudes.length; i++) {
                arrayMap.append("[").append(latitudes[i]).append(",").append(longitudes[i]).append("]");
                if (i < latitudes.length - 1) {
                    arrayMap.append(",");
                }
            }
        }
        
        arrayMap.append("]");
        
        return arrayMap.toString();
    }
    
}
