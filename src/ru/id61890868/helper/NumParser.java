package ru.id61890868.helper;


public class NumParser {

    private static final String[] DIGITS = {null, "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] TENS = {null, null, "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String[] TEENS = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] MAGNITUDES = {null, null, "hundred", "thousand"};
    private static final String ZERO = "zero";



    /*
    Nine thousand nine hundred ninety nine
    Nine thousand nine hundred eleven
    Nine thousand eleven
    one thousand two hundred ninety-eight
    Seven hundred fifty four
    Sixty
    three
    zero
     */

    /**
     * Преобразует строку в число. Корректно работает в диапазоне 0-9999
     * @param s строка представляющая число
     * @return значение числа в строке
     * @throws Exception не валидная строка
     */
    public static Integer parse(String s) throws Exception {

        s = s.toLowerCase();

        if (!(s.replaceAll(" ", "")).matches("([A-z]|-)*")) {
            throw new Exception("not valid string");
        }
        String[] words = s.split("\\s+|,\\s*|-");

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

        for (int j = 0; j < i; j++) {

            Integer digit = findIndex(DIGITS, words[j]);    //индекс слова числа соответсвует числу
            if (digit != null) {
                if (j < (i - 1)) {//слово не последнее
                    Integer magnitude = findIndex(MAGNITUDES, toSingle(words[j + 1])); //10^index магнитуды соответствует ее значению
                    if (magnitude != null) {    //если есть магнитуда
                        num = num + ((int) Math.pow(10, magnitude)) * (digit);
                    }
                }else {
                    num = num + digit;  //если магнитуды нет, то это просто число
                }
            } else {
                Integer teens = findIndex(TEENS, words[j]);
                if (teens != null) {
                    num = num + 10 + teens; //индекс teens равен ее значению - 10. teens = {10 - 19}
                } else {
                    Integer tens = findIndex(TENS, words[j]);   //десятки. значение равно индекс * 10
                    if (tens != null) {
                        num = num + tens * 10;
                    }
                }
            }
        }
        return num;
    }


    /**
     * Убираем 's' с конца слова. Предполагается что слово не заканчивается пробелом
     *
     * @param word слово, в котором, вероятно, есть 's' на конце
     * @return слово без 's' на конце
     */
    public static String toSingle(String word) {
        return word.replaceAll("s$", "");
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
        if(obj == null){
            return null;
        }
        for (Object item : array) {
            if(item != null) {
                if (item.equals(obj)) {
                    return i;
                }
            }
            i++;
        }
        return null;
    }
}
