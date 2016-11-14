package xuyihao.formatter.ui.executor;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * 
 * @Author Xuyh created at 2016年11月14日 上午11:06:22
 *
 */
public class ExchangeExecutor {
	private TextField main_tab_exchange_text_field_outputFileName;
	private ChoiceBox<String> main_tab_exchange_choise_box_outputFileType_splitVideo;
	private ChoiceBox<String> main_tab_exchange_choise_box_outputFileType_splitAudio;
	private ChoiceBox<String> main_tab_exchange_choise_box_outputFileType_convertFormat;

	public ExchangeExecutor(TextField outputField, ChoiceBox<String> videoTypeBox, ChoiceBox<String> audioTypeBox,
			ChoiceBox<String> converFormatTypeBox) {
		this.main_tab_exchange_choise_box_outputFileType_splitVideo = videoTypeBox;
		this.main_tab_exchange_choise_box_outputFileType_splitAudio = audioTypeBox;
		this.main_tab_exchange_choise_box_outputFileType_convertFormat = converFormatTypeBox;
	}
}
