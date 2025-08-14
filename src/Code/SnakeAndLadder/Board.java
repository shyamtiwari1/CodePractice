package Code.SnakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {

    Cell[][] cells;

    public Board(int size , int snakes , int ladders){
        initialiseCell(size);
        addSnakeLadders( cells , snakes, ladders);
    }



    private void initialiseCell(int size) {

        cells = new Cell[size][size];
        for(int i = 0 ; i < cells.length ; i ++){
            for(int j = 0 ; j < cells[0].length ; j ++){
                cells[i][j] = new Cell();
            }
        }
    }


    private void addSnakeLadders(Cell[][] cells, int snakes, int ladders) {

        while(snakes>0){
            int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length*cells[0].length-1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length*cells[0].length-1);

            if(snakeHead<=snakeTail){
                continue;
            }

            Jump snakeObj = new Jump();
            snakeObj.start = snakeHead;
            snakeObj.end = snakeTail;
            Cell cell= getCell(snakeHead);

            cell.jump = snakeObj;
            snakes--;


        }
        while(ladders > 0) {
            int ladderStart = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            if(ladderStart >= ladderEnd) {
                continue;
            }

            Jump ladderObj = new Jump();
            ladderObj.start = ladderStart;
            ladderObj.end = ladderEnd;

            Cell cell = getCell(ladderStart);
            cell.jump = ladderObj;

            ladders--;
        }

    }



    private Cell getCell(int playerPosition) {
        int boardRow = playerPosition/ cells.length;
        int boardColumn = playerPosition % cells.length;
        return  cells[boardRow][boardColumn];
    }
}
