import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(Eulers(0.001));
    }

    public static double Eulers(double steglengde) {
        double x = 0;
        double y= 3;
        double f;
        int z = 1;

        for (double i = 0; i <= 1; i += steglengde) {
            y = findY(y,x,steglengde);
            x= i;
            //System.out.println(z+ ": " + y);
            z++;
        }
        return y;
    }
    public static double function(double x,double y) {
        return 6*Math.pow(x,2) - 3*Math.pow(x,2)*y;
    }

    public static double findY(double forrigeY, double forrigeX, double steglengde) {
        return forrigeY + steglengde*function(forrigeX,forrigeY);
    }
}
