package xuyihao.formatter.ui.executor;

import java.io.File;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import xuyihao.formatter.invoker.executer.Executor;
import xuyihao.formatter.invoker.progress.Progress;
import xuyihao.formatter.ui.window.information.InformationWindow;
import xuyihao.formatter.ui.window.warning.WarningWindow;

/**
 * 视频片段截取
 * 
 * @Author Xuyh created at 2016年11月14日 上午11:07:19
 *
 */
public class CutVideoExecutor {
	private TextField main_text_field_inputFile;
	private TextField main_text_field_outputFilePath;
	private TextField main_tab_cutVideo_text_field_outputFileName;
	private ChoiceBox<String> main_tab_cutVideo_choise_box_outputFileType;
	private TextField main_tab_cutVideo_text_field_beginTime;
	private TextField main_tab_cutVideo_text_field_lastTime;

	public CutVideoExecutor(TextField main_text_field_inputFile, TextField main_text_field_outputFilePath,
			TextField main_tab_cutVideo_text_field_outputFileName,
			ChoiceBox<String> main_tab_cutVideo_choise_box_outputFileType, TextField main_tab_cutVideo_text_field_beginTime,
			TextField main_tab_cutVideo_text_field_lastTime) {
		super();
		this.main_text_field_inputFile = main_text_field_inputFile;
		this.main_text_field_outputFilePath = main_text_field_outputFilePath;
		this.main_tab_cutVideo_text_field_outputFileName = main_tab_cutVideo_text_field_outputFileName;
		this.main_tab_cutVideo_choise_box_outputFileType = main_tab_cutVideo_choise_box_outputFileType;
		this.main_tab_cutVideo_text_field_beginTime = main_tab_cutVideo_text_field_beginTime;
		this.main_tab_cutVideo_text_field_lastTime = main_tab_cutVideo_text_field_lastTime;
	}

	private String inputFile = "";
	private String outputPath = "";
	private String outputFileName = "";
	private String outputFileType = "";
	private String beginTime = "";
	private String lastTime = "";

	public void cutVideo() {
		refreshState();
		if (inputFile == null || inputFile.equals("")) {
			new WarningWindow("inputFile is null !").show();
		} else {
			if (outputPath == null || outputPath.equals("")) {
				new WarningWindow("outputPath is null !").show();
			} else {
				if (outputFileName == null || outputFileName.equals("")) {
					new WarningWindow("outputFileName is null !").show();
				} else {
					if (outputFileType == null || outputFileType.equals("")) {
						new WarningWindow("outputFileType is null !").show();
					} else {
						if (beginTime == null || beginTime.equals("")) {
							new WarningWindow("beginTime is null !").show();
						} else {
							if (lastTime == null || lastTime.equals("")) {
								new WarningWindow("lastTime is null !").show();
							} else {
								final Progress progress = Executor.cutoutVideo(inputFile,
										outputPath + File.separator + outputFileName + outputFileType, beginTime, lastTime);
								final InformationWindow informationWindow = new InformationWindow("视频截取中...", 18.0, progress);
								informationWindow.show();
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

	private void refreshState() {
		inputFile = main_text_field_inputFile.getText().trim();
		outputPath = main_text_field_outputFilePath.getText().trim();
		outputFileName = main_tab_cutVideo_text_field_outputFileName.getText().trim();
		outputFileType = main_tab_cutVideo_choise_box_outputFileType.getSelectionModel().getSelectedItem();
		beginTime = main_tab_cutVideo_text_field_beginTime.getText().trim();
		lastTime = main_tab_cutVideo_text_field_lastTime.getText().trim();
	}
}
