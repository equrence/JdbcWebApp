package servlet;

import model.dao.UserDao;
import model.dao.UserDaoImpl;
import model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class MainServlet extends HttpServlet {
    private UserDao dao;

    @Override
    public void init() {
        dao = new UserDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = dao.getAllUsers();
        req.setAttribute("users", users);

        req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
    }
}
