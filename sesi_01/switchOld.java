
public class switchOld {
    public static void main(String[] args) {
        String result;
        String day = "T";
        switch (day) {
            case "M":
            case "W":
            case "F": {
                result = "NWF";
                System.out.println(result);
                break;
            }
            case "T":
            case "TF":
            case "S": {
                result = "TTS";
                System.out.println(result);
                break;
            }
        }
    }

}
