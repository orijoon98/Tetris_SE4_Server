package se4.tetris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se4.tetris.domain.Item;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    public List<Item> findTop10ByOrderByScoreDesc();
}
