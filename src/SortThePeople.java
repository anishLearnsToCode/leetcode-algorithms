// https://leetcode.com/problems/sort-the-people
// T: O(n + nlogn)
// S: O(n)

import java.util.ArrayList;
import java.util.List;

public class SortThePeople {
    private record Person(String name, int height) {}

    public String[] sortPeople(String[] names, int[] heights) {
        final List<Person> people = getPeople(names, heights);
        people.sort((a, b) ->  Integer.compare(b.height, a.height));
        return toNameArray(people);
    }

    private String[] toNameArray(List<Person> people) {
        final String[] names = new String[people.size()];
        int k = 0;
        for (Person person : people) {
            names[k++] = person.name;
        }
        return names;
    }

    private List<Person> getPeople(String[] names, int[] heights) {
        final List<Person> people = new ArrayList<>();
        for (int i = 0 ; i < names.length ; i++) {
            people.add(new Person(names[i], heights[i]));
        }
        return people;
    }
}
