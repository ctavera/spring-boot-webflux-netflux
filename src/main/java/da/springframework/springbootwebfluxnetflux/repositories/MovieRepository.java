package da.springframework.springbootwebfluxnetflux.repositories;

import da.springframework.springbootwebfluxnetflux.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
}
