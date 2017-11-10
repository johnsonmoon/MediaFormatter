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
import xuyihao.formatter.invoker.progress.Progress;

import java.net.URL;

/**
 * 定义简单的消息显示窗口
 *
 * @Author Xuyh created at 2016年11月15日 上午10:32:21
 */
public class InformationWindow {
    private Progress progress;
    private Stage stage;// 窗口
    /**
     * 控件
     */
    private TextArea textArea;
    private Button btnCloseWindow;
    private Button btnKillProcess;

    /**
     * @param fontSize 字体大小
     */
    public InformationWindow(String informationMessage, double fontSize, Progress progress) {
        this.progress = progress;
        Parent parent = null;
        URL url = Thread.currentThread().getContextClassLoader().getResource("information_window.fxml");
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
        btnKillProcess = (Button) parent.lookup("#information_window_button_killProcess");
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
        btnKillProcess.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (progress != null) {
                    //FIXME 现在的问题是有的命令操作(如转换视频格式)需要关闭父Java进程才会执行
                    //输入q使ffmpeg停止操作
                    //progress.setProcessInput("q");

                    progress.stopProcess();
                    appendInformationMessage("\r\n-->子进程关闭成功!");
                }
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
     * @param appendedMessage
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
     * <p>
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
