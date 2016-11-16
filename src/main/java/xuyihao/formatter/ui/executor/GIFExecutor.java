package xuyihao.formatter.ui.executor;

import java.io.File;

import javafx.scene.control.TextField;
import xuyihao.formatter.invoker.executer.Executor;
import xuyihao.formatter.invoker.progress.Progress;
import xuyihao.formatter.ui.window.information.InformationWindow;
import xuyihao.formatter.ui.window.warning.WarningWindow;

/**
 * GIF制作
 * 
 * @Author Xuyh created at 2016年11月14日 上午11:09:09
 *
 */
public class GIFExecutor {
	private TextField main_text_field_inputFile;
	private TextField main_text_field_outputFilePath;
	private TextField main_tab_makeGIF_text_field_beginTime;
	private TextField main_tab_makeGIF_text_field_lastTime;
	private TextField main_tab_makeGIF_text_field_sizeX;
	private TextField main_tab_makeGIF_text_field_sizeY;
	private TextField main_tab_makeGIF_text_field_outputFileName;

	public GIFExecutor(TextField main_text_field_inputFile, TextField main_text_field_outputFilePath,
			TextField main_tab_makeGIF_text_field_beginTime, TextField main_tab_makeGIF_text_field_lastTime,
			TextField main_tab_makeGIF_text_field_sizeX, TextField main_tab_makeGIF_text_field_sizeY,
			TextField main_tab_makeGIF_text_field_outputFileName) {
		this.main_text_field_inputFile = main_text_field_inputFile;
		this.main_text_field_outputFilePath = main_text_field_outputFilePath;
		this.main_tab_makeGIF_text_field_beginTime = main_tab_makeGIF_text_field_beginTime;
		this.main_tab_makeGIF_text_field_lastTime = main_tab_makeGIF_text_field_lastTime;
		this.main_tab_makeGIF_text_field_sizeX = main_tab_makeGIF_text_field_sizeX;
		this.main_tab_makeGIF_text_field_sizeY = main_tab_makeGIF_text_field_sizeY;
		this.main_tab_makeGIF_text_field_outputFileName = main_tab_makeGIF_text_field_outputFileName;
	}

	private String inputFile = "";
	private String outputPath = "";
	private String beginTime = "";
	private String lastTime = "";
	private String sizeX = "";
	private String sizeY = "";
	private String outputFileName = "";

	private void refresh() {
		inputFile = main_text_field_inputFile.getText().trim();
		outputPath = main_text_field_outputFilePath.getText().trim();
		beginTime = main_tab_makeGIF_text_field_beginTime.getText().trim();
		lastTime = main_tab_makeGIF_text_field_lastTime.getText().trim();
		sizeX = main_tab_makeGIF_text_field_sizeX.getText().trim();
		sizeY = main_tab_makeGIF_text_field_sizeY.getText().trim();
		outputFileName = main_tab_makeGIF_text_field_outputFileName.getText().trim();
	}

	/**
	 * 制作GIF
	 */
	public void makeGIF() {
		refresh();
		if (inputFile == null || inputFile.equals("")) {
			new WarningWindow("inputFile is null !").show();
		} else {
			if (outputPath == null || outputPath.equals("")) {
				new WarningWindow("outputPath is null !").show();
			} else {
				if (beginTime == null || beginTime.equals("")) {
					new WarningWindow("beginTime is null !").show();
				} else {
					if (lastTime == null || lastTime.equals("")) {
						new WarningWindow("lastTime is null !").show();
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
									final InformationWindow informationWindow = new InformationWindow("生成GIF中...", 18.0);
									informationWindow.show();
									final Progress progress = Executor.generateGIFImage(inputFile, Integer.parseInt(beginTime),
											Integer.parseInt(lastTime), Integer.parseInt(sizeX), Integer.parseInt(sizeY),
											outputPath + File.separator + outputFileName + ".gif");
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
