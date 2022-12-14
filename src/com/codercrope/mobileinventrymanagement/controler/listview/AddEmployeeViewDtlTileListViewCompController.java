package com.codercrope.mobileinventrymanagement.controler.listview;

import com.codercrope.mobileinventrymanagement.controler.AddItemsViewController;
import com.codercrope.mobileinventrymanagement.controler.WorkerViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddEmployeeViewDtlTileListViewCompController {

    public Label txtContent;
    @FXML
    private Label lblTitle;


    private WorkerViewController viewController;

    public TextField txtTopic;
    public TextArea txtArea;

    @FXML
    void btnLstviewContentOnMouseClick(MouseEvent event) {
        txtTopic.setText(lblTitle.getText());
        txtArea.setText(txtContent.getText());
        viewController.btnAddDtl.setDisable(true);
        viewController.btnUpdateDtl.setDisable(false);
        viewController.btnDeleteDtl.setDisable(false);
        txtTopic.setEditable(false);

    }

    public void setData(WorkerViewController addItemsViewController, String title, String content, TextField textField, TextArea textArea){
        this.viewController = addItemsViewController;
        this.lblTitle.setText(title);
        this.txtContent.setText(content);
        this.txtTopic = textField;
        this.txtArea = textArea;
        this.txtContent.setWrapText(true);
    }

}
