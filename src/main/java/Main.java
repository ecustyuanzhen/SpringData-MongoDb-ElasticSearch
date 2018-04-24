import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static ClassPathXmlApplicationContext applicationContext;
    public static void main(String[] args){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring/spring-*.xml");
        applicationContext = classPathXmlApplicationContext;
    }
}
