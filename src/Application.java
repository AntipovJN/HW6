import java.io.IOException;

public class Application {

    public static void main(String[] args) {
        Processor firstProcessor = new Processor("Intel", "Core i5");
        GraphicsCard firstGraphicsCard = new GraphicsCard("NVIDIA", "GeForce 610m");
        Laptop firstLaptop = new Laptop("Toshiba", "black", firstProcessor, firstGraphicsCard);

        try {
            Laptop cloneLaptop = firstLaptop.cloneLaptop();
            System.out.println(firstLaptop + "\n" + cloneLaptop);
            firstProcessor.setBrand("AMD");
            firstProcessor.setModel("A-8");
            System.out.println(firstLaptop + "\n" + cloneLaptop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try { //Using universal Class "CloningHandler", for clone laptops
            Laptop laptop3 = (Laptop) CloningHandler.cloneObject(firstLaptop);
            System.out.println("-----------------\n" + laptop3 + " by Cloning Handler");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean getConnection = false;
        for (int i = 0; i < 3 && !getConnection; i++) {
            try (RobotConnection connection = robotConnectionManager.getConnection()) {
                connection.moveRobotTo(toX, toY);
                getConnection = true;
            } catch (RobotConnectionException connectException) {
                if (i == 2) {
                    throw new RobotConnectionException("can't connect to the robot");
                }
            }
        }
    }
}
