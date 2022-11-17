package com.codercrope.mobileinventrymanagement.util;

import com.codercrope.mobileinventrymanagement.controler.btncontrollers.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import static com.codercrope.mobileinventrymanagement.util.NavBtn.*;

public class SetNavBtn {

    public static GridPane grid;


    public static HashMap<String,ImageView> navIco = new HashMap<>();
    public static  HashMap<String,SideBarController> navIcoController = new HashMap<>();

    public static FXMLLoader initBtn(String event, GridPane pane) throws IOException {
        URL resourse = SetNavBtn.class.getResource(event);
        FXMLLoader fxmlLoader = new FXMLLoader(resourse);
        //System.out.println(fxmlLoader);
        Parent load = (Parent) fxmlLoader.load();
        pane.getChildren().clear();
        pane.getChildren().add(load);
        return fxmlLoader;
    }

    public static void setBtn(GridPane pane, String event, NavBtn type){
        //if
       // String s = User.getUser().getAdministrativeDtlId().getAdministrativeStats();
       // System.out.println(User.getUser().getAdministrativeDtlId().getAdministrativeStats().toString());
        switch("admin") {
            case "admin":
                switch (type) {
                    case DB:
                        try {
                            ButtonDBSideVBController controller = ((ButtonDBSideVBController) initBtn(event, pane).getController());
                            navIcoController.put("db", controller);
                            controller.getPane(grid);
                            ImageView img = controller.getImage();
                            navIco.put("db", img);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        break;
                    case ORDER:
                        try {
                            ButtonOrderSideVBController controller = ((ButtonOrderSideVBController) initBtn(event, pane).getController());
                            navIcoController.put("order", controller);
                            controller.getPane(grid);
                            ImageView img = controller.getImage();
                            navIco.put("order", img);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case ITEM:
                        try {
                            ButtonItemSideVBController controller = ((ButtonItemSideVBController) initBtn(event, pane).getController());
                            navIcoController.put("item", controller);
                            controller.getPane(grid);
                            ImageView img = controller.getImage();
                            navIco.put("item", img);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case REPAIR:
                        try {
                            ButtonRepairSideVBController controller = ((ButtonRepairSideVBController) initBtn(event, pane).getController());
                            navIcoController.put("repair", controller);
                            controller.getPane(grid);
                            ImageView img = controller.getImage();
                            navIco.put("repair", img);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case WORKER:
                        try {
                            ButtonWorkerSideVBController controller = ((ButtonWorkerSideVBController) initBtn(event, pane).getController());
                            navIcoController.put("worker", controller);
                            controller.getPane(grid);
                            ImageView img = controller.getImage();
                            navIco.put("worker", img);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case REPORT:
                        try {
                            ButtonReportSideVBController controller = ((ButtonReportSideVBController) initBtn(event, pane).getController());
                            navIcoController.put("report", controller);
                            controller.getPane(grid);
                            ImageView img = controller.getImage();
                            navIco.put("report", img);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        try {
                            ((ButtonOrderSideVBController) initBtn(event, pane).getController()).getPane(grid);
                            ButtonOrderSideVBController controller = ((ButtonOrderSideVBController) initBtn(event, pane).getController());
                            navIcoController.put("orders", controller);
                            controller.getPane(grid);
                            ImageView img = controller.getImage();
                            navIco.put("order", img);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                }
                break;
            case "worker":
                switch (type) {
                    case DB:
                        try {
                            ButtonReportSideVBController controller = ((ButtonReportSideVBController) initBtn(event, pane).getController());
                            navIcoController.put("db", controller);
                            controller.getPane(grid);
                            ImageView img = controller.getImage();
                            navIco.put("db", img);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        break;
                    case ORDER:
                        try {
                            ButtonOrderSideVBController controller = ((ButtonOrderSideVBController) initBtn(event, pane).getController());
                            navIcoController.put("order", controller);
                            controller.getPane(grid);
                            ImageView img = controller.getImage();
                            navIco.put("order", img);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case ITEM:
                        try {
                            ButtonItemSideVBController controller = ((ButtonItemSideVBController) initBtn(event, pane).getController());
                            navIcoController.put("item", controller);
                            controller.getPane(grid);
                            ImageView img = controller.getImage();
                            navIco.put("item", img);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case REPAIR:
                        try {
                            ButtonRepairSideVBController controller = ((ButtonRepairSideVBController) initBtn(event, pane).getController());
                            navIcoController.put("repair", controller);
                            controller.getPane(grid);
                            ImageView img = controller.getImage();
                            navIco.put("repair", img);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case WORKER:
                        try {
                            ButtonWorkerSideVBController controller = ((ButtonWorkerSideVBController) initBtn(event, pane).getController());
                            navIcoController.put("worker", controller);
                            controller.getPane(grid);
                            ImageView img = controller.getImage();
                            navIco.put("worker", img);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case REPORT:
                        try {
                            ButtonReportSideVBController controller = ((ButtonReportSideVBController) initBtn(event, pane).getController());
                            navIcoController.put("report", controller);
                            controller.getPane(grid);
                            ImageView img = controller.getImage();
                            navIco.put("report", img);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        try {
                            ((ButtonOrderSideVBController) initBtn(event, pane).getController()).getPane(grid);
                            ButtonOrderSideVBController controller = ((ButtonOrderSideVBController) initBtn(event, pane).getController());
                            navIcoController.put("orders", controller);
                            controller.getPane(grid);
                            ImageView img = controller.getImage();
                            navIco.put("order", img);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                }
                break;
            case "technician":
                switch (type) {
                    case DB:
                        try {
                            ButtonDBSideVBController controller = ((ButtonDBSideVBController) initBtn(event, pane).getController());
                            navIcoController.put("db", controller);
                            controller.getPane(grid);
                            ImageView img = controller.getImage();
                            navIco.put("db", img);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        break;
                    case ORDER:
                        try {
                            ButtonOrderSideVBController controller = ((ButtonOrderSideVBController) initBtn(event, pane).getController());
                            navIcoController.put("order", controller);
                            controller.getPane(grid);
                            ImageView img = controller.getImage();
                            navIco.put("order", img);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case ITEM:
                        try {
                            ButtonItemSideVBController controller = ((ButtonItemSideVBController) initBtn(event, pane).getController());
                            navIcoController.put("item", controller);
                            controller.getPane(grid);
                            ImageView img = controller.getImage();
                            navIco.put("item", img);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case REPAIR:
                        try {
                            ButtonRepairSideVBController controller = ((ButtonRepairSideVBController) initBtn(event, pane).getController());
                            navIcoController.put("repair", controller);
                            controller.getPane(grid);
                            ImageView img = controller.getImage();
                            navIco.put("repair", img);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case WORKER:
                        try {
                            ButtonWorkerSideVBController controller = ((ButtonWorkerSideVBController) initBtn(event, pane).getController());
                            navIcoController.put("worker", controller);
                            controller.getPane(grid);
                            ImageView img = controller.getImage();
                            navIco.put("worker", img);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case REPORT:
                        try {
                            ButtonReportSideVBController controller = ((ButtonReportSideVBController) initBtn(event, pane).getController());
                            navIcoController.put("report", controller);
                            controller.getPane(grid);
                            ImageView img = controller.getImage();
                            navIco.put("report", img);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        try {
                            ((ButtonOrderSideVBController) initBtn(event, pane).getController()).getPane(grid);
                            ButtonOrderSideVBController controller = ((ButtonOrderSideVBController) initBtn(event, pane).getController());
                            navIcoController.put("orders", controller);
                            controller.getPane(grid);
                            ImageView img = controller.getImage();
                            navIco.put("order", img);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                }
        }


    }

}
