package macicame.org.springbootdemo.service.base;

import macicame.org.springbootdemo.model.base.Identifiable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudService<T extends Identifiable> extends CrudRepository<T, Long> {

}
