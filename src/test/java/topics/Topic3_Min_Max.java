package topics;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;

import java.util.Comparator;
import java.util.List;
import org.junit.Test;

public class Topic3_Min_Max {

  @Test
  public void min() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
    // Find the minimum number
//    Integer result = numbers.stream()
//            .min((number1, number2) -> number1>number2?1:-1)
//            .get();
    Integer result = numbers.stream()
            .min(Comparator.naturalOrder())
            .get();
    System.out.println(result);
  }

  @Test
  public void max() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
    Integer result = numbers.stream()
            .max(Comparator.naturalOrder())
            .get();
    System.out.println(result);
  }
}
