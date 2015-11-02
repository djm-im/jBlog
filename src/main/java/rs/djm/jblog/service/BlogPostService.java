package rs.djm.jblog.service;

import java.util.List;
import javax.persistence.EntityManager;
import rs.djm.jblog.dao.BlogPostDAO;
import rs.djm.jblog.dao.EntityManagerWrapper;
import rs.djm.jblog.data.BlogPost;
import rs.djm.jblog.exceptions.BlogPostNotExistException;
import rs.djm.jblog.exceptions.BlogPostSameIdException;

public class BlogPostService {

    private static final BlogPostService instance = new BlogPostService();

    private BlogPostService() {
    }

    public static BlogPostService getInstance() {
        return instance;
    }

    public List<BlogPost> getAll() {
        EntityManager em = EntityManagerWrapper.getEntityManager();
        return BlogPostDAO.getInstance().getAll(em);
    }

    public void add(BlogPost blogPost) {
        validate(blogPost);

        EntityManager em = EntityManagerWrapper.getEntityManager();
        try {
            em.getTransaction().begin();
            BlogPostDAO.getInstance().add(em, blogPost);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void update(String strId, BlogPost updateBlogPost) throws BlogPostNotExistException {
        EntityManager em = EntityManagerWrapper.getEntityManager();
        try {
            em.getTransaction().begin();
            BlogPostDAO.getInstance().updateBlogPost(em, updateBlogPost);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public BlogPost getById(String strIdBlogPost) throws BlogPostNotExistException, BlogPostSameIdException {
        EntityManager em = EntityManagerWrapper.getEntityManager();
        return BlogPostDAO.getInstance().getBlogPostById(em, strIdBlogPost);
    }

    public void deleteBlogPost(BlogPost blogPost) {
        EntityManager em = EntityManagerWrapper.getEntityManager();
        try {
            em.getTransaction().begin();
            BlogPostDAO.getInstance().deleteBlogPost(em, blogPost);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // TODO: add data validation
    public void validate(BlogPost blogPost) {
        // TODO: check are fields are valide
        // if blog post is not valide throw exception
    }
}
