public class Tshirts {
    static String size(int cms) {
        if(cms < 38) {
            return "S";
        } else if(cms > 38 && cms < 42) {
            return "M";
        } else {
            return "L";
        }
    }

    public static void main(String[] args) { 
        assert(size(37).equals("S"));
        assert(size(40).equals(("M"));
        assert(size(43).equals("L"));
        assert(size(42).equals("L"));
        assert(size(38).equals("M"));
        System.out.println("All is well (maybe!)");
    }
}

