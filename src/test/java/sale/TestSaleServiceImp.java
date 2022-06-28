package sale;
//basic tests complete, need discussion tho
import co.za.carolsBoutique.Sale.model.ExchangeInfo;
import co.za.carolsBoutique.Sale.model.Sale;
import co.za.carolsBoutique.Sale.repository.ISaleRepository;
import co.za.carolsBoutique.Sale.repository.SaleRepositoryImp;
import co.za.carolsBoutique.Sale.service.SaleIdGenerator;
import co.za.carolsBoutique.Sale.service.SaleServiceImp;
import co.za.carolsBoutique.paymentGateway.PaymentGateway;
import co.za.carolsBoutique.product.model.Category;
import co.za.carolsBoutique.product.model.Product;
import co.za.carolsBoutique.product.model.Size;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class TestSaleServiceImp {
    ISaleRepository dao;
    SaleIdGenerator gen;
    SaleServiceImp service;
    Sale saleTest;
    List<Size> sizes;
    List<Category> sCats;
    List<Product> products;
    public TestSaleServiceImp() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dao = new SaleRepositoryImp();
        gen = new SaleIdGenerator();
        service = new SaleServiceImp(dao, gen, new PaymentGateway());
        products = new ArrayList();
        sizes = new ArrayList<Size>();
        sizes.add(new Size("22", "hats"));
        sCats = new ArrayList<Category>();
        sCats.add(new Category("22", "hats"));
        products.add(new Product("1234567891", "Hat", "Red Hat", sizes, "Red", 19.99,2.0,sCats));
        saleTest = new Sale("asdew12311", "12werw23", false, 19.99, products, "ao8154bb","123");
        saleTest.setCustomerEmail("dean.swanepoel13@gmail.com");
    }
    
    @After
    public void tearDown() {
        dao = null;
        gen = null;
        service = null;
        products = null;
        sizes = null;
        sCats = null;
        saleTest = null;
    }

     @Test//Id generator is blocking the method for some reason
     public void testCheckout() {
        assertEquals("accepted", service.checkout(saleTest));
     }
	  @Test//Id generator is blocking the method for some reason
     public void testCheckoutWithDiscount() {
        assertEquals("accepted", service.checkout(saleTest));
     }
     @Test//test passed(need to discuss the id or name return of cats and size)
     public void testFindSale() {
         List<Product> products = new ArrayList();
         products.add(new Product("123", "Hat", "Red Hat", sizes, "Red", 20.2,12.00, sCats));
        assertEquals(new Sale("1", "1", true, 200.00, products, "htfh", "123"), service.findSale("1"));
     }
     
     @Test//test passed
     public void testRefund() {
         Map<String,String> refundInfo= new HashMap<>();
         refundInfo.put("asdew12343", "12343456");
        assertEquals("refund completed", service.refund(refundInfo));
     }
     @Test//test passed
     public void testExchange() {
//         List<String> exchangeInfo = new ArrayList<>();//sale,return, new
//         exchangeInfo.add("asdew12343");
//         exchangeInfo.add("1234567891");
//         exchangeInfo.add("1321321321");
         ExchangeInfo ei = new ExchangeInfo();
        assertEquals("Exchange Successful", service.exchange(ei));
     }
     
}
