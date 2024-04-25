import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    Map<City, List<Theatre>> cityTheatreMap;
    List<Theatre> theatres;

    TheatreController(){
        cityTheatreMap = new HashMap<>();
        theatres = new ArrayList<>();
    }

    void addTheatre(Theatre theatre, City city){
        theatres.add(theatre);
        List<Theatre>  theaterInCity = cityTheatreMap.getOrDefault(city, new ArrayList<>());
        theaterInCity.add(theatre);
        cityTheatreMap.put(city, theaterInCity);
    }

    Map<Theatre, List<Show>> getAllShow(Movie movie, City city){
        Map<Theatre, List<Show>> theatreShowsMap = new HashMap<>();
        List<Theatre> theatresInCity = cityTheatreMap.get(city);

        for(Theatre theatre: theatresInCity){
            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = theatre.getShows();

            for(Show show: shows){
                if(show.movie.getMovieId() == movie.getMovieId()){
                    givenMovieShows.add(show);
                }
            }
            if(!givenMovieShows.isEmpty()){
                theatreShowsMap.put(theatre, givenMovieShows);
            }
        }
        return theatreShowsMap;
    }
}
