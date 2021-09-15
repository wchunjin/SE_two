public class Cosine {
    /**
     * 计算余弦相似度
     * @param arr0:向量0
     * @param arr1:向量1
     * @return 字符类型的百分比数字
     */
    static String calculate(int[] arr0, int[] arr1) {
        // 异常处理
        if (arr0==null || arr1==null || arr0.length==0 || arr1.length == 0) {
            throw new NullPointerException("错误：用于余弦计算的数组为空数组");
        }
        if (arr0.length != arr1.length) {
            throw new ArrayIndexOutOfBoundsException("错误：用于余弦计算的数组长度为0");
        }
        double result = 0;
        double median0 = 0; // 中间计算结果
        double median1 = 0;
        for (int i = 0; i < arr0.length; i++) {
            result += arr0[i] * arr1[i];
            median0 += Math.pow(arr0[i], 2);
            median1 += Math.pow(arr1[i], 2);
        }
        result /= Math.sqrt(median0)*Math.sqrt(median1);
        // 结果化为百分比形式，保留两位小数
        result *= 100;
        return String.format("%.2f", result)+"%";
    }
}
