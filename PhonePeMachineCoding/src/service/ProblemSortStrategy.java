package service;

import models.Problem;

import java.util.List;

public interface ProblemSortStrategy {

    void sort(List<Problem> problemList);
}
