package se4.tetris.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se4.tetris.dto.ResponseDTO;
import se4.tetris.dto.response.NormalTopTen;
import se4.tetris.service.ScoreService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ScoreController {

    private final ScoreService scoreService;

    @GetMapping("/normal/score")
    public ResponseEntity<ResponseDTO> getNormalScore() {

        List<NormalTopTen> normalTopTen = scoreService.getNormalScore();

        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseDTO.builder()
                        .status(200)
                        .message("일반모드 스코어보드")
                        .data(normalTopTen)
                        .build()
        );
    }
}
