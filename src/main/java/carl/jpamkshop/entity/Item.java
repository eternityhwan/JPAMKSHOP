package carl.jpamkshop.entity;


import carl.jpamkshop.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity // 엔티티 테이블로 DBMS에 TABLE, COLUMN 까지 생성됨 대신 CRUD기능은 안됨.
@Table(name="item") // DBMS 테이블 이름이 item임임
public class Item {

    @Id
    @Column(name="item_id") // DBMS에 등록된 컬럼 이름은 item_id임
    @GeneratedValue(strategy = GenerationType.AUTO) // JPA 구현체가 자동으로 생성 전략
    private Long id; // 상품 코드

    @Column(nullable = false, length = 50)
    // nullabe = false로 맞추면 ddl 생성 시에 not null 제약조건 추가
    private String itemNm; // 상품명

    @Column(name = "price", nullable = false)
    private int price; // 가격

    @Column(nullable = false)
    private int stockNumber; // 재고수량

    @Lob // BLOB, CLOB 타입 매핑
    // CLOB 사이즈가 큰 데이터를 외부 파일로 저장하기 위한 데이터 타입
    // BLOB 바이너리 데이터를 DB 외부에 저장하기 위한 타입. 멀티미디어 데이터 다룰 때 사용
    // 상품설명에 그림 넣고 하니 큰 데이터 파일을 넣는거임.
    @Column(nullable = false)
    private String itemDetail; // 상품 상세 설명명

    @Enumerated(EnumType.STRING) // enum 타입 매핑
    private ItemSellStatus itemSellStatus; // 상품 판매 상태

    private LocalDateTime regTime; // 등록 시간

    private LocalDateTime updateTime; // 수정 시간
}
