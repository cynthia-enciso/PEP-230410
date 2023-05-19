import controller.ItemController;

public class App {
    public static void main(String[] args)  {
        // needs to call controller method
        ItemController controller = new ItemController();
        controller.setUpEndpoints();
    }
}
