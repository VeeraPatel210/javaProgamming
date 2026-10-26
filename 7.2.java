
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run {}

class MyTests {
    @Run
    public void test1() {
        System.out.println("Test 1 passed");
    }

    @Run
    public void test2() {
        System.out.println("Test 2 passed");
    }

    public void test3() {
        System.out.println("Test 3 passed");
    }
}

 class MiniTestRunner {
    public static void main(String[] args) throws Exception {
        MyTests obj = new MyTests();
        int count = 0;

        for (Method m : obj.getClass().getDeclaredMethods()) {
            if (m.isAnnotationPresent(Run.class)) {
                m.invoke(obj);
                count++;
            }
        }

        System.out.println("Total tests run: " + count);
    }
}
