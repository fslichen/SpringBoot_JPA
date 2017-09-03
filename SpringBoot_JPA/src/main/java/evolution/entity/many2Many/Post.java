package evolution.entity.many2Many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "Post")
@Table(name = "post")
public class Post {// This Post entity owns the relationship.
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    public Post() {
    	tags = new ArrayList<>();
    }
    public Post(String title) {
        this.title = title;
    }
    // Remove cascade in may-to-many relationship does not make sense since it will trigger a chain of deletion.
    // Remove cascade often happens in parent-children relationship, that means once the parent is deleted, the children are deleted.
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "post_tag", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;
    public void addTag(Tag tag) {
        tags.add(tag);
        tag.getPosts().add(this);
    }
    public void removeTag(Tag tag) {
        tags.remove(tag);
        tag.getPosts().remove(this);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        return id != null && id.equals(((Post) o).id);
    }
    @Override
    public int hashCode() {
        return 31;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", tags=" + tags + "]";
	}
}