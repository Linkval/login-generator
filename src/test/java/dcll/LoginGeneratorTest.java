package dcll;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by VinkHiker on 15/04/2016.
 */
public class LoginGeneratorTest {

    LoginService loginService;
    LoginGenerator lg;
    @Before
    public void setUp() throws Exception {
        loginService = new LoginService(new String[] {"JROL", "BPER", "CGUR", "JDUP", "JRAL", "JRAL1"});
        lg = new LoginGenerator(loginService);
    }

    @Test
    public void testPDUR() throws Exception {
        assertEquals("PDUR",lg.generateLoginForNomAndPrenom("Durand", "Paul"));
    }

    @Test
    public void testJROL1() throws Exception {
        assertEquals("JROL1",lg.generateLoginForNomAndPrenom("Rolling", "Jean"));
    }

    @Test
    public void testPDURAccent() throws Exception {
        assertEquals("PDUR",lg.generateLoginForNomAndPrenom("Dùrand", "Paul"));
    }
}