import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String emailAddress : emails) {
            uniqueEmails.add(getActualEmailAddress(emailAddress));
        }
        return uniqueEmails.size();
    }

    private static String getActualEmailAddress(String email) {
        StringBuilder result = new StringBuilder();
        for (int index = 0 ; index < email.length() ; index++) {
            if (email.charAt(index) == '+') {
                while (email.charAt(index) != '@') index++;
                result.append(email.substring(index));
                break;
            } else if (email.charAt(index) == '@') {
                result.append(email.substring(index));
                break;
            } else if (email.charAt(index) != '.') result.append(email.charAt(index));
        }
        return result.toString();
    }
}
