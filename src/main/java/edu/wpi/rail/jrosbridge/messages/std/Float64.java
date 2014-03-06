package edu.wpi.rail.jrosbridge.messages.std;

import javax.json.Json;

import edu.wpi.rail.jrosbridge.messages.Message;

/**
 * The std_msgs/Float64 message.
 * 
 * @author Russell Toris -- rctoris@wpi.edu
 * @version March 6, 2014
 */
public class Float64 extends Message {

	/**
	 * The name of the data field for the message.
	 */
	public static final java.lang.String FIELD_DATA = "data";

	/**
	 * The message type.
	 */
	public static final java.lang.String TYPE = "std_msgs/Float64";

	private final double data;

	/**
	 * Create a new Float64 with a default of 0.
	 */
	public Float64() {
		this(0);
	}

	/**
	 * Create a new Float64 with the given data value.
	 * 
	 * @param data
	 *            The data value of the double.
	 */
	public Float64(double data) {
		// build the JSON object
		super(Json.createObjectBuilder().add(Float64.FIELD_DATA, data).build(),
				Float64.TYPE);
		this.data = data;
	}

	/**
	 * Get the data value of this double.
	 * 
	 * @return The data value of this double.
	 */
	public double getData() {
		return this.data;
	}

	/**
	 * Create a deep clone of this Float64.
	 */
	@Override
	public Float64 clone() {
		return new Float64(this.data);
	}
}