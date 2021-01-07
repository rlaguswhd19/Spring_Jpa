package hj.springboot.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Post {
	
	@Id @GeneratedValue
	private Long id;
	
	private String title;
	
	@OneToMany(mappedBy = "post", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Set<Comment> comments = new HashSet<>();
	
	public void addComment(Comment comment) {
		this.getComments().add(comment);
		comment.setPost(this);
	}
	
}
