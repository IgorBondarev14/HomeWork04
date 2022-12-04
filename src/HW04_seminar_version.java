import java.util.ArrayList;
import java.util.Scanner;
public class HW04_seminar_version {

    public static void main(String[] args) {

        ArrayList<String> listFname = new ArrayList<>();
        ArrayList<String> listLname = new ArrayList<>();
        ArrayList<String> listTname = new ArrayList<>();
        ArrayList<Integer> listAge = new ArrayList<>();
        ArrayList<Boolean> listGender = new ArrayList<>();

        boolean flag = true;
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            Scanner scannerAge = new Scanner(System.in);
            Scanner scannerGender = new Scanner(System.in);

            System.out.println("Enter your fio: ");
            String fio = scanner.nextLine();
            System.out.println("Enter your age: ");
            Integer age = scannerAge.nextInt();
            listAge.add(age);

            String[] fio1 = fio.split(" ");
            if (fio1.length == 3) {
                listFname.add(fio1[1]);
                listLname.add(fio1[0]);
                listTname.add(fio1[2]);
            } else if (fio1.length == 2) {
                listLname.add(fio1[0]);
                listFname.add(fio1[1]);
                listTname.add("");
            } else {
                listLname.add(fio1[0]);
                listFname.add("");
                listTname.add("");
            }

            System.out.println("Enter your gender(male or female): ");
            String gender = scannerGender.nextLine();
            while (!gender.equals("male") && !gender.equals("female")) {
                System.out.println("Enter your gender(male or female): ");
                gender = scannerGender.nextLine();
            }
            if (gender.equals("male")) {
                listGender.add(false);
            }
            if (gender.equals("female")) {
                listGender.add(true);
            }

            System.out.println("Do u want enter next one? Y/N");
            Scanner scanner1 = new Scanner(System.in);
            String yn = scanner1.nextLine();
            if (yn.toUpperCase().equals("N")) {
                flag = false;
            }

        }
        ArrayList<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < listAge.size(); i++) {
            indexList.add(i);
        }
        System.out.println("Исходные данные: ");
        indexList.forEach(i ->
                System.out.println(listFname.get(i) + " " + listLname.get(i) + " " + listTname.get(i) + ", "
                + listAge.get(i) + " года/лет, " + listGender.get(i)));


        int cnt = listAge.size() - 1;
        while (cnt > - 1) {
            int max_age = listAge.get(indexList.get(cnt));
            int index = cnt;
            for (int i = 0; i < cnt; i++){
                if (max_age < listAge.get(indexList.get(i))){
                    max_age = listAge.get(indexList.get(i));
                    index = i;
                }
            }
            int tmp = indexList.get(cnt);
            indexList.set(cnt, indexList.get(index));
            indexList.set(index, tmp);
            cnt--;
        }
        ArrayList<String> sortedFname = new ArrayList<>();
        for (int i = 0; i < indexList.size(); i++){
            sortedFname.add(listFname.get(indexList.get(i)));
        }
        ArrayList<String> sortedLname = new ArrayList<>();
        for (int i = 0; i < indexList.size(); i++){
            sortedLname.add(listLname.get(indexList.get(i)));
        }
        ArrayList<String> sortedTname = new ArrayList<>();
        for (int i = 0; i < indexList.size(); i++){
            sortedTname.add(listTname.get(indexList.get(i)));
        }
        ArrayList<Integer> sortedAge = new ArrayList<>();
        for (int i = 0; i < indexList.size(); i++){
            sortedAge.add(listAge.get(indexList.get(i)));
        }
        ArrayList<Boolean> sortedGender = new ArrayList<>();
        for (int i = 0; i < indexList.size(); i++) {
            sortedGender.add(listGender.get(indexList.get(i)));
        }
        System.out.println();
        System.out.println("Данные отсортированные по возрасту: ");
        indexList.forEach(i ->
                System.out.println(listLname.get(i) + " " + listFname.get(i) + " " + listTname.get(i) + ", "
                        + listAge.get(i) + " года/лет, " + listGender.get(i)));

    }

}
