package hj.springboot.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//@Component
@Transactional
public class QueryRunner implements ApplicationRunner {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		TypedQuery<Post> query = entityManager.createQuery("SELECT p from Post AS p", Post.class);
//		List<Post> resultList = query.getResultList();

//		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Post> query = builder.createQuery(Post.class); // result type
//		Root<Post> from = query.from(Post.class); //query 작성 class
//		query.select(from);
//		
//		List<Post> resultList = entityManager.createQuery(query).getResultList();
//		resultList.forEach(System.out::println);

		List<Post> posts = entityManager.createNativeQuery("SELECT * FROM POST", Post.class).getResultList();
		posts.forEach(p -> {
			System.out.println(p);
		});
	}
}
