import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Trasaction {
  
   public static void main(String[] args){
       File file = new File("points.txt");
       Scanner sc = null;
       try{
           sc = new Scanner(file);
       }catch(FileNotFoundException f){
           System.out.println("File not found!");
       }
       Map<String,Integer> customerRewardMap = new HashMap<String,Integer>();
       int totalReward = 0;
       int counter = 0;
       while(sc.hasNext()){
           counter++;
           if(counter ==1) { 
               sc.next();
               sc.next();
               sc.next();
               continue;
           }
           String customerId = sc.next();
           double tranAmount = Double.parseDouble(sc.next());
           String date = sc.next();
           int currentReward = 0;
           tranAmount = Math.floor(tranAmount);
           if(tranAmount > 50 && tranAmount <=100){ 
               currentReward = currentReward + 1 * (int)(tranAmount -50);
           }
           if(tranAmount > 100){ 
               currentReward = currentReward + 2 * (int)(tranAmount - 100);
           }
          
           
           if(customerRewardMap.containsKey(customerId)){
               int rewardAmt = customerRewardMap.get(customerId);
               rewardAmt = rewardAmt + currentReward;
               customerRewardMap.put(customerId, rewardAmt);
           }else{
               customerRewardMap.put(customerId, currentReward);
           }
          
           totalReward = totalReward + currentReward;
       }
      
       sc.close();
      
       
       for(String customerId: customerRewardMap.keySet()){
           System.out.println("Customer Id: "+ customerId+"\t"+"RewardAmount: $"
                   +customerRewardMap.get(customerId));
       }
       System.out.println("Total Reward Amount = $"+totalReward);
   }

}
