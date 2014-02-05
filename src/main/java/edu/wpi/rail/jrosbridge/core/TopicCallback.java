package edu.wpi.rail.jrosbridge.core;

/**
 * The TopicCallback interface defines a single method which will be called when
 * an incoming message is received for an associated topic.
 * 
 * @author Russell Toris - rctoris@wpi.edu
 * @version Feb. 4, 2014
 */
public interface TopicCallback {

	/**
	 * This function is called when an incoming message is received for a given
	 * topic. No ROS type checking is done on the internal message data.
	 * 
	 * @param message
	 *            The message that was received.
	 */
	public void handleMessage(Message message);
}
