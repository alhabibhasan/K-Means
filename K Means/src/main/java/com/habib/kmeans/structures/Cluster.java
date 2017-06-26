/**
 * 
 */
package com.habib.kmeans.structures;

import java.util.ArrayList;

/**
 * This class models a cluster of points
 * 
 * @author Muhammed Hasan
 *
 */
public class Cluster {
	private String id;
	private ArrayList<Point> points;
	private Centroid center;

	public Cluster(String id) {
		this.points = new ArrayList<Point>();
		this.id = id;
	}

	/**
	 * Add a point to the cluster
	 * 
	 * @param p
	 *            The point to add
	 * @return
	 */
	public boolean addToCluster(Point p) {
		return points.add(p);
	}

	/**
	 * Remove a point from the cluster
	 * 
	 * @param p
	 *            The point to remove
	 * @return
	 */
	public Point removeFromCluster(Point p) {
		points.remove(p);
		return p;
	}

	/**
	 * @return the center
	 */
	public Centroid getCenter() {
		return center;
	}

	/**
	 * @param center
	 *            the center to set
	 */
	public void setCenter(Centroid center) {
		this.center = center;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the points
	 */
	public ArrayList<Point> getPoints() {
		return points;
	}

	public void assignCentroid(ArrayList<Point> points) {
		boolean assigned = false;

		while (!assigned) {
			// will loop until we find an appropriate centroid
			int indexToCheck = (int) Math.floor(Math.random() * points.size());
			Point toCheck = points.get(indexToCheck);
			// ensure that the point isnt already selected
			if (toCheck.isCentroid() == false) {
				toCheck.setCentroid(true);
				this.setCenter(new Centroid(toCheck));

				// update the point in the array
				// terminate the loop
				assigned = true;

			}
		}

	}

	@Override
	public String toString() {
		return "Cluster " + this.id + "[" + points + "]";
	}

}
