import java.util.Scanner;

public class CandyLauncher2 
{
    public static void main(String[] args)
    {
        
        boolean runCode = true;
        while(runCode)
            {
                // set-up
                System.out.println("Enter launcher height (m):");
                Scanner launcherHeight = new Scanner(System.in);
                double myLauncherHeight = launcherHeight.nextDouble();
                System.out.println("");

                System.out.println("Enter mass of projectile (kg):");
                Scanner projMass = new Scanner(System.in);
                double myProjMass = projMass.nextDouble(); // 0.04593 kg
                System.out.println("");

                // initializing
                System.out.println("Enter target height (m):");
                Scanner targetHeight = new Scanner(System.in);
                double myTargetHeight = targetHeight.nextDouble();
                double height = myTargetHeight - myLauncherHeight;
                System.out.println("Height to travel: " + height + " m");
                System.out.println("");

                System.out.println("Enter target range (m):");
                Scanner targetRange = new Scanner(System.in);
                double myTargetRange = targetHeight.nextDouble();
                System.out.println("");


                // velocity
                System.out.println("Enter displacement of spring from equilibrium (cm):");
                Scanner springDisplacement = new Scanner(System.in);
                double mySpringDisplacement = (springDisplacement.nextDouble()) * 0.01;
                System.out.println("Spring displacement from equilibrium: " + mySpringDisplacement + " m");
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

                double initVelRoot = Math.pow((totalSpringConstant / myProjMass), 0.5);
                double initVelocity = mySpringDisplacement * initVelRoot;
                System.out.println("Initial velocity: " + initVelocity + " m/s");
                
                // velocity components
                System.out.println("Enter degree of launch:");
                Scanner launchDegree = new Scanner(System.in);
                double myLaunchDegree = launchDegree.nextDouble();
                double rad = Math.toRadians(myLaunchDegree);

                double velocityY;
                velocityY = initVelocity * Math.sin(rad);
                double velocityX; 
                velocityX = initVelocity * Math.cos(rad);

                System.out.print("Initial x-component of velocity: ");
                System.out.println(velocityX); 
                System.out.print("Initial y-component of velocity: ");
                System.out.println(velocityY);
                System.out.println("");

                // time
                double velYSquare = Math.pow(velocityY, 2);
                double timeNumerator = velocityY + Math.pow((velYSquare - 19.62), 0.5);
                double time = timeNumerator / 9.81;
                System.out.println("Time to target: " + time + " s");

                // range
                double xPos = velocityX * time;
                System.out.print("X-position: " + xPos + " m");

                // height
                double yPos = (velocityY * time) - 4.905 * Math.pow(time, 2);
                System.out.print("Y-position: " + yPos + " m");
                System.out.println("");

                // restart
                System.out.println("");
                System.out.println("Start a new calculation? (YES/NO)");
                Scanner answer = new Scanner(System.in);
                String myAnswer = answer.nextLine();
                if(myAnswer.equals("NO"))
                    {
                            runCode = false;
                    }
            }

        
    }
}