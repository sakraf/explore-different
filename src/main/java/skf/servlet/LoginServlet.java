package skf.servlet;

import skf.bean.Login;
import skf.database.LoginDao;
import skf.database.RegisterDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/login"})

public class LoginServlet extends HttpServlet {

    private LoginDao loginDao;

    @Override
    public void init() throws ServletException {
        super.init();
        this.loginDao = new LoginDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session.getAttribute("username") != null) {
            resp.sendRedirect(req.getContextPath() + "/shop");
        } else {
            req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Login loginBean = new Login();
        loginBean.setUsername(username);
        loginBean.setPassword(password);


        try {
            Integer userId = loginDao.validate(loginBean);

            if (userId != null) {
                HttpSession session = req.getSession();
                session.setAttribute("username", username);
                req.getSession().setAttribute("userId", userId);
                resp.sendRedirect(req.getContextPath() + "/shop");
            } else{
                String someMessage = "Username or password are not correct. Please try again !";
                PrintWriter out = resp.getWriter();
                out.print("<html><head>");
                out.print("<script type=\"text/javascript\">alert(" + someMessage + ");</script>");
                out.print("</head><body></body></html>");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}