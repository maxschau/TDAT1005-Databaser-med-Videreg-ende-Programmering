public class oving8 {
    public static void main(String[] args) {
        Double[][] svar = new Double[3][3];
        svar[0][0] = trapesregelen(10);
        svar[0][1] = trapesregelen(100);
        svar[0][2] = trapesregelen(1000);

        svar[1][0] = midtpunktsregelen(10);
        svar[1][1] = midtpunktsregelen(100);
        svar[1][2] = midtpunktsregelen(1000);

        svar[2][0] = simsonsmetode(10);
        svar[2][1] = simsonsmetode(100);
        svar[2][2] = simsonsmetode(1000);

        for (int i = 0; i < svar.length; i++) {;
            if (i==0) {
                System.out.println("Trapesregelen:");
            } else if (i==1) {
                System.out.println("Midtpunktsregelen");
            } else {
                System.out.println("Simpsonsmetode:");
            }
            for (int j = 0; j < svar[i].length; j++) {
                System.out.println(svar[i][j]);
            }
        }


    }

    private static double trapesregelen(double n) {
        double deltaX = (2-1)/n;

        double result = 0;
        for (double i = 0; i <= n; i++) {
            double factor = 1+(1/n)*i;
            if (i == 0 || i == n) {
                result += function(factor);
            } else {
                result += 2*function(factor);
            }
        }
        result = deltaX*0.5*result;
        return result;
    }

    private static double midtpunktsregelen(double n) {
        double deltaX = (2-1)/n;
        double result = 0;
        for (double i = 0; i < n; i++) {
            double factor = (((1+(1/n)*i) + (1+(1/n)*(i+1)))/2);
            result += deltaX * function(factor);
        }
        return result;
    }

    private static double simsonsmetode(double n) {
        double deltaX = (2 - 1) / n;
        double result = 0;
        for (double i = 0; i <= n; i++) {
            double factor = 1 + (1 / n) * i;
            if (i == 0 || i == n) {
                result += function(factor);
            } else if (i % 2 == 0) {//partall
                result += 2 * function(factor);
            } else {
                result += 4 * function(factor);
            }
        }
        result = (deltaX/3) * result;
        return result;
    }

    private static double function(double x) {
        return Math.sqrt(Math.pow(x,3)-1);
    }
}
