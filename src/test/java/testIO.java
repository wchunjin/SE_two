import org.junit.Test;

import java.util.List;

public class testIO {
    public static String right_in = "D:\\SE_two\\src\\test\\resources\\orig.txt";
    public static String error_in = "D:\\SE_two\\src\\test\\resources\\error_in.txt";
    public static String content = "程序运行结果";
    public static String right_out = "D:\\SE_two\\src\\test\\resources\\result.txt";
    public static String error_out = "D:\\SE_two\\src\\test\\resources\\result\\result.txt";

    @Test
    public void testIO_In_right() {
        // 文本路径正确
        String right_in_result = IO.In(right_in);
        System.out.println(right_in_result);
    }

    @Test
    public void testIO_In_error() {
        // 文本路径错误
        String error_in_result = IO.In(error_in);
        System.out.println(error_in_result);
    }

    @Test
    public void testIO_In_null () {
        // 文本路径为空
        String null_in_result = IO.In(null);
        System.out.println(null_in_result);
    }

    @Test
    public void testIO_In_blank () {
        // 文本路径为 ""或"    "
        String null_in_result = IO.In("   ");
        System.out.println(null_in_result);
    }

    @Test
    public void testIO_stopWords_right () {
        // 停用词文件存放在src/main/java/resources目录下
        List<String> stopWords = IO.stopWords();
        System.out.println(stopWords);
    }

    @Test
    public void testIO_stopWords_error () {
        // 停用词文件不在src/main/java/resources目录下
        List<String> stopWords = IO.stopWords();
        System.out.println(stopWords);
    }

    @Test
    public void testIO_Out_right () {
        // 有写入内容+正确文件路径
        IO.Out(content,right_out);
    }

    @Test
    public void testIO_Out_error () {
        // 有写入内容+错误文件路径
        IO.Out(content,error_out);
    }

    @Test
    public void testIO_Out_error_null () {
        // 有写入内容+文件路径为空
        IO.Out(content,null);
    }

    @Test
    public void testIO_Out_error_blank () {
        // 有写入内容+文件路径为空
        IO.Out(content,"   ");
    }

    @Test
    public void testIO_Out_error_content () {
        // 无写入内容
//        IO.Out(null,"   ");
        IO.Out("    ","   ");
    }
}
