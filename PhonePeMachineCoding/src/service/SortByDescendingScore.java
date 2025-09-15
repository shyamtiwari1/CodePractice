package service;

import models.Problem;

import java.util.List;

public class SortByDescendingScore implements ProblemSortStrategy{
    @Override
    public void sort(List<Problem> problemList) {
        problemList.sort((a,b) -> Integer.compare(b.getScore(),a.getScore()));
    }
}
