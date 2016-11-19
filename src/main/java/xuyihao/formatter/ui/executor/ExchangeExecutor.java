package xuyihao.formatter.ui.executor;

import java.io.File;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import xuyihao.formatter.invoker.executer.Executor;
import xuyihao.formatter.invoker.progress.Progress;
import xuyihao.formatter.ui.window.information.InformationWindow;
import xuyihao.formatter.ui.window.warning.WarningWindow;

/**
 * 
 * @Author Xuyh created at 2016年11月14日 上午11:06:22
 *
 */
public class ExchangeExecutor {
	private TextField main_text_field_inputFile;
	private TextField main_text_field_outputFilePath;
	private TextField main_tab_exchange_text_field_outputFileName;
	private ChoiceBox<String> main_tab_exchange_choise_box_outputFileType_splitVideo;
	private ChoiceBox<String> main_tab_exchange_choise_box_outputFileType_splitAudio;
	private ChoiceBox<String> main_tab_exchange_choise_box_outputFileType_convertFormat;

	public ExchangeExecutor(TextField main_text_field_inputFile, TextField main_text_field_outputFilePath,
			TextField outputFieldFileName, ChoiceBox<String> videoTypeBox, ChoiceBox<String> audioTypeBox,
			ChoiceBox<String> converFormatTypeBox) {
		this.main_text_field_inputFile = main_text_field_inputFile;
		this.main_text_field_outputFilePath = main_text_field_outputFilePath;
		this.main_tab_exchange_choise_box_outputFileType_splitVideo = videoTypeBox;
		this.main_tab_exchange_text_field_outputFileName = outputFieldFileName;
		this.main_tab_exchange_choise_box_outputFileType_splitAudio = audioTypeBox;
		this.main_tab_exchange_choise_box_outputFileType_convertFormat = converFormatTypeBox;
	}

	private String inputFile = "";
	private String outputPath = "";
	private String outputName = "";
	private String splitVideoOutputType = "";
	private String splitAudioOutputType = "";
	private String convertFormatOutputType = "";

	public void splitVideo() {
		refreshState();
		if (inputFile == null || inputFile.equals("")) {
			new WarningWindow("Input File is null!").show();
		} else {
			if (outputPath == null || outputPath.equals("")) {
				new WarningWindow("Output path is null!").show();
			} else {
				if (outputName == null || outputName.equals("")) {
					new WarningWindow("File name is null!").show();
				} else {
					if (splitVideoOutputType == null || splitVideoOutputType.equals("")) {
						new WarningWindow("File suffix is null!").show();
					} else {
						String inputVideoPathName = inputFile;
						String outputVideoPathName = outputPath + File.separator + outputName + splitVideoOutputType;
						final Progress progress = Executor.splitVideo(inputVideoPathName, outputVideoPathName);
						final InformationWindow informationWindow = new InformationWindow("分离视频中...", 18.0, progress);
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

	public void splitAudio() {
		refreshState();
		if (inputFile == null || inputFile.equals("")) {
			new WarningWindow("Input File is null!").show();
		} else {
			if (outputPath == null || outputPath.equals("")) {
				new WarningWindow("Output path is null!").show();
			} else {
				if (outputName == null || outputName.equals("")) {
					new WarningWindow("File name is null!").show();
				} else {
					if (splitAudioOutputType == null || splitAudioOutputType.equals("")) {
						new WarningWindow("File suffix is null!").show();
					} else {
						String inputVideoPathName = inputFile;
						String outputAudioPathName = outputPath + File.separator + outputName + splitAudioOutputType;
						final Progress progress = Executor.splitAudio(inputVideoPathName, outputAudioPathName);
						final InformationWindow informationWindow = new InformationWindow("分离音频中...", 18.0, progress);
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

	public void convertFormat() {
		refreshState();
		if (inputFile == null || inputFile.equals("")) {
			new WarningWindow("Input File is null!").show();
		} else {
			if (outputPath == null || outputPath.equals("")) {
				new WarningWindow("Output path is null!").show();
			} else {
				if (outputName == null || outputName.equals("")) {
					new WarningWindow("File name is null!").show();
				} else {
					if (convertFormatOutputType == null || convertFormatOutputType.equals("")) {
						new WarningWindow("File suffix is null!").show();
					} else {
						String inputVideoPathName = inputFile;
						String outputVideoPathName = outputPath + File.separator + outputName + convertFormatOutputType;
						final Progress progress = Executor.convertFromat(inputVideoPathName, outputVideoPathName);
						final InformationWindow informationWindow = new InformationWindow("格式转换中...", 18.0, progress);
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

	private void refreshState() {
		inputFile = main_text_field_inputFile.getText().trim();
		outputPath = main_text_field_outputFilePath.getText().trim();
		outputName = main_tab_exchange_text_field_outputFileName.getText().trim();
		splitVideoOutputType = main_tab_exchange_choise_box_outputFileType_splitVideo.getSelectionModel().getSelectedItem();
		splitAudioOutputType = main_tab_exchange_choise_box_outputFileType_splitAudio.getSelectionModel().getSelectedItem();
		convertFormatOutputType = main_tab_exchange_choise_box_outputFileType_convertFormat.getSelectionModel()
				.getSelectedItem();
	}
}
