package guru.springframework.spring5webapp.dao;

import guru.springframework.spring5webapp.entity.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
