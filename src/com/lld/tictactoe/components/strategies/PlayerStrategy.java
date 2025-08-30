package com.lld.tictactoe.components.strategies;

import com.lld.tictactoe.entities.Board;
import com.lld.tictactoe.entities.Position;

public interface PlayerStrategy {

    Position makeMove(Board board);
}
