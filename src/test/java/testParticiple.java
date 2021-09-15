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
        List<String> result = Participle.participle(right_str, make_list_str(stopWords_arr));
        System.out.println(result);
    }

    @Test
    public void test_participle_error_stopWords() {
        // 分词测试，停用表为空或不存在，降为标准分词
//        List<String> result = Participle.participle(right_str, new ArrayList<>());
        List<String> result = Participle.participle(right_str, null);
        System.out.println(result);
    }

    @Test
    public void test_participle_error_str() {
        // 传入字符串为空或空格
//        List<String> result = Participle.participle("   ", make_stopWords());
        List<String> result = Participle.participle(null, make_list_str(stopWords_arr));
        System.out.println(result);
    }

    @Test
    public void test_unionSet() {
        // 正确合并集合
        List<String> result = Participle.unionSet(make_list_str(list_str_arr_1), make_list_str(list_str_arr_2));
        System.out.println(result);
    }

    @Test
    public void test_unionSet_error_null() {
        // 至少一个集合不存在
        List<String> result = Participle.unionSet(null, make_list_str(list_str_arr_2));
        System.out.println(result);
    }

    @Test
    public void test_unionSet_error_0() {
        // 合并的集合都为空集合
        List<String> result = Participle.unionSet(new ArrayList<>(), new ArrayList<>());
        System.out.println(result);
    }

    @Test
    public void test_computingWordFrequency_right() {
        // 正确测试
        int[] result = Participle.computingWordFrequency(make_list_str(list_str_arr_1),make_list_str(list_str_arr_3));
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void test_computingWordFrequency_error_null() {
        // 异常测试：集合不存在
        int[] result = Participle.computingWordFrequency(null, null);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void test_computingWordFrequency_error() {
        // 异常测试：集合为空
        int[] result = Participle.computingWordFrequency(new ArrayList<>(), new ArrayList<>());
        System.out.println(Arrays.toString(result));
    }
}
