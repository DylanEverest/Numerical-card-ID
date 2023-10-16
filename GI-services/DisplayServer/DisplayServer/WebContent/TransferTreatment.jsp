<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%
    String sender = request.getParameter("sender");
    String receiver = request.getParameter("receiver");
    String amount = request.getParameter("amount");
    String currency = request.getParameter("currency");

    Bank.BankAccess.transferMoney(sender ,receiver  ,currency ,amount) ;

    %>