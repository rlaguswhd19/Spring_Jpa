package hj.springboot.jpa;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;


@NoRepositoryBean
public interface MyRepository<T, Id extends Serializable> extends Repository<T, Id>{
	<E extends T> E save(@NonNull E entity);
	List<T> findAll();
	long count();
	
	@Nullable //리턴 값
	<E extends T> E findById(Id id); //파라미터 값
}
