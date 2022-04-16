package se4.tetris.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item extends BaseEntity {

    @Column
    private String name;

    @Column
    private int score;

    @Builder
    public Item(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
