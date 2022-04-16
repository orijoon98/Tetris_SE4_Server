package se4.tetris.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se4.tetris.dto.ResponseDTO;
import se4.tetris.dto.request.ItemAdd;
import se4.tetris.dto.request.NormalAdd;
import se4.tetris.dto.response.ItemTopTen;
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

    @GetMapping("/item/score")
    public ResponseEntity<ResponseDTO> getItemScore() {

        List<ItemTopTen> itemTopTen = scoreService.getItemScore();

        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseDTO.builder()
                        .status(200)
                        .message("아이템모드 스코어보드")
                        .data(itemTopTen)
                        .build()
        );
    }

    @PostMapping("/normal")
    public ResponseEntity<ResponseDTO> addNormal(@RequestBody NormalAdd normalAdd) {

        scoreService.addNormal(normalAdd.getName(), normalAdd.getScore());

        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseDTO.builder()
                        .status(200)
                        .message("일반모드 추가 성공")
                        .data(null)
                        .build()
        );
    }

    @PostMapping("/item")
    public ResponseEntity<ResponseDTO> addItem(@RequestBody ItemAdd itemAdd) {

        scoreService.addItem(itemAdd.getName(), itemAdd.getScore());

        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseDTO.builder()
                        .status(200)
                        .message("아이템모드 추가 성공")
                        .data(null)
                        .build()
        );
    }
}
