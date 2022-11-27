package com.codercrope.mobileinventrymanagement.view.listview;

import com.codercrope.mobileinventrymanagement.to.Item;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddItemViewDtlTileListViewCompController {

    @FXML
    private Label lblTitle;

    @FXML
    private TextArea txtContent;

    public TextField txtTopic;
    public TextArea txtArea;

    @FXML
    void btnLstviewContentOnMouseClick(MouseEvent event) {
        txtTopic.setText(lblTitle.getText());
        txtArea.setText(txtContent.getText());

    }

    public void setData(String title ,String content ,TextField textField ,TextArea textArea){
        this.lblTitle.setText(title);
        this.txtContent.setText(content);
        this.txtTopic = textField;
        this.txtArea = textArea;
        txtContent.setEditable(false);
    }

}
