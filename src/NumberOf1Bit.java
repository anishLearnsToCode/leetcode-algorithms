public class NumberOf1Bit {
    public int hammingWeight(int n) {
        if (n==0) return 0;
        int count = 0;

        //revert first bit if it's 1 to make the number positive
        int pos_n = (n>0) ? n : n^(1<<31);

        for(int i=1 ; i > 0 && i <= pos_n ; i = i << 1) {
            if ((i ^ n) < n) {
                count++;
            }
        }

        return count + (n > 0 ? 0 : 1);
    }
}
