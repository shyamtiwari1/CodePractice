package service;

import models.Problem;

import java.util.Comparator;
import java.util.List;

public class SortByDifficulty implements  ProblemSortStrategy{
    @Override
    public void sort(List<Problem> problemList) {
        problemList.sort((p1,p2) -> p1.getDifficulty().compareTo(p2.getDifficulty()));;
    }
}
