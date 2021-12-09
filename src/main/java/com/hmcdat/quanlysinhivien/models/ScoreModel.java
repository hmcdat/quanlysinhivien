package com.hmcdat.quanlysinhivien.models;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "scores")
public class ScoreModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private long id;

    @Column(name = "student_id")
    @NotNull
    private long studentId;

    @Column(name = "department_id")
    private long departmentId;

    @Column(name = "class_id")
    private long classId;

    @Column(name = "subject_id")
    private long subjectId;

    @Column(name = "semester")
    private int semester;

    @Column(name = "first_score")
    private int firstScore;

    @Column(name = "last_score")
    private int lastScore;
}
