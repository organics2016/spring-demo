package ink.organics.demo.jpa;

import com.alibaba.fastjson2.JSON;
import ink.organics.demo.jpa.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
//@AutoConfigureRestDocs
public class RestTest {

    @Autowired
    private MockMvc mvc;


    @Test
    void rollback() throws Exception {

        this.mvc.perform(post("/user/rollback")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(UserDTO.builder().build())))
                .andDo(print())
                .andExpect(status().isBadRequest());

    }

    @Test
    void rollback2() throws Exception {

        this.mvc.perform(post("/user/rollback")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(UserDTO.builder().rollback(false).build())))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void rollback3() throws Exception {

        this.mvc.perform(post("/user/rollback")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(UserDTO.builder().rollback(true).build())))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    void allTest() throws Exception {
        this.mvc.perform(get("/user/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
