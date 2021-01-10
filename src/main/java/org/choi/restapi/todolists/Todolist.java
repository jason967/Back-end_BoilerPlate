package org.choi.restapi.todolists;

import lombok.*;

import java.time.LocalDateTime;

//롬복 에노테이션은 메타에노테이션으로 동작하지 못한다. -> 줄일 방법이 없다.
@Getter @Setter @EqualsAndHashCode(of="id")
@Builder @NoArgsConstructor @AllArgsConstructor
public class Todolist {

    private Long id;

    private String name;
    private String content;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private TodoPriority todoPriority ;


}
