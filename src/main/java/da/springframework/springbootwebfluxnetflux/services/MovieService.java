package da.springframework.springbootwebfluxnetflux.services;

import da.springframework.springbootwebfluxnetflux.domain.Movie;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {

    Mono<Movie> getMovieById(String id);

    Flux<Movie> getAllMovies();
}
