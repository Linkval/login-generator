package dcll;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Linkval on 15/04/2016.
 */
public class LoginServiceTest {

    LoginService ls;
    @Before
    public void setUp() throws Exception {
        ls = new LoginService(new String[]{"TOTO", "TUTU"});
    }

    @Test
    public void testLoginExists() throws Exception {
        assertTrue(ls.loginExists("TOTO"));
        assertFalse(ls.loginExists("TATA"));
    }

    @Test
    public void testAddLogin() throws Exception {
        ls.addLogin("TATA");
        assertTrue(ls.loginExists("TATA"));
    }

    @Test
    public void testFindAllLoginsStartingWith() throws Exception {
        assertEquals("TOTO", ls.findAllLoginsStartingWith("TO").get(0));
        assertEquals(1, ls.findAllLoginsStartingWith("TO").size());
    }

    @Test
    public void testFindAllLogins() throws Exception {
        assertEquals("TOTO", ls.findAllLogins().get(0));
        assertEquals("TUTU", ls.findAllLogins().get(1));
        assertEquals(2, ls.findAllLogins().size());
    }
}