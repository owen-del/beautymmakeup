package hi;

import com.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test01 {

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        SessionFactory sessionFactory = applicationContext.getBean("sessionFactory", SessionFactory.class);
        Session session = sessionFactory.openSession();
//        Category category = new Category();
//        category.setDatashowname("洗衣液");
//        Object save = session.save(category);
//        System.out.println(save);

        Category category = session.get(Category.class, 7);
        System.out.println(category);

    }
}
