import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class DailyPlanner {
    private Map<Integer, Task> planer = new HashMap<>();

    public DailyPlanner() {
    }

    public void addDailyPlanner(Integer integer, Task task) {
        if (integer < 0 || task == null) {
            throw new RuntimeException("проверьте правильность добавления задачи");
        } else if (planer.containsKey(integer)) {
            throw new RuntimeException("проверьте ключ к задаче " + integer + " задача с данным номером уже присутствует в ежедневнике");
        } else {
            planer.put(integer, task);
        }
    }

    public void getDate(LocalDate localDate) {
        var x = planer.values();
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

        public void removeTask ( int count){
            planer.remove(count);
        }

        @Override
        public String toString () {
            return "planer = " + planer.values();
        }
    }
