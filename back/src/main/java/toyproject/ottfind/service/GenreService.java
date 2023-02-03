package toyproject.ottfind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import toyproject.ottfind.domain.Genre;
import toyproject.ottfind.domain.User;
import toyproject.ottfind.repository.GenreRepository;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    public void validateDuplicateGenre(Genre genre){
        genreRepository.findByGenrename(genre.getName())
                .ifPresent(u -> {
                    throw new IllegalStateException("이미 존재하는 genre입니다");
                });
    }

    public Integer save(Genre genre) {
        validateDuplicateGenre(genre);
        genreRepository.save(genre);
        return genre.getId();
    }

    public Genre getGenreByname(String name){
        Genre genre = genreRepository.findByGenrename(name).orElseThrow(() -> new IllegalStateException("없는 genre 입니다"));
        return genre;
    }
}
