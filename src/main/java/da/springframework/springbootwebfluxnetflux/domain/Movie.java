package da.springframework.springbootwebfluxnetflux.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Movie {

    private String id;

    @NonNull
    private String title;
}
