<%@ page import="jakarta.servlet.http.HttpServletRequest" %>

<%
    Property.PropertyAccess.insertPropertyPerson(request.getParameter("NIC") ,request.getParameter("Adress"));
%>