package ch06.jms;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

public class MsgReceiver {
	@Resource(name="qcf", mappedName="qcf")
	private QueueConnectionFactory qf;
	@Resource(name="jmsQ", mappedName="jmsQ")
	private Queue queue;
	private QueueConnection conn;

	public String receive(){
		String cliche = null;
		try {
			if (conn == null) conn = qf.createQueueConnection();
			QueueSession session = conn.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
			QueueReceiver receiver = session.createReceiver(queue);
			conn.start();
			
			Message msg = receiver.receiveNoWait();
			if(msg != null && msg instanceof TextMessage){
				TextMessage tmsg = (TextMessage) msg;
				cliche = tmsg.getText().trim();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return cliche;
	}
}
