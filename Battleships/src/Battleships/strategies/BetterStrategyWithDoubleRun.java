package Battleships.strategies;

import Battleships.Board;
import Battleships.ComputerPlayerStrategy;
import Battleships.Outcome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BetterStrategyWithDoubleRun implements ComputerPlayerStrategy {

  private boolean firstRunCompleted;  
  private boolean firstRunWasVertical;
  
  private final List<int[]> lastHits = new ArrayList<>();

  @Override
  public int[] chooseTarget(Board opponentBoard, Board ownBoard) {
    System.out.println( "\nChoosing target....");
    if (!this.lastHits.isEmpty()) {
      
      // pass one: favour untried square adjacent to and opposite hits
      // effectively, try to place a hit in line with two existing hits
      
      Adjacent candidate = null;
      if (this.firstRunCompleted) {
        // favour run in same axis and any existing run
        if (this.firstRunWasVertical) {
          candidate = Adjacent.ABOVE;
        } else {
          candidate = Adjacent.LEFT;
        }
        if (Math.random() >= 0.5) {
          candidate = candidate.opposite();
        }
      } else {
        candidate = Adjacent.random();
      }

      
      candidate = Adjacent.random();
      
      int[] runExtension = null;
      runExtension = extendRunOnAxis(opponentBoard, candidate, runExtension);
      if (runExtension == null) {
        candidate = candidate.next();
        runExtension = extendRunOnAxis(opponentBoard, candidate, runExtension);        
      }
      
      if (runExtension != null) {
        System.out.println("PASS1 - EXTENDING RUN: " + Arrays.toString(runExtension));
        return runExtension; 
      } else {
        System.out.println("CANNOT EXTEND RUN");            
      }      
      
      // at this point we know it is impossible to place three in a row
      // this might be because there is only one hit at the moment, or
      // because we have had a miss at each end of an existing run
      // hence
      if (!this.firstRunCompleted && this.lastHits.size() > 2) {
        this.firstRunCompleted = true;
        // we now want to favour runs in the same direction to optimise bombing aircraft carriers
        this.firstRunWasVertical = lastHitsLooksVertical();
        System.out.println( "FIRST RUN COMPLETED: " + (this.firstRunWasVertical ? "VERTICAL" : "HORIZONTAL"));
      }
       
      
      
      // if we have had any hits, then try any untried square adjacent to a hit
      for(int index = 0; index < this.lastHits.size(); index++) {
        final int[] lastHit = this.lastHits.get(index);
        candidate = Adjacent.random();
        int c = 4;
        while(c > 0) {
          int x = lastHit[0] + candidate.dx;
          int y = lastHit[1] + candidate.dy;
          if (inBoundsAndUntried(opponentBoard, x, y) && squareMightBeShip(opponentBoard, x, y)) {
            return new int[] { x, y };
          }
          candidate = candidate.next();
          c--; 
        }
      }    
    } 
    // else choose a random unbombed square and return that
    return chooseSquare(opponentBoard);
  }

  private boolean inBoundsAndUntried(Board board, int x, int y) {
    return board.inBounds(x, y) && !board.getSquare(x, y).getTried();
  }
  
  private int[] extendRunOnAxis(Board opponentBoard, Adjacent candidate, int[] runExtension) {
    for(int index = 0; index < this.lastHits.size(); index++) {
      final int[] lastHit = this.lastHits.get(index);
      System.out.print( Arrays.toString(lastHit));        
      System.out.print( " " + candidate);
      runExtension = tryThreeInARow(opponentBoard, lastHit, candidate);
      if (runExtension != null) { break; }
      candidate = candidate.opposite();
      System.out.print( " " + candidate + " ");
      runExtension = tryThreeInARow(opponentBoard, lastHit, candidate);
      if (runExtension != null) { break; }
    }
    System.out.println();
    return runExtension;
  }
  
  private int[] tryThreeInARow(Board opponentBoard, final int[] lastHit, Adjacent candidate) {
    int x = lastHit[0] + candidate.dx;
    int y = lastHit[1] + candidate.dy;
    final int ox = lastHit[0] + candidate.opposite().dx;
    final int oy = lastHit[1] + candidate.opposite().dy;
    if (inBoundsAndUntried(opponentBoard, x, y) && squareMightBeShip(opponentBoard, x, y)) {
      if (opponentBoard.inBounds(ox, oy) && opponentBoard.getSquare(ox, oy).isHit()) {
        return new int[] { x, y };
      }
    }
    return null;
  }
  
  private boolean lastHitsLooksVertical() {
    int maxY = -1;
    int minY = Integer.MAX_VALUE;
    int maxX = -1;
    int minX = Integer.MAX_VALUE;
    for (int[] is : this.lastHits) {
      if (is[0] > maxX) { maxX = is[0]; }
      if (is[0] < minX) { minX = is[0]; }
      if (is[1] > maxY) { maxY = is[1]; }
      if (is[1] < minY) { minY = is[1]; }
    }
    return maxY - minY >  maxX - minX;
  }
  
  private boolean squareMightBeShip(final Board board, final int x, final int y) {
    if (!board.inBounds(x, y)) {
      return false;
    }
    if (board.getSquare(x, y).isMiss()) {
      return false;
    }
    // examine squares around the target being considered
    for(int i = -1; i <= 1; i++) {
      for(int j = -1; j <= 1; j++) {
        if (i != 0 || j != 0) {
          final int tx = x + i;
          final int ty = y + j;
          if (board.inBounds(tx, ty) && board.getSquare(tx, ty).isHit()) {
            // if the square is a hit in lastHits that is OK as its part of the ship we are part 
            // way through destroying (this method is also used when picking adjacent squares in
            // that process).
            if (!isInLastHits( tx, ty)) {    
              System.out.println( "BOOST!");
              return false;
            }
          }
        }
      }
    }
    return true;
  }
  private boolean isInLastHits(int x, int y) {
    for(int[] hit : this.lastHits) {
      if (hit[0] == x && hit[1] == y) {
        return true;
      }
    }
    return false;
  }
  
  private int[] chooseSquare(final Board board) {
    while(true) {
      final int x = (int)(Math.random() * board.getWidth());
      final int y = (int)(Math.random() * board.getHeight());
      if (!board.getSquare(x, y).getTried()) {
        return new int[] { x, y };
      }
    }
  }
  
  @Override
  public void resultOfMove(Outcome outcome) {
    if (outcome.hit()) {
      this.lastHits.add(new int[] { outcome.getX(), outcome.getY() });
      if (outcome.sunk() != null) {
        this.lastHits.clear();
      }
    }
  }

}