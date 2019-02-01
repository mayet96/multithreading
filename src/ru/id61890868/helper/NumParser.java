package ru.id61890868.helper;


public class NumParser {

    private static final String[] DIGITS = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] TENS = {null, "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String[] TEENS = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] MAGNITUDES = {"hundred", "thousand", "million", "point"};
    private static final String ZERO = "zero";



    /*
    Nine thousand nine hundred ninety nine
    Nine thousand nine hundred eleven
    Nine thousand eleven


     */

    public static Integer parse(String s) throws Exception {

        s = s.toLowerCase();

        if (!(s.replaceAll(" ", "")).matches("[A-z]*")) {
            throw new Exception("not valid string");
        }
        String[] words = s.split("\\s+|,\\s*");

        int i = words.length;
        if (i == 0) {
            throw new Exception("empty string");
        }

        //проверяем на зеро
        int num = 0;
        if (i == 1) {
            if (words[0].equals(ZERO)) {
                return 0;
            }
        }

        for (int j = i - 1; j >= 0; j--) {
            System.out.println(words[j]);
            Integer digit = findIndex(DIGITS, words[j]);
            if (digit != null) {
                if (j < (i - 1)) {//слово не последнее
                    Integer magnitude = findIndex(MAGNITUDES, words[j + 1]);
                    if (magnitude != null) {
                        num = num + ((int)Math.pow(10, magnitude + 2)) * (digit + 1);
                    }
                }
            }
        }

        return num;
    }


    /**
     * Ищем элемент в массиве, возвращаем индекс
     *
     * @param array массив в котором ищем соозтвествие
     * @param obj   элемент, соответсвие которому ищим
     * @return индекс первого найденного элемента,
     * если элемент не найдет - null
     */
    public static Integer findIndex(Object[] array, Object obj) {
        int i = 0;
        for (Object item : array) {
            if (item.equals(obj)) {
                return i;
            } else {
                i++;
            }
        }
        return null;
    }

}
