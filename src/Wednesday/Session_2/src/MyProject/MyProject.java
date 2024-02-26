package Wednesday.Session_2.src.MyProject;

import Wednesday.Session_2.src.Controller.CliConnector;
import Wednesday.Session_2.src.Controller.CommunicateToSeller;
import Wednesday.Session_2.src.Model.BedRoom.Bed;
import Wednesday.Session_2.src.Model.BedRoom.Closet;
import Wednesday.Session_2.src.Model.Customer;
import Wednesday.Session_2.src.Model.LivingRoom.Seat;
import Wednesday.Session_2.src.Model.LivingRoom.Television;
import Wednesday.Session_2.src.Model.Seller;
import Wednesday.Session_2.src.View.CustomerCli;
import Wednesday.Session_2.src.View.SellerCli;

import java.awt.*;

public class MyProject {

    public MyProject(){
        init();
    }

    public void init(){
        Seller seller = new Seller();
        CommunicateToSeller communicate = new CommunicateToSeller(seller);
        Customer customer = new Customer(communicate);
        CustomerCli customerCli = new CustomerCli(customer);
        SellerCli sellerCli = new SellerCli(seller);
        CliConnector cliConnector = new CliConnector(customerCli, sellerCli);
        addInitProducts(seller);
        sellerCli.setCliConnector(cliConnector);
        customerCli.setCliConnector(cliConnector);
        cliConnector.init();
    }

    private void addInitProducts(Seller seller) {

        seller.getStorage().getProducts().add(new Bed(20, "wooden", Color.BLACK, true, 100));
        seller.getStorage().getProducts().add(new Closet(20, "wooden", Color.BLACK, true, 100));
        seller.getStorage().getProducts().add(new Seat(50, "wooden", 5, Color.WHITE));
        seller.getStorage().getProducts().add(new Television(50, "LG", true, 100, 50));


    }

}
