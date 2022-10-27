import java.time.LocalDate;
import java.util.Scanner;

public class ServicePlanner {

    protected static Repeatability repeatability(int repeatability) {
        Repeatability x = null;
        if (repeatability == 1) {
            x = Repeatability.single;
        } else if (repeatability == 2) {
            x = Repeatability.daily;
        } else if (repeatability == 3) {
            x = Repeatability.weekly;
        } else if (repeatability == 4) {
            x = Repeatability.monthly;
        } else if (repeatability == 5) {
            x = Repeatability.annual;
        }
        return x;
    }
    protected static void getTaskforDate(Scanner scanner) {
        LocalDate taskDate = LocalDate.parse(scanner.next());
        getDate(taskDate);
    }
    protected static void getDate(LocalDate localDate) {
        var x = DailyPlanner.planer.values();
        for (Task task : x) {
            if (task.getRepeatability().equals(Repeatability.single) && task.getTimeCreateTask().equals(localDate)) {
                System.out.println("На эту дату есть задачи: " + task);
            } else if (task.getRepeatability().equals(Repeatability.daily)) {
                System.out.println("На эту дату есть задачи: " + task);
            } else if (task.getRepeatability().equals(Repeatability.weekly) && task.getWeek().equals(localDate)) {
                System.out.println("На эту дату есть задачи: " + task);
            } else if (task.getRepeatability().equals(Repeatability.monthly)&& task.getMonth().equals(localDate)) {
                System.out.println("На эту дату есть задачи: " + task);
            }else if (task.getRepeatability().equals(Repeatability.annual)&& task.getYear().equals(localDate)) {
                System.out.println("На эту дату есть задачи: " + task);
            } else {
                System.out.println("Задач на " + localDate + " нет");
            }
        }
    }
    protected static void remove(Scanner scanner) {
        System.out.println("Введите номер задачи которую нужно удалить ");
        int taskid = scanner.nextInt();
        Main.planner.removeTask(taskid);
    }
}
