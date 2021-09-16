import org.junit.Test;

public class testCosine {
    public static int[] right_1 = {1,2,3,0,0};
    public static int[] right_2 = {0,0,1,2,3};
    public static int[] error_1 = {0,0,1,2,3,4};
    public static int[] error_2 = {};
    public static int[] error_3 = {0,0,0,0,0};
    @Test
    public void text_calculate_right() {
        // 正确数组参数
        System.out.println(Cosine.calculate(right_1, right_2)); // 21.43%
    }
    @Test
    public void text_calculate_error_length() {
        // 数组参数长度不等
        // java.lang.ArrayIndexOutOfBoundsException: 错误：用于余弦计算的数组长度不等
        Cosine.calculate(right_1, error_1);
    }
    @Test
    public void text_calculate_error_null() {
        // 数组参数为 null
        // java.lang.NullPointerException: 错误：用于余弦计算的数组为空数组
        Cosine.calculate(null, null);
    }
    @Test
    public void text_calculate_error_0() {
        // 数组长度为0
        // java.lang.NullPointerException: 错误：用于余弦计算的数组为空数组
        Cosine.calculate(error_2, error_2);
    }
    @Test
    public void text_calculate_error__0() {
        // 其中一个数组值皆为0
        // java.lang.ArithmeticException: 错误：用于余弦计算的两个数组，存在值皆为0的数组
        Cosine.calculate(right_1, error_3);
    }
}
