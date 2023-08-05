import java.util.Random;

public class Check {
    public int Verify(int number){
        int result=0;
        int ans=0;

        // LOGIC BEHIND RANDOM No. GENERATION

        Random random = new Random();
        result = random.nextInt(100);
        ans = result;

        if (number == result){
            return ans;
        }

        return ans;
    }

//    public static void main(String[] args) {
//
//        System.out.println(Verify(32));
//    }
}
