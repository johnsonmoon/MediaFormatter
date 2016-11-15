package xuyihao.formatter.ui.executor;

import javafx.scene.control.TextField;
import xuyihao.formatter.ui.common.FilePathChooser;

/**
 * 主窗口按键事件动作实现
 * 
 * @Author Xuyh created at 2016年11月14日 上午11:16:27
 *
 */
public class MainWindowExecutor {
	private TextField main_text_field_inputFile;
	private TextField main_text_field_outputFilePath;

	public MainWindowExecutor(TextField inputField, TextField outputField) {
		this.main_text_field_inputFile = inputField;
		this.main_text_field_outputFilePath = outputField;
	}

	public void inputFileChoose() {
		main_text_field_inputFile.setText(FilePathChooser.chooseFile());
	}

	public void outputFilePathChoose() {
		main_text_field_outputFilePath.setText(FilePathChooser.choosePath());
	}
}
