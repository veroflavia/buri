package ch06.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;



@Stateless
@WebService
public interface Fib {
	@WebMethod int fib(int n);
	@WebMethod List getFibs();

}
