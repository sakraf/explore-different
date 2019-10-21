package skf.servlet;

import skf.bean.Customer;
import skf.database.RegisterDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/register"})

public class RegisterServlet extends HttpServlet {

    private RegisterDao registerDao;

    @Override
    public void init() throws ServletException {
        super.init();
        this.registerDao = new RegisterDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/customer_register.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = new Customer();
        customer.setFirstName(req.getParameter("firstName"));
        customer.setLastName(req.getParameter("lastName"));
        customer.setUsername(req.getParameter("username"));
        customer.setPassword(req.getParameter("password"));
        customer.setAddress(req.getParameter("address"));
        customer.setContact(req.getParameter("contact"));
        this.registerDao.registerCustomer(customer);
        resp.sendRedirect(req.getContextPath() + "/login");
        return;

    }

}
