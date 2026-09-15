import java.util.Scanner;

enum Coin{
    ONE,TWO,FIVE,TEN
}

class Main1{
    public static void main(String args[])
    {
        final int snackPrice=15;
        int total=0;

        Scanner sc= new Scanner (System.in);

        while(total<=snackPrice)
        {
            System.out.print("Enter a coin(ONE,TWO,FIVE,TEN): ");
            String s=sc.nextLine().toUpperCase();

            int num=switch(Coin.valueOf(s))
            {
                case ONE-> 1;
                case TWO-> 2;
                case FIVE-> 5;
                case TEN-> 10;
            };

            total+=num;
        }

        System.out.println("Total Amount: "+total);
        System.out.println("Remaining: "+(total-snackPrice));

    }
}