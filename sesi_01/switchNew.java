public class switchNew {
    public static void main(String[] args) {
        String day = "S";
        String result = switch (day)
        {
            case "M", "W", "F" -> "MWF";
            case "T", "TH", "S" -> "TTS";
            default ->
            {
                if(day.isEmpty())
                    result = "Please insert a valid day";
                else
                    result = "Looks like a Sunday";
                throw new IllegalStateException("Invalid day: " + result);
            }
        };
        System.out.println(result);
    }
    
}
