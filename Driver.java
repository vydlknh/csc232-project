/**
 * The driver reads in commands from the user and output the corresponding message.
 * @author Vy Do
 * @author Phan Nguyen
 * @author Audrey Bui
 * @author Anh Nguyen
 */
import java.util.Scanner;

public class Driver {
  private static Location currLocation;
  private static ContainerItem myInventory;

  public static void createWorld() {
    Location Kitchen = new Location("Kitchen", "a kitchen");
    Location Hallway = new Location("Hallway", "a hallway");
    Location Bedroom = new Location("Bedroom", "a bedroom");
    Location Garden = new Location("Garden", "a garden");
    
    Kitchen.addItem(new Item("knife", "weapon", "a knife"));
    Kitchen.addItem(new Item("turkey", "food", "a turkey"));
    Kitchen.addItem(new Item("plate", "item", "a plate"));

    Hallway.addItem(new Item("picture", "item", "a picture"));
    Hallway.addItem(new Item("vase", "item", "a vase"));
    Bedroom.addItem(new Item("lamp", "item", "a lamp"));
    Bedroom.addItem(new Item("journal", "item", "a journal"));
    Garden.addItem(new Item("axe", "weapon", "an axe"));
    Garden.addItem(new Item("apple", "food", "an apple"));

    Hallway.connect("north", Kitchen);
    Hallway.connect("east", Bedroom);
    Hallway.connect("south", Garden);
    Kitchen.connect("south", Hallway);
    Bedroom.connect("west", Hallway);
    Garden.connect("north", Hallway);
    
    currLocation = Kitchen;
    myInventory = new ContainerItem("bag", "container", "just a regular bag");
  }

  public static void commandLines() {
    System.out.println("quit: stop the game");
    System.out.println("look: display the current location's name, description, and items at the location");
    System.out.println("examine [item]: examine an item");
    System.out.println("go [direction]: go to a location at a specific direction");
    System.out.println("inventory: display a list of items in your inventory");
    System.out.println("take [item]: take an item and put it in your inventory");
    System.out.println("drop [item]: drop an item from your inventory");
  }
  public static void main(String[] args) {
    createWorld();
    Scanner s = new Scanner(System.in);
    boolean flag = false;
    while (!flag) {
      System.out.println("Enter command: ");
      String command = s.nextLine().toLowerCase();
      String[]commands = command.split(" ");
      switch (commands[0]) {
        case "quit":
          flag = true;
          break;

        case "look":
          StringBuilder location = new StringBuilder();
          location.append(currLocation.getName());
          location.append(" - ");
          location.append(currLocation.getDescription());
          System.out.println(location.toString());
          for (int i = 0; i < currLocation.numItems(); i++) {
            System.out.println("+ " + currLocation.getItem(i).getName());
          }
          break;

        case "examine":
          if (commands.length == 1) {
            System.out.println("You did not tell me an item you want to examinne");
          }
          else if(currLocation.hasItem(commands[1])) {
            System.out.println(currLocation.getItem(commands[1].toString()));
          } else {
            System.out.println("Cannot find that item");
          }
          break;
          
        case "go":
          if(commands.length == 1) {
            System.out.println("You did not tell me a direction that you want to move in");
          }
          else if (!commands[1].equalsIgnoreCase("north") &&
          !commands[1].equalsIgnoreCase("east") &&
          !commands[1].equalsIgnoreCase("south") &&
          !commands[1].equalsIgnoreCase("west")) {
            System.out.println("That is not a valid direction");
          }
          else if (!currLocation.canMove(commands[1])) {
            System.out.println("I am unable to move in that direction");
          }
          else {
            currLocation = currLocation.getLocation(commands[1]);
          }
          break;

        case "inventory":
          System.out.println(myInventory.toString());
          break;
        
        case "take":
          if (commands.length == 1) {
            System.out.println("You did not tell me an item you want to take");
          } else if (currLocation.hasItem(commands[1])) {
            myInventory.addItem(currLocation.getItem(commands[1]));
            currLocation.removeItem(commands[1]);
          } else {
            System.out.println("Cannot find that item here");
          }
          break;
          
        case "drop":
          if (commands.length == 1) {
            System.out.println("You did not tell me an item you want to drop");
          } 
          else if (myInventory.hasItem(commands[1])) {
            currLocation.addItem(myInventory.removeItem(commands[1]));
          } else {
            System.out.println("Cannot find that item in your inventory");
          }
          break;

        case "help":
          commandLines();
          break;
      
        default:
          System.out.println("I don't know how to do that");
          break;
      }
    }
    s.close();

  }
}
