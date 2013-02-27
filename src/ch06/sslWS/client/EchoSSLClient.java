package ch06.sslWS.client;




class EchoSSLClient {
	public static void main(String[] args) {
		try {
			EchoSSLService service = new EchoSSLService();
			EchoSSL port = service.getEchoSSLPort();
			System.out.println(port.echo("Goodbye, cruel world!"));
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
