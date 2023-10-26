<%@ page import="jakarta.servlet.http.HttpServletRequest" %>

<%
    Property.PropertyAccess.insertPropertyPerson(req.getParameter("NIC") ,req.getParameter("Adress"));
%>