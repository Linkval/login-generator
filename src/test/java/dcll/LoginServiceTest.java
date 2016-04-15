package dcll;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by VinkHiker on 15/04/2016.
 */
public class LoginServiceTest {

    LoginService lg;
    @Before
    public void setUp() throws Exception {
        lg = new LoginService(new String[]{"TOTO", "TUTU"});
    }

    @Test
    public void testLoginExists() throws Exception {
        assertTrue(lg.loginExists("TOTO"));
        assertFalse(lg.loginExists("TATA"));
    }

    @Test
    public void testAddLogin() throws Exception {
        lg.addLogin("TATA");
        assertTrue(lg.loginExists("TATA"));
    }

    @Test
    public void testFindAllLoginsStartingWith() throws Exception {
        assertEquals("TOTO",lg.findAllLoginsStartingWith("TO").get(0));
        assertEquals(1,lg.findAllLoginsStartingWith("TO").size());
    }

    @Test
    public void testFindAllLogins() throws Exception {
        assertEquals("TOTO",lg.findAllLogins().get(0));
        assertEquals("TUTU",lg.findAllLogins().get(1));
        assertEquals(2,lg.findAllLogins().size());
    }
}