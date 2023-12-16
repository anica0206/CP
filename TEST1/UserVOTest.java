import com.example.demo12.model.UserVO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserVOTest {

    @Test
    public void testUserVO() {
        // UserVO 인스턴스 생성
        UserVO userVO = new UserVO();

        // 테스트를 위해 몇 가지 값 설정
        userVO.setUserId("sohee01");
        userVO.setPassword("1234");
        userVO.setEmail("kcc2021@naver.com");
        userVO.setName("강소희");
        userVO.setBirthday("1995-03-25"); // 생일 필드가 문자열로 가정됨
        userVO.setRole(1);
        userVO.setDesiredJob("개발자");
        userVO.setEducation("학사 학위");

        // 값이 올바르게 설정되었는지 확인하기 위한 어서션(assertions) 수행
        assertEquals("sohee01", userVO.getUserId());
        assertEquals("1234", userVO.getPassword());
        assertEquals("kcc2021@naver.com", userVO.getEmail());
        assertEquals("강소희", userVO.getName());
        assertEquals("1995-03-25", userVO.getBirthday());
        assertEquals(1, userVO.getRole());
        assertEquals("개발자", userVO.getDesiredJob());
        assertEquals("학사 학위", userVO.getEducation());
    }
}
