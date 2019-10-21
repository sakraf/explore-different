package skf.servlet;


import skf.bean.Login;
import skf.database.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/customer"})
public class UserServlet extends HttpServlet {

    private LoginDao loginDao;

    @Override
    public void init() throws ServletException {
        super.init();
        this.loginDao = new LoginDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = (action != null) ? action : "list";

        switch (action) {
            case "cart":
                req.getRequestDispatcher("jsp/cart.jsp").forward(req, resp);
                break;
            case "logout":
                HttpSession session = req.getSession(false);
                if (session != null) {
                        session.removeAttribute("username");
                        session.removeAttribute("userId");
                }
                resp.sendRedirect(req.getContextPath() + "/");
                break;
            case "clearCart":
                session = req.getSession(false);
                if (session != null) {
                    session.removeAttribute("cart");
                }
                resp.sendRedirect(req.getContextPath() + "/customer?action=cart");
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = (action != null) ? action : "list";


        switch (action) {
            case "cart":
                String username2 = req.getParameter("username");
                String password2 = req.getParameter("password");
                Login loginBean2 = new Login();
                loginBean2.setUsername(username2);
                loginBean2.setPassword(password2);
                try {
                    Integer userId = loginDao.validate(loginBean2);

                    if (userId != null) {
                        req.getSession().setAttribute("userId", userId);
                        resp.sendRedirect(req.getContextPath() + "/customer?action=cart");
                    }


                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

        }

    }
}