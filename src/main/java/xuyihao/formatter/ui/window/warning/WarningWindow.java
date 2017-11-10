package xuyihao.formatter.ui.window.warning;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.net.URL;
import java.security.spec.ECField;

/**
 * 定义简单的警告消息显示窗口(内部定义事件，不需要controller)
 *
 * @Author Xuyh created at 2016年11月15日 上午9:29:23
 */
public class WarningWindow {
    private Stage stage;// 窗口
    /**
     * 控件
     */
    private TextArea textArea;
    private Button btnConfirm;

    public WarningWindow(String warningMessage) {
        Parent parent = null;
        URL url = Thread.currentThread().getContextClassLoader().getResource("warning_window.fxml");
        if (url == null)
            return;
        try {
            parent = FXMLLoader.load(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (parent == null)
            return;
        stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Warning");
        initView(parent, warningMessage);
        initEvent();
    }

    /**
     * 初始化控件（获取）
     *
     * @param parent
     */
    private void initView(Parent parent, String text) {
        textArea = (TextArea) parent.lookup("#warningWindow_textArea_message");
        textArea.setText(text);
        textArea.setFont(Font.font(24.0));
        btnConfirm = (Button) parent.lookup("#warningWindow_button_confirm");
    }

    /**
     * 初始化控件事件
     */
    private void initEvent() {
        btnConfirm.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                WarningWindow.this.stage.close();
            }
        });
    }

    /**
     * 开启窗口
     */
    public void show() {
        stage.show();
    }

    /**
     * 关闭窗口
     */
    public void close() {
        stage.close();
    }
}
