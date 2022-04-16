package se4.tetris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se4.tetris.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
