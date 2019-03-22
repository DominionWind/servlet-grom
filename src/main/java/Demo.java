import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        ItemController controller = new ItemController();

        Item item = new Item();
        item.setName("First Name");
        item.setDateCreated(new Date());
        item.setDescription("Test Description");

        controller.saveItem(item);
    }
}
