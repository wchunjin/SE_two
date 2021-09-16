import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class testParticiple {
    public static String right_str = "这只皮靴号码大了，那只号码合适。";
    public static String[] stopWords_arr = {"这","，","了","那","。"};
    public static String[] list_str_arr_1 = {"A","B","C","D"};
    public static String[] list_str_arr_2 = {"A","D","E","F"};
    public static String[] list_str_arr_3 = {"A","B","C","D","E","F"};
    // 自定义简易停用词
    private static List<String> make_list_str(String[] arr) {
        List<String> stopWords_simple = new ArrayList<>();
        Collections.addAll(stopWords_simple, arr);
        return stopWords_simple;
    }
    @Test
    public void test_participle_right() {
        // 正确分词测试，启用停用词
        // [只, 皮靴, 号码, 大, 那只, 号码, 合适]
        System.out.println(Participle.participle(right_str, make_list_str(stopWords_arr)));
    }
    @Test
    public void test_participle_error_stopWords() {
        // 分词测试，停用表为空或不存在，降为标准分词
        // [这, 只, 皮靴, 号码, 大, 了, ，, 那只, 号码, 合适, 。]
//        System.out.println(Participle.participle(right_str, new ArrayList<>()));
        System.out.println(Participle.participle(right_str, null));
    }
    @Test
    public void test_participle_error_str() {
        // 传入字符串为空或空格
        // java.lang.NullPointerException: 错误：传入内容为空内容
//        System.out.println(Participle.participle("   ", make_list_str(stopWords_arr)));
        System.out.println(Participle.participle(null, make_list_str(stopWords_arr)));
    }
    @Test
    public void test_unionSet() {
        // 正确合并集合
        // [A, B, C, D, E, F]
        System.out.println(Participle.unionSet(make_list_str(list_str_arr_1), make_list_str(list_str_arr_2)));
    }
    @Test
    public void test_unionSet_error_null() {
        // 至少一个集合不存在
        // java.lang.NullPointerException: 错误：不存在两个集合用于合并
        Participle.unionSet(null, make_list_str(list_str_arr_2));
    }
    @Test
    public void test_unionSet_error_0() {
        // 合并的集合都为空集合
        // java.lang.NullPointerException: 错误：用于合并的两个集合同时不能为空
        Participle.unionSet(new ArrayList<>(), new ArrayList<>());
    }
    @Test
    public void test_computingWordFrequency_right() {
        // 正确测试计算词频
        // [1, 1, 1, 1, 0, 0]
        System.out.println(Arrays.toString(Participle.computingWordFrequency(make_list_str(list_str_arr_1),make_list_str(list_str_arr_3))));
    }
    @Test
    public void test_computingWordFrequency_error_null() {
        // 异常测试：集合不存在
        // java.lang.NullPointerException: 错误：文章分词集合或文章集合并集不存在
        Participle.computingWordFrequency(null, null);
    }
    @Test
    public void test_computingWordFrequency_error() {
        // 异常测试：集合为空
        // java.lang.NullPointerException: 错误：文章分词集合或文章集合并集为空
        Participle.computingWordFrequency(new ArrayList<>(), new ArrayList<>());
    }
}
