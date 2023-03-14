package demo;

import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;
import de.danielbechler.diff.selector.BeanPropertyElementSelector;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.text.MessageFormat;


@RunWith(JUnit4.class)
public class DiffTest {

    private static  User user1;

    private static User user2;

    static {
        user1 = new User("xujie", 23);
        user2 = new User("xiehuiru", 20);
    }


    @Test
    public void diff_test1() {
        DiffNode compare = ObjectDifferBuilder.buildDefault().compare(user1, user2);
        compare.visitChildren((node,visit)->{
            System.out.println(MessageFormat.format("key:{0},value:{1}",
                    ((BeanPropertyElementSelector)node.getElementSelector()),node.canonicalGet(user2)));
        });
    }

    static class User{

        public User(String username,int age){
            this.username = username;
            this.age = age;
        }

        private String username;
        private int age;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
