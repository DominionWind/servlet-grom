import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class ItemUtil {

//    @JsonCreator
//    public Item createItem(String string) {
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
//
//        mapper.setDateFormat(format);
//
//        Item item = null;
//        try {
//            item = mapper.readValue(string, Item.class);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return item;
//    }
}
