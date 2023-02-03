package toyproject.ottfind.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import toyproject.ottfind.domain.Genre;
import toyproject.ottfind.domain.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Component
public class JpaGenreRepository implements GenreRepository{
    private final EntityManager em;

    @Autowired
    public JpaGenreRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public Genre save(Genre genre) {
        em.persist(genre);
        return genre;
    }

    @Override
    public Optional<Genre> findById(Integer id) {
        Genre genre = em.find(Genre.class, id);
        return Optional.ofNullable(genre);
    }

    @Override
    public List<Genre> findAll() {
        return em.createQuery("select g from genre g", Genre.class).getResultList();
    }

    @Override
    public Optional<Genre> findByGenrename(String name) {
        List<Genre> result = em.createQuery("select g from genre g where g.name=:name", Genre.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }
}
