package org.choi.restapi.todolists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder @Data @AllArgsConstructor @NoArgsConstructor
public class TodolistDTO {

    @NotEmpty
    private String name;
    @NotEmpty
    private String content;
    @NotNull
    private LocalDateTime startDate;
    @NotNull
    private LocalDateTime endDate;
    //Ordinal은 순서에 따라서 1,2,3 숫자가 저장이 됌 따라서 순서가 바뀌면 데이터가 꼬일수 있음 따라서 String을 사용하는게 더 좋음
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private TodoPriority todoPriority = TodoPriority.MIDDLE;
}
