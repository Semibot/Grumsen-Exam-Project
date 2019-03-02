package attendanceautomation.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author DKE
 */
public class AttendanceController implements Initializable{
    
    @FXML private JFXTextField nameTextField;
    @FXML private JFXDatePicker datepicker;
    @FXML private JFXButton attendBtn;
    @FXML private Label attendLabel;
    
    public AttendanceController(){
        
    }
    
    @FXML
    private void attendBtnAction(ActionEvent e){
        attendLabel.setText(nameTextField.getText()
           +"\n attended classes on "+
                datepicker.getValue());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        nameTextField.setPromptText("Enter your name");
        datepicker.setPromptText("Select a date");
    }
}