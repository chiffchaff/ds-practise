package com.sumit.ds.recursion.practise;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
@DisplayName("Should pass the method parameters provided by the @CsvSource annotation")
public class BunnyEars2 {
    public int bunnyEars2(int bunnies) {
        if(bunnies == 0)
            return 0;
        if(bunnies%2==0){
            return 3+bunnyEars2(bunnies-1);
        }
        else{
            return 2+bunnyEars2(bunnies-1);
        }
    }

    @DisplayName("Should provide the count of bunny ears")
    @ParameterizedTest
    @CsvSource({"0",
            "1",
            "2",
            "3"
    })
    public void testBunnies(int n){
        BunnyEars2 bunnyEars2 = new BunnyEars2();
        System.out.println(bunnyEars2.bunnyEars2(n));
    }
}
