import java.util.Scanner;

public class XYDISCalculator
{
    public static void main(String[] args)
    {
        // choosing what to calculate
        System.out.println("What would you like to find? (XY/DISPLACEMENT)");
        Scanner answer = new Scanner(System.in);
        String myAnswer = answer.nextLine();

        if(myAnswer.equals("XY")) 
            {
                // find x- and y-pos
                // set data
                System.out.println("Enter initial velocity (m/s):");
                Scanner velocity = new Scanner(System.in);
                double initVelocity = velocity.nextDouble();

                System.out.println("Enter degree of launch:");
                Scanner launchDegree = new Scanner(System.in);
                double myLaunchDegree = launchDegree.nextDouble();
                double rad = Math.toRadians(myLaunchDegree); 

                System.out.println("");

                double velocityX; 
                velocityX = initVelocity * Math.cos(rad);
                System.out.println("Initial x-component of velocity: " + velocityX + " m/s");
                double velocityY;
                velocityY = initVelocity * Math.sin(rad);
                System.out.println("Initial y-component of velocity: " + velocityY + " m/s");
                System.out.println("");

                // time
                double velYSquare = Math.pow(velocityY, 2);
                double timeNumerator = velocityY + Math.pow((velYSquare - 19.62), 0.5);

                System.out.println("TEST " + timeNumerator); // test

                double time = timeNumerator / 9.81;
                System.out.println("Time to target: " + time + "s");
                System.out.println("");

                // range
                double xPos = velocityX * time;
                System.out.println("X-position: " + xPos + " m");

                // height
                double yPos = (velocityY * time) - 4.905 * Math.pow(time, 2);
                System.out.println("Y-position: " + yPos + " m");
            }
        
        else if(myAnswer.equals("DISPLACEMENT"))
            {
                // find displacement of spring for v
                System.out.println("Enter mass of projectile (kg):");
                Scanner projMass = new Scanner(System.in);
                double myProjMass = projMass.nextDouble(); // 0.04593 kg
                System.out.println("");

                System.out.println("Enter spring constant (N/m):");
                Scanner springConstant = new Scanner(System.in);
                double mySpringConstant = springConstant.nextDouble();
                System.out.println("Enter number of springs:");
                Scanner springCount = new Scanner(System.in);
                double mySpringCount = springCount.nextDouble();
                double totalSpringConstant = mySpringConstant * mySpringCount;
                System.out.println("Total Spring Constant: " + totalSpringConstant + "N/m");
                System.out.println("");

                System.out.println("Enter target velocity (m/s):");
                Scanner targetVelocity = new Scanner(System.in);
                double myTargetVelocity = targetVelocity.nextDouble();
                System.out.println("");

                double myTarSpringDis;
                myTarSpringDis = myTargetVelocity * (Math.pow((myProjMass / totalSpringConstant), 0.5));
                System.out.println("Needed spring displacement: " + myTarSpringDis + " m");
                System.out.println("Needed spring displacement: " + (myTarSpringDis * 100) + " cm");
            }
    }
}