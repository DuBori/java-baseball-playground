package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    /*@Test*/
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    /*@Test*/
    public void test1() {
        String test1 = "1,2";
        String[] split = test1.split(",");
        assertThat(split).contains("1","2");

        String test2 = "1,2";
        String substring = test2.substring(0, test2.indexOf(","));
        assertThat(substring).containsOnlyOnce("1");
    }

    @Test
    public void test2() {
        String test2 = "(1,2)";
        test2.substring(test2.lastIndexOf("(") + 1 ,test2.lastIndexOf(")") - 1 );
    }


    @Test
    public void test3() {
        String test3 = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            for (int i = 0; i < test3.length(); i++) {
                test3.charAt(i);
            }
        }).withMessageMatching("Index: \\d+, Size: \\d+");

    }

    public class SetTest {
        private Set<Integer> numbers;
        @BeforeEach
        void setUp() {
            numbers = new HashSet<>();
            numbers.add(1);
            numbers.add(1);
            numbers.add(2);
            numbers.add(3);
        }

        // Test Case 구현
    }
    @Test
    public void test4() {
        assertThat("".isEmpty()).isTrue();
    }
    @Test
    public void test5() {
        List<String> list = Arrays.asList("1", "2", "3");

        assertThat(list)
                .isNotEmpty()
                .contains("1")
                .doesNotContainNull()
                .containsSequence("2", "3");
    }
    @Test
    public void test6() {
        String someCharacter = "b";

        assertThat(someCharacter)
                .isNotEqualTo("a")
                .inUnicode()
                .isGreaterThanOrEqualTo("b")
                .isLowerCase();
    }

    @Test
    public void test7() {
        assertThat(Runnable.class).isInterface();
    }
    @Test
    public void test8() {
        assertThat(Exception.class).isAssignableFrom(NoSuchElementException.class);
    }
    @Test
    public void test9() {
        File file = new File("settings.gradle");
        assertThat(file)
                .exists()
                .isFile()
                .canRead()
                .canWrite();

        assertThat(5.1).isEqualTo(5, withPrecision(1d));
    }


    @Test
    public void test10() {
        Map<Object,Object> map = new HashMap<>();
        map.put("hi","hi");
        map.put(2,"a");
        assertThat(map)
                .isNotEmpty()
                .containsKey(2)
                .doesNotContainKeys(10)
                .contains(entry(2, "a"));

 /*       assertThat(person.getAge())
                .as("%s's age should be equal to 100", person.getName())
                .isEqualTo(100);*/
    }



}
