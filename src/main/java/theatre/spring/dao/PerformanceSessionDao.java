package theatre.spring.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import theatre.spring.model.PerformanceSession;

public interface PerformanceSessionDao {
    PerformanceSession add(PerformanceSession movieSession);

    Optional<PerformanceSession> get(Long id);

    List<PerformanceSession> findAvailableSessions(Long movieId, LocalDate date);

    PerformanceSession update(PerformanceSession movieSession);

    void delete(Long id);
}
