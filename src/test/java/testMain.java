import org.junit.Test;

import java.util.List;

public class testMain {
    public static String str_1 = "这只皮靴号码大了，那只号码合适。";
    public static String str_2 = "。适合码号只那，了大码号靴皮只这"; // 倒叙
    public static String str_3 = "这 只皮 靴号 码大了，那只 号码 合 适。"; // 空格
    public static String str_4 = "这只皮&靴号码&大了，那只*号）码#合适。"; // 插入符号
    public static String str_5 = "这只皮靴号码不小，那只更合适。"; // 部分抄袭
    public static String str_6 = ""; // 空串
    public static String str_7 = null;
    public static String file_1 = "D:\\SE_two\\src\\test\\resources\\orig.txt"; // 原文本
    public static String file_2 = "D:\\SE_two\\src\\test\\resources\\orig_0.8_add.txt"; // 对比文本
    public static String file_3 = "D:\\SE_two\\src\\test\\resources\\result.txt"; // 结果文本
    public static String file_4 = "D:\\SE_two\\src\\test\\resources\\org.txt"; // 错误路径
    public static String file_5 = "D:\\SE_two\\src\\test\\resources\\orig"; // 路径无后缀
    // 这里测试主函数在将 读取文章内容后 与 将结果写入文件前 的操作
    private static void main_simple(String str0, String str1) {
        // 停用字符集
        List<String> stopWords = IO.stopWords();
        // 分词
        List<String> list0 =  Participle.participle(str0, stopWords);
        List<String> list1 =  Participle.participle(str1, stopWords);
        // 分词并集
        List<String> union = Participle.unionSet(list0, list1);
        // 计算词频
        int[] arr0 = Participle.computingWordFrequency(list0, union);
        int[] arr1 = Participle.computingWordFrequency(list1, union);
        // 利用余弦相似算法计算文本相似度
        String result = Cosine.calculate(arr0, arr1);
        System.out.println("原文本："+str0);
        System.out.println("对比文本："+str1);
        System.out.println("相似度："+result);
    }
    @Test
    public void test_1() {
        // 完全相同
        // 相似度：100.00%
        main_simple(str_1, str_1);
        // 完全倒叙
        // 相似度：18.49%
        main_simple(str_1, str_2);
        // 空格
        // 相似度：24.57%
        main_simple(str_1, str_3);
        // 插入符号
        // 相似度：66.67%
        main_simple(str_1, str_4);
        // 部分抄袭
        // 相似度：62.99%
        main_simple(str_1, str_5);
    }
    @Test
    public void test_6() {
        // 空串或字符串不存在
        // java.lang.NullPointerException: 错误：传入内容为空内容
        main_simple(str_1, str_6);
        main_simple(str_1, str_7);
    }
    @Test
    public void test_main() {
        // 正确使用
        // 程序完成，已将结果写入指定文本，感谢使用。
        String[] arr_1 = {file_1, file_2, file_3};
        Main.main(arr_1);

        // 传入错误路径
        // java.lang.NullPointerException: 错误：文件路径错误，找不到相关文件
        String[] arr_2 = {file_1, file_4, file_3};
        Main.main(arr_2);

        // 文件名无后缀，读取文件的话仍能继续执行
        // 程序完成，已将结果写入指定文本，感谢使用。
        String[] arr_3 = {file_1, file_5, file_3};
        Main.main(arr_3);

        // 文件名无后缀，写入文件的话仍能继续执行
        // 程序完成，已将结果写入指定文本，感谢使用。
        String[] arr_4 = {file_1, file_2, file_5};
        Main.main(arr_4);
    }
}
