/**
 * 
 */
package com.habib.kmeans.run;

import java.util.ArrayList;

import com.habib.kmeans.main.KMeans;
import com.habib.kmeans.main.MetricType;
import com.habib.kmeans.structures.Centroid;
import com.habib.kmeans.structures.Cluster;
import com.habib.kmeans.structures.Point;

/**
 * @author Muhammed Hasan
 *
 */
public class Driver {
	public static void main(String[] args) {
		Point a = new Point(1, 2, "a");
		Point b = new Point(2, 5, "b");
		Point c = new Point(2, 10, "c");
		Point d = new Point(4, 9, "d");
		Point e = new Point(5, 8, "e");
		Point f = new Point(6, 4, "f");
		Point g = new Point(7, 5, "g");
		Point h = new Point(8, 4, "h");
		

		ArrayList<Point> points = new ArrayList<Point>();

		/*points.add(a);
		points.add(b);
		points.add(c);
		points.add(d);
		points.add(e);
		points.add(f);
		points.add(g);
		points.add(h);*/
		
		

		Cluster c1 = new Cluster("Orange");
		c1.assignCentroid(points);

		Cluster c2 = new Cluster("Green");
		c2.assignCentroid(points);
		
		Cluster c3 = new Cluster("Gray");
		c3.assignCentroid(points);

		ArrayList<Cluster> clusters = new ArrayList<Cluster>();

		clusters.add(c1);
		clusters.add(c2);
		clusters.add(c3);

		KMeans means = new KMeans(clusters, points);

		means.setMetric(MetricType.Manhattan);
		
		
		
		means.run();
		

	}
}
