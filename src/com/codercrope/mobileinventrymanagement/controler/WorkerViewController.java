package com.codercrope.mobileinventrymanagement.controler;

import com.codercrope.mobileinventrymanagement.controler.tmlist.EmployeeTM;
import com.codercrope.mobileinventrymanagement.model.*;
import com.codercrope.mobileinventrymanagement.to.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class WorkerViewController {

    public Label lblEmployeeId;
    @FXML
    private GridPane pane1;

    @FXML
    private TableView<EmployeeTM> tblEmployeeView;

    @FXML
    private TableColumn<EmployeeTM, String> tblEmpId;

    @FXML
    private TableColumn<EmployeeTM, String> tblEmpAdminSts;

    @FXML
    private TableColumn<EmployeeTM, String> tblEmpFullName;

    @FXML
    private TableColumn<EmployeeTM, String> tblEmpEmail;

    @FXML
    private TableColumn<EmployeeTM, Button> tblEmpMoreDtl;

    @FXML
    private TextField txtSearch;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private ListView<?> empDtlComponentLW;

    @FXML
    private Label lblItemIdPT;

    @FXML
    private Label lblItemId;

    @FXML
    private SplitMenuButton empStatsSelector;

    @FXML
    private Label lblWarrantyIdPt;

    @FXML
    private Label lblItemPrice;

    @FXML
    private DatePicker BdayPicker;

    @FXML
    private Label lblItemPrice1;

    @FXML
    private TextField txtFullName;

    @FXML
    private Label lblProfitPercentage11;

    @FXML
    private TextField txtAddress;

    @FXML
    private Label lblItemPrice11;

    @FXML
    private Label lblProfitPercentage1;

    @FXML
    private PasswordField txtPwdField;

    @FXML
    private Button btnShowPwd;

    @FXML
    private Label lblWarrantyIdPt1;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEnterItemDtlTopic;

    @FXML
    private TextArea txtEnterItemDtl;

    @FXML
    private Button btnAddDtl;

    @FXML
    private Button btnUpdateDtl;

    @FXML
    private Button btnDeleteDtl;

    public void initialize() throws SQLException, ClassNotFoundException, IOException {
        tblEmpId.setCellValueFactory(new PropertyValueFactory<EmployeeTM, String>("employeeId"));
        tblEmpAdminSts.setCellValueFactory(new PropertyValueFactory<EmployeeTM, String>("administrativeSts"));
        tblEmpFullName.setCellValueFactory(new PropertyValueFactory<EmployeeTM, String>("fullName"));
        tblEmpEmail.setCellValueFactory(new PropertyValueFactory<EmployeeTM, String>("email"));
        tblEmpMoreDtl.setCellValueFactory(new PropertyValueFactory<EmployeeTM, Button>("Dtl"));

        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);

        setData();
        lblEmployeeId.setText(EmployeeModel.getNextEmployeeID());
        /*lblItemId.setText(ItemModel.getItemId());
        lblWarrantyId.setText(WarrantyModel.getWarrantyId());
        ArrayList<WarrantyType> ar = WarrantyTypeModel.getWarrantyTypes();
        warrantyTypeSelector.getItems().clear();
        for (WarrantyType w : ar) {
            MenuItem i = new MenuItem(w.getWarrantyTypeId());
            warrantyTypeSelector.getItems().add(i);
            i.setOnAction(event -> {
                warrantyTypeSelector.setText(w.getWarrantyTypeId());
                //warrantyType = w.getWarrantyTypeId();
            });
        }
        warrantyTypeSelector.setText(ar.get(ar.size() - 1).getWarrantyTypeId());
        batchDtlListView.getItems().removeAll(batchListView);
        batchList.clear();
        initBatchDtlList(null);
        btnAdd.setDisable(false);
        btnUpdateDtl.setDisable(false);
        btnAddDtl.setDisable(true);
        btnDeleteDtl.setDisable(false);
        txtEnterItemDtl.setWrapText(true);*/
    }

    public void setData() throws SQLException, ClassNotFoundException {
        ArrayList<Employee> employees = EmployeeModel.getEmployees();

        ObservableList<EmployeeTM> employee = FXCollections.observableArrayList();
        for (Employee ob : employees) {
            Button tem = new Button("  More Details  ");
            EmployeeTM temp = new EmployeeTM(ob,ob.getEmployeeId(),ob.getAdministrativeDtlId().getAdministrativeDtlId(),ob.getFullName(),ob.getEmail(),tem);
            /*tem.setOnAction(e -> {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/subwindows/ItemMoreDetailView.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    ((ItemMoreDetailViewController) fxmlLoader.getController()).getObject(ob);
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });*/
            employee.add(temp);
        }
        tblEmployeeView.setItems(employee);
    }

    @FXML
    void bdayPickerOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddDtlOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddOrderOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteDtlOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOrderOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateDtlOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateDtlOnClickEvt(MouseEvent event) {

    }

    @FXML
    void btnUpdateOrderOnAction(ActionEvent event) {

    }

    @FXML
    void empDtlComponentOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void empStatsSelectorOnAction(ActionEvent event) {

    }

    @FXML
    void tblEmployeeViewOnAction(MouseEvent event) {

    }

    @FXML
    void txtAddressOnAction(ActionEvent event) {

    }

    @FXML
    void txtEmailOnAction(ActionEvent event) {

    }

    @FXML
    void txtEnterItemDtlOnKeyPressed(KeyEvent event) {

    }

    @FXML
    void txtEnterItemDtlTopicOnAction(ActionEvent event) {

    }

    @FXML
    void txtEnterItemDtlTopicOnMouseClick(MouseEvent event) {

    }

    @FXML
    void txtFullNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtPwdFoeldOnAction(ActionEvent event) {

    }

}
