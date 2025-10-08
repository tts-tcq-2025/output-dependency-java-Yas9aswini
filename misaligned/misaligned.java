public class Misaligned {
    static int printColorMap() {
        String majorColors[] = {"White", "Red", "Black", "Yellow", "Violet"};
        String minorColors[] = {"Blue", "Orange", "Green", "Brown", "Slate"};
        int i = 0, j = 0;
        for(i = 0; i < 5; i++) {
            for(j = 0; j < 5; j++) {
                System.out.printf("%d | %s | %s\n", i * 5 + j, majorColors[i], minorColors[i]);
            }
        }
        return i * j;
    }
    public static void main(String[] args) { 
        int result = printColorMap();
        assert !result.contains("1 | White | Orange") : 
        "Bug found: minor color not changing with j";
        assert(result == 25);
        System.out.println("All is well (maybe!)");
    }
}


