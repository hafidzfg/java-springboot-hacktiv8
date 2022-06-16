import java.util.Scanner;

public class HitungGrade {
    public static void main(String[] args) {
        int nilai;
        String grade;
        Scanner scan = new Scanner(System.in);

        // get input from user
        System.out.println("Input nilai: ");
        nilai = scan.nextInt();

        scan.close();

        if (nilai >= 90) {
            grade = "A";
        } else if (nilai >= 80) {
            grade = "B+";
        } else if (nilai >= 70) {
            grade = "B";
        } else if (nilai >= 60) {
            grade = "C+";
        } else if (nilai >= 50) {
            grade = "C";
        } else if (nilai >= 40) {
            grade = "D";
        } else {
            grade = "E";
        }

        // cetak gradenya
        System.out.println("Nilai kamu: " + nilai + ", kamu mendapat predikat: " + grade);
    }

}
