package org.usfirst.frc.team7154.robotSubsystems;

import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj.Encoder;

public class KEncoder extends Encoder {
	private static KEncoder kEncoder = null;

	 public static KEncoder getInstance(int[] args, boolean invert) {
	        if (kEncoder==null) {
	            kEncoder = new KEncoder(args[0], args[1], invert, Encoder.EncodingType.k4X);
	            kEncoder.setMaxPeriod(.1);
	            kEncoder.setMinRate(10);
	            kEncoder.setDistancePerPulse(5);
	            kEncoder.setReverseDirection(true);
	            kEncoder.setSamplesToAverage(7);
	        }
	        return kEncoder;
	    } 
	public KEncoder(int channelA, int channelB) {
		super(channelA, channelB);
		// TODO Auto-generated constructor stub
	}

	public KEncoder(DigitalSource sourceA, DigitalSource sourceB) {
		super(sourceA, sourceB);
		// TODO Auto-generated constructor stub
	}

	public KEncoder(int channelA, int channelB, boolean reverseDirection) {
		super(channelA, channelB, reverseDirection);
		// TODO Auto-generated constructor stub
	}

	public KEncoder(int channelA, int channelB, int indexChannel) {
		super(channelA, channelB, indexChannel);
		// TODO Auto-generated constructor stub
	}

	public KEncoder(DigitalSource sourceA, DigitalSource sourceB, boolean reverseDirection) {
		super(sourceA, sourceB, reverseDirection);
		// TODO Auto-generated constructor stub
	}

	public KEncoder(DigitalSource sourceA, DigitalSource sourceB, DigitalSource indexSource) {
		super(sourceA, sourceB, indexSource);
		// TODO Auto-generated constructor stub
	}

	public KEncoder(int channelA, int channelB, boolean reverseDirection, EncodingType encodingType) {
		super(channelA, channelB, reverseDirection, encodingType);
		// TODO Auto-generated constructor stub
	}

	public KEncoder(int channelA, int channelB, int indexChannel, boolean reverseDirection) {
		super(channelA, channelB, indexChannel, reverseDirection);
		// TODO Auto-generated constructor stub
	}

	public KEncoder(DigitalSource sourceA, DigitalSource sourceB, boolean reverseDirection, EncodingType encodingType) {
		super(sourceA, sourceB, reverseDirection, encodingType);
		// TODO Auto-generated constructor stub
	}

	public KEncoder(DigitalSource sourceA, DigitalSource sourceB, DigitalSource indexSource, boolean reverseDirection) {
		super(sourceA, sourceB, indexSource, reverseDirection);
		// TODO Auto-generated constructor stub
	}

}
