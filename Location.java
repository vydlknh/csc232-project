import java.util.ArrayList;

public class Location {
    private String name;
    private String description;
    private ArrayList<Item> store;

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
        store = new ArrayList<Item>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addItem(Item item) {
        store.add(item);
    }
    
    public boolean hasItem(String itemName) {
        for (int i = 0; i < store.size(); i++) {
            if (itemName.equalsIgnoreCase(store.get(i).getName())) {
                return true;
            }
        }
        return false;
    }

    public Item getItem(String itemName) {
        for (int i = 0; i < store.size(); i++) {
            if (itemName.equalsIgnoreCase(store.get(i).getName())) {
                return store.get(i);
            }
        }
        return null;
    }

    public Item getItem(int index) {
        if (index < numItems()) {
            return store.get(index);
        }
        return null;
    }

    public int numItems() {
        return store.size();
    }

    public Item removeItem(String itemName) {
        Item removedItem = getItem(itemName);
        store.remove(removedItem);
        return removedItem;
    }
}
