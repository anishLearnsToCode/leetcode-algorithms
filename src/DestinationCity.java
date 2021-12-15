import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        final Set<String> cities = new HashSet<>();
        final Set<String> departureCities = new HashSet<>();
        for (List<String> path : paths) {
            cities.add(path.get(0));
            cities.add(path.get(1));
            departureCities.add(path.get(0));
        }
        for (String city : cities) {
            if (!departureCities.contains(city)) return city;
        }
        return null;
    }
}
