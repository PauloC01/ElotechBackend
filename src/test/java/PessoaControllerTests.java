import ControllersApi.PessoaApi;
import Model.Pessoa;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = PessoaApi.class)
public class PessoaControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPost() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/usuario/adicionar")).
                andExpect(MockMvcResultMatchers.status().isOk());
    }
}
