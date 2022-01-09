package carl.jpamkshop.repository;

import carl.jpamkshop.constant.ItemSellStatus;
import carl.jpamkshop.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 통합 테스트를 위해 스프링부트에서 적용하는 어노테이션 실제 구동처럼 BEAN을 IOC 컨테이너에 등록함.
@TestPropertySource(locations = "classpath:application-test.properties")
// 테스트용 application properties 주소를 입력해줘야지 그렇지 않으면 application.properties를 사용함
class ItemRepositoryTest {

    @Autowired
    // 오토와이어 어노테이션으로 bean을 주입해줘야 itemRepository 사용할 수 있음.
    // Spring IOC 컨테이너가 관리하는 자바 객체를 BEAN이라 부름.
    // 자바에서는 CLASS 생성하고 NEW를 입력하여 객체를 생성했었지만
    // SPRING에서는 NEW 생성 객체가 아니라 SPRING에 의하여 관리하는 자바 객체 사용함.
    // BEAN 주입 방법 1. autowired 같은 자바 어노테이션, 2. Bean Configuration File에 직접 등록
    ItemRepository itemRepository;

    @Test // 테스트할 메소드 위에 선언하여 메소드를 테스트 대상으로 지정함
    @DisplayName("상품 저장 테스트")
    public void creatItemList(){ // 테스트용 상품테스터가 없어 for문으로 10개를 생성해줌.
        for(int i = 1; i <= 10; i++) {
        Item item = new Item();
        item.setItemNm("테스트 상품" + i);
        item.setPrice(10000 + i);
        item.setItemDetail("상세설명" + i);
        item.setItemSellStatus(ItemSellStatus.SELL) ;
        item.setStockNumber(100);
        item.setRegTime(LocalDateTime.now());
        item.setUpdateTime(LocalDateTime.now());
        Item saveItem = itemRepository.save(item);
        System.out.println(saveItem.toString());
    }
}

    @Test
    @DisplayName("상품명 조회 테스트") // 조회기능
    public void findByItemNmTest(){
        this.creatItemList();
        List<Item> itemList = itemRepository.findByItemNm("테스트 상품1");
        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }
}