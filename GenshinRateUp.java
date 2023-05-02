import java.util.Random;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;


public class GenshinRateUp {
    public static void main(String[] args) throws IOException{
        Random rand = new Random();
        double deviation = 2.5;
        double ssr_rate;
        int count;
        int results[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        FileWriter myWriter = new FileWriter("GenshinRealOutput.txt");


        for (int i = 0; i <= 1200000; i++){
            ssr_rate = 0.006;
            count = 0;
            int soft_pity = 74;
            int hard_pity = 16 + soft_pity;
            while (count <= hard_pity){
                count++;
                if (count >= soft_pity){
                    ssr_rate = ssr_rate + 0.06;
                }
                if (count == hard_pity) {
                    results[hard_pity]++;
                    break;
                };
                double roll = rand.nextDouble();
                if (roll <= ssr_rate){
                    results[count]++;
                    break;
                }
            }

        }


        for (int output = 0; output < results.length; output++){
            myWriter.write(String.valueOf(results[output]));
            myWriter.write(",");
        }

        myWriter.close();
    }
}