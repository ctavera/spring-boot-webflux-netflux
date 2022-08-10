package da.springframework.springbootwebfluxnetflux.services;

import da.springframework.springbootwebfluxnetflux.domain.Movie;
import da.springframework.springbootwebfluxnetflux.domain.MovieEvent;
import da.springframework.springbootwebfluxnetflux.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Mono<Movie> getMovieById(String id) {
        return movieRepository.findById(id);
    }

    @Override
    public Flux<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Flux<MovieEvent> streamMovieEvents(String id) {
        return Flux.<MovieEvent>generate(movieEventSynchronousSink -> movieEventSynchronousSink.next(new MovieEvent(id, new Date())))
                .delayElements(Duration.ofSeconds(1)); //emit new MovieEvent every second
    }
}
