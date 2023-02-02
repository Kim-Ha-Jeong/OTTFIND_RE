package toyproject.ottfind.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import toyproject.ottfind.domain.Film;
import toyproject.ottfind.domain.Genre;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Component
public class JpaFilmRepository implements FilmRepository{

    private final EntityManager em;

    @Autowired
    public JpaFilmRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public List<Film> findByTitle(String title) {
        List<Film> result = em.createQuery("select f from film f where f.title=:title", Film.class)
                .setParameter("title", title)
                .getResultList();

        return result;
    }

    @Override
    public Optional<Film> findByYear(int year) {
        return Optional.empty();
    }

    @Override
    public Optional<Film> findByGenre(Genre genre) {
        return Optional.empty();
    }

    @Override
    public Optional<Film> findByCountry(String country) {
        return Optional.empty();
    }

    @Override
    public Film save(Film film) {
        em.persist(film);
        return film;
    }

    @Override
    public Optional<Film> findById(Integer id) {
        Film film = em.find(Film.class, id);
        return Optional.ofNullable(film);
    }

    @Override
    public List<Film> findAll() {
        return em.createQuery("select f from film f", Film.class).getResultList();
    }
}
