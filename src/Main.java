import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    protected static DailyPlanner planner = new DailyPlanner();
    private static final ServicePlanner servicePlanner = new ServicePlanner();

    public static void main(String[] args) throws PersonalTackException {

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            ServicePlanner.remove(scanner);
                            break;
                        case 3:
                            System.out.println(planner);
                            System.out.println("Введите желаемую дату в формате : год-месяц-день ");
                            ServicePlanner.getTaskforDate(scanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }
    private static void printMenu() {
        System.out.println("1. Добавить задачу \n2. Удалить задачу \n3. Получить задачу на указанный день \n0. Выход");
    }

    private static void inputTask(Scanner scanner) throws PersonalTackException {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        System.out.print("Введите описание задачи задачи: ");
        String taskDescription = scanner.next();
        System.out.print("Если задача личная ведите - 1 \nесли по работе введите - 2\n");
        int scanerPersonalTack = scanner.nextInt();
        boolean personalTack;

        if (scanerPersonalTack == 1) {
            personalTack = true;
        } else if (scanerPersonalTack == 2) {
            personalTack = false;
        } else {
            throw new PersonalTackException("Вы ввели не то значение, нужно определиться с задачей");
        }
        System.out.print("Если задача единоразовая введите - 1\nесли ежедневная введите - 2\n" +
                "если еженедельная введите - 3 \nесли ежемесячная введите - 4 " +
                "\nесли ежегодная введите - 5\n");
        int repeatability = scanner.nextInt();
        System.out.println("Если хотите, введите желаемую дату задачи в формате год-месяц-день ");
        String dateCreate = scanner.next();
        if (dateCreate.equals("нет")) {
            Task example = new Task(taskName, taskDescription, personalTack, servicePlanner.repeatability(repeatability));
            planner.addDailyPlanner(example.getCounter(), example);
        } else {
            Task example = new Task(taskName, taskDescription, personalTack, servicePlanner.repeatability(repeatability));
            planner.addDailyPlanner(example.getCounter(), example);
            example.setTimeCreateTask(LocalDate.parse(dateCreate));
        }
    }

//    private static Repeatability repeatability(int repeatability) {
//        Repeatability x = null;
//        if (repeatability == 1) {
//            x = Repeatability.single;
//        } else if (repeatability == 2) {
//            x = Repeatability.daily;
//        } else if (repeatability == 3) {
//            x = Repeatability.weekly;
//        } else if (repeatability == 4) {
//            x = Repeatability.monthly;
//        } else if (repeatability == 5) {
//            x = Repeatability.annual;
//        }
//        return x;
//    }

//    private static void remove(Scanner scanner) {
//        System.out.println("Введите номер задачи которую нужно удалить ");
//        int taskid = scanner.nextInt();
//        planner.removeTask(taskid);
//    }

    //    private static void getTaskforDate(Scanner scanner) {
//        LocalDate taskDate = LocalDate.parse(scanner.next());
//        planner.getDate(taskDate);
//    }
}
