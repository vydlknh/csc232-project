/**
 * The location class is used to encapsulate information about a location in the game
 * @author Audrey Bui
 * @author Anh Nguyen
*/
import java.util.ArrayList;
import java.util.HashMap;

public class Location {
    // Member variables
    private String name;
    private String description;
    private ArrayList<Item> store;
    private HashMap<String, Location> connections;

    // Constructor
    /**
     * The constructor used to construct a new Location from name and description information
     * @param name
     * @param description
     */
    public Location(String name, String description) {
        this.name = name;
        this.description = description;
        store = new ArrayList<Item>();
        connections = new HashMap<>();
    }

    public void connect(String direction, Location location) {
        connections.put(direction, location);
    }

    public boolean canMove(String direction) {
        return connections.containsKey(direction);
    }

    public Location getLocation(String direction) {
        return connections.get(direction);
    }
    /**
     * This method returns the name of the item
     * @return The name of the item
     */
    public String getName() {
        return name;
    }
    /**
     * This method returns the description of the item
     * @return The description of the item
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method set the name of the item
     * @param name The new name of the item
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * This method set the description of the item
     * @param name The new description of the item
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method adds the item to the location's ArrayList of stored items
     * @param item The item to be added to the ArrayList
     */
    public void addItem(Item item) {
        store.add(item);
    }
    
    /**
     * This method checks whether the location's ArrayList contains an item with the same name
     * @param itemName The name of the item
     * @return Whether the item is in the location's ArrayList
     */
    public boolean hasItem(String itemName) {
        for (int i = 0; i < store.size(); i++) {
            if (itemName.equalsIgnoreCase(store.get(i).getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks whether the location's ArrayList contains an item with the same name
     * and return the matching item 
     * @param itemName The name of the item
     * @return The matching item in the ArrayList
     */
    public Item getItem(String itemName) {
        for (int i = 0; i < store.size(); i++) {
            if (itemName.equalsIgnoreCase(store.get(i).getName())) {
                return store.get(i);
            }
        }
        return null;
    }

    /**
     * This method returns the item in the location's ArrayList at the index
     * @param index The index of the item
     * @return The item at the index
     */
    public Item getItem(int index) {
        if (index < numItems()) {
            return store.get(index);
        }
        return null;
    }

    /**
     * This method returns how many items are in the location's ArrayList
     * @return The number of items in the location's ArrayList
     */
    public int numItems() {
        return store.size();
    }

    /**
     * This method checks whether the location's ArrayList contains an item with the same name,
     * remove and return the matching item 
     * @param itemName The name of the item
     * @return The matching item in the ArrayList
     */
    public Item removeItem(String itemName) {
        Item removedItem = getItem(itemName);
        store.remove(removedItem);
        return removedItem;
    }
}
