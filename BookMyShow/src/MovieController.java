import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<City, List<Movie>> cityMoviesMap;
    List<Movie> allMovies;

    MovieController(){
        cityMoviesMap = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    void addMovie(Movie movie, City city){
        allMovies.add(movie);
        List<Movie> movies = cityMoviesMap.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityMoviesMap.put(city, movies);
    }

    Movie getMovieByName(String movieName){
        for(Movie movie: allMovies){
            if((movie.getMovieName()).equals(movieName)){
                return movie;
            }
        }
        return null;
    }

    List<Movie> getMoviesByCity(City city){
        return cityMoviesMap.get(city);
    }
}
