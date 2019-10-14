package structure;

public class MessageRMQ {

	private  String  host;
	private  String targetID;
	
	
	public MessageRMQ() {
		super();
	}
	
	public MessageRMQ(String host, String targetID) {
		this.host = host;
		this.targetID = targetID;
	}
	
	public  String getHost() {
		return host;
	}
	public  void setHost(String host) {
		this.host = host;
	}
	public  String getTargetID() {
		return targetID;
	}
	public  void setTargetID(String targetID) {
		this.targetID = targetID;
	}
	
	
}

