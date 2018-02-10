package Demo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
 
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
 
public class Webview extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  launch(args);
	}

	@Override
	public void start(final Stage stage) throws Exception {
		// TODO Auto-generated method stub
		  Button buttonURL = new Button("YouTube");
	        Button buttonHtmlString = new Button("Load HTML String");
	        Button buttonHtmlFile = new Button("Load File C:/test/a.html");
	 
	        final WebView browser = new WebView();
	        final WebEngine webEngine = browser.getEngine();
	 
	        buttonURL.setOnAction(new EventHandler<ActionEvent>() {
	 
	            @Override
	            public void handle(ActionEvent event) {
	                String url = "https://www.youtube.com/";
	                // Load a page from remote url.
	                webEngine.load(url);
	            }
	        });
	 
	        buttonHtmlString.setOnAction(new EventHandler<ActionEvent>() {
	 
	            @Override
	            public void handle(ActionEvent event) {
	                String html = "<html><h1>Hello</h1><h2>Hello</h2></html>";
	                // Load HTML String
	                webEngine.loadContent(html);
	            }
	        });
	        buttonHtmlFile.setOnAction(new EventHandler<ActionEvent>() {
	 
	            @Override
	            public void handle(ActionEvent event) {
	                try {
	                    File file = new File("C:/Users/India/Desktop/DATA/Landing Page Starter Files/shubham.html");
	                    URL url = file.toURI().toURL();
	                    // file:/C:/test/a.html
	                    System.out.println("Local URL: " + url.toString());
	                    webEngine.load(url.toString());
	                } catch (MalformedURLException e) {
	                    e.printStackTrace();
	                }
	 
	            }
	        });
	 
	        VBox root = new VBox();
	        root.setPadding(new Insets(5));
	        root.setSpacing(5);
	        root.getChildren().addAll(buttonURL, buttonHtmlString, buttonHtmlFile, browser);
	 
	        Scene scene = new Scene(root);
	 
	        stage.setTitle("JavaFX WebView (o7planning.org)");
	        stage.setScene(scene);
	        stage.setWidth(450);
	        stage.setHeight(300);
	 
	        stage.show();
	    }
	}


