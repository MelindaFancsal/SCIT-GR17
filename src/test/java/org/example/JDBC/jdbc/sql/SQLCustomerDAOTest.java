package org.example.JDBC.jdbc.sql;

import org.example.JDBC.jdbc.db.PostgreSQLDbTest;
import org.example.JDBC.jdbc.models.Customer;
import org.junit.*;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class SQLCustomerDAOTest {
    private PostgreSQLDbTest db;
    private SQLCustomerDAO customersDAO;

    @BeforeClass
    public static void initTests()  {
        PostgreSQLDbTest.setUpTestDB();
    }

    @AfterClass
    public static void discardTests()  {
        PostgreSQLDbTest.dropTestDB();
    }

    @Before
    public void setUp(){
        db = new PostgreSQLDbTest();
        customersDAO = new SQLCustomerDAOImpl(db);
    }

    @After
    public void tearDown()  {
        db.dropDataFromTables();
    }

    @Test
    public void whenNewCustomersInsertedIntoDB_getReturnsThem()  {
        Customer customer = new Customer("name", "mame", "address");

        Customer customer2 = new Customer("name2", "nam2", "address2");


        customersDAO.add(customer);
        customersDAO.add(customer2);

        List<Customer> all = customersDAO.getAll();

        Assert.assertArrayEquals(new Customer[]{customer, customer2}, all.toArray());
    }

    @Test
    public void afterCustomerDeleted_dbDoesNotContainIt() {
        Customer customer = new Customer("name", "mame", "address");
        customersDAO.add(customer);
        customersDAO.delete(customer.getId());

        List<Customer> all = customersDAO.getAll();
        Assert.assertEquals(0, all.size());
    }

    @Test
    public void afterCustomerUpdated_dbReflectsTheChange(){
        Customer customer =  new Customer("name", "mame", "address");

        customersDAO.add(customer);

        customer.setAddress("newStreet");
        customersDAO.update(customer);
        List<Customer> all = customersDAO.getAll();
        Assert.assertEquals(customer, all.get(0));
    }
}