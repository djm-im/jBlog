package rs.djm.jblog.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.djm.jblog.data.BlogPost;
import rs.djm.jblog.exceptions.BlogPostNotExistException;
import rs.djm.jblog.exceptions.BlogPostSameIdException;
import rs.djm.jblog.service.BlogPostService;

public class EditServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private void proceedRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String strIdBlogPost = request.getParameter("id");

        BlogPost blogPost = null;
        try {
            blogPost = BlogPostService.getInstance().getById(strIdBlogPost);
        } catch (BlogPostNotExistException | BlogPostSameIdException e) {
            // TODO Log error in file
            e.printStackTrace(System.err);

            //
            List<String> errors = new ArrayList<>();
            errors.add(e.getMessage());
            request.setAttribute("errors", errors);

            List<BlogPost> blogPosts = BlogPostService.getInstance().getAll();
            request.setAttribute("postList", blogPosts);
            request.getRequestDispatcher("/index.jsp").forward(request, response);

            return;
        }

        request.setAttribute("blogPost", blogPost);
        request.getRequestDispatcher("/WEB-INF/pages/edit.jsp").forward(request, response);
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
