package com.astronaut.patterns.behavioral.strategy;

import com.astronaut.models.Task;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StartTimeSortStrategy implements SortStrategy {
  @Override
  public List<Task> sort(List<Task> tasks) {
    List<Task> sortedTasks = new ArrayList<>(tasks);
    sortedTasks.sort(Comparator.comparing(Task::getStartTime));
    return sortedTasks;
  }

  @Override
  public String getStrategyName() {
    return "Start Time";
  }
}
