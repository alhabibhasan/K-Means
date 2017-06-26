/**
 * 
 */
package com.habib.kmeans.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Muhammed Hasan
 *
 */
public class Graph extends Application {
	public static void main(String[] args) {
		launch(args);

	}

	public static Stage stage;

	@Override
	public void start(Stage stage) throws Exception {
		Graph.stage = stage; // initialize value of stage.
		Parent root = FXMLLoader.load(getClass().getResource("MeansGUI.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

		stage.setResizable(false);
	}
}
