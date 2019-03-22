import java.util.List;

public class ItemController extends ItemService {

    public Item saveItem(Item item){
        return saveI(item);
    }

    public Item updateItem(Item item){
        return updateI(item);
    }

    public void deleteItem(long id){
        deleteI(id);
    }

    public Item findByIdItem(long id) throws Exception{
        return findByIdI(id);
    }

    public List<Item> getAllItems(){
        return getAllI();
    }
}
