package org.ros.android.jaco_perception;

import org.ros.message.MessageListener;
import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.topic.Subscriber;

import std_msgs.*;
import std_msgs.String;

/**
 * Created by robot on 18/06/14.
 */
public class RosListener extends AbstractNodeMain {

	private boolean allMessageReceived = false;
	private boolean priseListReceived = false;
	private boolean objectRecon = false;
	private java.lang.String objectReconOk = "object_recon";
	private java.lang.String objectReconNotOk = "object_not_recon";
	private java.lang.String priseList = "";


	@Override
	public GraphName getDefaultNodeName() {
		return GraphName.of("/android_ros_listener");
	}

	public void onStart(ConnectedNode connectedNode){
		final Subscriber<std_msgs.String> subscriber = connectedNode.newSubscriber("/android_listener", String._TYPE);
		subscriber.addMessageListener(stringMessageListener);
	}

	public MessageListener<String> stringMessageListener = new MessageListener<String>() {
		@Override
		public void onNewMessage(String string) {
			java.lang.String messageReceived = string.getData();
			if(messageReceived.contentEquals(objectReconOk)) {
				objectRecon = true;
			}
			else if(messageReceived.charAt(0) == 'p'){
				priseListReceived = true;
				priseList = messageReceived;
			}
			if (objectRecon && priseListReceived){
				allMessageReceived = true;
			}
		}
	};

	public java.lang.String getPriseList(){
		return priseList;
	}

	public boolean getAllMessagesReceived(){
		return allMessageReceived;
	}

}
