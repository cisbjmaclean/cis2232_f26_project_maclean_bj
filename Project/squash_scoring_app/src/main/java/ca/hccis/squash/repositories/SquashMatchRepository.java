package ca.hccis.squash.repositories;

import ca.hccis.squash.jpa.entity.SquashMatch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SquashMatchRepository extends CrudRepository<SquashMatch, Integer> {
}