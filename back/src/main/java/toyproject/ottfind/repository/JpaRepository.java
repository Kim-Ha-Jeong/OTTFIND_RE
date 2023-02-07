package toyproject.ottfind.repository;

import java.util.List;
import java.util.Optional;

public interface JpaRepository<T> {
    T save(T data);
    Optional<T> findById(Integer id);
    List<T> findAll();
}
