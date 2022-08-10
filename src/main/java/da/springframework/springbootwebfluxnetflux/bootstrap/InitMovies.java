package da.springframework.springbootwebfluxnetflux.bootstrap;

import da.springframework.springbootwebfluxnetflux.domain.Movie;
import da.springframework.springbootwebfluxnetflux.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Component
public class InitMovies implements CommandLineRunner {

    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll()
                .thenMany(Flux.just("Lord of the Rings", "Aeon Flux", "Back to the Future", "Silence of the lambs",
                                "The Terminator", "Predator", "Enter the Matrix")
                        .map(Movie::new)
                        .flatMap(movieRepository::save) // movie -> movieRepository.save(movie)
                ).subscribe(null, null, () -> movieRepository.findAll().subscribe(System.out::println));
    }
}
