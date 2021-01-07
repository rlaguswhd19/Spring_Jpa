package hj.springboot.jpa;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Comment {
	
	@Id @GeneratedValue
	private Long id;
	
	private String comment;
	
	@ManyToOne
	private Post post;
}
