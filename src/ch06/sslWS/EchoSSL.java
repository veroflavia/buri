package ch06.sslWS;

import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@WebService
public class EchoSSL {
	public String echo(String msg) {
		return "Echoing: " + msg;
	}
}
