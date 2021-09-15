import org.junit.Test;

public class testCosine {

    public static int[] right_1 = {1,2,3,0,0};
    public static int[] right_2 = {0,0,1,2,3};
    public static int[] error_1 = {0,0,1,2,3,4};
    public static int[] error_2 = {};

    @Test
    public void text_calculate_right() {
        // 正确数组参数
        String result = Cosine.calculate(right_1, right_2);
        System.out.println(result);
    }

    @Test
    public void text_calculate_error_length() {
        // 数组参数长度不等
        String result = Cosine.calculate(right_1, error_1);
        System.out.println(result);
    }

    @Test
    public void text_calculate_error_null() {
        // 数组参数长度不等
        String result = Cosine.calculate(null, null);
        System.out.println(result);
    }

    @Test
    public void text_calculate_error_0() {
        // 数组长度为0
        String result = Cosine.calculate(error_2, error_2);
        System.out.println(result);
    }

}
