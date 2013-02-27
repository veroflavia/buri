import clientEJB.FibEJBService;
import clientEJB.Fib;
import java.util.List;

class ClientEJB {
	public static void main(String args[]) {
		FibEJBService service = new FibEJBService();
		Fib port = service.getFibEJBPort();
		final int n = 8;
		for (int i = 1; i < n; i++)
			System.out.println("Fib(" + i + ") == " + port.fib(i));
		List fibs = port.getFibs();
		for (Object next : fibs)
			System.out.println(next);
	}
}