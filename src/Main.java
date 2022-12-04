import javax.crypto.spec.PSource;
import java.util.*;

public class Main {
    static ArrayList<String> fNameList = new ArrayList<>();
    static ArrayList<String> lNameList = new ArrayList<>();
    static ArrayList<String> tNameList = new ArrayList<>();
    static ArrayList<Integer> ageList = new ArrayList<>();
    static ArrayList<Boolean> genderList = new ArrayList<>();
    static ArrayList<Integer> indexList = new ArrayList<>();
    static ArrayList<Integer> sortedIndexList = new ArrayList<>();
    static ArrayList<String> sortedfNameList = new ArrayList<>();
    static ArrayList<String> sortedlNameList = new ArrayList<>();
    static ArrayList<String> sortedtNameList = new ArrayList<>();
    static ArrayList<Integer> sortedageList = new ArrayList<>();
    static ArrayList<Boolean> sortedgenderList = new ArrayList<>();

    public static void main(String[] args) {
        enterData();
        sortedChoice();
    }
    public static void enterData() {
        boolean flag = true;
        while (flag) {
            Scanner scannerFIO = new Scanner(System.in);
            Scanner scannerAge = new Scanner(System.in);
            Scanner scannerGender = new Scanner(System.in);

            System.out.println("Введите Фамилию, имя и отчество (через пробел):");
            String fio = scannerFIO.nextLine();
            String[] fioArray = fio.split(" ");
            if (fioArray.length == 3) {
                fNameList.add(fioArray[0]);
                lNameList.add(fioArray[1]);
                tNameList.add(fioArray[2]);
            }
            if (fioArray.length == 2) {
                fNameList.add(fioArray[0]);
                lNameList.add(fioArray[1]);
                tNameList.add(".");
            }
            if (fioArray.length == 1) {
                fNameList.add(fioArray[0]);
                lNameList.add(".");
                tNameList.add(".");
            }

            System.out.println("Введите возраст:");
            int age = scannerAge.nextInt();
            ageList.add(age);

            System.out.println("Введите пол ('м' или 'ж'):");
            String gender = scannerGender.nextLine();
            while (!gender.equals("м") && !gender.equals("ж")) {
                System.out.println("Введите пол ('м' или 'ж'):");
                gender = scannerGender.nextLine();
            }
            if (gender.equals("м")) {
                genderList.add(false);
            }
            if (gender.equals("ж")) {
                genderList.add(true);
            }

            Scanner scannerQ = new Scanner(System.in);
            System.out.println("Желаете ввести следующую запись? ('да' или 'нет'):");
            String question = scannerQ.nextLine();
            if (question.equals("нет") || question.equals("н") || question.equals("no") || question.equals("n")) {
                flag = false;
            }
        }
        for (int i = 0; i < ageList.size(); i++) {
            indexList.add(i);
        }
        System.out.println("Исходные данные:");
        indexList.forEach(i -> System.out.println(fNameList.get(i) + " " + lNameList.get(i) + " " + tNameList.get(i)
                + ", " + ageList.get(i) + " года/лет, " + genderList.get(i)));
        System.out.println();
    }
    public static void sortedChoice() {
        boolean flag = true;
        while (flag) {
            System.out.println("По какому критерию вы хотите провести сортировку?:\n1. Фамилия\n2. Имя\n" +
                    "3. Отчество\n4. Возраст\n5. Пол\n6. Не сортировать (вывести изначальные данные)");
            Scanner scanner1 = new Scanner(System.in);
            int choice = scanner1.nextInt();
            if (choice == 1) {
                sortedFirstName();
                sorted();
            }
            if (choice == 2) {
                sortedLastName();
                sorted();
            }
            if (choice == 3) {
                sortedPatrName();
                sorted();
            }
            if (choice == 4) {
                sortedAge();
                sorted();
            }
            if (choice == 5) {
                sortedGender();
                sorted();
            }
            if (choice == 6) {
                System.out.println("Исходные данные:");
                sortedIndexList.forEach(i -> System.out.println(fNameList.get(i) + " " + lNameList.get(i) + " " + tNameList.get(i)
                        + ", " + ageList.get(i) + " года/лет, " + genderList.get(i)));
                System.out.println();
            }
            System.out.println("Желаете провести другую сортировку? (да или нет)");
            Scanner scanner2 = new Scanner(System.in);
            String question = scanner2.nextLine();
            if (question.equals("нет")) {
                flag = false;
            }
        }
    }
    public static void sortedFirstName() {
        sortedIndexList.removeAll(sortedIndexList);
        ArrayList<String> sortedfName = new ArrayList<>(fNameList);
        Collections.sort(sortedfName);
        for (int i = 0; i < sortedfName.size(); i++) {
            for (int j = 0; j < fNameList.size(); j++) {
                if (sortedfName.get(i).equals(fNameList.get(j))) {
                    sortedIndexList.add(j);
                    break;
                }
            }
        }
    }
    public static void sortedLastName() {
        sortedIndexList.removeAll(sortedIndexList);
        ArrayList<String> sortedlName = new ArrayList<>(lNameList);
        Collections.sort(sortedlName);
        for (int i = 0; i < sortedlName.size(); i++) {
            for (int j = 0; j < lNameList.size(); j++) {
                if (sortedlName.get(i).equals(lNameList.get(j))) {
                    sortedIndexList.add(j);
                    break;
                }
            }
        }
    }
    public static void sortedPatrName() {
        sortedIndexList.removeAll(sortedIndexList);
        ArrayList<String> sortedtName = new ArrayList<>(tNameList);
        Collections.sort(sortedtName);
        for (int i = 0; i < sortedtName.size(); i++) {
            for (int j = 0; j < tNameList.size(); j++) {
                if (sortedtName.get(i).equals(tNameList.get(j))) {
                    sortedIndexList.add(j);
                    break;
                }
            }
        }
    }
    public static void sortedAge() {
        int cnt = ageList.size() - 1;
        sortedIndexList = indexList;
        while (cnt > - 1) {
            int max_age = ageList.get(sortedIndexList.get(cnt));
            int index = cnt;
            for (int i = 0; i < cnt; i++) {
                if (max_age < ageList.get(sortedIndexList.get(i))) {
                    max_age = ageList.get(sortedIndexList.get(i));
                    index = i;
                }
            }
            int tmp = sortedIndexList.get(cnt);
            sortedIndexList.set(cnt, indexList.get(index));
            sortedIndexList.set(index, tmp);
            cnt--;
        }

    }

    public static void sortedGender() {
        sortedIndexList.removeAll(sortedIndexList);
        for (int i = 0; i < genderList.size(); i++) {
            if (genderList.get(i).equals(true)) {
                sortedIndexList.add(i);
            }
        }
        for (int i = 0; i < genderList.size(); i++) {
            if (genderList.get(i).equals(false)) {
                sortedIndexList.add(i);
            }
        }
    }

    public static void sorted() {

        for (int i = 0; i < sortedIndexList.size(); i++){
            sortedfNameList.add(fNameList.get(sortedIndexList.get(i)));
        }
        for (int i = 0; i < sortedIndexList.size(); i++){
            sortedlNameList.add(lNameList.get(sortedIndexList.get(i)));
        }
        for (int i = 0; i < sortedIndexList.size(); i++){
            sortedtNameList.add(tNameList.get(sortedIndexList.get(i)));
        }
        for (int i = 0; i < sortedIndexList.size(); i++){
            sortedageList.add(ageList.get(sortedIndexList.get(i)));
        }
        for (int i = 0; i < sortedIndexList.size(); i++) {
            sortedgenderList.add(genderList.get(sortedIndexList.get(i)));
        }
        System.out.println("Отсортированные данные:");
        sortedIndexList.forEach(i -> System.out.println(fNameList.get(i) + " " + lNameList.get(i) + " " + tNameList.get(i)
                + ", " + ageList.get(i) + " года/лет, " + genderList.get(i)));
        System.out.println();
    }
}