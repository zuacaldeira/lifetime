/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old;

import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.ejb.Remote;
import lifetime.persistence.LifetimeUser;

/**
 *
 * @author azc
 */
@Remote
public interface LifetimeBusiness {

    // ADRESS MANAGEMENT
    void addAddress(String street, String number, String postalCode, String locality, String region, String country);

    void addUserAddress(Integer userId, Integer addressId);

    void addAddressGPS(Integer addressId, Long latitude, Long longitude);

    // USER MANAGEMENT
    void addUser(String firstname, String lastname, String email, String password, String motherLanguage);

    void addRole(String rolename);

    void addUserRole(String username, String rolename);

    public LifetimeUser getUser(Integer userId);

    public Integer getUserId(String username);

    // ORGANIZATION
    void addOrganization(String name, String shortname, String language);

    void add(Organization org);

    void delete(Organization org);

    void update(Organization org);

    void add(Course course);

    void delete(Course course);

    void update(Course course);

    void add(Degree degree);

    void delete(Degree degree);

    void update(Degree degree);

    void add(Project project);

    void delete(Project project);

    void update(Project project);

    //
    //
    void add(JobOffer jobOffer);

    void delete(JobOffer jobOffer);

    void update(JobOffer jobOffer);

    //
    public void add(CoverLetter coverLetter);

    public void delete(CoverLetter coverLetter);

    public void update(CoverLetter coverLetter);

    // 
    public void add(JobApplication position);

    public void delete(JobApplication coverLetter);

    public void update(JobApplication coverLetter);

    //
    public void add(Academic achievement);

    public void add(Professional achievement);

    public void add(Certification achievement);

    public void add(Entrepeneurship achievement);

    public void add(Social achievement);

    public void add(Linguistic achievement);

    public void add(Other achievement);

    public void delete(Academic achievement);

    public void delete(Professional achievement);

    public void delete(Certification achievement);

    public void delete(Linguistic achievement);

    public void delete(Entrepeneurship achievement);

    public void delete(Social achievement);

    public void delete(Other achievement);

    public void update(Achievement achievement);

    public void update(Task task);

    public void update(Tool tool);

    void addOrganizationAddress(Integer organizationId, Integer addressId);

    // ACHIEVEMENT TYPES
    public List<Academic> getAcademics(Integer userId);

    public List<Professional> getProfessionals(Integer userId);

    public List<Certification> getCertifications(Integer userId);

    public List<Entrepeneurship> getEntrepeneurships(Integer userId);

    public List<Social> getSocials(Integer userId);

    public List<Linguistic> getLinguistics(Integer userId);

    public List<Other> getOthers(Integer userId);

    public List<Academic> getAcademics(Integer userId, String language);

    public List<Professional> getProfessionals(Integer userId, String language);

    public List<Certification> getCertifications(Integer userId, String language);

    public List<Entrepeneurship> getEntrepeneurship(Integer userId, String language);

    public List<Social> getSocials(Integer userId, String language);

    public List<Linguistic> getLinguistics(Integer userId, String language);

    public List<Other> getOthers(Integer userId, String language);

    public Set<String> getUserLanguages(Integer userId);

    public Set<String> getNotTranslatedLanguages(Integer userId, Academic achievement);

    public Set<String> getNotTranslatedLanguages(Integer userId, Professional achievement);

    public Set<String> getNotTranslatedLanguages(Integer userId, Certification achievement);

    public Set<String> getNotTranslatedLanguages(Integer userId, Entrepeneurship achievement);

    public Set<String> getNotTranslatedLanguages(Integer userId, Linguistic achievement);

    public Set<String> getNotTranslatedLanguages(Integer userId, Social achievement);

    public Set<String> getNotTranslatedLanguages(Integer userId, Other achievement);

    public Set<String> getTranslatedLanguages(Academic original);

    public Set<String> getTranslatedLanguages(Professional original);

    public Set<String> getTranslatedLanguages(Certification original);

    public Set<String> getTranslatedLanguages(Linguistic original);

    public Set<String> getTranslatedLanguages(Entrepeneurship original);

    public Set<String> getTranslatedLanguages(Social original);

    public Set<String> getTranslatedLanguages(Other original);

    public List<Academic> getTranslations(Academic original);

    public List<Professional> getTranslations(Professional original);

    public List<Certification> getTranslations(Certification original);

    public List<Linguistic> getTranslations(Linguistic original);

    public List<Entrepeneurship> getTranslations(Entrepeneurship original);

    public List<Social> getTranslations(Social original);

    public List<Other> getTranslations(Other original);

    public Academic getAcademic(Integer id);

    public Professional getProfessional(Integer id);

    public Certification getCertification(Integer id);

    public Entrepeneurship getEntrepeneurship(Integer id);

    public Social getSocial(Integer id);

    public Other getOther(Integer id);

    public Linguistic getLinguistic(Integer id);

    public List<String> getFullnames();

    public List<LifetimeUser> getAllUsers();

    public Integer getUserId(String firstname, String lastname);

    public String getUserMessage(Integer userId) throws UserWithoutWelcomeMessageException;

    public void addUserMessage(Integer userId, String message);

    public Photo getUserPhoto(Integer userId) throws UserWithoutPhotoException;

    public void addUserPhoto(Integer userId, byte[] image);

    public Degree getDegree(String name, String language);

    public List<Degree> getDegrees(String language);

    public Translation getTranslation(String word, String from, String to);

    public List<Course> getCourses(String language);

    public List<Country> getCountries(String language);

    public List<String> getFirstnames();

    public List<String> getLastnames();

    public List<String> getCertificationsDegrees(String language);

    public List<String> getLanguages(String language);

    public List<Position> getPositions(String language);

    public List<String> getSocialTitles(String language);

    public List<String> getOtherTitles(String language);

    public boolean usernameExists(String s);

    public String getMotherLanguage(Integer userId);

    public void addComment(Integer userId, String message, String language);

    public void setHostId(Integer userId, Integer hostId);

    public Integer getHostId(Integer userId);

    public List<MissingTranslation> getMissingTranslations(Integer userId, String language);

    public List<Word> getWords(String from);

    public void addTranslation(Integer userId, String word, String origin, String target, String value);

    public Word getWord(String word, String from);

    public List<Achievement> getAchievements(Integer userId, String language);

    public boolean sendMail(String to, String subject, String body);

    public Course getCourse(String coursename, String language);

    public Organization getOrganization(String orgname, String language);

    public List<Achievement> getOriginalsNotTranslatedTo(Integer userId, String language);

    public void addCertificate(Achievement achievement, byte[] toByteArray);

    public List<Certificate> getCertificates(Integer achievementId);

    public void addTask(Task task);

    public List<Task> getTasks(String language);

    public void addTool(Tool tool);

    public List<Tool> getTools(String language);

    public void sendJobApplication(Integer userId, String language, JobApplication jobApplication, byte[][] documents);

    public void addPosition(Position position);

    public void addPosition(String name, String languague);

    public Position getPosition(String name, String language);

    public List<Organization> getOrganizations(String language);

    public List<JobOffer> getJobOffers(String language);

    public List<JobOffer> getJobOffers(String position, String language);

    public JobOffer getJobOffer(String position, String language, Date d);

    public List<CoverLetter> getCoverLetters(String language);

    public Entrepeneurship getEntrepeneurship(String name, String language);

    public JobApplication getJobApplication(Integer jobOfferId, Integer userId);

    public List<JobApplication> getJobApplications(Integer userId, String language);

    public List<Project> getProjects(String language);

}
