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
 * @Author Xuyh created at 2016年11月14日 上午11:06:50
 *
 */
public class CutImageExecutor {
	private TextField main_text_field_inputFile;
	private TextField main_text_field_outputFilePath;
	private TextField main_tab_cutImage_text_field_cutTime;
	private TextField main_tab_cutImage_text_field_outputFileName;
	//截取图片类型（后缀名）
	private ChoiceBox<String> main_tab_cutImage_choise_box_outputFileType;
	//截取图片组使用
	private TextField main_tab_cutImage_text_field_cutRate;

	public CutImageExecutor(TextField main_text_field_inputFile, TextField main_text_field_outputFilePath,
			TextField main_tab_cutImage_text_field_cutTime, TextField main_tab_cutImage_text_field_outputFileName,
			ChoiceBox<String> main_tab_cutImage_choise_box_outputFileType, TextField main_tab_cutImage_text_field_cutRate) {
		super();
		this.main_text_field_inputFile = main_text_field_inputFile;
		this.main_text_field_outputFilePath = main_text_field_outputFilePath;
		this.main_tab_cutImage_text_field_cutTime = main_tab_cutImage_text_field_cutTime;
		this.main_tab_cutImage_text_field_outputFileName = main_tab_cutImage_text_field_outputFileName;
		this.main_tab_cutImage_choise_box_outputFileType = main_tab_cutImage_choise_box_outputFileType;
		this.main_tab_cutImage_text_field_cutRate = main_tab_cutImage_text_field_cutRate;
	}

	private String inputFile = "";
	private String outputPath = "";
	private String cutTime = "";
	private String outputFileName = "";
	private String outputFileType = "";
	private String cutRate = "";

	/**
	 * 截取单张图片
	 */
	public void cutSingleImage() {
		refreshState();
		if (inputFile == null || inputFile.equals("")) {
			new WarningWindow("Input file is null !").show();
		} else {
			if (outputPath == null || outputPath.equals("")) {
				new WarningWindow("File output path is null !").show();
			} else {
				if (cutTime == null || cutTime.equals("")) {
					new WarningWindow("Cut time is null !").show();
				} else {
					if (outputFileName == null || outputFileName.equals("")) {
						new WarningWindow("Output file name is null !").show();
					} else {
						if (outputFileType == null || outputFileType.equals("")) {
							new WarningWindow("Output file suffix is null !").show();
						} else {
							final Progress progress = Executor.cutoutVideoForSingleImage(inputFile,
									outputPath + File.separator + outputFileName + outputFileType, Float.parseFloat(cutTime));
							final InformationWindow informationWindow = new InformationWindow("截图中...", 18.0, progress);
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

	/**
	 * 截取一系列图片
	 */
	public void cutImageArray() {
		refreshState();
		if (inputFile == null || inputFile.equals("")) {
			new WarningWindow("Input file is null !").show();
		} else {
			if (outputPath == null || outputPath.equals("")) {
				new WarningWindow("File output path is null !").show();
			} else {
				if (outputFileType == null || outputFileType.equals("")) {
					new WarningWindow("Output file suffix is null !").show();
				} else {
					if (cutRate == null || cutRate.equals("")) {
						new WarningWindow("CutRate is null !").show();
					} else {
						final Progress progress = Executor.cutoutVideoForImageArray(inputFile, outputPath, outputFileType,
								Float.parseFloat(cutRate));
						final InformationWindow informationWindow = new InformationWindow("截图片组中...", 18.0, progress);
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
		cutTime = main_tab_cutImage_text_field_cutTime.getText().trim();
		outputFileName = main_tab_cutImage_text_field_outputFileName.getText().trim();
		outputFileType = main_tab_cutImage_choise_box_outputFileType.getSelectionModel().getSelectedItem();
		cutRate = main_tab_cutImage_text_field_cutRate.getText().trim();
	}
}
