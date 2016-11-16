package xuyihao.formatter.ui.window.main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import xuyihao.formatter.ui.common.FilePathChooser;
import xuyihao.formatter.ui.executor.CombineVideoExecutor;
import xuyihao.formatter.ui.executor.CutImageExecutor;
import xuyihao.formatter.ui.executor.CutVideoExecutor;
import xuyihao.formatter.ui.executor.ExchangeExecutor;
import xuyihao.formatter.ui.executor.GIFExecutor;
import xuyihao.formatter.ui.executor.MainWindowExecutor;
import xuyihao.formatter.ui.executor.ScreenShutExecutor;

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
		new ExchangeExecutor(main_text_field_inputFile, main_text_field_outputFilePath,
				main_tab_exchange_text_field_outputFileName, main_tab_exchange_choise_box_outputFileType_splitVideo,
				main_tab_exchange_choise_box_outputFileType_splitAudio,
				main_tab_exchange_choise_box_outputFileType_convertFormat).splitVideo();
	}

	@FXML
	protected void exchangeSplitAudioClick() {
		new ExchangeExecutor(main_text_field_inputFile, main_text_field_outputFilePath,
				main_tab_exchange_text_field_outputFileName, main_tab_exchange_choise_box_outputFileType_splitVideo,
				main_tab_exchange_choise_box_outputFileType_splitAudio,
				main_tab_exchange_choise_box_outputFileType_convertFormat).splitAudio();
	}

	@FXML
	protected void exchangeConvertFormatClick() {
		new ExchangeExecutor(main_text_field_inputFile, main_text_field_outputFilePath,
				main_tab_exchange_text_field_outputFileName, main_tab_exchange_choise_box_outputFileType_splitVideo,
				main_tab_exchange_choise_box_outputFileType_splitAudio,
				main_tab_exchange_choise_box_outputFileType_convertFormat).convertFormat();
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
	protected void cutImageBeginCutClick() {
		new CutImageExecutor(main_text_field_inputFile, main_text_field_outputFilePath,
				main_tab_cutImage_text_field_cutTime, main_tab_cutImage_text_field_outputFileName,
				main_tab_cutImage_choise_box_outputFileType, main_tab_cutImage_text_field_cutRate).cutSingleImage();
	}

	@FXML
	protected void cutImageBegincutoutVideoForImageCutClick() {
		new CutImageExecutor(main_text_field_inputFile, main_text_field_outputFilePath,
				main_tab_cutImage_text_field_cutTime, main_tab_cutImage_text_field_outputFileName,
				main_tab_cutImage_choise_box_outputFileType, main_tab_cutImage_text_field_cutRate).cutImageArray();
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
	protected void cutVideoBeginCutClick() {
		new CutVideoExecutor(main_text_field_inputFile, main_text_field_outputFilePath,
				main_tab_cutVideo_text_field_outputFileName, main_tab_cutVideo_choise_box_outputFileType,
				main_tab_cutVideo_text_field_beginTime, main_tab_cutVideo_text_field_lastTime).cutVideo();
	}

	/**
	 * 视频音频合成
	 */
	@FXML
	private TextField main_tab_combine_video_text_field_inputVideo;

	@FXML
	private TextField main_tab_combine_video_text_field_inputAudio;

	@FXML
	private TextField main_tab_combine_video_text_field_outputFileName;

	@FXML
	private ChoiceBox<String> main_tab_combine_video_choise_box_outputFileType;

	@FXML
	protected void combineVideoChooseInputVideoClick() {
		main_tab_combine_video_text_field_inputVideo.setText(FilePathChooser.chooseFile());
	}

	@FXML
	protected void combineVideoChooseInputAudioClick() {
		main_tab_combine_video_text_field_inputAudio.setText(FilePathChooser.chooseFile());
	}

	@FXML
	protected void combineVideoBeginCombineClick() {
		new CombineVideoExecutor(main_text_field_outputFilePath, main_tab_combine_video_text_field_inputVideo,
				main_tab_combine_video_text_field_inputAudio, main_tab_combine_video_text_field_outputFileName,
				main_tab_combine_video_choise_box_outputFileType).combineVideo();
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
	private TextField main_tab_screenShut_text_field_frameRate;

	@FXML
	protected void screenShutScreenShut() {
		new ScreenShutExecutor(main_text_field_outputFilePath, main_tab_screenShut_text_field_offsetX,
				main_tab_screenShut_text_field_offsetY, main_tab_screenShut_text_field_sizeX,
				main_tab_screenShut_text_field_sizeY, main_tab_screenShut_text_field_outputFileName,
				main_tab_screenShut_choise_box_outputFileType, main_tab_screenShut_text_field_frameRate).screenShut();
	}

	@FXML
	protected void screenShutRecordScreen() {
		new ScreenShutExecutor(main_text_field_outputFilePath, main_tab_screenShut_text_field_offsetX,
				main_tab_screenShut_text_field_offsetY, main_tab_screenShut_text_field_sizeX,
				main_tab_screenShut_text_field_sizeY, main_tab_screenShut_text_field_outputFileName,
				main_tab_screenShut_choise_box_outputFileType, main_tab_screenShut_text_field_frameRate).RecordScreen();
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
	protected void makeGIFBeginMakeClick() {
		new GIFExecutor(main_text_field_inputFile, main_text_field_outputFilePath, main_tab_makeGIF_text_field_beginTime,
				main_tab_makeGIF_text_field_lastTime, main_tab_makeGIF_text_field_sizeX, main_tab_makeGIF_text_field_sizeY,
				main_tab_makeGIF_text_field_outputFileName).makeGIF();
	}
}
