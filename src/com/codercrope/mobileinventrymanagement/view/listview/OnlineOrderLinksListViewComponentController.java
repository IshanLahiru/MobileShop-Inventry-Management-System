package com.codercrope.mobileinventrymanagement.view.listview;

import com.codercrope.mobileinventrymanagement.controler.subwindows.AddOnlineOrderViewController;
import com.codercrope.mobileinventrymanagement.controler.subwindows.AddWarrantyTypeViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class OnlineOrderLinksListViewComponentController {
    @FXML
    private Button btn;

    @FXML
    private Label lblContent;

    @FXML
    private Label lblId;

    private TextField txtEnterWarrantyDtlTopic;
    private TextArea txtEnterWarrantyDtl;

    private
    AddOnlineOrderViewController addOnlineOrderViewController;

    @FXML
    void btnClickEvent(MouseEvent event) {
        txtEnterWarrantyDtlTopic.setText(lblId.getText());
        txtEnterWarrantyDtl.setText(lblContent.getText());
        addOnlineOrderViewController.btnAddLink.setDisable(true);
        addOnlineOrderViewController.btnUpdateLink.setDisable(false);
        addOnlineOrderViewController.btnDeleteLink.setDisable(false);
    }

    public void setData(AddOnlineOrderViewController addOnlineOrderViewController,
                        String key,
                        String value,
                        TextField txtEnterWarrantyDtlTopic,
                        TextArea txtEnterWarrantyDtl) {
        this.lblId.setText(key);
        this.lblContent.setText(value);
        this.addOnlineOrderViewController = addOnlineOrderViewController;
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
