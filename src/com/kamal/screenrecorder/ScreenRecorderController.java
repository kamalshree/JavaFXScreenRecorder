package com.kamal.screenrecorder;

import javafx.fxml.FXML;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ScreenRecorderController {
	@FXML
	private ImageView display;
	private BufferedImage buffimage;
	private AnchorPane ap;

	// Event Listener on Button.onAction
	@FXML
	public void captureScreen(ActionEvent event) {
		try {
			Stage stage = (Stage) ap.getScene().getWindow();
			stage.setIconified(true);
			Robot robot = new Robot();
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			buffimage = robot.createScreenCapture(screenRect);
			Image image = SwingFXUtils.toFXImage(buffimage, null);
			display.setImage(image);
			stage.setIconified(false);

		} catch (AWTException e) {
			
			e.printStackTrace();
		}
	}

	// Event Listener on Button.onAction
	@FXML
	public void saveScreen(ActionEvent event) throws IOException {
		ImageIO.write(buffimage, "jpg", new File("ScreenCapture.jpg"));
	}

	// Event Listener on Button.onAction
	@FXML
	public void clearScreen(ActionEvent event) {
		display.setImage(null);
	}
}
