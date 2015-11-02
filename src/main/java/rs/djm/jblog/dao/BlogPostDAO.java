package rs.djm.jblog.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import rs.djm.jblog.data.BlogPost;
import rs.djm.jblog.exceptions.BlogPostNotExistException;
import rs.djm.jblog.exceptions.BlogPostSameIdException;

public class BlogPostDAO {

    private static final BlogPostDAO instance = new BlogPostDAO();

    // TODO: remove this variable after connectio to the database
    private final List<BlogPost> blogPosts = new ArrayList<>();

    private BlogPostDAO() {
    }

    public static BlogPostDAO getInstance() {
        return instance;
    }

    public List<BlogPost> getAll(EntityManager em) {
        Query query = em.createQuery("SELECT bp FROM BlogPost bp");
        return query.getResultList();
    }

    public void add(EntityManager em, BlogPost bp) {
        em.persist(bp);
    }

    public BlogPost getBlogPostById(EntityManager em, String strIdBlogPost) throws BlogPostNotExistException, BlogPostSameIdException {
        Query query = em.createQuery("SELECT bp FROM BlogPost bp WHERE bp.idBlogPost = :idBlogPost");

        Integer intIdBlogPost = Integer.parseInt(strIdBlogPost);
        query.setParameter("idBlogPost", intIdBlogPost);

        List<BlogPost> result = query.getResultList();
        if (result.isEmpty()) {
            throw new BlogPostNotExistException("Exception: Doesn't exist blog post rerered by id: " + strIdBlogPost);
        }
        if (result.size() > 1) {
            // TODO : create new exception
            throw new BlogPostSameIdException("Too many blog posts with the same Id " + strIdBlogPost);
        }

        return (BlogPost) result.get(0);
    }

    public void updateBlogPost(EntityManager em, BlogPost updateBlogPost) throws BlogPostNotExistException {
        em.merge(updateBlogPost);
    }

    public void deleteBlogPost(EntityManager em, BlogPost blogPost) {
        BlogPost delBlogPost = em.merge(blogPost);
        em.remove(delBlogPost);
    }

}
