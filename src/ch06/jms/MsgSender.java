package ch06.jms;

import javax.annotation.Resource;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jws.WebMethod;

public class MsgSender {
	@Resource(name="qcf", mappedName="qcf")
	private QueueConnectionFactory qf;
	@Resource(name="jmsQ", mappedName="jmsQ")
	private Queue queue;
	private QueueConnection conn;
	
	@WebMethod
	public void send(String msg){
		try {
			if(conn == null) conn = (QueueConnection) qf.createConnection();
			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			TextMessage tmsg = session.createTextMessage(msg);
			session.createProducer(queue).send(tmsg);
			session.close();		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
