/**
 * 
 */
package com.habib.kmeans.structures;

/**
 * @author Muhammed Hasan
 *
 */
public class Centroid extends Point {
	
	private static final long serialVersionUID = -7799894249264769591L;

	/**
	 * @param x
	 * @param y
	 * @param cluster
	 */
	public Centroid(double x, double y, String s){
		super(x, y, s);
	}
	
	public Centroid(Point p) {
		super(p.getX(), p.getY(), p.getId());
		this.setCentroid(p.isCentroid());
	}
	
	

}
