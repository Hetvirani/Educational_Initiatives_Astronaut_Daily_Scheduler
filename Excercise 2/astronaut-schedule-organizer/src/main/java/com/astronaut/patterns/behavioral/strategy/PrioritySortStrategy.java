package com.astronaut.patterns.behavioral.strategy;

import com.astronaut.models.Task;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PrioritySortStrategy implements SortStrategy {
  @Override
  public List<Task> sort(List<Task> tasks) {
    List<Task> sortedTasks = new ArrayList<>(tasks);
    sortedTasks
        .sort(
            Comparator.comparing((Task t) -> t.getPriority().getLevel())
                .reversed()
                .thenComparing(Task::getStartTime));
    return sortedTasks;
  }

  @Override
  public String getStrategyName() {
    return "Priority (High to Low)";
  }
}
