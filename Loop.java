import java.util.Random;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;


public class Loop {
    public static void main(String[] args) throws IOException{
        Random rand = new Random();
        double deviation = 2.5;
        double ssr_rate = 0.006;
        int count;
        int results[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        FileWriter myWriter = new FileWriter("GenshinOutput.txt");


        for (int i = 0; i <= 1200000; i++){
            count = 0;
            int soft_pity = (int)Math.round(rand.nextGaussian() * deviation);
            while (soft_pity <= -4){
                soft_pity = (int)Math.round(rand.nextGaussian() * deviation);
            }
            int hard_pity = 77 + soft_pity;
            if (hard_pity > 90) {
                hard_pity = 90;
            }
            while (count <= hard_pity){
                count++;
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