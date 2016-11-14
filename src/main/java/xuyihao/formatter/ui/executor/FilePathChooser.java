package xuyihao.formatter.ui.executor;

import java.io.File;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import xuyihao.formatter.ui.MainWindow;

/**
 * 选择文件&路径
 * 
 * @Author Xuyh created at 2016年11月14日 下午12:36:51
 *
 */
public class FilePathChooser {
	public static String chooseFile() {
		String filePathName = "";
		FileChooser chooser = new FileChooser();
		chooser.setTitle("选择文件");
		File file = chooser.showOpenDialog(MainWindow.MAIN_WINDOW_STAGE_CONTEXT);
		if (file.exists()) {
			filePathName = file.getAbsolutePath();
		}
		return filePathName;
	}

	public static String choosePath() {
		String path = "";
		DirectoryChooser chooser = new DirectoryChooser();
		chooser.setTitle("选择路径");
		File file = chooser.showDialog(MainWindow.MAIN_WINDOW_STAGE_CONTEXT);
		if (file.exists()) {
			path = file.getAbsolutePath();
		}
		return path;
	}
}
