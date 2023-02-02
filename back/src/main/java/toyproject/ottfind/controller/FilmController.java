package toyproject.ottfind.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import toyproject.ottfind.service.FilmService;

@RestController
@RequestMapping("/api")
public class FilmController {
    private FilmService filmService;

    @GetMapping("/film")
    public List<Film>
}
