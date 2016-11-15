package xuyihao.formatter.ui.window.information;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * 定义简单的消息显示窗口
 * 
 * @Author Xuyh created at 2016年11月15日 上午10:32:21
 *
 */
public class InformationWindow {
	private Stage stage;// 窗口
	/**
	 * 控件
	 */
	private TextArea textArea;
	private Button btnCloseWindow;

	/**
	 * 
	 * @param fontSize 字体大小
	 */
	public InformationWindow(String informationMessage, double fontSize) {
		Parent parent = null;
		try {
			parent = FXMLLoader.load(getClass().getResource("information_window.fxml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Information");
		initView(parent, informationMessage, fontSize);
		initEvent();
	}

	/**
	 * 初始化控件（获取）
	 * 
	 * @param parent
	 */
	private void initView(Parent parent, String message, double fontSize) {
		textArea = (TextArea) parent.lookup("#information_window_textArea_information");
		textArea.setText(message);
		textArea.setFont(Font.font(fontSize));
		btnCloseWindow = (Button) parent.lookup("#information_window_button_closeWindow");
	}

	/**
	 * 初始化事件监听
	 */
	private void initEvent() {
		btnCloseWindow.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stage.close();
			}
		});
	}

	/**
	 * 重新设置消息
	 * 
	 * @param message
	 */
	public void setInformationMessage(String message) {
		textArea.setText(message);
	}

	/**
	 * 添加消息
	 * 
	 * @param message
	 */
	public void appendInformationMessage(String appendedMessage) {
		textArea.appendText(appendedMessage);
	}

	/**
	 * 开启窗口
	 */
	public void show() {
		stage.show();
	}

	/**
	 * 关闭窗口
	 * 
	 * <pre>
	 * 必须要是
	 * javafx.application.Application线程实例
	 * 才可以对窗口进行关闭操作
	 * </pre>
	 */
	public void close() {
		stage.close();
	}
}
