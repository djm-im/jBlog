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
import rs.djm.jblog.service.BlogPostService;

public class NewPostServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @SuppressWarnings("deprecation")
    private void proceedRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String action = request.getParameter("action");

        String title = request.getParameter("title");
        String subtitle = request.getParameter("subtitle");
        String author = request.getParameter("author");
        String blogPostText = request.getParameter("posttext");

        // TODO: add data validation
        // TODO: change to data-time
        String timedate = "2015-11-01";

        // TODO: consider to replace if with switch statement
        if ("newpost".equals(action)) {
            BlogPost newBlogPost = new BlogPost(title, subtitle, author, timedate, blogPostText);
            BlogPostService.getInstance().add(newBlogPost);

            List<BlogPost> postsList = BlogPostService.getInstance().getAll();
            request.setAttribute("postList", postsList);

            request.setAttribute("message", "Blog post successfully save");
            request.getRequestDispatcher("index.jsp").forward(request, response);

            return;
        } else if ("editpost".equals(action)) {
            String strId = request.getParameter("id");
            Integer idBlogPost = Integer.parseInt(strId);
            BlogPost updateBlogPost = new BlogPost(idBlogPost, title, subtitle, author, timedate, blogPostText);
            try {
                BlogPostService.getInstance().update(strId, updateBlogPost);
            } catch (BlogPostNotExistException e) {
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

            List<BlogPost> postsList = BlogPostService.getInstance().getAll();
            request.setAttribute("postList", postsList);
            request.setAttribute("message", "Blog post successfully updated");

            request.getRequestDispatcher("index.jsp").forward(request, response);

            return;
        }

        request.getRequestDispatcher("/WEB-INF/pages/newpost.jsp").forward(request, response);
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
