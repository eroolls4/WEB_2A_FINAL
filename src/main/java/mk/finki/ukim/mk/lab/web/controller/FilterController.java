package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Movie;
import mk.finki.ukim.mk.lab.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/filter")
public class FilterController {

    private final MovieService movieService;

    public FilterController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public String filterMovies(
            @RequestParam String textFilter,
            @RequestParam double ratingFilter,
            Model model) {
        List<Movie> filteredMovies = movieService.searchMovies(textFilter, String.valueOf(ratingFilter));
        model.addAttribute("movies", filteredMovies);
        return "listMovies"; // Return the name of the HTML template for the filtered movie list
    }
}
