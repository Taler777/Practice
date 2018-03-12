/*
extract file name

Вы должны извлечь часть имени файла по следующим правилам:

Предположим, что имя начинается с даты, представленной в виде длинного числа
После даты следует знак подчеркивания.
Далее имя файла с расширением.
В самом конце всегда есть дополнительное расширение файла.

Вход / Выход

1231231_FILE_NAME.EXTENSION.OTHEREXTENSION   -   FILE_NAME.EXTENSION
1_This_is_an_otherExample.mpg.OTHEREXTENSION34   -   This_is_an_otherExample.mpg
1231231223123131_myFile.tar.gz2   -   myFile.tar

 */

public class Juniorlab13 {
    public static String fileNameExtractor(String dirtyFileName) {
        //int begin = dirtyFileName.indexOf("_") + 1;
        // System.out.println(begin);
        //int end = dirtyFileName.lastIndexOf(".");
        // System.out.println(end);
        //String result = dirtyFileName.substring(begin, end);
        //return result;

        //коротко
        return dirtyFileName.substring((dirtyFileName.indexOf("_") + 1), dirtyFileName.lastIndexOf("."));
    }

    public static void main(String[] args) {
        String example01 = "1_ohto28texko6r.g52.gz2";
        String example11 = "1231231223123131_FILE_NAME.EXTENSION.OTHEREXTENSION";
        String example21 = "1_This_is_an_otherExample.mpg.OTHEREXTENSIONadasdassdassds34";
        String example31 = "11254_w1gqt2x7m6v6xbt9.fgz.gz2";
        String example41 = "544_psa2nslkprchxgvi.m24.gsd";
        String example51 = "123_o56hs7s0sikvs4i.ydg.md4";
        String example61 = "321_qdrsul7xonzsemi.jgr.md3";
        String example71 = "2_v53ir3ddmmer8uxr.spp.gz7";

        System.out.println(fileNameExtractor(example01));
        System.out.println(fileNameExtractor(example11));
        System.out.println(fileNameExtractor(example21));
        System.out.println(fileNameExtractor(example31));
        System.out.println(fileNameExtractor(example41));
        System.out.println(fileNameExtractor(example51));
        System.out.println(fileNameExtractor(example61));
        System.out.println(fileNameExtractor(example71));
    }
}
