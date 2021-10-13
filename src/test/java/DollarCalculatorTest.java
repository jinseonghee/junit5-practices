import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) //mocking 처리 = 특정 객체가 어떤 메셔드가 호출 되었을 때 원하는 결과 값을 return 시켜줌
public class DollarCalculatorTest {

    @Mock // Mock을 붙여 가짜 객체를 진짜 객체처럼 사용
    public MarketApi marketApi;


    @BeforeEach //Test 하기 전에 먼저 돔
    public void init() {
        Mockito.lenient().when(marketApi.connect()).thenReturn(3000); //stubbing 하여 원래 값을 조작하여 return 값을 3000으로 바꿔줌.
        //when(marketApi.connect()).thenReturn(3000);
    }

    @DisplayName("assertNull 사용하기")
    @Test
    public void testHello() {
         System.out.println("hello");
         MarketApi nullTestMarketApi = null;
         assertNull(nullTestMarketApi);
     }

     @DisplayName("stubbing의 여러 형태 Test")
     @Test
     void mockStubbingTest() {
        when(marketApi.println()).thenReturn("가나다라");
        //assertNotEquals("진성희", marketApi.println(), (String) null);
        //assertEquals("진성희2", marketApi.println(), "실패했습니다");
        //Assertions.assertThrows(RuntimeException.class, () -> marketApi.println());
        //lenient().when(marketApi.println()).thenAnswer(invocation -> invocation.callRealMethod());
     }


     @Test
    public void dollarTest() {

        MarketApi marketApi = new MarketApi();
        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();

         Calculator calculator = new Calculator(dollarCalculator);
         //System.out.println(calculator.sum(10, 10));
         Assertions.assertEquals(22000, calculator.sum(10, 10));
         Assertions.assertEquals(0, calculator.minus(10, 10));
     }

    @Test
    public void mockTest() {

        DollarCalculator dollarCalculator = new DollarCalculator(marketApi); //mocking 처리한 marketApi를 넣어줌
        dollarCalculator.init();

        Calculator calculator = new Calculator(dollarCalculator);
        System.out.println(calculator.sum(10, 10));
        Assertions.assertEquals(60000, calculator.sum(10, 10));
        Assertions.assertEquals(0, calculator.minus(10, 10));
    }
}
