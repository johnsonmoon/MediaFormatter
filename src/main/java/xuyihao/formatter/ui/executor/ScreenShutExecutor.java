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
 * @Author Xuyh created at 2016年11月14日 上午11:08:43
 *
 */
public class ScreenShutExecutor {
	private TextField main_text_field_outputFilePath;
	private TextField main_tab_screenShut_text_field_offsetX;
	private TextField main_tab_screenShut_text_field_offsetY;
	private TextField main_tab_screenShut_text_field_sizeX;
	private TextField main_tab_screenShut_text_field_sizeY;
	private TextField main_tab_screenShut_text_field_outputFileName;
	private ChoiceBox<String> main_tab_screenShut_choise_box_outputFileType;
	private TextField main_tab_screenShut_text_field_frameRate;

	public ScreenShutExecutor(TextField main_text_field_outputFilePath, TextField main_tab_screenShut_text_field_offsetX,
			TextField main_tab_screenShut_text_field_offsetY, TextField main_tab_screenShut_text_field_sizeX,
			TextField main_tab_screenShut_text_field_sizeY, TextField main_tab_screenShut_text_field_outputFileName,
			ChoiceBox<String> main_tab_screenShut_choise_box_outputFileType,
			TextField main_tab_screenShut_text_field_frameRate) {
		super();
		this.main_text_field_outputFilePath = main_text_field_outputFilePath;
		this.main_tab_screenShut_text_field_offsetX = main_tab_screenShut_text_field_offsetX;
		this.main_tab_screenShut_text_field_offsetY = main_tab_screenShut_text_field_offsetY;
		this.main_tab_screenShut_text_field_sizeX = main_tab_screenShut_text_field_sizeX;
		this.main_tab_screenShut_text_field_sizeY = main_tab_screenShut_text_field_sizeY;
		this.main_tab_screenShut_text_field_outputFileName = main_tab_screenShut_text_field_outputFileName;
		this.main_tab_screenShut_choise_box_outputFileType = main_tab_screenShut_choise_box_outputFileType;
		this.main_tab_screenShut_text_field_frameRate = main_tab_screenShut_text_field_frameRate;
	}

	private String outputPath = "";
	private String offsetX = "";
	private String offsetY = "";
	private String sizeX = "";
	private String sizeY = "";
	private String outputFileName = "";
	private String outputFileType = "";
	private String frameRate = "";

	private void refreshState() {
		outputPath = main_text_field_outputFilePath.getText().trim();
		offsetX = main_tab_screenShut_text_field_offsetX.getText().trim();
		offsetY = main_tab_screenShut_text_field_offsetY.getText().trim();
		sizeX = main_tab_screenShut_text_field_sizeX.getText().trim();
		sizeY = main_tab_screenShut_text_field_sizeY.getText().trim();
		outputFileName = main_tab_screenShut_text_field_outputFileName.getText().trim();
		outputFileType = main_tab_screenShut_choise_box_outputFileType.getSelectionModel().getSelectedItem();
		frameRate = main_tab_screenShut_text_field_frameRate.getText().trim();
	}

	/**
	 * 截屏
	 */
	public void screenShut() {
		refreshState();
		if (outputPath == null || outputPath.equals("")) {
			new WarningWindow("outputPath is null !").show();
		} else {
			if (offsetX == null || offsetX.equals("")) {
				new WarningWindow("offsetX is null !").show();
			} else {
				if (offsetY == null || offsetY.equals("")) {
					new WarningWindow("offsetY is null !").show();
				} else {
					if (sizeX == null || sizeX.equals("")) {
						new WarningWindow("sizeX is null !").show();
					} else {
						if (sizeY == null || sizeY.equals("")) {
							new WarningWindow("sizeY is null !").show();
						} else {
							if (outputFileName == null || outputFileName.equals("")) {
								new WarningWindow("outputFileName is null !").show();
							} else {
								if (outputFileType == null || outputFileType.equals("")) {
									new WarningWindow("outputFileType is null !").show();
								} else {
									final Progress progress = Executor.recordScreenForImage(Integer.parseInt(offsetX),
											Integer.parseInt(offsetY), Integer.parseInt(sizeX), Integer.parseInt(sizeY),
											outputPath + File.separator + outputFileName + outputFileType);
									final InformationWindow informationWindow = new InformationWindow("截屏中...", 18.0, progress);
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
	}

	/**
	 * 屏幕录制
	 */
	public void RecordScreen() {
		refreshState();
		if (outputPath == null || outputPath.equals("")) {
			new WarningWindow("outputPath is null !").show();
		} else {
			if (offsetX == null || offsetX.equals("")) {
				new WarningWindow("offsetX is null !").show();
			} else {
				if (offsetY == null || offsetY.equals("")) {
					new WarningWindow("offsetY is null !").show();
				} else {
					if (sizeX == null || sizeX.equals("")) {
						new WarningWindow("sizeX is null !").show();
					} else {
						if (sizeY == null || sizeY.equals("")) {
							new WarningWindow("sizeY is null !").show();
						} else {
							if (outputFileName == null || outputFileName.equals("")) {
								new WarningWindow("outputFileName is null !").show();
							} else {
								if (outputFileType == null || outputFileType.equals("")) {
									new WarningWindow("outputFileType is null !").show();
								} else {
									if (frameRate == null || frameRate.equals("")) {
										new WarningWindow("frameRate is null !").show();
									} else {
										final Progress progress = Executor.recordScreenForVideo(Integer.parseInt(frameRate),
												Integer.parseInt(offsetX), Integer.parseInt(offsetY), Integer.parseInt(sizeX),
												Integer.parseInt(sizeY), outputPath + File.separator + outputFileName + outputFileType);
										final InformationWindow informationWindow = new InformationWindow("屏幕录制中...", 18.0, progress);
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
		}
	}
}
