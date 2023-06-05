package streams.supplementary;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MoreExamplesUsingPerson {
    public static void main(String[] args) {
        
    }

	public static List<Person> getAdults(List<Person> list) {
		return list.stream().filter(person -> person.getAge() > 17).collect(Collectors.toList());
	}

	// collectors: groupingBy
	public static Map<String, List<Person>> groupByGender(List<Person> list) {
		// applies a function/method to a given argument
		return list.stream().collect(Collectors.groupingBy(Person::getGender));
	}
}
