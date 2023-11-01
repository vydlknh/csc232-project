/**
 * The item class is used to encapsulate information about an item in the game
 * @author Vy Do
 * @author Phan Nguyen
 */

public class Item {

  // Member variables
  private String name;
  private String type;
  private String description;

  // Constructor
  /**
   * The constructor used to construct a new Item from name, type, and description information
   * @param name The name of the object
   * @param type The type of the object
   * @param description The description of the object
   */
  public Item (String name, String type, String description) {
    this.name = name;
    this.type = type;
    this.description = description;
  }

  /**
   * This method returns the name of the item
   * @return The name of the item
   */
  public String getName () {return name;}

  /**
   * This method returns the type of the item
   * @return The type of the item
   */
  public String getType () {return type;}

  /**
   * This method returns the description of the item
   * @return The description of the item
   */
  public String getDescription () {return description;}

  /**
   * This method set the name of the item
   * @param name The new name of the item
   */
  public void setName (String name) {this.name = name;}

  /**
   * This method set the type of the item
   * @param name The new type of the item
   */
  public void setType (String type) {this.type = type;}
  
  /**
   * This method set the description of the item
   * @param name The new description of the item
   */
  public void setDescription (String description) {this.description = description;}

  /**
   * This methods overrides the toString() method to return a String containing the item's information in a specific format
   * @return The item's information
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(name);
    builder.append(" [ ");
    builder.append(type);
    builder.append(" ] ");
    builder.append(": ");
    builder.append(description);
    return builder.toString();
  }
}