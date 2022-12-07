import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

 class KontigentTest {
     Member member;

     @BeforeEach
     void setUp() {
        member = new Member();
     }

     @Test
     void calculateSupsription() {
         //Arrange
        int expectedPrice = 1000;
        int expectedAge = 18;

        int result = member.calculateSubsription();

        assertEquals(expectedAge, result, expectedPrice);

     }

}
