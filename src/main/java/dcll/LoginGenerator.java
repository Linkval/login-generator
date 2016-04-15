package dcll;

import java.text.Normalizer;
import java.util.regex.Pattern;

/**
 * Classe representant un generateur de login.
 */
public class LoginGenerator {

    /**
     * Nombre de lettres max pour le nom.
     */
    public static final int NB_LETTRES_NOM_MAX = 3;

    /**
     * Nombre de lettres max pour le prénom.
     */
    public static final int NB_LETTRES_PRENOM_MAX = 1;

    /**
     * Le service de login nécéssaire au generator.
     */
    private LoginService loginService;

    /**
     * Construit un login generator.
     * @param loginService le service de login
     */
    public LoginGenerator(final LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * Genere un login unique a partir d'un nom et d'un prenom en prenant
     * la premiere lettre du prenom, concatenee avec
     * les 3 premieres lettres du nom, le tout mis en lettres capitales
     * et desaccentue. Le login genere doit etre unique
     * par rapport a la liste des logins existants. En cas de doublon,
     * on incremente le doublon d'un indice. Ci dessous des
     * exemples :
     * <ul>
     *     <li>Paul Dupond -> PDUP </li>
     *     <li>Pierre Dupard -> PDUP1</li>
     *     <li>Jacques Durand -> JDUR</li>
     *     <li>Lionel R&eacute;gal -> LREG</li>
     * </ul>
     * @param nom le nom
     * @param prenom le prenom
     * @return le login genere
     */
    public final String generateLoginForNomAndPrenom(final String nom,
                                                     final String prenom) {
        String n;
        String p = deAccent(prenom.substring(0,
                NB_LETTRES_PRENOM_MAX).toUpperCase());
        if (nom.length() < NB_LETTRES_NOM_MAX) {
            n = deAccent(nom.substring(0, nom.length()).toUpperCase());
        } else {
            n = deAccent(nom.substring(0, NB_LETTRES_NOM_MAX).toUpperCase());
        }
        String login = p + n;
        if (loginService.loginExists(login)) {
            login = login + Integer.toString(
                    loginService.findAllLoginsStartingWith(login).size());
        }
        loginService.addLogin(login);
        return login;
    }

    /**
     * Supprime les accents d'une chaine de caractere.
     *
     * @param str la chaine de caractere
     * @return la chaine de caractere sans accents
     */
    private String deAccent(final String str) {
        String nfdNormalizedString = Normalizer.normalize(str,
                Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }






}
