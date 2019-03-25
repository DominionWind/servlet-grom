import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {
        ItemController controller = new ItemController();

//
//        Item item = new Item();
//        item.setName("First Name");
//        item.setDateCreated(new Date());
//        item.setLastDateUpdate(new Date());
//        item.setDescription("Test Description");

//        controller.saveItem(item);
//
        System.out.println(controller.findByIdI(21).toString());

//        System.out.println(controller.getAllItems().toString());

    }
}
