import java.util.LinkedList;

/*
Upside-Down Numbers

Функция принимает две строки, каждая из которых состоит из цифр, представляющих положительное целое число.
Вернуть она должна количество чисел в диапазоне между двумя переданными числами включительно,
которые не меняются, если их перевернуть.
 */
public class Juniorlab39 {

    public static long upsidedown(String x, String y) {

        int counter = 0;
        String currentNumber = findStart(x);
        if (currentNumber.compareTo(x) >= 0) {
            System.out.println(currentNumber + "     x=" + x);
        }
        counter++;
        String numberWithMask = currentNumber;
        for (int i = 0; i < y.length() - currentNumber.length(); i++) {
            numberWithMask = "0" + numberWithMask;
        }
        while (y.compareTo(numberWithMask) > 0) {
            currentNumber = getNextNumber(currentNumber);
            counter++;
            for (int i = 0; i < y.length() - currentNumber.length(); i++) {
                numberWithMask = "0" + numberWithMask;
            }
        }
        return counter;
    }

    private static String getNextNumber(String numberAsString) {
        boolean even = true; // четный
        int length = numberAsString.length();
        even = length % 2 == 0 ? true : false;
        char[] arrayOfDigits = numberAsString.toCharArray();
        int position = arrayOfDigits.length-1;
        String result = new String();
            char digit = numberAsString.charAt(position);
            if (digit == '0') {
                arrayOfDigits[position] = '1';
            } else if (position == length - 1) {
                if (even) {
                    if (digit == '1') {
                        arrayOfDigits[position] = '6';
                    } else if (digit == '6') {
                        arrayOfDigits[position] = '8';
                    } else if (digit == '8') {
                        arrayOfDigits[position] = '9';
                    } else if (digit == '9') {
                        arrayOfDigits[position] = '0';
                        int k = position - 1;
                        while (k >= 0 && arrayOfDigits[k] == '9') {
                            arrayOfDigits[k] = '0';
                            k--;
                        }
                        if (k == -1) {
                            //result = "1" + new String(arrayOfDigits);
                            result = "1" + repairNumber(arrayOfDigits, even);
                            return result;
                        } else {
                            if (arrayOfDigits[k] == '0') {
                                arrayOfDigits[k] = '1';
                            } else if (digit == '1') {
                                arrayOfDigits[k] = '6';
                            } else if (digit == '6') {
                                arrayOfDigits[k] = '8';
                            } else if (digit == '8') {
                                arrayOfDigits[k] = '9';
                            }
                        }

                    }
                } else if (!even) {
                    if (digit == '1') {
                        arrayOfDigits[position] = '8';
                    } else if (digit == '8') {
                        arrayOfDigits[position] = '0';
                        int k = position - 1;
                        while (k >= 0 && arrayOfDigits[k] == '9') {
                            arrayOfDigits[k] = '0';
                            k--;
                        }
                        if (k == -1) {
                            //result = "1" + new String(arrayOfDigits);
                            result = "1" + repairNumber(arrayOfDigits, even);
                            return result;
                        } else {
                            if (arrayOfDigits[k] == '0') {
                                arrayOfDigits[k] = '1';
                            } else if (digit == '1') {
                                arrayOfDigits[k] = '6';
                            } else if (digit == '6') {
                                arrayOfDigits[k] = '8';
                            } else if (digit == '8') {
                                arrayOfDigits[k] = '9';
                            }
                        }
                    }
                } else {
                    if (arrayOfDigits[position] == '0') {
                        arrayOfDigits[position] = '1';
                    } else if (digit == '1') {
                        arrayOfDigits[position] = '6';
                    } else if (digit == '6') {
                        arrayOfDigits[position] = '8';
                    } else if (digit == '8') {
                        arrayOfDigits[position] = '9';
                    } else if (digit == '9') {
                        arrayOfDigits[position] = '0';
                        int k = position - 1;
                        while (k >= 0 && arrayOfDigits[k] == '9') {
                            arrayOfDigits[k] = '0';
                            k--;
                        }
                        if (k == -1) {
                            //result = "1" + new String(arrayOfDigits);
                            result = "1" + repairNumber(arrayOfDigits, even);
                            return result;
                        } else {
                            if (arrayOfDigits[k] == '0') {
                                arrayOfDigits[k] = '1';
                            } else if (digit == '1') {
                                arrayOfDigits[k] = '6';
                            } else if (digit == '6') {
                                arrayOfDigits[k] = '8';
                            } else if (digit == '8') {
                                arrayOfDigits[k] = '9';
                            }
                        }

                    }
                }
            }

        result = new String(arrayOfDigits);
        return result;

    }

    private static String repairNumber(char[] arrayOfDigits, boolean even) {
        int length = arrayOfDigits.length;
        String result = new String(arrayOfDigits);
        length = even ? length-2 : length-1;
        for (int i = length; i > 0; i--) {
            result += arrayOfDigits[i];
        }
        System.out.println(result);
        return result;
    }

    private static String findStart(String numberAsString) {
        boolean even = true; // четный
        int range = numberAsString.length() / 2 + numberAsString.length() % 2;
        even = numberAsString.length() % 2 == 0 ? true : false;
        char[] arrayOfDigits = numberAsString.substring(0, range).toCharArray();
        String result = new String();

        for (int i = range - 1; i >= 0; i--) {
            char digit = numberAsString.charAt(i);
            if (even) {
                if (digit == '0' || digit == '1' || digit == '6' || digit == '8' || digit == '9') {
                    //     arrayOfDigits[i] = digit;
                } else if (digit == '2' || digit == '3' || digit == '4' || digit == '5') {
                    arrayOfDigits[i] = '6';
                } else arrayOfDigits[i] = '8'; // если '7'
            } else {
                if (digit == '0' || digit == '1' || digit == '8') {
                    arrayOfDigits[i] = digit;
                } else if (digit == '2' || digit == '3' || digit == '4' || digit == '5' || digit == '6' || digit == '7') {
                    arrayOfDigits[i] = '8';
                } else if (digit == '9') {
                    // записать 0 и увеличить цифру слева, если есть
                    arrayOfDigits[i] = '0';

                    int k = i - 1;
                    while (arrayOfDigits[k] == '9' && k >= 0) {
                        arrayOfDigits[k] = '0';
                        k--;
                    }
                    if (k == -1) {
                        result = "1" + new String(arrayOfDigits);
                        return result;
                    } else {
                        arrayOfDigits[k]++;
                    }
                }
            }
        }
        result = new String(arrayOfDigits);
        return result;
    }

    public static void main(String[] args) {
        String example01 = "187310929748";
        String example02 = "4337317188278519608";
        String example11 = "0";
        String example12 = "10";
        String example21 = "6";
        String example22 = "25";
        String example31 = "10";
        String example32 = "100";
        String example41 = "100";
        String example42 = "1000";
        String example51 = "100000";
        String example52 = "12345678900000000";
        String example61 = "10000000000";
        String example62 = "10000000000000000000000";
        String example71 = "861813545615";
        String example72 = "9813815838784151548487";
        String example81 = "5748392065435706";
        String example82 = "643572652056324089572278742";
        String example91 = "1";
        String example92 = "45898942362076547326957326537845432452352";
        String example101 = "7164006";
        String example102 = "2329491238";
        String example111 = "66478560783";
        String example112 = "174991074343062206";


//        System.out.println(upsidedown(example01, example02) + " total"); // 4282125l
//        System.out.println(upsidedown(example11, example12) + " total"); // 3L    +++++++++
        System.out.println(upsidedown(example21, example22) + " total"); // 2L    +++++++++++
//        System.out.println(upsidedown(example31, example32) + " total"); // 4L    ++++++++++
//        System.out.println(upsidedown(example41, example42) + " total"); // 12L   ++++++++++
//        System.out.println(upsidedown(example51, example52) + " total"); // 718650L    ++++++++++
//        System.out.println(upsidedown(example61, example62) + " total"); // 78120000L  +++++++++++++++++++
//        System.out.println(upsidedown(example71, example72) + " total"); // 74745418L   ++++++++++++++++++
//        System.out.println(upsidedown(example81, example82) + " total"); // 2978125000L
//        System.out.println(upsidedown(example91, example92) + " total"); // 209808349609373L
//        System.out.println(upsidedown(example101, example102) + " total"); // 2775L             2754    --------
//        System.out.println(upsidedown(example111, example112) + " total"); // 1789100L      1789046   ---------

//        assertEquals(74745418l, Juniorlab.upsidedown(example71, example72));
//        assertEquals(2978125000l, Juniorlab.upsidedown(example81, example82));
//        assertEquals(209808349609373l, Juniorlab.upsidedown(example91, example92));
//        assertEquals(2775l, Juniorlab.upsidedown(example101, example102));
//        assertEquals(1789100l, Juniorlab.upsidedown(example111, example112));
    }
}


//public class Juniorlab39 {
//
//    public static long upsidedown(String x, String y) {
//
//        // long finish = Long.parseLong(y);
//        long counter = 0;
//        String sample = new String();
//        String sampleWithMask = new String();
//        // нахожу ближайшее число-перевертыш
//        sample = findStart(x);
//        sampleWithMask=sample;
//        for (int i = 0; i < x.length()-sample.length() ; i++) {
//            sampleWithMask= "0"+sampleWithMask;
//        }
//        while (sampleWithMask.compareTo(x)<0) {
//
//            sample = takeNext(sample);
//            sampleWithMask=sample;
//            for (int i = 0; i < x.length()-sample.length() ; i++) {
//                sampleWithMask= "0"+sampleWithMask;
//            }
//        }
//        System.out.println(sample);
//        counter++;
//
//
//        for (int i = 0; i < y.length()-sample.length() ; i++) {
//            sampleWithMask= "0"+sampleWithMask;
//        }
//        while (sampleWithMask.compareTo(y)<0) {
//            sample = takeNext(sample);
//            sampleWithMask=sample;
//            for (int i = 0; i < y.length()-sample.length() ; i++) {
//                sampleWithMask= "0"+sampleWithMask;
//            }
//            // System.out.println(sample);
//            counter++;
//        }
//        counter--;
//        System.out.println(sample);
//        return counter;
//    }
//
//    public static String findStart(String str) {
//        char digit;
//        int lengthStr = str.length();
//        char[] resultAsCharArray = new char[lengthStr];
//        for (int i = 0; i < lengthStr / 2; i++) {
//            digit = str.charAt(i);
//            if (digit == '0' || digit == '1' || digit == '8') {
//                resultAsCharArray[i] = digit;
//                resultAsCharArray[lengthStr - 1 - i] = digit;
//            } else if (digit == '2' || digit == '3' || digit == '4' || digit == '5' || digit == '6') {
//                resultAsCharArray[i] = '6';
//                resultAsCharArray[lengthStr - 1 - i] = '9';
//            } else if (digit == '9') {
//                resultAsCharArray[i] = digit;
//                resultAsCharArray[lengthStr - 1 - i] = '6';
//            } else if (digit == '7') {
//                resultAsCharArray[i] = '8';
//                resultAsCharArray[lengthStr - 1 - i] = '8';
//            }
//        }
//        if (lengthStr % 2 == 1) {
//            digit = str.charAt(lengthStr / 2);
//            if (digit == '0' || digit == '1' || digit == '8') {
//                resultAsCharArray[lengthStr / 2] = digit;
//            } else if (digit == '2' || digit == '3' || digit == '4' || digit == '5' || digit == '6' || digit == '7' || digit == '9') {
//                // ничего не остается как поставить 0 или УВЕЛИЧИТЬ РАЗРЯД если число меньше искомого
//                resultAsCharArray[lengthStr / 2] = '0';
//            }
//        }
//        String hhh = new String(resultAsCharArray);
//        for (int i = 0; i < str.length()-hhh.length() ; i++) {
//            hhh= "0"+hhh;
//        }
//        if (hhh.compareTo(str)<0) {
//
//            resultAsCharArray = takeNext(new String(resultAsCharArray)).toCharArray();
//        }
//        return new String(resultAsCharArray);
//    }
//
//    public static String takeNext(String str) {
//        char digit;
//        int lengthStr = str.length();
//        char[] resultAsCharArray = str.toCharArray();
//        if (lengthStr % 2 == 1) {
//            digit = str.charAt(lengthStr / 2);
//            if (digit == '0') {
//                resultAsCharArray[lengthStr / 2] = '1';
//            } else if (digit == '1') {
//                //                resultAsCharArray[lengthStr / 2] = '8';
//                //            } else {
//                //                // надо увеличивать разряд слева, а центр обнулять
//                //                // если число одноразрядное, то возвращаем 11
//                resultAsCharArray[lengthStr / 2] = '8';
//                // иначе увеличиваем разряд слева
////                } else {
////                    int position = lengthStr / 2 - 1;
////                    resultAsCharArray[lengthStr / 2] = '0';
////                    char ddd []= new char[]{};
////                    ddd = increaseDigit(position, resultAsCharArray);
////                    return new String(ddd);
////                }
//            } else if (digit == '8') {
//                int position = lengthStr / 2 - 1;
//                resultAsCharArray[lengthStr / 2] = '0';
//                char ddd []= new char[]{};
//                ddd = increaseDigit(position, resultAsCharArray);
//                return new String(ddd);
//            }
//        } else {
//            for (int i = lengthStr / 2-1; i < lengthStr / 2; i++) {
//                digit = str.charAt(i);
//                if (digit == '0') {
//                    resultAsCharArray[i] = '1';
//                    resultAsCharArray[lengthStr - 1 - i] = '1';
//                } else if (digit == '1') {
//                    resultAsCharArray[i] = '6';
//                    resultAsCharArray[lengthStr - 1 - i] = '9';
//                } else if (digit == '2' || digit == '3' || digit == '4' || digit == '5' || digit == '6' || digit == '7') {
//                    resultAsCharArray[i] = '8';
//                    resultAsCharArray[lengthStr - 1 - i] = '8';
//                } else if (digit == '8') {
//                    resultAsCharArray[i] = '9';
//                    resultAsCharArray[lengthStr - 1 - i] = '6';
//                } else if (digit == '9') {
//                    resultAsCharArray[i] = '0';
//                    resultAsCharArray[lengthStr - 1 - i] = '0';
//                    if (lengthStr - 1 - i - 1 == 0) {
//                        char ddd []= new char[]{};
//                        ddd = increaseDigit(-1, resultAsCharArray);
//                        return new String(ddd);
//                    } else {
//                        char ddd []= new char[]{};
//                        ddd = increaseDigit(i - 1, resultAsCharArray);
//                        return new String(ddd);
//                    }
//                }
//            }
//        }
//
//        return new String(resultAsCharArray);
//    }
//
//    private static char[] increaseDigit(int position, char[] resultAsCharArray) {
//        String result = new String();
//        int lengthArray = resultAsCharArray.length;
//        if (position == -1) {
//            resultAsCharArray[lengthArray - 1] = '1';
//            result += "1" + new String (resultAsCharArray);
//            return result.toCharArray();
//        }
//        char digit;
//        digit = resultAsCharArray[position];
//
//        if (digit == '0') {
//            resultAsCharArray[position] = '1';
//            resultAsCharArray[lengthArray - 1 - position] = '1';
//        } else if (digit == '1') {
//            resultAsCharArray[position] = '6';
//            resultAsCharArray[lengthArray - 1 - position] = '9';
//        } else if (digit == '6') {
//            resultAsCharArray[position] = '8';
//            resultAsCharArray[lengthArray - 1 - position] = '8';
//        } else if (digit == '8') {
//            resultAsCharArray[position] = '9';
//            resultAsCharArray[lengthArray - 1 - position] = '6';
//        } else if (digit == '9') {
//            resultAsCharArray[position] = '0';
//            resultAsCharArray[lengthArray - 1 - position] = '0';
//            position--;
//            resultAsCharArray = increaseDigit(position, resultAsCharArray);
//        }
//        return resultAsCharArray;
//    }
//
//    public static void main(String[] args) {
//        String example01 = "187310929748";
//        String example02 = "4337317188278519608";
//        String example11 = "0";
//        String example12 = "10";
//        String example21 = "6";
//        String example22 = "25";
//        String example31 = "10";
//        String example32 = "100";
//        String example41 = "100";
//        String example42 = "1000";
//        String example51 = "100000";
//        String example52 = "12345678900000000";
//        String example61 = "10000000000";
//        String example62 = "10000000000000000000000";
//        String example71 = "861813545615";
//        String example72 = "9813815838784151548487";
//        String example81 = "5748392065435706";
//        String example82 = "643572652056324089572278742";
//        String example91 = "1";
//        String example92 = "45898942362076547326957326537845432452352";
//        String example101 = "7164006";
//        String example102 = "2329491238";
//        String example111 = "66478560783";
//        String example112 = "174991074343062206";
//
////        System.out.println(upsidedown(example01, example02)); // 4282125l
////        System.out.println(upsidedown(example11, example12) + " total"); // 3L    +++++++++
////        System.out.println(upsidedown(example21, example22) + " total"); // 2L    +++++++++++
////        System.out.println(upsidedown(example31, example32) + " total"); // 4L    ++++++++++
////        System.out.println(upsidedown(example41, example42) + " total"); // 12L   ++++++++++
////        System.out.println(upsidedown(example51, example52)); // 718650L    ++++++++++
////        System.out.println(upsidedown(example61, example62)); // 78120000L  +++++++++++++++++++
////        System.out.println(upsidedown(example71, example72)); // 74745418L   ++++++++++++++++++
////        System.out.println(upsidedown(example81, example82)); // 2978125000L
////        System.out.println(upsidedown(example91, example92)); // 209808349609373L
////        System.out.println(upsidedown(example101, example102)); // 2775L             2754    --------
////        System.out.println(upsidedown(example111, example112)); // 1789100L      1789046   ---------
//
////        assertEquals(74745418l, Juniorlab.upsidedown(example71, example72));
////        assertEquals(2978125000l, Juniorlab.upsidedown(example81, example82));
////        assertEquals(209808349609373l, Juniorlab.upsidedown(example91, example92));
////        assertEquals(2775l, Juniorlab.upsidedown(example101, example102));
////        assertEquals(1789100l, Juniorlab.upsidedown(example111, example112));
//    }
//}
