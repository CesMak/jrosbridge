package edu.wpi.rail.jrosbridge.messages.geometry;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPoint {

	private Point empty, p1, p2, p3;

	@Before
	public void setUp() {
		empty = new Point();
		p1 = new Point(0.5);
		p2 = new Point(0.5, 1.5);
		p3 = new Point(0.5, 1.5, 3.0);
	}

	@Test
	public void testConstructor() {
		assertEquals(0.0, empty.getX());
		assertEquals(0.0, empty.getY());
		assertEquals(0.0, empty.getZ());

		assertEquals("{\"x\":0.0,\"y\":0.0,\"z\":0.0}", empty.toString());

		assertEquals(3, empty.toJsonObject().size());
		assertEquals(0.0, empty.toJsonObject().getJsonNumber(Point.FIELD_X)
				.doubleValue());
		assertEquals(0.0, empty.toJsonObject().getJsonNumber(Point.FIELD_Y)
				.doubleValue());
		assertEquals(0.0, empty.toJsonObject().getJsonNumber(Point.FIELD_Z)
				.doubleValue());

		assertEquals(Point.TYPE, empty.getMessageType());
	}

	@Test
	public void testDoubleConstructor() {
		assertEquals(0.5, p1.getX());
		assertEquals(0.0, p1.getY());
		assertEquals(0.0, p1.getZ());

		assertEquals("{\"x\":0.5,\"y\":0.0,\"z\":0.0}", p1.toString());

		assertEquals(3, p1.toJsonObject().size());
		assertEquals(0.5, p1.toJsonObject().getJsonNumber(Point.FIELD_X)
				.doubleValue());
		assertEquals(0.0, p1.toJsonObject().getJsonNumber(Point.FIELD_Y)
				.doubleValue());
		assertEquals(0.0, p1.toJsonObject().getJsonNumber(Point.FIELD_Z)
				.doubleValue());

		assertEquals(Point.TYPE, empty.getMessageType());
	}

	@Test
	public void testDoubleAndDoubleConstructor() {
		assertEquals(0.5, p2.getX());
		assertEquals(1.5, p2.getY());
		assertEquals(0.0, p2.getZ());

		assertEquals("{\"x\":0.5,\"y\":1.5,\"z\":0.0}", p2.toString());

		assertEquals(3, p2.toJsonObject().size());
		assertEquals(0.5, p2.toJsonObject().getJsonNumber(Point.FIELD_X)
				.doubleValue());
		assertEquals(1.5, p2.toJsonObject().getJsonNumber(Point.FIELD_Y)
				.doubleValue());
		assertEquals(0.0, p2.toJsonObject().getJsonNumber(Point.FIELD_Z)
				.doubleValue());

		assertEquals(Point.TYPE, empty.getMessageType());
	}

	@Test
	public void testDoubleDoubleAndDoubleConstructor() {
		assertEquals(0.5, p3.getX());
		assertEquals(1.5, p3.getY());
		assertEquals(3.0, p3.getZ());

		assertEquals("{\"x\":0.5,\"y\":1.5,\"z\":3.0}", p3.toString());

		assertEquals(3, p3.toJsonObject().size());
		assertEquals(0.5, p3.toJsonObject().getJsonNumber(Point.FIELD_X)
				.doubleValue());
		assertEquals(1.5, p3.toJsonObject().getJsonNumber(Point.FIELD_Y)
				.doubleValue());
		assertEquals(3.0, p3.toJsonObject().getJsonNumber(Point.FIELD_Z)
				.doubleValue());

		assertEquals(Point.TYPE, empty.getMessageType());
	}

	@Test
	public void testSetType() {
		empty.setMessageType("test");
		assertEquals("test", empty.getMessageType());
	}

	@Test
	public void testHashCode() {
		assertEquals(empty.toString().hashCode(), empty.hashCode());
		assertEquals(p1.toString().hashCode(), p1.hashCode());
		assertEquals(p2.toString().hashCode(), p2.hashCode());
		assertEquals(p3.toString().hashCode(), p3.hashCode());
	}

	@Test
	public void testEquals() {
		assertFalse(empty.equals(p1));
		assertFalse(p1.equals(empty));
		assertFalse(empty.equals(p2));
		assertFalse(p2.equals(empty));
		assertFalse(empty.equals(p3));
		assertFalse(p3.equals(empty));

		assertFalse(p1.equals(p2));
		assertFalse(p1.equals(p3));
		assertFalse(p2.equals(p1));
		assertFalse(p2.equals(p3));
		assertFalse(p3.equals(p1));
		assertFalse(p3.equals(p2));

		assertTrue(empty.equals(empty));
		assertTrue(p1.equals(p1));
		assertTrue(p2.equals(p2));
		assertTrue(p3.equals(p3));
	}

	@Test
	public void testEqualsWrongObject() {
		assertFalse(empty.equals(new String(empty.toString())));
	}

	@Test
	public void testClone() {
		Point clone = p3.clone();
		assertEquals(p3.toString(), clone.toString());
		assertEquals(p3.toJsonObject(), clone.toJsonObject());
		assertEquals(p3.getMessageType(), clone.getMessageType());
		assertEquals(p3.getX(), clone.getX());
		assertEquals(p3.getY(), clone.getY());
		assertEquals(p3.getZ(), clone.getZ());
		assertNotSame(p3, clone);
		assertNotSame(p3.toString(), clone.toString());
		assertNotSame(p3.toJsonObject(), clone.toJsonObject());
	}
}