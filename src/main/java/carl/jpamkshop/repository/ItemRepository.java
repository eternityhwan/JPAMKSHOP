package carl.jpamkshop.repository;

import carl.jpamkshop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

    // 레파지토리 클래스 - 엔티티 매니저를 안쓰는 대신 DAO(Data Access Object) 만들어줘야하는데
    // 그 역할을 하는게 레파지토리 클래스이다.

public interface ItemRepository extends JpaRepository<Item, Long> {
    // Item 테이블을 사용한다는 뜻임
    // primary key 이야기 해주는 이유,
    // 스프링은 pk로 하는게 오지게 많아서 지정해줌.
    //스프링이 커피추출기면 나는 원두만 넣으면되는거.
    // repository 는 crud 를 해줄 수 있게 해주는거.

    List<Item> findByItemNm(String itemNm);
    // Item 클래스에 itemNm 상품명으로 데이터를 조회하는 메소드를 지정해놓음.
    // find + (엔티티 이름) + By + 변수이름름
    // itemNm(상품명)으로 데이터를 조회하기 위해 By 뒤 필드명 ItemNm으로 메소드 이름 붙임
}
