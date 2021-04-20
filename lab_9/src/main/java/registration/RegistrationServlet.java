package registration;

import login.LoginBean;
import login.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

@WebServlet(name = "RegistrationServlet", value = "/registration")
public class RegistrationServlet extends HttpServlet {

    LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);
        loginBean.setRole(role);
        boolean status = false;
        try {
            status = loginDao.insert(loginBean);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        if (status) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            resp.sendRedirect("/loginsuccess");
        } else {
            resp.sendRedirect("/registration");
        }
    }
}
