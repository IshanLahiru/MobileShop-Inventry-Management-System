package com.codercrope.mobileinventrymanagement.util;

import javafx.scene.layout.BorderPane;

public class StyleController {
    public static boolean isEnadled;


    public static void setDark(BorderPane parent) {
        parent.getStylesheets().remove("com/codercrope/mobileinventrymanagement/assets/Styles/DarkMode.css");
        parent.getStylesheets().add("com/codercrope/mobileinventrymanagement/assets/Styles/lightMode.css");
    }

    public static void setLight(BorderPane parent) {
        parent.getStylesheets().remove("com/codercrope/mobileinventrymanagement/assats/Styles/lightMode.css");
        parent.getStylesheets().add("com/codercrope/mobileinventrymanagement/assets/Styles/DarkMode.css");
    }
}
