package org.choi.restapi.todolists;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

//롬복 에노테이션은 메타에노테이션으로 동작하지 못한다. -> 줄일 방법이 없다.
@Getter @Setter @EqualsAndHashCode(of="id")
@Builder @NoArgsConstructor @AllArgsConstructor
@Entity
public class Todolist {

    //TODO ID,GeneratedValue가 뭔지 알아보기
    @Id @GeneratedValue
    private Long id;

    private String name;
    private String content;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    //Ordinal은 순서에 따라서 1,2,3 숫자가 저장이 됌 따라서 순서가 바뀌면 데이터가 꼬일수 있음 따라서 String을 사용하는게 더 좋음
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private TodoPriority todoPriority = TodoPriority.MIDDLE ;


}
