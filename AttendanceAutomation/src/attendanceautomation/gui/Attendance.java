package attendanceautomation.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author DKE
 */
public class Attendance extends Application{
    
    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Attendance.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Attendance Subject Page");
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * @param args
     */
    public static void main(String[] args){
        launch(args);
    }
}