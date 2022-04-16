package se4.tetris.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se4.tetris.domain.Normal;
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
}
