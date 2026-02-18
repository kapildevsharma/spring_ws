package io.javabrains.movieinfoservice.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.javabrains.movieinfoservice.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;
    
    private static List<Movie> moviesRepo = new ArrayList<Movie>();
    static {
    	Movie honey = new Movie("1", "Honey", "Honey movies");
	      moviesRepo.add(honey);
	      
	      Movie almond = new Movie("2","Almond","Almond moveis");
	      moviesRepo.add(almond);
	   }
    
    
    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		/*
		 * MovieSummary movieSummary =
		 * restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId +
		 * "?api_key=" + apiKey, MovieSummary.class); return new Movie(movieId,
		 * movieSummary.getTitle(), movieSummary.getOverview());
		 */
    	Movie movie = moviesRepo.stream().filter(e-> e.getMovieId().equals(movieId)).findFirst().orElse(new Movie("10","TEST","TEST DEscription"));
    	 return movie;

    }

}
