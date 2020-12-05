import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

  public static void main(String[] args) {
    StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure("hibernate.cfg.xml").build();
    Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
    SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

    Session session = sessionFactory.openSession();
    for(int i = 1; i < 47;i++){
      Course course = session.get(Course.class,i);
      System.out.printf("%-35s: %d человек%n", course.getName(),course.getStudentsCount());
    }
    for(int i = 1; i < 101;i++){
      Student student = session.get(Student.class,i);
      System.out.println(student);
    }
    sessionFactory.close();
  }
}