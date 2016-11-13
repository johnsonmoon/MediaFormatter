package xuyihao.formatter.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 * @Author Xuyh created at 2016年11月13日 下午12:01:11
 *
 */
public class MainWindow extends Application {

	public static void main(String... strings) {
		Application.launch(MainWindow.class, strings);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("main_window.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Media Formatter");
		primaryStage.show();
	}
}
