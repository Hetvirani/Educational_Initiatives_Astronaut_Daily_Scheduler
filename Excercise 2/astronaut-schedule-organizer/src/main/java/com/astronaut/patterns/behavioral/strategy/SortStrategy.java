package com.astronaut.patterns.behavioral.strategy;

import com.astronaut.models.Task;
import java.util.List;

public interface SortStrategy {
  List<Task> sort(List<Task> tasks);
  String getStrategyName();
}
