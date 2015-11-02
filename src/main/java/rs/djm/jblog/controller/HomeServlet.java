package rs.djm.jblog.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.djm.jblog.data.BlogPost;
import rs.djm.jblog.service.BlogPostService;

public class HomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private void proceedRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        List<BlogPost> postsList = BlogPostService.getInstance().getAll();
        request.setAttribute("postList", postsList);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        proceedRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        proceedRequest(request, response);
    }

}
