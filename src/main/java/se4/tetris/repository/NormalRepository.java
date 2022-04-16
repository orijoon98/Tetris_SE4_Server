package se4.tetris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se4.tetris.domain.Normal;

import java.util.List;

public interface NormalRepository extends JpaRepository<Normal, Long> {

    public List<Normal> findTop10ByOrderByScoreDesc();
}
