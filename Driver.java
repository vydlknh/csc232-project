import java.util.Scanner;

public class Driver {
  private static Location currLocation;
  public static void main(String[] args) {
    Location Kitchen = new Location("Kitchen", "a kitchen");
    currLocation = Kitchen;
    Kitchen.addItem(new Item("knife", "weapon", "a knife"));
    Kitchen.addItem(new Item("turkey", "food", "a turkey"));
    Kitchen.addItem(new Item("plate", "item", "a plate"));

    Scanner s = new Scanner(System.in);
    boolean flag = false;
    while (!flag) {
      System.out.println("Enter command: ");
      String command = s.nextLine();
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
            System.out.println(currLocation.getItem(i));
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
      
        default:
          System.out.println("I don’t know how to do that");
          break;
      }
    }
    s.close();
  }
}
