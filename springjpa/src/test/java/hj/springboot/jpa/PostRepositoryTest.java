package hj.springboot.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

	@Autowired
	PostRepository postRepository;
	
	@Before
	public void setUp() {
		postRepository.deleteAll();
	}
	
	@Test
	@Rollback(false)
	public void crudRepository() {
		Post post = Post.builder()
				.title("JPA 배우기")
				.comments(new HashSet<>())
				.build();
		
		assertThat(post.getComments()).isNotNull();
		assertThat(post.getId()).isNull();
		
		Post newPost = postRepository.save(post);
		assertThat(newPost.getId()).isNotNull();
		
		List<Post> posts = postRepository.findAll();
		assertThat(posts.size()).isEqualTo(1);
		assertThat(posts).contains(newPost);
	}
	
	@Test
	@Rollback(false)
	public void pagingAndSortingRepository() {
		Post post = Post.builder()
				.title("아프리카 합격가즈아")
				.comments(new HashSet<>())
				.build();
		
		postRepository.save(post);
		
		Page<Post> pages = postRepository.findAll(PageRequest.of(0, 10));
		assertThat(pages.getTotalElements()).isEqualTo(1);
		assertThat(pages.getNumber()).isEqualTo(0);
		assertThat(pages.getSize()).isEqualTo(10);
		assertThat(pages.getNumberOfElements()).isEqualTo(1);
	}
	
	@Test
	@Rollback(false)
	public void findByTitleContains() {
		for (int i = 0; i < 10; i++) {
			Post post = Post.builder()
					.title("JPA"+i)
					.comments(new HashSet<>())
					.build();
			
			postRepository.save(post);
		}
		
		Post post = new Post();
		post.setTitle("안녕");
		postRepository.save(post);
		
		Page<Post> posts = postRepository.findByTitleContains("안", PageRequest.of(0, 10));
		System.out.println(posts.getContent());
	}
}
