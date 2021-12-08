package com.hmcdat.quanlysinhivien.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public
class ScoreDto {
    private long id;
    private int subjectId;
    private int semester;
    private int firstScore;
    private int lastScore;
}
