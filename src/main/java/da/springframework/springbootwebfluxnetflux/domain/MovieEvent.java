package da.springframework.springbootwebfluxnetflux.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class MovieEvent {

    private String movieId;

    private Date movieDate;
}
