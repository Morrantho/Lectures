import java.lang.Exception;
import java.lang.Integer;

public class Basic{
    // 1.
    public static void print1to255(){
        for(int i=1;i<=255;i++){
            System.out.println(i);
        }
    }
    // 2.
    public static void printIntsAndSum0To255(){
        for(int i=0,sum=0;i<=255;i++,sum+=i){
            System.out.println(sum);
        }
    }
    // 3.
    public static void printMaxOfArray(int[] arr){
       for(int i=1,max=arr[0];i<arr.length;i++){
           if(max < arr[i])
               max = arr[i];
           if(i==arr.length-1)
               System.out.println(max);
       }
    }
    // 4.
    public static int[] odds1To255(){
        int[] a = new int[127];
        
        for(int i=0,j=1;j<255;i++,j+=2)
            a[i] = j;

        return a;
    }
    // 5.
    public static void greaterThanY(int[] arr,int y){
        int numGreater = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > y){
                System.out.println(arr[i]);
                numGreater++;
            }
        }
        System.out.println("Total Nums Greater:"+numGreater);
    }
    // 6.
    public static void minMaxAvg(int[] arr){
        int min = arr[0];
        int max = arr[0];
        int avg = 0;

        for(int i=0;i<arr.length;i++){
            if(max < arr[i]) max = arr[i];
            if(min > arr[i]) min = arr[i];
            avg += arr[i];
        }
        avg /= arr.length;
        System.out.println("Min:"+min+" Max: "+max+" Avg: "+avg);
    }
    // 7.
    public static void dojoNegatives(Object[] arr){
        for(int i=0;i<arr.length;i++){
            try{
                int num = (int)arr[i];
                if(num < 0) arr[i] = "Dojo";
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    // 8.
    public static void printOdds1To255(){
        for(int i=1;i<=255;i+=2){
            System.out.println(i);
        }
    }
    // 9.
    public static void iterate(Object[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    // 10.
    public static void doAverage(int[] arr){
        for(int i=1,avg=arr[0];i<arr.length-1;i++,avg+=arr[i]){
            if(i == arr.length-2) System.out.println("Average: "+avg);
        }
    }
    // 11.
    public static int[] squares(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i] = arr[i]*arr[i];
        }

        return arr;
    }
    // 12.
    public static int[] remNegs(int[] arr){
        for(int i=0;i<arr.length;i++) if(arr[i] < 0) arr[i] = 0;
        return arr;
    }
    // 13.
    public static int[] shiftVals(int[] arr){
        for(int i=0;i<arr.length-1;i++)
            arr[i] = arr[i+1];
        arr[arr.length-1] = 0;

        return arr;
    }

    public static void main(String[] args){
        //Basic.print1to255();
        //Basic.printIntsAndSum0To255();
        //Basic.printMaxOfArray(new int[]{50,3,65,12,94});
        //Basic.odds1To255();
        //Basic.greaterThanY(new int[]{5,15,4,12,7,19},10);
        //Basic.minMaxAvg(new int[]{50,10,20,30,40}); 
        //Basic.dojoNegatives(new Object[]{10,20,-40,15,-60});
        // Basic.printOdds1To255();
        // Basic.iterate(new Object[]{10,20,30,40,50});
        // Basic.doAverage(new int[]{123,123,145,6,23,6,245,6});
        // Basic.shiftVals(new int[]{12,5,3,6,2,35});
    }
}
