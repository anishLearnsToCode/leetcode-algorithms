import java.util.Arrays;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        String[] groups = S.split("-");
        String characters = String.join("", groups).toUpperCase();

        StringBuilder result = new StringBuilder();
        for (int index = characters.length() - 1, counter = 0 ; index >= 0 ; index--, counter++) {
            if (counter % K == 0 && counter != 0) {
                result.append('-');
            }
            result.append(characters.charAt(index));
        }

        return result.reverse().toString();
    }
}
