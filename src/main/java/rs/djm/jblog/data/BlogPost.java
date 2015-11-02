package rs.djm.jblog.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// TODO: ??? Can I remove set methods
// to objects be unchangeble
@Entity
@Table(name = "BlogPost")
public class BlogPost implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBlogPost")
    private Integer idBlogPost;

    @Basic(optional = false)
    @NotNull
    @Column(name = "title")
    @Size(min = 1, max = 500)
    private String title;

    @Column(name = "subtitle")
    @Size(min = 0, max = 500)
    private String subtitle;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "author")
    private String author;

    // TODO: replace timestamp string with Data Time
    // @Column(name = "dateTime", columnDefinition = "DATETIME")
    // @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateTime")
    @Size(max = 10)
    private String dateTime;

    @Column(name = "blogPostText")
    private String blogPostText;

    public BlogPost() {
    }

    public BlogPost(int id, String title, String subtitle, String authorName, String timestamp, String blogPost) {
        this.idBlogPost = id;
        this.title = title;
        this.subtitle = subtitle;
        this.author = authorName;
        this.dateTime = timestamp;
        this.blogPostText = blogPost;
    }

    public BlogPost(String title, String subtitle, String authorName, String timestamp, String blogPost) {
        this.title = title;
        this.subtitle = subtitle;
        this.author = authorName;
        this.dateTime = timestamp;
        this.blogPostText = blogPost;
    }

    public Integer getIdBlogPost() {
        return this.idBlogPost;
    }

    public void setIdBlogPost(Integer id) {
        this.idBlogPost = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String datetime) {
        this.dateTime = datetime;
    }

    public String getBlogPostText() {
        return blogPostText;
    }

    public void setBlogPostText(String blogPost) {
        this.blogPostText = blogPost;
    }

}
