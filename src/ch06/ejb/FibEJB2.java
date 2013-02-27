package ch06.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@WebService(endpointInterface = "ch06.ejb.Fib")
public class FibEJB2 implements Fib {
	@PersistenceContext(unitName = "FibServicePU")
	private EntityManager em;

	public int fib(int n) {
		FibNum fn = em.find(FibNum.class, n);
		if (fn != null)
			return fn.getF();

		int f = compute_fib(Math.abs(n));
		fn = new FibNum();
		fn.setN(n);
		fn.setF(f);
		em.persist(fn);
		return f;
	}

	

	public List getFibs() {
		Query query = em.createNativeQuery("select * from FibNum");
		// fib_nums is a list of pairs: N and Fibonacci(N)
		List fib_nums = query.getResultList(); // read from database
		List results = new ArrayList();
		for (Object next : fib_nums) {
			List list = (List) next;
			for (Object n : list)
				results.add(n);
		}
		return results; // N, fib(N), K, fib(K),...
	}

	private int compute_fib(int n) {
		int fib = 1, prev = 0;
		for (int i = 2; i <= n; i++) {
			int temp = fib;
			fib += prev;
			prev = temp;
		}
		return fib;
	}

}