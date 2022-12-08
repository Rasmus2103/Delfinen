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
     void calculateSupsriptionPassivt() {
         //Arrange
        int expectedPrice = 425;
        int expectedAge = 17;
        member.setMemberAge(expectedAge);
        member.setMembership("passivt");
        member.setisStudying(true);

        //Act
        int result = member.calculateSubsription();

        //Arrange
        assertEquals(expectedPrice, result);
     }

     @Test
     void calculateSubsriptionStudent() {
         int expectedPrice = 1360;
         int expectedAge = 19;
         member.setMemberAge(expectedAge);
         member.setMembership("aktivt");
         member.setisStudying(true);

         int result = member.calculateSubsription();

         assertEquals(expectedPrice, result);
     }

     @Test
     void calculateSubsriptionUnder18() {
         int expectedPrice = 1000;
         int expectedAge = 17;
         member.setMemberAge(expectedAge);
         member.setMembership("aktivt");
         member.setisStudying(false);

         int result = member.calculateSubsription();

         assertEquals(expectedPrice, result);
     }

     @Test
     void calculateSubsriptionOver18() {
         int expectedPrice = 1600;
         int expectedAge = 20;
         member.setMemberAge(expectedAge);
         member.setMembership("aktivt");
         member.setisStudying(false);

         int result = member.calculateSubsription();

         assertEquals(expectedPrice, result);
     }

}
