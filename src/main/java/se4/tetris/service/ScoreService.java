package se4.tetris.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se4.tetris.domain.Item;
import se4.tetris.domain.Normal;
import se4.tetris.dto.response.ItemTopTen;
import se4.tetris.dto.response.NormalTopTen;
import se4.tetris.repository.ItemRepository;
import se4.tetris.repository.NormalRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreService {

    private final NormalRepository normalRepository;
    private final ItemRepository itemRepository;

    public List<NormalTopTen> getNormalScore() {
        List<NormalTopTen> normalTopTenList = new ArrayList<>();

        List<Normal> normalTopTen = normalRepository.findTop10ByOrderByScoreDesc();

        for (int i = 0; i < normalTopTen.size(); i++) {
            NormalTopTen tmp = new NormalTopTen();
            tmp.setName(normalTopTen.get(i).getName());
            tmp.setScore(normalTopTen.get(i).getScore());
            normalTopTenList.add(tmp);
        }

        return normalTopTenList;
    }

    public List<ItemTopTen> getItemScore() {
        List<ItemTopTen> itemTopTenList = new ArrayList<>();

        List<Item> itemTopTen = itemRepository.findTop10ByOrderByScoreDesc();

        for (int i = 0; i < itemTopTen.size(); i++) {
            ItemTopTen tmp = new ItemTopTen();
            tmp.setName(itemTopTen.get(i).getName());
            tmp.setScore(itemTopTen.get(i).getScore());
            itemTopTenList.add(tmp);
        }

        return itemTopTenList;
    }
}
