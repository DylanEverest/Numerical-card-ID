<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%@ page import="Property.PropertyAccess" %>
<%

        WebserviceModule.response.GeometryProperty geometryProperty =PropertyAccess.getGeometryProperty(request.getParameterValues("latitude[]"),request.getParameterValues("longitude[]")) ;
        out.println(geometryProperty);
        WebserviceModule.response.PropertyResponse rp = new WebserviceModule.response.PropertyResponse();
        rp.setAddress(request.getParameter("Adress"));
        geometryProperty.setProperty(rp);

        Property.PropertyAccess.insertPropertiesAdress(geometryProperty);

%>