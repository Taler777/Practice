public class Dubstep {
    public static String songDecoder(String song) {
        String s[] = song.split("WUB");
        String result = new String();
        for (int i = 0; i < s.length; i++) {
            if (!s[i].equals(""))
            result += s[i]+" ";
        }
        return result.trim();
    }

    public static void main(String[] args) {
        System.out.println(songDecoder("WUBWUBABCWUB")); // "ABC"
        System.out.println(songDecoder("RWUBWUBWUBLWUB")); // "R L"
    }
}