package com.study.springboot.restrant;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.restaurant.entity.Menu;
import com.study.springboot.restaurant.entity.Restaurant;
import com.study.springboot.restaurant.repository.MenuRepository;
import com.study.springboot.restaurant.repository.RestaurantRepository;

@SpringBootTest
public class RestrountTest {

	@Autowired
	private RestaurantRepository restauranteRepository;
	
	@Autowired
	private MenuRepository menuRepository;

@Test
public void testRestaurantAndMenu() {
    // 레스토랑 생성
    Restaurant restaurant = new Restaurant();
    restaurant.setName("맛있는 한식당");
    restaurant.setAddress("서울시 강남구 테헤란로 123");
    restaurant.setPhoneNumber("02-1234-5678");
    restaurant.setDescription("전통 한식과 현대적 감각이 조화를 이룬 레스토랑");

    
    Restaurant savedRestaurant = restauranteRepository.save(restaurant);
    
    // 메뉴 1 생성
    Menu menu1 = new Menu();
    menu1.setName("불고기");
    menu1.setPrice(15000);
    menu1.setRestaurant(savedRestaurant);
    
    // 메뉴 2 생성
    Menu menu2 = new Menu();
    menu2.setName("김치찌개");
    menu2.setPrice(12000);
    menu2.setRestaurant(savedRestaurant);
    
    // 메뉴 3 생성
    Menu menu3 = new Menu();
    menu3.setName("비빔밥");
    menu3.setPrice(13000);
    menu3.setRestaurant(savedRestaurant);
    
    // 메뉴 저장
    menuRepository.save(menu1);
    menuRepository.save(menu2);
    menuRepository.save(menu3);
    
    System.out.println("레스토랑과 메뉴가 성공적으로 저장되었습니다.");
    System.out.println("레스토랑: " + savedRestaurant.getName());
    
}
	
	
}
