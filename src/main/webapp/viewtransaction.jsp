<%@page import="dto.BankTransaction"%>
<%@page import="java.util.List"%>
<%@page import="dto.BankAccount"%>
<%@page import="dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Transaction</title>
</head>
<body>
<%
long acno = (long) session.getAttribute("acno");
BankDao bankDao = new BankDao();
BankAccount account = bankDao.find(acno);
List<BankTransaction> list=account.getTransactions();
%>


</body>
</html>