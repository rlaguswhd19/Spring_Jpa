package hj.springboot.jpa;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import hj.springboot.jpa.accounts.Account;
import hj.springboot.jpa.accounts.Study;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner{

	@PersistenceContext
	EntityManager entityManager;	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Account account = Account.builder()
				.username("hj")
				.password("pass")
				.created(LocalDate.now())
				.studys(new HashSet<>())
				.build();
		
		Study study = Study.builder()
				.name("JPA 공부를 해보자")
				.build();

		study.setOwner(account);
		
		// 필수는 아니지만 객체 지향적으로 생각하면 해줘야 하는일
		// 양쪽다 가지고 있어야 한다.
		account.getStudys().add(study);
		
//		jpa
//		entityManager.persist(account);
		
//		hibernate
		Session session = entityManager.unwrap(Session.class);
//		session.save(account);
//		session.save(study);
		
//		Account hj = session.load(Account.class, account.getId());
//		hj.setUsername("hj2");
//		System.out.println("====================================");
//		System.out.println(hj.getUsername());
		
//		Post post = Post.builder()
//				.title("JPA 공부해보기")
//				.comments(new HashSet<>())
//				.build();
//		
//		Comment comment1 = Comment.builder()
//				.comment("언제 공부하지")
//				.build();
//		post.addComment(comment1);
//		
//		Comment comment2 = Comment.builder()
//				.comment("지금부터라도 공부해")
//				.build();
//		post.addComment(comment2);
//		
//		session.save(post);
		
		Post getPost = session.get(Post.class, 10L);
		System.out.println(getPost.getTitle());

		getPost.getComments().forEach(c -> {
			System.out.println(c.getComment());
		});
//		session.remove(post);
		
//		Comment comment = session.get(Comment.class, 11L);
//		System.out.println(comment.getComment());
//		System.out.println(comment.getPost().getTitle());
	}
}
