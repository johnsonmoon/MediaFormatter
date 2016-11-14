package xuyihao.formatter.ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

/**
 * 
 * @Author Xuyh created at 2016年11月13日 下午12:01:11
 *
 */
public class MainWindow extends Application {
	public static Stage MAIN_WINDOW_STAGE_CONTEXT = null;
	private ChoiceBox<String> main_tab_exchange_choise_box_outputFileType_splitVideo;
	private ChoiceBox<String> main_tab_exchange_choise_box_outputFileType_splitAudio;
	private ChoiceBox<String> main_tab_exchange_choise_box_outputFileType_convertFormat;
	private ChoiceBox<String> main_tab_cutImage_choise_box_outputFileType;
	private ChoiceBox<String> main_tab_cutVideo_choise_box_outputFileType;
	private ChoiceBox<String> main_tab_combine_video_choise_box_outputFileType;
	private ChoiceBox<String> main_tab_screenShut_choise_box_outputFileType;

	public static void main(String... strings) {
		Application.launch(MainWindow.class, strings);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		MainWindow.MAIN_WINDOW_STAGE_CONTEXT = primaryStage;
		Parent root = FXMLLoader.load(getClass().getResource("main_window.fxml"));
		initView(root);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Media Formatter");
		primaryStage.show();
	}

	/**
	 * 类似android获取view并初始化
	 *
	 * @param parent
	 */
	@SuppressWarnings("unchecked")
	private void initView(Parent parent) {
		main_tab_exchange_choise_box_outputFileType_splitVideo = (ChoiceBox<String>) parent
				.lookup("#main_tab_exchange_choise_box_outputFileType_splitVideo");
		main_tab_exchange_choise_box_outputFileType_splitAudio = (ChoiceBox<String>) parent
				.lookup("#main_tab_exchange_choise_box_outputFileType_splitAudio");
		main_tab_exchange_choise_box_outputFileType_convertFormat = (ChoiceBox<String>) parent
				.lookup("#main_tab_exchange_choise_box_outputFileType_convertFormat");
		main_tab_cutImage_choise_box_outputFileType = (ChoiceBox<String>) parent
				.lookup("#main_tab_cutImage_choise_box_outputFileType");
		main_tab_cutVideo_choise_box_outputFileType = (ChoiceBox<String>) parent
				.lookup("#main_tab_cutVideo_choise_box_outputFileType");
		main_tab_combine_video_choise_box_outputFileType = (ChoiceBox<String>) parent
				.lookup("#main_tab_combine_video_choise_box_outputFileType");
		main_tab_screenShut_choise_box_outputFileType = (ChoiceBox<String>) parent
				.lookup("#main_tab_screenShut_choise_box_outputFileType");

		main_tab_exchange_choise_box_outputFileType_splitVideo
				.setItems(FXCollections.<String> observableArrayList(".mp4", ".mkv", ".flv", ".avi", ".3gp"));
		main_tab_exchange_choise_box_outputFileType_splitAudio
				.setItems(FXCollections.<String> observableArrayList(".mp3", ".wmv"));
		main_tab_exchange_choise_box_outputFileType_convertFormat
				.setItems(FXCollections.<String> observableArrayList(".mp4", ".mkv", ".flv", ".avi", ".3gp"));
		main_tab_cutImage_choise_box_outputFileType
				.setItems(FXCollections.<String> observableArrayList(".jpg", ".jpeg", ".png", "bmp"));
		main_tab_cutVideo_choise_box_outputFileType
				.setItems(FXCollections.<String> observableArrayList(".mp4", ".mkv", ".flv", ".avi", ".3gp"));
		main_tab_combine_video_choise_box_outputFileType
				.setItems(FXCollections.<String> observableArrayList(".mp4", ".mkv", ".flv", ".avi", ".3gp"));
		main_tab_screenShut_choise_box_outputFileType.setItems(FXCollections.<String> observableArrayList(".jpg", ".jpeg",
				".png", "bmp", ".mp4", ".mkv", ".flv", ".avi", ".3gp"));
	}
}
