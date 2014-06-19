package org.ros.android.jaco_perception;

import org.ros.concurrent.CancellableLoop;
import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.topic.Publisher;

import java.lang.String;

import std_msgs.*;


/**
 * Created by Jean Bouchard on 18/06/14.
 */
public class RosCommunication extends AbstractNodeMain {

	private Publisher<std_msgs.String> publisher;


	@Override
	public GraphName getDefaultNodeName() {
		return GraphName.of("/android_ros_communication");
	}

	@Override
	public void onStart(ConnectedNode connectedNode)
	{
		publisher = connectedNode.newPublisher("/android_response", std_msgs.String._TYPE);
	}

	public void sendMessage(String p_message){

		std_msgs.String sendedString = publisher.newMessage();
		sendedString.setData(p_message);
		publisher.publish(sendedString);
	}

}
