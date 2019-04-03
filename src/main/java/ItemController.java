import java.util.List;

public class ItemController{

    private ItemService itemService = new ItemService();

    public Item saveItem(Item item){
        return itemService.saveI(item);
    }

    public Item updateItem(Item item){
        return itemService.updateI(item);
    }

    public void deleteItem(long id)throws Exception{
        itemService.deleteI(id);
    }

    public Item findByIdItem(long id) throws Exception{
        return itemService.findByIdI(id);
    }

    public List<Item> getAllItems(){
        return itemService.getAllI();
    }
}
