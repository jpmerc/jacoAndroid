package org.ros.android.jaco_perception;

import android.util.Log;
import android.widget.TextView;

import org.ros.message.MessageListener;
import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.topic.Subscriber;

import sensor_msgs.Image;

import std_msgs.String;


/**
 * Created by robot on 05/06/14.
 */
public class CameraListener extends AbstractNodeMain {
    @Override
    public GraphName getDefaultNodeName() {
        return GraphName.of("/camera_listener");
    }

    public void onStart(ConnectedNode connectedNode){
        final Subscriber<std_msgs.String> subscriber = connectedNode.newSubscriber("/image_coordinate_rgb", String._TYPE);
        subscriber.addMessageListener(new MessageListener<String>() {
            @Override
            public void onNewMessage(String string) {
                Log.d("blabla", string.getData());
                Log.d("blabla", string.getData());
                Log.d("blabla", string.getData());
                Log.d("blabla", string.getData());
                Log.d("blabla", string.getData());
            }
        });

            }
    }
