import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Task {
    private String name; //название задачи
    private String description; //описане задачи
    private static int counter; //счетчик

    private boolean personalTack; //если личная-то tru иначе лож
    private LocalDate timeCreateTask; //время и дата постановки задачи
    private Repeatability repeatability; //енам по повторяемости
    private ArrayList<LocalDate> repeatabilityForDays;

    public void setTimeCreateTask(LocalDate timeCreateTask) {
        this.timeCreateTask = timeCreateTask;
    }

    public Task(String name, String description, boolean personalTack, Repeatability repeatability) {
        counter = counter + 1;
        setName(name);
        setDescription(description);
        setPersonalTack(personalTack);
        setLocalDateTime();
        setRepeatability(repeatability);
    }

    public LocalDate getTimeCreateTask() {
        return timeCreateTask;
    }

    public int getCounter() {
        return counter;
    }

    public Repeatability getRepeatability() {
        return repeatability;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNullElse(name, "Задача " + counter);
    }

    public void setDescription(String description) {
        this.description = Objects.requireNonNullElse(description, "o_o");
    }

    public void setPersonalTack(boolean personalTack) {
        this.personalTack = personalTack;
    }

    public void setLocalDateTime() {
        this.timeCreateTask = LocalDate.now();
    }

    public void setRepeatability(Repeatability repeatability) {
        this.repeatability = repeatability;
    }

    private String getInfoPersonalTack() {
        String x;
        if (personalTack) {
            x = " личная задача ";
        } else {
            x = " рабочая задача ";
        }
        return x;
    }

    @Override
    public String toString() {
        return "Название задачи " + name + ", описание " + description +
                ", тип:" + getInfoPersonalTack() + ", время постановки " + timeCreateTask +
                ", повторямость " + repeatability.getInfo() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return personalTack == task.personalTack && Objects.equals(name, task.name) && Objects.equals(description, task.description) && Objects.equals(timeCreateTask, task.timeCreateTask) && repeatability == task.repeatability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, counter, personalTack, timeCreateTask, repeatability);
    }

    public LocalDate getWeek() {
        LocalDate y = timeCreateTask;
        while (LocalDate.now().isAfter(y)) {
            y = y.plusWeeks(1);
        }
        return y;
    }
    public LocalDate getMonth() {
        LocalDate x = timeCreateTask; // дата создания -
        while (LocalDate.now().isAfter(x)) {
            x = x.plusMonths(1);
        }
        return x;
    }
    public LocalDate getYear() {
        LocalDate z = timeCreateTask;
        while (LocalDate.now().isAfter(z)) {
            z = z.plusYears(1);
        }
        return z;
    }
}
