public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0, tenners = 0, twenties = 0;
        for (int i = 0 ; i < bills.length && fives >= 0 && tenners >= 0 && twenties >= 0 ; i++) {
            if (bills[i] == 20) {
                if (tenners > 0) {
                    tenners--;
                    fives--;
                } else {
                    fives -= 3;
                }
                twenties++;
            } else if (bills[i] == 10) {
                fives--;
                tenners++;
            } else fives++;
        }
        return fives >=0 && tenners >= 0 && twenties >= 0;
    }
}
