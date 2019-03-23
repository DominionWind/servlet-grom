import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/test")
public class MyServlet extends HttpServlet {
    ItemController itemController = new ItemController();
    ItemUtil util = new ItemUtil();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.getWriter().println(itemController.findByIdItem(Long.parseLong(req.getParameter("param"))).toString());
        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//
//        Long id = Long.valueOf(req.getParameter("param"));
//        Item item = null;
//        try {
//            item = itemController.findByIdItem(id);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            if (item.getName() != null) {
//                resp.getWriter().println(item.toString());
//            } else {
//                resp.getWriter().println("Item with id " + id + " cant find in DB");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            resp.getWriter().println("Cant get item " + e.getMessage());
//        }
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            itemController.saveItem(util.createItem(req.toString()));
        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            itemController.updateItem(util.createItem(req.toString()));
        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            itemController.deleteItem(Long.valueOf(util.createItem(req.toString()).getId()));
        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }
}
