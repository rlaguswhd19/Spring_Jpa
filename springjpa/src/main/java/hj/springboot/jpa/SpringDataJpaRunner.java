package hj.springboot.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class SpringDataJpaRunner implements ApplicationRunner{
	
	@Autowired
	PostRepository postRepository;

	@Autowired
	Hyeonjong hyeonjong;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		postRepository.findAll().forEach(p ->{
			System.out.println(p);
		});;
		
		System.out.println(hyeonjong.getName());
	}
	
	
}
