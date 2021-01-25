package hj.springboot.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

	@Autowired
	CommentRepository commentRepository;
	
	@Test
	public void crud() {
		Comment comment = Comment.builder()
				.comment("합격할 수 있을까")
				.build();
		commentRepository.save(comment);
		
		List<Comment> list = commentRepository.findAll();
		assertThat(list.size()).isEqualTo(1);
	}
	
	@Test
	public void optionalTest() {
//		Optional<Comment> byId = commentRepository.findById(100L);
//		assertThat(byId).isEmpty();
//		Comment comment = byId.orElseThrow(() -> new IllegalArgumentException());
		
		List<Comment> comments = commentRepository.findAll();
		if(comments != null){
            // 필요 없는 코드 비어있는것으로 나온다.
        }
		assertThat(comments.isEmpty());
	}
	
	@Test
	public void nullTest() {
//		commentRepository.save(null);
		Comment byId = commentRepository.findById(100L);
//		assertThat(byId).isNull();
//		System.out.println(byId);
	}
}
