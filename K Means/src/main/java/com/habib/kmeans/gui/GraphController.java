/**
 * 
 */
package com.habib.kmeans.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Button;

public class GraphController implements Initializable {
	@FXML
	private Button btnSubmit;
	@FXML
	private ScatterChart<String, Double > scatterChart;
	@FXML
	private NumberAxis yAxis;
	@FXML
	private CategoryAxis xAxis;

	public void graphClick() {

		
		
		
	}

	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	public void initialize(URL location, ResourceBundle resources) {
		
		XYChart.Series series = new XYChart.Series();
		series.getData().add(new Data("A", 2.0));
		series.getData().add(new Data("B", 9.0));
		series.getData().add(new Data("C", 10.0));
		series.getData().add(new Data("D", 13.0));

		scatterChart.getData().addAll(series);
	}

}
