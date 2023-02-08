package toyproject.ottfind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import toyproject.ottfind.domain.Film;
import toyproject.ottfind.service.FilmService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("/film")
    public List<Film> getAllFilms(){
        return filmService.getAllFilms();
    }

    @RequestMapping(value = "/film", params = "title")
    public List<Film> findByTitle(@RequestParam String title){
        return filmService.findFilmByTitle(title);
    }
}
