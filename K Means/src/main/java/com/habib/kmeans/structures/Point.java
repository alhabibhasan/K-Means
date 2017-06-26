/**
 * 
 */
package com.habib.kmeans.structures;

import java.io.Serializable;
import java.util.UUID;

import com.habib.kmeans.main.MetricType;

/**
 * this class will model a single data point.
 * 
 * @author Muhammed Hasan
 *
 */
public class Point implements Serializable {
	private String id;
	private static final long serialVersionUID = 8749885643557358699L;
	private double x, y;
	private Cluster cluster;
	private boolean isCentroid;
	private double distanceFromCentroid;

	/**
	 * @param x
	 *            The x coordinate
	 * @param y
	 *            The y coordinate
	 * @param cluster
	 */
	public Point(double x, double y, String id) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.isCentroid = false;
		this.distanceFromCentroid = -1;
		this.cluster = null;///
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * @return the cluster
	 */
	public Cluster getCluster() {
		return cluster;
	}

	/**
	 * @param cluster
	 *            the cluster to set
	 */
	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
		System.out.println(this.id + " assigned to cluster " + cluster.getId());
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the isCentroid
	 */
	public boolean isCentroid() {
		return isCentroid;
	}

	/**
	 * @param isCentroid
	 *            the isCentroid to set
	 */
	public void setCentroid(boolean isCentroid) {
		this.isCentroid = isCentroid;
	}

	/**
	 * @return the distanceFromCenter
	 */
	public double getDistanceFromCenter() {
		return distanceFromCentroid;
	}

	/**
	 * @param distanceFromCenter
	 *            the distanceFromCenter to set this value only changes if the
	 *            current value of -1 and the value passed in is lower than the
	 *            current value
	 */
	public void setDistanceFromCenter(double distanceFromCenter) {
		this.distanceFromCentroid = distanceFromCenter;
	}

	/**
	 * Calculates the distance between the current point and another point
	 * provided
	 * 
	 * @param p
	 *            The other point
	 * @param metricType
	 *            Specify the metric to use, either manhattan or euclidean
	 *            Default metric is manhattan.
	 * @return
	 */
	public double getDistanceBetween(Point p, MetricType metricType) {
		if (metricType == MetricType.Euclidean) {
			double xVal = this.getX() - p.getX();
			double yVal = this.getY() - p.getY();
			double squaredSum = Math.pow(xVal, 2) + Math.pow(yVal, 2);
			return Math.sqrt(squaredSum);
		} else {
			double xVal = Math.abs(this.getX() - p.getX());
			double yVal = Math.abs(this.getY() - p.getY());
			return xVal + yVal;
		}
	}

	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", Cluster: " + cluster.getId() + " ]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cluster == null) ? 0 : cluster.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isCentroid ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (cluster == null) {
			if (other.cluster != null)
				return false;
		} else if (!cluster.equals(other.cluster))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isCentroid != other.isCentroid)
			return false;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

}
