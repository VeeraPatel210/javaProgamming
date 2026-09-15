import java.util.Scanner;
class Thermostat{
    private String location;
    private int temp;
    private static final int MIN=16;
    private static final int MAX=30;
    private static int activeCount=0;

    Thermostat(String location,int temp)
    {
        this.location=location;
        if(temp>=MIN && temp<=MAX)
        {
            this.temp=temp;
        }
        else {
            this.temp = 22;
        }
        activeCount++;
    }
    Thermostat(String location)
    {
        this(location,22);
    }

    void raise()
    {
        if(temp<MAX)
        {
            temp++;
        }
        else {
            System.out.println("Already at maximum");
        }
    }

    void lower()
    {
        if(getTemp()>MIN)
        {
            temp--;
        }
        else {
            System.out.println("Already at minimum");
        }
    }

    int getTemp() {
        return temp;
    }

    static int getActiveCount() {
        return activeCount;
    }

}
class Main3{
    public static void main(String args[])
    {
        Thermostat t1=new Thermostat("Room 1",20);
        Thermostat t2=new Thermostat("Room 2");

        for (int i = 0; i < 10; i++) {
            t1.raise();
            System.out.println(t1.getTemp());
        }

        for (int i = 0; i < 20; i++) {
            t1.lower();
            System.out.println(t1.getTemp());
        }

        System.out.println("Active Count: " + Thermostat.getActiveCount());
    }
}