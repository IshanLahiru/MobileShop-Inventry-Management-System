package com.codercrope.mobileinventrymanagement.view.listview;

import com.codercrope.mobileinventrymanagement.view.subwindows.AddWarrantyTypeViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class WarrantyDtlListViewComponentController {

    @FXML
    private Button btn;

    @FXML
    private Label lblContent;

    @FXML
    private Label lblId;

    private TextField txtEnterWarrantyDtlTopic;
    private TextArea txtEnterWarrantyDtl;

    private AddWarrantyTypeViewController addWarrantyTypeViewController;

    @FXML
    void btnClickEvent(MouseEvent event) {
        txtEnterWarrantyDtlTopic.setText(lblId.getText());
        txtEnterWarrantyDtl.setText(lblContent.getText());
        addWarrantyTypeViewController.btnAddDtl.setDisable(true);
        addWarrantyTypeViewController.btnUpdateDtl.setDisable(false);
        addWarrantyTypeViewController.btnDeleteDtl.setDisable(false);
    }

    public void setData(AddWarrantyTypeViewController addWarrantyTypeViewController,
                        String key,
                        String value,
                        TextField txtEnterWarrantyDtlTopic,
                        TextArea txtEnterWarrantyDtl) {
        this.lblId.setText(key);
        this.lblContent.setText(value);
        this.addWarrantyTypeViewController = addWarrantyTypeViewController;
        this.txtEnterWarrantyDtlTopic = txtEnterWarrantyDtlTopic;
        this.txtEnterWarrantyDtl = txtEnterWarrantyDtl;
        this.txtEnterWarrantyDtl.setWrapText(true);
    }
    public String getId(){
        return this.lblId.getText();
    }
    public String getContent(){
        return this.lblContent.getText();
    }
}
