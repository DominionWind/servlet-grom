import java.util.List;

public class ItemService extends ItemDAO {

    public Item saveI(Item item){
        return save(item);
    }

    public Item updateI(Item item){
        return update(item);
    }

    public void deleteI(long id){
        delete(id);
    }

    public Item findByIdI(long id) throws Exception{
        return findById(id);
    }

    public List<Item> getAllI(){
        return getAllItem();
    }
}
