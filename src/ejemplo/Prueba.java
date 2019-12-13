package ejemplo;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Prueba extends Application implements Initializable {

    @FXML
    private ListView<String> lv_nombres;

    @FXML
    private TextField tf_nombre;

    @FXML
    private TextField tf_filtrar;

   private ObservableList<String> nombres = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Prueba.fxml"));
        Scene scene = new Scene(root, 600,400);
        stage.setTitle("Pantalla principal");
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tf_filtrar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {

                lv_nombres.setItems(filtrar(newValue));
            }
        });

    }
    @FXML
    public void anadir_nombre(ActionEvent actionEvent) {

        nombres.add(tf_nombre.getText());
        lv_nombres.setItems(nombres);
        tf_nombre.clear();
    }


    public ObservableList<String> filtrar(String texto_filtrado){

        ObservableList<String> lista_filtrada = FXCollections.observableArrayList();

        if (texto_filtrado!=null && !"".equals(texto_filtrado)){

            lista_filtrada.clear();

            for(String s : nombres){
                if(s.contains(texto_filtrado))
                    lista_filtrada.add(s);
            }

          return  lista_filtrada;

        }else{
            return nombres;
        }

    }

}
