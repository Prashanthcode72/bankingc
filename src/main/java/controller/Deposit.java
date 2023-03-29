package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankDao;
import dto.BankAccount;

@WebServlet("/deposit")
public class Deposit extends HttpServlet 
{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	double amt=Double.parseDouble(req.getParameter("amt"));
	
	long acno=(long)req.getSession().getAttribute("acno");
	BankDao bankDao=new BankDao();
	
	BankAccount account=bankDao.find(acno);
	account.setAmount(account.getAmount()+amt);
	
	bankDao.update(account);
	
	resp.getWriter().print("<h1>Amount added Successfully</h1>");
	req.getRequestDispatcher("AccountHome.jsp").include(req, resp);
	
}
}