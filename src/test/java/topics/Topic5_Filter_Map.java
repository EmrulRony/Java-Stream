package topics;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.junit.Test;

public class Topic5_Filter_Map {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    List<Car> cheapCars = cars.stream()
            .filter(car -> car.getPrice() < 10000)
            .collect(Collectors.toList());
    cheapCars.forEach(System.out::println);
  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();
    List<PersonDTO> personDTOS = people.stream()
            .map(person -> {
              PersonDTO personDTO = new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
              return personDTO;
            })
            .limit(20)
            .collect(Collectors.toList());
    personDTOS.forEach(System.out::println);
  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    ImmutableList<Car> cars = MockData.getCars();
    double averageCarPrice = cars.stream()
            .mapToDouble(Car::getPrice) // Car::getPrice === car -> car.getPrice()
            .average()
            .orElse(0);
    System.out.println(averageCarPrice);
  }

  @Test
  public void test() throws Exception {

  }
}



