/**
 * 
 */
package com.habib.kmeans.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import com.habib.kmeans.structures.Centroid;
import com.habib.kmeans.structures.Cluster;
import com.habib.kmeans.structures.Point;

/**
 * @author Muhammed Hasan
 *
 */
public class KMeans {
	private ArrayList<Cluster> clusters;
	private ArrayList<Point> points;
	private MetricType metricType;

	public KMeans(ArrayList<Cluster> clusters, ArrayList<Point> points) {
		this.clusters = clusters;
		this.points = points;
		this.metricType = MetricType.Manhattan;
	}

	/**
	 * Used to set the metric to be used. Default is manhattan. Inputting an
	 * invalid metric will result in the default one being used.
	 * 
	 * @param type
	 */
	public void setMetric(MetricType type) {
		if (type == MetricType.Euclidean) {
			this.metricType = MetricType.Euclidean;
			System.out.println("Using metric " + metricType.toString());
		} else {
			System.out.println("Using default metric " + metricType.toString());
		}
	}

	/**
	 * Used to start the K means algorithm.
	 */
	public void run() {
		if (checkValidRun()) { // check if the algo can run without any errors
			double[][] results = new double[points.size()][clusters.size()];
			double[][] previousResults = null;
			boolean isFinished = false;
			int iterNo = 1;
			while (!isFinished) {
				System.out.println("-----------------------------");
				System.out.println("iter no.: " + iterNo);
				for (int pointer = 0; pointer < points.size(); pointer++) {
					for (int clust = 0; clust < clusters.size(); clust++) {
						Point pointAccessing = points.get(pointer);
						Cluster clusterAccessing = clusters.get(clust);
						// get the distance between the current point and the
						// current
						// centroid
						double distance = clusterAccessing.getCenter().getDistanceBetween(pointAccessing, metricType);

						// plot the distance
						results[pointer][clust] = distance;

						assignPointToCluster(pointAccessing, clusterAccessing, distance);

					}

				}

				if (previousResults == null || !Arrays.equals(results, previousResults)) {
					previousResults = results;
					getNewCentroids(clusters);

				} else {
					isFinished = true;
				}
				iterNo++;
				printGrid(results);

			}
			System.out.println("-----------------------------");
			outputCluster(clusters);
		}
	}

	/**
	 * Assigns a point to the appropriate cluster
	 * 
	 * @param pointAccessing
	 *            The point being assessed at present
	 * @param clusterAccessing
	 *            The cluster being assessed at present
	 * @param distance
	 *            The distance calculcated between the point and the centroid of
	 *            the cluster
	 */
	private void assignPointToCluster(Point pointAccessing, Cluster clusterAccessing,
			double distanceFromPointToCentroid) {

		// check if the point has been assigned to any cluster at all
		if (pointAccessing.getCluster() == null) {
			// the point hasnt been assigned yet
			pointAccessing.setCluster(clusterAccessing);
			pointAccessing.setDistanceFromCenter(distanceFromPointToCentroid);

			clusterAccessing.addToCluster(pointAccessing);

		} else {
			// the point has been assigned, we are looking to take the best
			// distance
			if (distanceFromPointToCentroid < pointAccessing.getDistanceFromCenter()) {

				// disassociating with the further cluster
				Cluster oldCluster = pointAccessing.getCluster();
				oldCluster.removeFromCluster(pointAccessing);

				// associating with the closer cluster

				clusterAccessing.addToCluster(pointAccessing);

				pointAccessing.setCluster(clusterAccessing);
				pointAccessing.setDistanceFromCenter(distanceFromPointToCentroid);
			}
		}
	}
	
	/**
	 * @return
	 */
	private boolean checkValidRun() {
		if (this.points.isEmpty() || this.clusters.isEmpty()) {
			return false;
		}

		return true;
	}

	/**
	 * This method output each cluster in a string form
	 * 
	 * @param clusters
	 *            The list of clusters
	 */
	private void outputCluster(ArrayList<Cluster> clusters) {
		for (Cluster c : clusters) {
			System.out.println(":: Cluster ::");
			System.out.println(c.toString());
		}

	}

	

	/**
	 * This method takes in the current list of clusters and from each cluster
	 * is derives the new centroids for each cluster.
	 * 
	 * @param clusters
	 *            The current list of clusters
	 */
	private void getNewCentroids(ArrayList<Cluster> clusters) {
		Iterator<Cluster> clusterIter = clusters.iterator();

		while (clusterIter.hasNext()) {
			Cluster currentCluster = clusterIter.next();
			int noOfPoints = currentCluster.getPoints().size();
			double sumX = 0;
			double sumY = 0;

			Iterator<Point> pointsIter = currentCluster.getPoints().iterator();

			while (pointsIter.hasNext()) {
				Point currentPoint = pointsIter.next();

				// add up the all the x and y values
				sumX += currentPoint.getX();
				sumY += currentPoint.getY();
			}
			// set the x and y value of each cluster as the of the x or y value
			// divided by the number of points
			// assigned to the cluster
			currentCluster.getCenter().setX(sumX / noOfPoints);
			currentCluster.getCenter().setY(sumY / noOfPoints);

		}

	}

	/**
	 * @return the clusters
	 */
	public ArrayList<Cluster> getClusters() {
		return clusters;
	}

	/**
	 * @return the points
	 */
	public ArrayList<Point> getPoints() {
		return points;
	}

	/**
	 * Method outputs the 2D matrix
	 * 
	 * @param results
	 */
	private void printGrid(double[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "|");
			}
			System.out.println();
		}

	}

}
