import org.junit.Test;

public class testIO {
    public static String right_in = "D:\\SE_two\\src\\test\\resources\\orig.txt";
    public static String error_in = "D:\\SE_two\\src\\test\\resources\\error_in.txt";
    public static String content = "程序运行结果";
    public static String right_out = "D:\\SE_two\\src\\test\\resources\\result.txt";
    public static String error_out = "D:\\SE_two\\src\\test\\resources\\result\\result.txt";
    @Test
    public void testIO_In_right() {
        // 文本路径正确
        // 活着前言一位真正的作家永远只为内心写作，只有内心才会真实地告诉他，他的自私、他的高尚是多么突出。...
        System.out.println(IO.In(right_in));
    }
    @Test
    public void testIO_In_error() {
        // 文本路径错误
        // java.lang.NullPointerException: 错误：文件路径错误，找不到相关文件
        IO.In(error_in);
    }
    @Test
    public void testIO_In_null () {
        // 文本路径为空
        // java.lang.NullPointerException: 错误：文件路径为空，找不到相关文件
        IO.In(null);
    }
    @Test
    public void testIO_In_blank () {
        // 文本路径为 ""或"    "
        // java.lang.NullPointerException: 错误：文件路径为空，找不到相关文件
        IO.In("   ");
    }
    @Test
    public void testIO_stopWords_right () {
        // 停用词文件存放在src/main/java/resources目录下
        // [———, 》），, ）÷（１－, ”，, ）、, ＝（, :, →, ℃ , &, *, 一一, ~~~~, ’, ...]
        System.out.println(IO.stopWords());
    }
    @Test
    public void testIO_stopWords_error () {
        // 停用词文件不在src/main/java/resources目录下
        // java.lang.AssertionError: 错误：找不到停用词文件
        IO.stopWords();
    }
    @Test
    public void testIO_Out_error () {
        // 有写入内容+错误文件路径
        // java.lang.NullPointerException: 错误：文件路径为错误，无法写入文件
        IO.Out(content,error_out);
    }
    @Test
    public void testIO_Out_error_null () {
        // 有写入内容+文件路径为空
        // java.lang.NullPointerException: 错误：文件路径为空，无法写入文件
        IO.Out(content,null);
    }
    @Test
    public void testIO_Out_error_blank () {
        // 有写入内容+文件路径为空格
        // java.lang.NullPointerException: 错误：文件路径为空，无法写入文件
        IO.Out(content,"   ");
    }
    @Test
    public void testIO_Out_error_content () {
        // 无写入内容
        // java.lang.NullPointerException: 错误：无写入内容
//        IO.Out(null,"   ");
        IO.Out("    ","   ");
    }

    @Test
    public void testIO_Out_right () {
        // 有写入内容+正确文件路径
        IO.Out(content,right_out);
    }
}
