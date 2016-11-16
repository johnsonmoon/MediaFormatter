package xuyihao.formatter.ui.executor;

import java.io.File;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import xuyihao.formatter.invoker.executer.Executor;
import xuyihao.formatter.invoker.progress.Progress;
import xuyihao.formatter.ui.window.information.InformationWindow;
import xuyihao.formatter.ui.window.warning.WarningWindow;

/**
 * 合成视频
 * 
 * @Author Xuyh created at 2016年11月14日 上午11:08:51
 *
 */
public class CombineVideoExecutor {
	private TextField main_text_field_outputFilePath;
	private TextField main_tab_combine_video_text_field_inputVideo;
	private TextField main_tab_combine_video_text_field_inputAudio;
	private TextField main_tab_combine_video_text_field_outputFileName;
	private ChoiceBox<String> main_tab_combine_video_choise_box_outputFileType;

	public CombineVideoExecutor(TextField main_text_field_outputFilePath,
			TextField main_tab_combine_video_text_field_inputVideo, TextField main_tab_combine_video_text_field_inputAudio,
			TextField main_tab_combine_video_text_field_outputFileName,
			ChoiceBox<String> main_tab_combine_video_choise_box_outputFileType) {
		super();
		this.main_text_field_outputFilePath = main_text_field_outputFilePath;
		this.main_tab_combine_video_text_field_inputVideo = main_tab_combine_video_text_field_inputVideo;
		this.main_tab_combine_video_text_field_inputAudio = main_tab_combine_video_text_field_inputAudio;
		this.main_tab_combine_video_text_field_outputFileName = main_tab_combine_video_text_field_outputFileName;
		this.main_tab_combine_video_choise_box_outputFileType = main_tab_combine_video_choise_box_outputFileType;
	}

	private String inputVideo = "";
	private String inputAudio = "";
	private String outputFilePath = "";
	private String outputFileName = "";
	private String outputFileType = "";

	private void refresh() {
		inputVideo = main_tab_combine_video_text_field_inputVideo.getText().trim();
		inputAudio = main_tab_combine_video_text_field_inputAudio.getText().trim();
		outputFilePath = main_text_field_outputFilePath.getText().trim();
		outputFileName = main_tab_combine_video_text_field_outputFileName.getText().trim();
		outputFileType = main_tab_combine_video_choise_box_outputFileType.getSelectionModel().getSelectedItem();
	}

	/**
	 * 合成视频
	 */
	public void combineVideo() {
		refresh();
		if (inputVideo == null || inputVideo.equals("")) {
			new WarningWindow("inputVideo is null !").show();
		} else {
			if (inputAudio == null || inputAudio.equals("")) {
				new WarningWindow("inputAudio is null !").show();
			} else {
				if (outputFilePath == null || outputFilePath.equals("")) {
					new WarningWindow("outputFilePath is null !").show();
				} else {
					if (outputFileName == null || outputFileName.equals("")) {
						new WarningWindow("outputFileName is null !").show();
					} else {
						if (outputFileType == null || outputFileType.equals("")) {
							new WarningWindow("outputFileType is null !").show();
						} else {
							final InformationWindow informationWindow = new InformationWindow("视频合成中...", 18.0);
							informationWindow.show();
							final Progress progress = Executor.compoundVideoAndAudio(inputVideo, inputAudio,
									outputFilePath + File.separator + outputFileName + outputFileType);
							informationWindow.appendInformationMessage("\r\nCommand--> \r\n#" + progress.getCommand());
							new Thread(new Runnable() {
								public void run() {
									progress.waitFor();
									informationWindow.appendInformationMessage("\r\n执行完成!");
								}
							}).start();
						}
					}
				}
			}
		}
	}
}
