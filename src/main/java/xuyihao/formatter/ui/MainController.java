package xuyihao.formatter.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import xuyihao.formatter.ui.executor.MainWindowExecutor;

/**
 * JavaFx controller 通过注解将控件对象与配置文件的id一一对应
 *
 * Created by Xuyh at 2016/11/13 下午 04:46.
 */
public class MainController {
	/**
	 * 外框
	 */
	@FXML
	private TextField main_text_field_inputFile;

	@FXML
	private TextField main_text_field_outputFilePath;

	@FXML
	protected void mainInputFileChooseClick() {
		new MainWindowExecutor(main_text_field_inputFile, main_text_field_outputFilePath).inputFileChoose();
	}

	@FXML
	protected void mainOutputFilePathClick() {
		new MainWindowExecutor(main_text_field_inputFile, main_text_field_outputFilePath).outputFilePathChoose();
	}

	/**
	 * 转换页面
	 */
	@FXML
	private TextField main_tab_exchange_text_field_outputFileName;

	@FXML
	private ChoiceBox<String> main_tab_exchange_choise_box_outputFileType_splitVideo;

	@FXML
	private ChoiceBox<String> main_tab_exchange_choise_box_outputFileType_splitAudio;

	@FXML
	private ChoiceBox<String> main_tab_exchange_choise_box_outputFileType_convertFormat;

	@FXML
	protected void exchangeSplitVideoClick() {

	}

	@FXML
	protected void exchangeSplitAudioClick() {

	}

	@FXML
	protected void exchangeConvertFormatClick() {

	}

	/**
	 * 截图图片页面
	 */
	@FXML
	private TextField main_tab_cutImage_text_field_cutTime;

	@FXML
	private Button main_tab_cutImage_button_beginCut;

	@FXML
	private TextField main_tab_cutImage_text_field_outputFileName;

	@FXML
	private ChoiceBox<String> main_tab_cutImage_choise_box_outputFileType;

	@FXML
	private TextField main_tab_cutImage_text_field_cutRate;

	@FXML
	private Button main_tab_cutImage_button_begincutoutVideoForImageArray;

	@FXML
	protected void cutImageBeginCutClick() {

	}

	@FXML
	protected void cutImageBegincutoutVideoForImageCutClick() {

	}

	/**
	 * 视频片段截取页面
	 */
	@FXML
	private TextField main_tab_cutVideo_text_field_outputFileName;

	@FXML
	private ChoiceBox<String> main_tab_cutVideo_choise_box_outputFileType;

	@FXML
	private TextField main_tab_cutVideo_text_field_beginTime;

	@FXML
	private TextField main_tab_cutVideo_text_field_lastTime;

	@FXML
	private Button main_tab_cutVideo_button_beginCut;

	@FXML
	protected void cutVideoBeginCutClick() {

	}

	/**
	 * 视频音频合成
	 */
	@FXML
	private TextField main_tab_combine_video_text_field_inputVideo;

	@FXML
	private TextField main_tab_combine_video_text_field_inputAudio;

	@FXML
	private Button main_tab_combine_video_button_chooseInputVideo;

	@FXML
	private Button main_tab_combine_video_button_chooseInputAudio;

	@FXML
	private TextField main_tab_combine_video_text_field_outputFileName;

	@FXML
	private ChoiceBox<String> main_tab_combine_video_choise_box_outputFileType;

	@FXML
	private Button main_tab_combine_video_button_beginCombine;

	@FXML
	protected void combineVideoChooseInputVideoClick() {

	}

	@FXML
	protected void combineVideoChooseInputAudioClick() {

	}

	@FXML
	protected void combineVideoBeginCombineClick() {

	}

	/**
	 * 截屏&录制页面
	 */
	@FXML
	private TextField main_tab_screenShut_text_field_offsetX;

	@FXML
	private TextField main_tab_screenShut_text_field_offsetY;

	@FXML
	private TextField main_tab_screenShut_text_field_sizeX;

	@FXML
	private TextField main_tab_screenShut_text_field_sizeY;

	@FXML
	private TextField main_tab_screenShut_text_field_outputFileName;

	@FXML
	private ChoiceBox<String> main_tab_screenShut_choise_box_outputFileType;

	@FXML
	private Button main_tab_screenShut_button_screenShut;

	@FXML
	private TextField main_tab_screenShut_text_field_frameRate;

	@FXML
	private Button main_tab_screenShut_button_recordScreen;

	@FXML
	protected void screenShutScreenShut() {

	}

	@FXML
	protected void screenShutRecordScreen() {

	}

	/**
	 * GIF
	 */
	@FXML
	private TextField main_tab_makeGIF_text_field_beginTime;

	@FXML
	private TextField main_tab_makeGIF_text_field_lastTime;

	@FXML
	private TextField main_tab_makeGIF_text_field_sizeX;

	@FXML
	private TextField main_tab_makeGIF_text_field_sizeY;

	@FXML
	private TextField main_tab_makeGIF_text_field_outputFileName;

	@FXML
	private Button main_tab_makeGIF_button_beginMakeGIF;

	@FXML
	protected void makeGIFBeginMakeClick() {

	}
}
