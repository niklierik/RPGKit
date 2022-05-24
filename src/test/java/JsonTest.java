import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.fiveship.rpgkit.RPGKit;
import me.fiveship.rpgkit.gameplay.items.ItemData;
import me.fiveship.rpgkit.localization.Lang;
import org.junit.jupiter.api.Test;


public class JsonTest {

    @Test
    public void testJson() throws JsonProcessingException {
        var lang = Lang.generateFrom("english");
        // lang.printEverything();
    }


}
