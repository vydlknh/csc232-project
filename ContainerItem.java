import java.util.ArrayList;

public class ContainerItem extends Item {

  private ArrayList<Item> items;

  public ContainerItem(String name, String type, String description) {
    super(name, type, description);
    items = new ArrayList<Item>();
  }

  public void addItem (Item item) {
    items.add(item);
  }

  public boolean hasItem (String name) {
    for (int i = 0; i < items.size(); i++) {
      if (name.equalsIgnoreCase(items.get(i).getName())) {
        return true;
      }
    }
    return false;
  }
  
  public Item removeItem(String name) {
    Item removedItem = null;
    for (int i = 0; i < items.size(); i++) {
      if (name.equalsIgnoreCase(items.get(i).getName())) {
        removedItem = items.get(i);
      }
    }
    items.remove(removedItem);
    return removedItem;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(super.getName());
    builder.append(" [ ");
    builder.append(super.getType());
    builder.append(" ] ");
    builder.append(": ");
    builder.append(super.getDescription());
    builder.append("\n");
    for (int i = 0; i < items.size(); i++) {
      builder.append("+ ");
      builder.append(items.get(i).getName());
      builder.append("\n");
    }
    return builder.toString();
  }
}
