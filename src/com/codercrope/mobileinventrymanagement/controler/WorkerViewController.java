package com.codercrope.mobileinventrymanagement.controler;

import com.codercrope.mobileinventrymanagement.controler.tmlist.EmployeeTM;
import com.codercrope.mobileinventrymanagement.model.*;
import com.codercrope.mobileinventrymanagement.to.AdministrativeDtl;
import com.codercrope.mobileinventrymanagement.to.Employee;
import com.codercrope.mobileinventrymanagement.to.WarrantyType;
import com.codercrope.mobileinventrymanagement.view.listview.AddEmployeeViewDtlTileListViewCompController;
import com.codercrope.mobileinventrymanagement.view.listview.AddItemViewDtlTileListViewCompController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    public Button btnAdd;

    @FXML
    public Button btnDelete;

    @FXML
    public Button btnUpdate;

    @FXML
    private ListView<Button> empDtlComponentLW;

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
    public Button btnAddDtl;

    @FXML
    public Button btnUpdateDtl;

    @FXML
    public Button btnDeleteDtl;

    public HashMap<String,String> workerDtlHm = new HashMap<>();
    public ArrayList<AddEmployeeViewDtlTileListViewCompController> dtlListControllers = new ArrayList<AddEmployeeViewDtlTileListViewCompController>();
    public ArrayList<Button> dtlListComp = new ArrayList<Button>();

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

        ArrayList<String> ar = AdministrativeDtlModel.getAdministrativeDtlSts();
        empStatsSelector.getItems().clear();
        for (String w : ar) {
            MenuItem i = new MenuItem(w);
            empStatsSelector.getItems().add(i);
            i.setOnAction(event -> {
                empStatsSelector.setText(w);
                //warrantyType = w.getWarrantyTypeId();
            });
        }
        empStatsSelector.setText(ar.get(ar.size() - 2));

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
    void btnAddDtlOnAction(ActionEvent event) throws IOException {
        workerDtlHm.put(txtEnterItemDtlTopic.getText(), txtEnterItemDtl.getText());
        txtEnterItemDtlTopic.setText("");
        txtEnterItemDtl.setText("");
        setDataToDtlTmList();

    }

    private void setDataToDtlTmList() throws IOException {
        empDtlComponentLW.getItems().removeAll(dtlListComp);
        dtlListComp.clear();
        dtlListControllers.clear();
        for (Map.Entry<String, String> entry : workerDtlHm.entrySet()) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/listview/AddEmployeeViewDtlTileListViewComp.fxml"));
            Button root1 = (Button) fxmlLoader.load();
            AddEmployeeViewDtlTileListViewCompController batch = ((AddEmployeeViewDtlTileListViewCompController) fxmlLoader.getController());
            batch.setData(this, entry.getKey(), entry.getValue(), txtEnterItemDtlTopic, txtEnterItemDtl);
            dtlListComp.add(root1);
            dtlListControllers.add(batch);
        }
        empDtlComponentLW.getItems().addAll(dtlListComp);
    }

    @FXML
    void btnAddOrderOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteDtlOnAction(ActionEvent event) throws IOException {
        workerDtlHm.remove(txtEnterItemDtlTopic.getText());
        txtEnterItemDtlTopic.setText("");
        txtEnterItemDtl.setText("");
        setDataToDtlTmList();

    }

    @FXML
    void btnDeleteOrderOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateDtlOnAction(ActionEvent event) throws IOException {
        workerDtlHm.remove(txtEnterItemDtlTopic.getText());
        txtEnterItemDtlTopic.setText("");
        txtEnterItemDtl.setText("");
        setDataToDtlTmList();

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
    void tblEmployeeViewOnAction(MouseEvent event) throws SQLException, IOException, ClassNotFoundException {
        btnDelete.setDisable(false);
        btnUpdate.setDisable(false);
        btnAdd.setDisable(true);
        if (event.getButton() == MouseButton.PRIMARY) {
            //if (tblItemView.getSelectionModel().getSelectedItem() != null) {
            EmployeeTM selectedItem = tblEmployeeView.getSelectionModel().getSelectedItem();
            txtEnterItemDtlTopic.setEditable(true);
            empStatsSelector.setText(selectedItem.getOb().getAdministrativeDtlId().getAdministrativeStats());
            initData(selectedItem);
            btnUpdateDtl.setDisable(true);
            btnAddDtl.setDisable(false);
            btnDeleteDtl.setDisable(true);
        } else if (event.getButton() == MouseButton.SECONDARY) {
            //System.out.println("rightClicked on the table");
            txtEnterItemDtlTopic.setEditable(true);
            txtEnterItemDtlTopic.setText("");
            txtEnterItemDtl.setText("");
            initialize();
            btnUpdateDtl.setDisable(true);
            btnAddDtl.setDisable(false);
            btnDeleteDtl.setDisable(true);
        }
    }
    private void initData(EmployeeTM temp) throws SQLException, ClassNotFoundException, IOException {
        Employee emp = EmployeeModel.getEmployee(temp.getEmployeeId());
        lblEmployeeId.setText(emp.getEmployeeId());
        txtFullName.setText(emp.getFullName());
        BdayPicker.setAccessibleText(emp.getBirthday());
        txtAddress.setText(emp.getAddress());
        txtEmail.setText(emp.getEmail());
        txtPwdField.setText(emp.getPwd());
        initListView(emp);
        /*lblWarrantyId.setText(it.getWarrentyId().getWarrantyId());
        txtItemName.setText(it.getItemName());
        txtItemProfitPercentage.setText(String.valueOf(it.getProfitPercentage()));
        warrantyTypeSelector.setText(it.getWarrentyId().getWarrantyTypeId().getWarrantyTypeId());
        txtItemPrice.setText(ItemPriceGenerator.getItemPrice(it.getItemId()));
        initBatchDtlList(it);*/

    }

    private void initListView(Employee emp) throws IOException {
        empDtlComponentLW.getItems().removeAll(dtlListComp);
        dtlListComp.clear();//this is the button array
        workerDtlHm.clear();//this is the hashmap that contains the dtl date
        dtlListControllers.clear();//this is the button controller
        if (emp != null) {
            workerDtlHm = emp.getEmployeeDtlHM();
            if (workerDtlHm != null) {
                for (Map.Entry<String, String> entry : workerDtlHm.entrySet()) {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/codercrope/mobileinventrymanagement/view/listview/AddEmployeeViewDtlTileListViewComp.fxml"));
                    Button root1 = (Button) fxmlLoader.load();
                    AddEmployeeViewDtlTileListViewCompController batch = ((AddEmployeeViewDtlTileListViewCompController) fxmlLoader.getController());
                    batch.setData(this, entry.getKey(), entry.getValue(), txtEnterItemDtlTopic, txtEnterItemDtl);
                    dtlListComp.add(root1);
                    dtlListControllers.add(batch);
                }
                empDtlComponentLW.getItems().addAll(dtlListComp);
            }
        }
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

    public void btnShowPwdOnMouseClick(MouseEvent mouseEvent) {
        new Alert(Alert.AlertType.INFORMATION, ("The Password Is : "+txtPwdField.getText())).show();
    }
}
