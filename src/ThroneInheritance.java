// https://leetcode.com/problems/throne-inheritance
// N = people in royal family
// birth() T: O(1)
// death() T: O(1)
// getInheritanceOrder T: O(N)
// S: O(N)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThroneInheritance {
    private static final class Person {
        private final String name;
        private boolean isAlive = true;
        private final List<Person> children = new ArrayList<>();

        Person(String name) {
            this.name = name;
        }

        void markDead() {
            this.isAlive = false;
        }

        void addChild(Person child) {
            this.children.add(child);
        }
    }

    private final Map<String, Person> royalFamily = new HashMap<>();
    private final Person king;

    public ThroneInheritance(String kingName) {
        king = new Person(kingName);
        royalFamily.put(kingName, king);
    }

    public void birth(String parentName, String childName) {
        Person child = new Person(childName);
        royalFamily.put(childName, child);
        royalFamily.get(parentName).addChild(child);
    }

    public void death(String name) {
        royalFamily.get(name).markDead();
    }

    public List<String> getInheritanceOrder() {
        final List<String> names = new ArrayList<>();
        getInheritanceOrder(king, names);
        return names;
    }

    public void getInheritanceOrder(Person person, List<String> names) {
        if (person == null) return;
        if (person.isAlive) names.add(person.name);
        for (Person child : person.children) {
            getInheritanceOrder(child, names);
        }
    }
}
