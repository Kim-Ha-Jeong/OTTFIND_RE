package toyproject.ottfind.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import toyproject.ottfind.domain.Film;
import toyproject.ottfind.repository.FilmInterface;

import java.util.List;

@Service
public class FilmService {
    private final FilmInterface filmRepository;

    @Autowired
    public FilmService(FilmInterface filmRepository){
        this.filmRepository = filmRepository;
    }
    public void validateDuplicateFilm(Film film){
        List<Film> result = filmRepository.findByTitle(film.getTitle());
        System.out.println("result = " + result);
        if(result.size() == 0) return;

        for(Film data : result){
            if(film.getDirector().equals(data.getDirector())){
                throw new IllegalStateException("이미 존재하는 영화/드라마입니다");
            }
        }
    }

    public Integer saveFilm(Film film){
        validateDuplicateFilm(film);
        filmRepository.save(film);
        return film.getId();
    }

    public List<Film> getAllFilms(){
        return filmRepository.findAll();
    }

    public List<Film> findFilmByTitle(String title){
        return filmRepository.findByTitle(title);
    }
}
