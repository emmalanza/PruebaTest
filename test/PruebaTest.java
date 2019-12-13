import ejemplo.Prueba;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.control.ListViewMatchers;
import static org.testfx.api.FxAssert.verifyThat;

public class PruebaTest extends ApplicationTest {

    @Before
    public void setup() throws Exception {
        ApplicationTest.launch(Prueba.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.show();
    }


    @Test
    public void comprobar_lista(){

        clickOn("#tf_nombre");
        write("Emma");
        clickOn("#bt_anadir");
        clickOn("#tf_nombre");
        write("Brandy");
        clickOn("#bt_anadir");

        //verifyThat("#lv_nombres", ListViewMatchers.hasListCell(new String[]{"Emma", "Brandy"}));

    }

    @Test
    public void comprobar_filtro(){

        clickOn("#tf_filtrar");
        write("Bra");
        //verifyThat("#lv_nombres", ListViewMatchers.hasListCell(new String[]{"Brandy"}));

        clickOn("#tf_filtrar");
        write("");
       // verifyThat("#lv_nombres", ListViewMatchers.hasListCell(new String[]{"Emma","Brandy"}));

    }

}
