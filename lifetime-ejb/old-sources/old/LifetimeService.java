/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old;

import old.LifetimeBusiness;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lifetime.persistence.User;

/**
 *
 * @author azc
 */
@Stateless
public class LifetimeService implements LifetimeBusiness {

    @PersistenceContext(name = "jdbc/lifetime", unitName = "lifetimePU")
    private EntityManager em;

    @Resource
    private SessionContext context;

    @EJB
    private SendMail sendMail;

    /*    @EJB
     private AccountService accountService;
    
     @EJB
     private AchievementService achievementService;
    
     @EJB
     private WorkService workService;
    
     @EJB
     private */
    @Override
    public void addAddress(String street, String number, String postalCode, String locality, String region, String country) {
        System.err.println("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addUserAddress(Integer userId, Integer addressId) {
        System.err.println("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addAddressGPS(Integer addressId, Long latitude, Long longitude) {
        System.err.println("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addUser(String firstname, String lastname, String email, String password, String motherlanguage) {
        User user = new User(null, firstname, lastname, email, null, null, motherlanguage);
        user.setMotherLanguage(motherlanguage);
        em.persist(user);
        addUserRole(email, "USERS");
    }

    @Override
    public void addRole(String rolename) {
        System.err.println("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addUserRole(String username, String rolename) {
        UserRoles uRole = new UserRoles(null, username, rolename);
        em.persist(uRole);
    }

    @Override
    public void addOrganization(String name, String shortname, String language) {
        Organization org = new Organization(null, name, language);
        org.setShortname(shortname);
        em.persist(org);
    }

    @Override
    public void addOrganizationAddress(Integer organizationId, Integer addressId) {
        System.err.println("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Achievement getAchievement(Integer achievementId) {
        Query namedQuery = em.createNamedQuery("Achievement.findById", Achievement.class);
        namedQuery.setParameter("id", achievementId);
        return (Achievement) namedQuery.getSingleResult();
    }

    @Override
    public List<Academic> getAcademics(Integer userId) {
        Query query = em.createNamedQuery("Academic.findByUserId", Academic.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public List<Professional> getProfessionals(Integer userId) {
        Query query = em.createNamedQuery("Professional.findByUserId", Professional.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public List<Certification> getCertifications(Integer userId) {
        Query query = em.createNamedQuery("Certification.findByUserId", Certification.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public List<Entrepeneurship> getEntrepeneurships(Integer userId) {
        Query query = em.createNamedQuery("Entrepeneurship.findByUserId", Entrepeneurship.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public List<Social> getSocials(Integer userId) {
        Query query = em.createNamedQuery("Social.findByUserId", Social.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public List<Linguistic> getLinguistics(Integer userId) {
        Query query = em.createNamedQuery("Linguistic.findByUserId", Linguistic.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public List<Other> getOthers(Integer userId) {
        Query query = em.createNamedQuery("Other.findByUserId", Other.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public void add(Academic achievement) {
        em.persist(achievement);
    }

    @Override
    public void add(Professional achievement) {
        em.persist(achievement);
    }

    @Override
    public void add(Certification achievement) {
        em.persist(achievement);
    }

    @Override
    public void add(Entrepeneurship achievement) {
        em.persist(achievement);
    }

    @Override
    public void add(Social achievement) {
        em.persist(achievement);
    }

    @Override
    public void add(Linguistic achievement) {
        em.persist(achievement);
    }

    @Override
    public void add(Other achievement) {
        em.persist(achievement);
    }

    @Override
    public Set<String> getUserLanguages(Integer userId) {
        Set<String> result = new TreeSet();
        List<Linguistic> linguistics = getLinguistics(userId);
        for (Linguistic l : linguistics) {
            result.add(l.getName());
        }
        return result;
    }

    @Override
    public void delete(Academic achievement) {
        em.remove(em.find(Academic.class, achievement.getId()));
    }

    @Override
    public void delete(Professional achievement) {
        em.remove(em.find(Professional.class, achievement.getId()));
    }

    @Override
    public void delete(Certification achievement) {
        em.remove(em.find(Certification.class, achievement.getId()));
    }

    @Override
    public void delete(Linguistic achievement) {
        em.remove(em.find(Linguistic.class, achievement.getId()));
    }

    @Override
    public void delete(Entrepeneurship achievement) {
        em.remove(em.find(Entrepeneurship.class, achievement.getId()));
    }

    @Override
    public void delete(Social achievement) {
        em.remove(em.find(Social.class, achievement.getId()));
    }

    @Override
    public void delete(Other achievement) {
        em.remove(em.find(Other.class, achievement.getId()));
    }

    @Override
    public void update(Achievement achievement) {
        em.merge(achievement);
    }

    @Override
    public Set<String> getNotTranslatedLanguages(Integer userId, Academic achievement) {
        Academic original = getOriginal(achievement);

        Set<String> userLanguages = getUserLanguages(original.getUserId());

        Set<String> translations = getTranslatedLanguages(original);

        for (String ll : translations) {
            if (userLanguages.remove(ll)) {
            }
        }

//        if (userLanguages.contains(original.getLanguage())) {
//            userLanguages.remove(original.getLanguage());
//        }
        return userLanguages;
    }

    @Override
    public Set<String> getNotTranslatedLanguages(Integer userId, Professional achievement) {
        Professional original = getOriginal(achievement);

        Set<String> userLanguages = getUserLanguages(original.getUserId());
        Set<String> translations = getTranslatedLanguages(original);

        for (String ll : translations) {
            if (userLanguages.remove(ll)) {
            }
        }
//        if (userLanguages.remove(original.getLanguage())) {
//        }

        return userLanguages;
    }

    @Override
    public Set<String> getNotTranslatedLanguages(Integer userId, Certification achievement) {
        Certification original = getOriginal(achievement);

        Set<String> userLanguages = getUserLanguages(original.getUserId());
        Set<String> translations = getTranslatedLanguages(original);

        for (String ll : translations) {
            if (userLanguages.remove(ll)) {
            }
        }
//        if (userLanguages.remove(original.getLanguage())) {
//        }

        return userLanguages;
    }

    @Override
    public Set<String> getNotTranslatedLanguages(Integer userId, Entrepeneurship achievement) {
        Entrepeneurship original = getOriginal(achievement);

        Set<String> userLanguages = getUserLanguages(original.getUserId());
        Set<String> translations = getTranslatedLanguages(original);

        for (String ll : translations) {
            if (userLanguages.remove(ll)) {
            }
        }
//        if (userLanguages.remove(original.getLanguage())) {
//        }

        return userLanguages;
    }

    @Override
    public Set<String> getNotTranslatedLanguages(Integer userId, Linguistic achievement) {
        Linguistic original = getOriginal(achievement);

        Set<String> userLanguages = getUserLanguages(original.getUserId());
        Set<String> translations = getTranslatedLanguages(original);

        for (String ll : translations) {
            if (userLanguages.remove(ll)) {
            }
        }
//        if (userLanguages.remove(original.getLanguage())) {
//        }

        return userLanguages;
    }

    @Override
    public Set<String> getNotTranslatedLanguages(Integer userId, Social achievement) {
        Social original = getOriginal(achievement);

        Set<String> userLanguages = getUserLanguages(original.getUserId());
        Set<String> translations = getTranslatedLanguages(original);

        for (String ll : translations) {
            if (userLanguages.remove(ll)) {
            }
        }
//        if (userLanguages.remove(original.getLanguage())) {
//        }

        return userLanguages;
    }

    @Override
    public Set<String> getNotTranslatedLanguages(Integer userId, Other achievement) {
        Other original = getOriginal(achievement);

        Set<String> userLanguages = getUserLanguages(original.getUserId());
        Set<String> translations = getTranslatedLanguages(original);

        for (String ll : translations) {
            if (userLanguages.remove(ll)) {
            }
        }
//        if (userLanguages.remove(original.getLanguage())) {
//        }

        return userLanguages;
    }

    @Override
    public Set<String> getTranslatedLanguages(Academic original) {
        List<Academic> queryResult = getTranslations(original);
        Set<String> translations = new TreeSet();
        for (Academic la : queryResult) {
            translations.add(la.getLanguage());
        }
        return translations;
    }

    @Override
    public Set<String> getTranslatedLanguages(Professional original) {
        List<Professional> queryResult = getTranslations(original);
        Set<String> translations = new TreeSet();
        for (Professional la : queryResult) {
            translations.add(la.getLanguage());
        }
        return translations;
    }

    @Override
    public Set<String> getTranslatedLanguages(Certification original) {
        List<Certification> queryResult = getTranslations(original);
        Set<String> translations = new TreeSet();
        for (Certification la : queryResult) {
            translations.add(la.getLanguage());
        }
        return translations;
    }

    @Override
    public Set<String> getTranslatedLanguages(Entrepeneurship original) {
        List<Entrepeneurship> queryResult = getTranslations(original);
        Set<String> translations = new TreeSet();
        for (Entrepeneurship la : queryResult) {
            translations.add(la.getLanguage());
        }
        return translations;
    }

    @Override
    public Set<String> getTranslatedLanguages(Social original) {
        List<Social> queryResult = getTranslations(original);
        Set<String> translations = new TreeSet();
        for (Social la : queryResult) {
            translations.add(la.getLanguage());
        }
        return translations;
    }

    @Override
    public Set<String> getTranslatedLanguages(Other original) {
        List<Other> queryResult = getTranslations(original);
        Set<String> translations = new TreeSet();
        for (Other la : queryResult) {
            translations.add(la.getLanguage());
        }
        return translations;
    }

    @Override
    public Set<String> getTranslatedLanguages(Linguistic original) {
        Query query = em.createNamedQuery("Linguistic.findByOriginalId", Linguistic.class);
        query.setParameter("originalId", original);
        List<Linguistic> queryResult = query.getResultList();
        Set<String> translations = new TreeSet<String>();
        for (Linguistic la : queryResult) {
            translations.add(la.getLanguage());
        }
        return translations;
    }

    private Linguistic getOriginal(Linguistic achievement) {
        if (achievement.getOriginalId() == null) {
            return achievement;
        } else {
            return getOriginal(achievement.getOriginalId());
        }
    }

    private Academic getOriginal(Academic achievement) {
        if (achievement.getOriginalId() == null) {
            return achievement;
        } else {
            return getOriginal(achievement.getOriginalId());
        }
    }

    private Professional getOriginal(Professional achievement) {
        if (achievement.getOriginalId() == null) {
            return achievement;
        } else {
            return getOriginal(achievement.getOriginalId());
        }
    }

    private Certification getOriginal(Certification achievement) {
        if (achievement.getOriginalId() == null) {
            return achievement;
        } else {
            return getOriginal(achievement.getOriginalId());
        }
    }

    private Entrepeneurship getOriginal(Entrepeneurship achievement) {
        if (achievement.getOriginalId() == null) {
            return achievement;
        } else {
            return getOriginal(achievement.getOriginalId());
        }
    }

    private Social getOriginal(Social achievement) {
        if (achievement.getOriginalId() == null) {
            return achievement;
        } else {
            return getOriginal(achievement.getOriginalId());
        }
    }

    private Other getOriginal(Other achievement) {
        if (achievement.getOriginalId() == null) {
            return achievement;
        } else {
            return getOriginal(achievement.getOriginalId());
        }
    }

    @Override
    public Linguistic getLinguistic(Integer id) {
        return em.find(Linguistic.class, id);
    }

    @Override
    public Academic getAcademic(Integer id) {
        return em.find(Academic.class, id);
    }

    @Override
    public Professional getProfessional(Integer id) {
        return em.find(Professional.class, id);
    }

    @Override
    public Certification getCertification(Integer id) {
        return em.find(Certification.class, id);
    }

    @Override
    public Entrepeneurship getEntrepeneurship(Integer id) {
        return em.find(Entrepeneurship.class, id);
    }

    @Override
    public Social getSocial(Integer id) {
        return em.find(Social.class, id);
    }

    @Override
    public Other getOther(Integer id) {
        return em.find(Other.class, id);
    }

    @Override
    public Translation getTranslation(String word, String from, String to) {
        Query q = em.createNamedQuery("Translation.findByOriginal", Translation.class);
        q.setParameter("original", word);
        List<Translation> translations = q.getResultList();
        for (Translation t : translations) {
            if (t.getTarget().equals(to)) {
                return t;
            }
        }

        // Translation not found -- Add missing translation
        MissingTranslation mt0 = getMissingTranslation(word, from, to);
        if (mt0 == null) {
            addMissingTranslation(word, from, to);
        }
        return null;
    }

    @Override
    public List<Academic> getAcademics(Integer userId, String language) {
        Query query = em.createNamedQuery("Academic.findByUserIdAndLanguage", Academic.class);
        query.setParameter("userId", userId);
        query.setParameter("language", language);
        return query.getResultList();
    }

    @Override
    public List<Professional> getProfessionals(Integer userId, String language) {
        Query query = em.createNamedQuery("Professional.findByUserIdAndLanguage", Professional.class);
        query.setParameter("userId", userId);
        query.setParameter("language", language);
        return query.getResultList();
    }

    @Override
    public List<Certification> getCertifications(Integer userId, String language) {
        Query query = em.createNamedQuery("Certification.findByUserIdAndLanguage", Certification.class);
        query.setParameter("userId", userId);
        query.setParameter("language", language);
        return query.getResultList();
    }

    @Override
    public List<Entrepeneurship> getEntrepeneurship(Integer userId, String language) {
        Query query = em.createNamedQuery("Entrepeneurship.findByUserIdAndLanguage", Entrepeneurship.class);
        query.setParameter("userId", userId);
        query.setParameter("language", language);
        return query.getResultList();
    }

    @Override
    public Entrepeneurship getEntrepeneurship(String name, String language) {
        Query query = em.createNamedQuery("Entrepeneurship.findByNameAndLanguage", Entrepeneurship.class);
        query.setParameter("name", name);
        query.setParameter("language", language);
        return (Entrepeneurship) query.getSingleResult();
    }

    @Override
    public List<Social> getSocials(Integer userId, String language) {
        Query query = em.createNamedQuery("Social.findByUserIdAndLanguage", Social.class);
        query.setParameter("userId", userId);
        query.setParameter("language", language);
        return query.getResultList();
    }

    @Override
    public List<Linguistic> getLinguistics(Integer userId, String language) {
        Query query = em.createNamedQuery("Linguistic.findByUserIdAndLanguage", Linguistic.class);
        query.setParameter("userId", userId);
        query.setParameter("language", language);
        return query.getResultList();
    }

    @Override
    public List<Other> getOthers(Integer userId, String language) {
        Query query = em.createNamedQuery("Other.findByUserIdAndLanguage", Other.class);
        query.setParameter("userId", userId);
        query.setParameter("language", language);
        return query.getResultList();
    }

    @Override
    public User getUser(Integer userId) {
        return em.find(User.class, userId);
    }

    @Override
    public Integer getUserId(String username) {
        Query q = em.createNamedQuery("User.findByUsername", User.class);
        q.setParameter("username", username);
        User user = (User) q.getSingleResult();
        return user.getId();
    }

    @Override
    public List<Social> getTranslations(Social original) {
        Query query = em.createNamedQuery("Social.findByOriginalId", Social.class);
        query.setParameter("originalId", original);
        return query.getResultList();
    }

    @Override
    public List<Academic> getTranslations(Academic original) {
        Query query = em.createNamedQuery("Academic.findByOriginalId", Academic.class);
        query.setParameter("originalId", original);
        return query.getResultList();
    }

    @Override
    public List<Professional> getTranslations(Professional original) {
        Query query = em.createNamedQuery("Professional.findByOriginalId", Professional.class);
        query.setParameter("originalId", original);
        return query.getResultList();
    }

    @Override
    public List<Certification> getTranslations(Certification original) {
        Query query = em.createNamedQuery("Certification.findByOriginalId", Certification.class);
        query.setParameter("originalId", original);
        return query.getResultList();
    }

    @Override
    public List<Linguistic> getTranslations(Linguistic original) {
        Query query = em.createNamedQuery("Linguistic.findByOriginalId", Linguistic.class);
        query.setParameter("originalId", original);
        return query.getResultList();
    }

    @Override
    public List<Entrepeneurship> getTranslations(Entrepeneurship original) {
        Query query = em.createNamedQuery("Entrepeneurship.findByOriginalId", Entrepeneurship.class);
        query.setParameter("originalId", original);
        return query.getResultList();
    }

    @Override
    public List<Other> getTranslations(Other original) {
        Query query = em.createNamedQuery("Other.findByOriginalId", Other.class);
        query.setParameter("originalId", original);
        return query.getResultList();
    }

    @Override
    public List<String> getFullnames() {
        List<User> users = getAllUsers();
        List<String> fullnames = new LinkedList();
        for (User u : users) {
            fullnames.add(u.getFirstName() + " " + u.getLastName());
        }
        return fullnames;
    }

    @Override
    public List<User> getAllUsers() {
        Query q = em.createNamedQuery("User.findAll", User.class);
        return q.getResultList();
    }

    @Override
    public Integer getUserId(String firstname, String lastname) {
        Query q = em.createNamedQuery("User.findByLastname", User.class);
        q.setParameter("lastname", lastname);
        List<User> users = q.getResultList();
        for (User u : users) {
            if (u.getFirstName().equals(firstname)) {
                return u.getId();
            }
        }
        return null;
    }

    @Override
    public String getUserMessage(Integer userId) throws UserWithoutWelcomeMessageException {
        Query q = em.createNamedQuery("WelcomeMessage.findByUserId", WelcomeMessage.class);
        q.setParameter("userId", userId);
        try {
            return ((WelcomeMessage) q.getSingleResult()).getMessage();
        } catch (NoResultException nrx) {
            throw new UserWithoutWelcomeMessageException(userId);
        }
    }

    @Override
    public Photo getUserPhoto(Integer userId) throws UserWithoutPhotoException {
        System.out.println("----------- get User photo" + userId);
        Query q = em.createNamedQuery("Photo.findByUserId", Photo.class);
        q.setParameter("userId", userId);
        List<Photo> photos = q.getResultList();
        if (photos == null || photos.isEmpty()) {
            throw new UserWithoutPhotoException(userId);
        } else {
            return photos.get(photos.size() - 1);
        }
    }

    @Override
    public void addUserPhoto(Integer userId, byte[] image) {
        Photo photo = new Photo();
        photo.setUserId(userId);
        System.out.println("----------->" + image.length);
        photo.setImage(image);
        em.persist(photo);
    }

    @Override
    public void addUserMessage(Integer userId, String message) {
        WelcomeMessage m = new WelcomeMessage();
        m.setUserId(userId);
        m.setMessage(message);
        System.out.println("----------->" + m.getMessage());
        em.persist(m);
    }

    @Override
    public List<Degree> getDegrees(String language) {
        Query q = em.createNamedQuery("Degree.findByLanguage", Degree.class);
        q.setParameter("language", language);
        return q.getResultList();
    }

    @Override
    public List<Course> getCourses(String language) {
        Query lQuery = em.createNamedQuery("Course.findByLanguage", Course.class);
        lQuery.setParameter("language", language);
        return lQuery.getResultList();
    }

    @Override
    public List<Country> getCountries(String language) {
        Query lQuery = em.createNamedQuery("Country.findByLanguage", Country.class);
        lQuery.setParameter("language", language);
        return lQuery.getResultList();
    }

    @Override
    public List<String> getFirstnames() {
        List<User> users = getAllUsers();
        List<String> names = new LinkedList<>();
        for (User u : users) {
            names.add(u.getFirstName());
        }
        return names;
    }

    @Override
    public List<String> getLastnames() {
        List<User> users = getAllUsers();
        List<String> names = new LinkedList<>();
        for (User u : users) {
            names.add(u.getLastName());
        }
        return names;
    }

    @Override
    public List<String> getCertificationsDegrees(String language) {
        List<Certification> certifications = getAllCertifications(language);
        List<String> names = new LinkedList<>();
        for (Certification c : certifications) {
            names.add(c.getDegree().getFullname());
        }
        return names;
    }

    private List<Certification> getAllCertifications(String language) {
        Query q = em.createNamedQuery("Certification.findByLanguage", Certification.class);
        q.setParameter("language", language);
        return q.getResultList();
    }

    private List<Academic> getAllAcademics(String language) {
        Query q = em.createNamedQuery("Academic.findByLanguage", Academic.class);
        q.setParameter("language", language);
        return q.getResultList();
    }

    private List<Entrepeneurship> getAllEntrepeneurships(String language) {
        Query q = em.createNamedQuery("Entrepeneurship.findByLanguage", Entrepeneurship.class);
        q.setParameter("language", language);
        return q.getResultList();
    }

    private List<Professional> getAllProfessionals(String language) {
        Query q = em.createNamedQuery("Professional.findByLanguage", Professional.class);
        q.setParameter("language", language);
        return q.getResultList();
    }

    private List<Linguistic> getAllLinguistics(String language) {
        Query q = em.createNamedQuery("Linguistic.findByLanguage", Linguistic.class);
        q.setParameter("language", language);
        return q.getResultList();
    }

    private List<Social> getAllSocials(String language) {
        Query q = em.createNamedQuery("Social.findByLanguage", Social.class);
        q.setParameter("language", language);
        return q.getResultList();
    }

    private List<Other> getAllOthers(String language) {
        Query q = em.createNamedQuery("Other.findByLanguage", Other.class);
        q.setParameter("language", language);
        return q.getResultList();
    }

    @Override
    public List<String> getLanguages(String language) {
        return Arrays.asList(Locale.getISOLanguages());
    }

    @Override
    public List<Position> getPositions(String language) {
        Query q = em.createNamedQuery("Position.findByLanguage", Professional.class);
        q.setParameter("language", language);
        return q.getResultList();

    }

    /*    public List<String> getPositions(String language) {
     Query q = em.createNamedQuery("Professional.findByLanguage", Professional.class);
     q.setParameter("language", language);
     List<Professional> achievements = q.getResultList();
     List<String> names = new LinkedList<>();
     for (Professional p : achievements) {
     names.add(p.getPosition());
     }
     return names;
     }*/
    @Override
    public List<String> getSocialTitles(String language) {
        Query q = em.createNamedQuery("Social.findByLanguage", Social.class);
        q.setParameter("language", language);
        List<Social> achievements = q.getResultList();
        List<String> names = new LinkedList<>();
        for (Social p : achievements) {
            names.add(p.getTitle());
        }
        return names;
    }

    @Override
    public List<String> getOtherTitles(String language) {
        Query q = em.createNamedQuery("Other.findByLanguage", Other.class);
        q.setParameter("language", language);
        List<Other> achievements = q.getResultList();
        List<String> names = new LinkedList<>();
        for (Other p : achievements) {
            names.add(p.getTitle());
        }
        return names;
    }

    @Override
    public boolean usernameExists(String username) {
        Query q = em.createNamedQuery("User.findByUsername", User.class);
        q.setParameter("username", username);
        List<User> users = q.getResultList();
        return !users.isEmpty();
    }

    @Override
    public String getMotherLanguage(Integer userId) {
        User u = em.find(User.class, userId);
        return u.getMotherLanguage();
    }

    @Override
    public void addComment(Integer userId, String message, String language) {
        Comment c = new Comment();
        if (userId != null) {
            c.setUserId(userId);
        }
        if (message != null) {
            c.setMessage(message);
        }
        if (language != null) {
            c.setLang(language);
        }
        em.persist(c);
    }

    @Override
    public void setHostId(Integer userId, Integer hostId) {
        Visits v = new Visits();
        v.setGuestId(userId);
        v.setHostId(hostId);
        v.setCreatedAt(new Date());
        em.persist(v);
    }

    @Override
    public Integer getHostId(Integer userId) {
        Query q = em.createNamedQuery("Visits.findByGuestId", Visits.class);
        q.setParameter("guestId", userId);
        Visits v = (Visits) q.getSingleResult();
        em.remove(v);
        return v.getHostId();
    }

    @Override
    public List<MissingTranslation> getMissingTranslations(Integer userId, String language) {
        Query q = em.createNamedQuery("MissingTranslation.findByTarget", MissingTranslation.class);
        q.setParameter("target", language);
        return q.getResultList();
    }

    @Override
    public List<Word> getWords(String from) {
        Query q = em.createNamedQuery("Word.findByLanguage", Word.class);
        q.setParameter("language", from);
        return q.getResultList();
    }

    @Override
    public void addTranslation(Integer userId, String original, String from, String to, String translation) {
        // Remove corresponding missing translation object
        MissingTranslation mt = getMissingTranslation(original, from, to);
        if (mt != null) {
            em.remove(mt);
        }
        Translation t = new Translation();
        t.setOriginal(original);
        t.setTranslation(translation);
        t.setOrigin(from);
        t.setTarget(to);
        em.persist(t);
    }

    @Override
    public Word
            getWord(String word, String language) {
        Query q = em.createNamedQuery("Word.findByWordAndLanguage", Word.class
        );
        q.setParameter(
                "word", word);
        q.setParameter(
                "language", language);
        List<Word> words = q.getResultList();

        if (words.isEmpty()) {
            Word w = addWord(word, language);
            return w;
        } else {
            return words.get(0);
        }
    }

    private MissingTranslation
            getMissingTranslation(String word, String origin, String target) {
        Query q = em.createNamedQuery("MissingTranslation.findByWord", MissingTranslation.class
        );
        q.setParameter(
                "word", word);
        List<MissingTranslation> ts = q.getResultList();
        for (MissingTranslation mt : ts) {
            if (mt.getOrigin().equals(origin) && mt.getTarget().equals(target)) {
                return mt;
            }
        }

        return null;
    }

    private Word addWord(String word, String language) {
        Word w = new Word(null, word, language);
        em.persist(w);
        return w;
    }

    private void addMissingTranslation(String word, String from, String to) {
        if (isValidString(word)) {
            MissingTranslation mt = new MissingTranslation();
            mt.setWord(word.trim());
            mt.setOrigin(from);
            mt.setTarget(to);
            em.persist(mt);
        }
    }

    @Override
    public List<Achievement> getAchievements(Integer userId, String language) {
        List<Achievement> result = new LinkedList<Achievement>();
        result.addAll(getAcademics(userId, language));
        result.addAll(getProfessionals(userId, language));
        result.addAll(getCertifications(userId, language));
        result.addAll(getEntrepeneurship(userId, language));
        result.addAll(getLinguistics(userId, language));
        result.addAll(getSocials(userId, language));
        result.addAll(getOthers(userId, language));
        return result;
    }

    @Override
    public boolean sendMail(String to, String subject, String body) {
        try {
            sendMail.sendMail(to, subject, body);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Degree getDegree(String degreename, String language) {
        Query q = em.createNamedQuery("Degree.findByFullname", Degree.class);
        q.setParameter("fullname", degreename);
        try {
            return (Degree) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Course getCourse(String coursename, String language) {
        Query q = em.createNamedQuery("Course.findByName", Course.class);
        q.setParameter("name", coursename);
        try {
            return (Course) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Organization getOrganization(String orgname, String language) {
        Query q = em.createNamedQuery("Organization.findByFullname", Organization.class);
        q.setParameter("fullname", orgname);
        try {
            return (Organization) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Position getPosition(String name, String language) {
        Query q = em.createNamedQuery("Position.findByName", Position.class);
        q.setParameter("name", name);
        List<Position> result = q.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
    }

    @Override
    public void addPosition(String name, String languague) {
        if (name != null) {
            Position position = new Position(null, name, new Date(), languague);
            em.persist(position);
        }
    }

    private Project getProject(String name, String language) {
        Query q = em.createNamedQuery("Project.findByName", Project.class);
        q.setParameter("name", name);
        try {
            return (Project) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    private void addProject(String name, String language) {
        if (name != null && language != null) {
            Project project = new Project(null, name, language, new Date());
            em.persist(project);
        }
    }

    public List<Todo> getAllTodos() {
        Query q = em.createNamedQuery("Todo.findAll", Todo.class);
        return q.getResultList();
    }

    public UserTodo getUserTodo(Integer userId, Integer todoId) {
        Query q = em.createNamedQuery("UserTodo.findByUserIdAndTodoId", UserTodo.class);
        q.setParameter("userId", userId);
        q.setParameter("todoId", todoId);
        List<UserTodo> todos = q.getResultList();
        if (todos == null || todos.isEmpty()) {
            return null;
        }
        return todos.get(0);
    }

    public void addUserTodo(UserTodo userTodo) {
        em.persist(userTodo);
    }

    @Override
    public List<Achievement> getOriginalsNotTranslatedTo(Integer userId, String language) {
        List<Achievement> result = new LinkedList<>();
        List<Achievement> originals = getOriginals(userId);
        for (Achievement o : originals) {
            if (needToBeTranslatedTo(o, userId, language)) {
                result.add(o);
            }
        }
        return result;
    }

    private List<Achievement> getOriginals(Integer userId) {
        List<Achievement> result = new LinkedList<>();
        Collection<? extends Achievement> academics = getOriginalAcademics(userId);
        result.addAll(academics);
        result.addAll(getOriginalProfessionalExperiences(userId));
        result.addAll(getOriginalCertifications(userId));
        result.addAll(getOriginalLinguisticSkills(userId));
        result.addAll(getOriginalSocialEngagements(userId));
        result.addAll(getOriginalEntrepeneurships(userId));
        result.addAll(getOriginalOthers(userId));
        return result;
    }

    private boolean needToBeTranslatedTo(Achievement o, Integer userId, String language) {
        boolean result = false;
        if (o instanceof Academic) {
            result = getNotTranslatedLanguages(userId, (Academic) o).contains(language);
        } else if (o instanceof Professional) {
            result = getNotTranslatedLanguages(userId, (Professional) o).contains(language);
        } else if (o instanceof Certification) {
            result = getNotTranslatedLanguages(userId, (Certification) o).contains(language);
        } else if (o instanceof Entrepeneurship) {
            result = getNotTranslatedLanguages(userId, (Entrepeneurship) o).contains(language);
        } else if (o instanceof Social) {
            result = getNotTranslatedLanguages(userId, (Social) o).contains(language);
        } else if (o instanceof Linguistic) {
            result = getNotTranslatedLanguages(userId, (Linguistic) o).contains(language);
        } else if (o instanceof Other) {
            result = getNotTranslatedLanguages(userId, (Other) o).contains(language);
        }

        if (result) {
            System.out.println("tttttttttttttttttttttttttttt");
            System.out.println(o + " need To be translated to " + language);
            System.out.println("tttttttttttttttttttttttttttt");
        }
        return result;
    }

    private List<? extends Achievement> getOriginalAcademics(Integer userId) {
        Query q = em.createNamedQuery("Academic.findByUserId", Academic.class);
        q.setParameter("userId", userId);
        List<Academic> achievements = q.getResultList();
        List<Academic> result = new LinkedList();
        for (Academic a : achievements) {
            if (a.getOriginalId() == null) {
                result.add(a);
            }
        }
        return result;
    }

    private List<? extends Achievement> getOriginalProfessionalExperiences(Integer userId) {
        Query q = em.createNamedQuery("Professional.findByUserId", Professional.class);
        q.setParameter("userId", userId);
        List<Professional> achievements = q.getResultList();
        List<Professional> result = new LinkedList();
        for (Professional a : achievements) {
            if (a.getOriginalId() == null) {
                result.add(a);
            }
        }
        return result;
    }

    private List<? extends Achievement> getOriginalCertifications(Integer userId) {
        Query q = em.createNamedQuery("Certification.findByUserId", Certification.class);
        q.setParameter("userId", userId);
        List<Certification> achievements = q.getResultList();
        List<Certification> result = new LinkedList();
        for (Certification a : achievements) {
            if (a.getOriginalId() == null) {
                result.add(a);
            }
        }
        return result;
    }

    private List<? extends Achievement> getOriginalLinguisticSkills(Integer userId) {
        Query q = em.createNamedQuery("Linguistic.findByUserId", Linguistic.class);
        q.setParameter("userId", userId);
        List<Linguistic> achievements = q.getResultList();
        List<Linguistic> result = new LinkedList();
        for (Linguistic a : achievements) {
            if (a.getOriginalId() == null) {
                result.add(a);
            }
        }
        return result;
    }

    private List<? extends Achievement> getOriginalSocialEngagements(Integer userId) {
        Query q = em.createNamedQuery("Social.findByUserId", Social.class);
        q.setParameter("userId", userId);
        List<Social> achievements = q.getResultList();
        List<Social> result = new LinkedList();
        for (Social a : achievements) {
            if (a.getOriginalId() == null) {
                result.add(a);
            }
        }
        return result;
    }

    private List<? extends Achievement> getOriginalEntrepeneurships(Integer userId) {
        Query q = em.createNamedQuery("Entrepeneurship.findByUserId", Entrepeneurship.class);
        q.setParameter("userId", userId);
        List<Entrepeneurship> achievements = q.getResultList();
        List<Entrepeneurship> result = new LinkedList();
        for (Entrepeneurship a : achievements) {
            if (a.getOriginalId() == null) {
                result.add(a);
            }
        }
        return result;
    }

    private List<? extends Achievement> getOriginalOthers(Integer userId) {
        Query q = em.createNamedQuery("Other.findByUserId", Other.class);
        q.setParameter("userId", userId);
        List<Other> achievements = q.getResultList();
        List<Other> result = new LinkedList();
        for (Other a : achievements) {
            if (a.getOriginalId() == null) {
                result.add(a);
            }
        }
        return result;
    }

    @Override
    public void addCertificate(Achievement achievement, byte[] bytes) {
        Certificate c = new Certificate(null, bytes);
        c.setAchievementId(achievement.getId());
        em.persist(c);
    }

    @Override
    public List<Certificate> getCertificates(Integer achievementId) {
        Query q = em.createNamedQuery("Certificate.findByAchievementId", Certificate.class);
        q.setParameter("achievementId", achievementId);
        return q.getResultList();
    }

    @Override
    public void addTask(Task task) {
        em.persist(task);
    }

    @Override
    public List<Task> getTasks(String language) {
        Query q = em.createNamedQuery("Task.findByLanguage", Task.class);
        q.setParameter("language", language);
        return q.getResultList();
    }

    @Override
    public void addTool(Tool tool) {
        em.persist(tool);
    }

    @Override
    public List<Tool> getTools(String language) {
        Query q = em.createNamedQuery("Tool.findByLanguage", Tool.class);
        q.setParameter("language", language);
        return q.getResultList();
    }

    @Override
    public List<JobOffer> getJobOffers(String language) {
        Query q = em.createNamedQuery("JobOffer.findByLanguage", JobOffer.class);
        q.setParameter("language", language);
        return q.getResultList();
    }

    @Override
    public List<JobOffer> getJobOffers(String position, String language) {
        Query q = em.createNamedQuery("JobOffer.findByPosition", JobOffer.class);
        q.setParameter("position", position);
        List<JobOffer> result = q.getResultList();
        for (JobOffer jo : result) {
            if (!jo.getLanguage().equals(language)) {
                result.remove(jo);
            }
        }
        return result;
    }

    @Override

    public void sendJobApplication(Integer userId, String language, JobApplication jobApplication, byte[][] documents) {
        System.out.println("********************************************");
        System.out.println("********************************************");
        System.out.println("Starting application");
        System.out.println("User: " + getUser(userId).getUsername());
        System.out.println("CV length: " + jobApplication.getResumeeImage().length);
        System.out.println("Letter length: " + jobApplication.getCoverLetterImage().length);
        System.out.println("#Documents: " + documents.length);
        System.out.println("Email Text: " + jobApplication.getEmailText());
        JobOffer jOffer = getJobOffer(jobApplication.getJobOfferId());
        User u = getUser(userId);
        sendMail.sendMail(u, jobApplication, jOffer, documents);
        System.out.println("********************************************");
        System.out.println("********************************************");
    }

    private boolean isValidString(String word) {
        return word != null && word.trim().length() > 0;
    }

    @Override
    public void addPosition(Position position) {
        em.persist(position);
    }

    @Override
    public List<Organization> getOrganizations(String language) {
        Query q = em.createNamedQuery("Organization.findByLanguage", Organization.class);
        q.setParameter("language", language);
        return q.getResultList();
    }

    @Override
    public JobOffer getJobOffer(String position, String language, Date d) {
        Query q = em.createNamedQuery("JobOffer.findByPosition", JobOffer.class);
        q.setParameter("position", position);
        List<JobOffer> offers = q.getResultList();
        for (JobOffer jo : offers) {
            if (jo.getCreatedAt().equals(d)) {
                return jo;
            }
        }
        return null;
    }

    @Override
    public void update(Task task) {
        em.merge(task);
    }

    @Override
    public void update(Tool tool) {
        em.merge(tool);
    }

    @Override
    public List<CoverLetter> getCoverLetters(String language) {
        Query q = em.createNamedQuery("CoverLetter.findByLanguage", CoverLetter.class);
        q.setParameter("language", language);
        return q.getResultList();
    }

    @Override
    public void add(CoverLetter entity) {
        em.persist(entity);
    }

    @Override
    public void delete(CoverLetter entity) {
        em.remove(em.merge(entity));
    }

    @Override
    public void update(CoverLetter entity) {
        em.merge(entity);
    }

    @Override
    public void add(JobApplication entity) {
        em.persist(entity);
    }

    @Override
    public void delete(JobApplication entity) {
        em.remove(em.merge(entity));
    }

    @Override
    public void update(JobApplication entity) {
        em.merge(entity);
    }

    public JobOffer getJobOffer(int jobOfferId) {
        return em.find(JobOffer.class, jobOfferId);
    }

    @Override
    public JobApplication getJobApplication(Integer jobOfferId, Integer userId) {
        Query q = em.createNamedQuery("JobApplication.findByJobOfferIdAndUserId", JobApplication.class);
        q.setParameter("jobOfferId", jobOfferId);
        q.setParameter("userId", userId);
        try {
            return (JobApplication) q.getSingleResult();
        } catch (NoResultException nrx) {
            return null;
        }
    }

    @Override
    public List<JobApplication> getJobApplications(Integer userId, String language) {
        Query q = em.createNamedQuery("JobApplication.findByUserIdAndLanguage", JobApplication.class);
        q.setParameter("userId", userId);
        q.setParameter("language", language);
        return q.getResultList();
    }

    @Override
    public void add(Organization org) {
        em.persist(org);
    }

    @Override
    public void delete(Organization organization) {
        em.remove(em.merge(organization));
    }

    @Override
    public void update(Organization organization) {
        em.merge(organization);
    }

    @Override
    public void add(Course course) {
        em.persist(course);
    }

    @Override
    public void delete(Course course) {
        em.remove(em.merge(course));
    }

    @Override
    public void update(Course course) {
        em.merge(course);
    }

    @Override
    public void add(Degree degree) {
        em.persist(degree);
    }

    @Override
    public void delete(Degree degree) {
        em.remove(em.merge(degree));
    }

    @Override
    public void update(Degree degree) {
        em.merge(degree);
    }

    @Override
    public List<Project> getProjects(String language) {
        Query q = em.createNamedQuery("Project.findByLanguage", Project.class);
        q.setParameter("language", language);
        return q.getResultList();
    }

    @Override
    public void add(Project project) {
        em.persist(project);
    }

    @Override
    public void delete(Project project) {
        em.remove(em.merge(project));
    }

    @Override
    public void update(Project project) {
        em.merge(project);
    }

    /*@Override
     public void add(JobOfferTool jobOfferTool) {
     em.persist(jobOfferTool);
     }

     @Override
     public void delete(JobOfferTool jobOfferTool) {
     em.remove(em.merge(jobOfferTool));
     }

     @Override
     public void update(JobOfferTool jobOfferTool) {
     em.merge(jobOfferTool);
     }*/
    @Override
    public void add(JobOffer jobOffer) {
        em.persist(jobOffer);
    }

    @Override
    public void delete(JobOffer jobOffer) {
        em.remove(em.merge(jobOffer));
    }

    @Override
    public void update(JobOffer jobOffer) {
        em.merge(jobOffer);
    }

}
