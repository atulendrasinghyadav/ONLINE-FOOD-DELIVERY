@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderDAO orderDAO;

    @Test
    public void testPlaceOrder() {
        Order order = new Order("Pizza", 2, "123 Main St");
        when(orderDAO.saveOrder(order)).thenReturn(true);

        boolean result = orderService.placeOrder("Pizza", "2", "123 Main St");
        assertTrue(result);
    }
}
