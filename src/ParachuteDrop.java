/***********************************************************
 // Assignment :  Parachute Drop
 // by: Kyle Gray
 // Date: 1 / 11 / 2015
 // Description: Calculate required parachute size for a given mass
 //  Notes: any special things you want me to consider.
 //***********************************************************
 //************************************************************
 If there are any questions that need to be answered put them here as comments
 */
import java.util.Scanner;

class Parachute {
    private int D;// is the chute diameter in meters
    private double m;// is the payload mass in kilograms
    private double g = 9.8;// is the acceleration of gravity = 9.8 m/s2
    private double pi = 3.14159265359;//π is 3.14159265359
    private double density = 1.22;//is the density of air = 1.22 kg/m3
    private double Ced = 1.5;// is the drag coefficient of the chute, or 1.5 for a parachute (true dome-shaped chute).
    private int v  = 3;// is the speed we want at impact with the ground (3 m/s or less)



    public void setVelocity(int newVelocity)
    {
        v = newVelocity;
    }

    public int getVelocity()
    {
        return v;
    }

    public void setPayload(double payload)
    {
        double metric_payload = payload / 2.2046;
        m = metric_payload;
    }

    double calculateDrop()
    {
        double formula =  Math.sqrt( (8 * m * g) / (pi * density * Ced * (v^2)) );
        return formula;
    }

    public Parachute()
    {

    }

}

public class ParachuteDrop {


    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);
        String userPayloadInput;
        String userYNInput;
        Parachute userParachute = new Parachute();

        System.out.println("Enter weight of the payload in lb: ");
        userPayloadInput = input.next();
        userParachute.setPayload(Double.parseDouble(userPayloadInput));
        System.out.println("Is the impact of ft/sec (conversion of 3 m/s) ok? Y or N ");
        userYNInput = input.next();

        if (userYNInput.equals("N"))
        {
            System.out.println("Enter new speed in m/s");
            String userImpactInput = input.next();
            userParachute.setVelocity(Integer.parseInt(userImpactInput));
        }


        double answer = userParachute.calculateDrop() * 39.370; //convert to inches

        System.out.println("For a payload of: " + userPayloadInput + "lbs");
        System.out.println("You will need a chute of at least " + answer + " inches");
        System.out.println("The payload will hit the ground at a velocity of " + userParachute.getVelocity() + "m/s");

    }

}

///////////////////////////////////////////////////////////////////
///   End Of File
///////////////////////////////////////////////////////////////////




