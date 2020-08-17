import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<String>();

        for(int i = 0 ; i < 12 ; i++){
            for(int j=0 ; j < 60 ; j++){
                int total = countDigits(i) + countDigits(j);
                if(total == num){
                    StringBuilder time = new StringBuilder();
                    time.append(i)
                            .append(":")
                            .append(j < 10 ? 0 : "")
                            .append(j);

                    result.add(time.toString());
                }
            }
        }

        return result;
    }

    public int countDigits(int num){
        int result = 0;

        while(num > 0){
            if((num & 1) == 1){
                result++;
            }

            num >>= 1;
        }

        return result;
    }
}
