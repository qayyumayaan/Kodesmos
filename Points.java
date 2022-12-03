class Points{
    public static void main(String args[]){
        /*for(double i = 1; i>=0; i-=0.1){
            for(double j = 1; j>=0; j-=0.1){
                System.out.printf("%.2f",i);
                System.out.printf(", %.2f",j);    
                System.out.println(); 

            }   
        }*/

        for(int i = 0; i<=30; i++){
            for(int j = 0; j<=30; j++){
                System.out.println(i+", "+j);
            }
        }

    }
}