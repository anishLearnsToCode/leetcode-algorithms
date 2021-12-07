public class DefangingAnIPAddress {
    public String defangIPaddr(String address) {
        StringBuilder result = new StringBuilder();
        for (int i = 0 ; i < address.length() ; i++) {
            result.append(address.charAt(i) == '.' ? "[.]" : address.charAt(i));
        }
        return result.toString();
    }
}
