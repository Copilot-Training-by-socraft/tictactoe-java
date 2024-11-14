public class Game {
    private char _lastSymbol = ' ';
    private Board _board = new Board();

    public void play(char symbol, int x, int y) throws Exception {
        //if first move
        if (_lastSymbol == ' ') {
            //if player is X
            if (symbol == 'O') {
                throw new Exception("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (symbol == _lastSymbol) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (_board.tileAt(x, y).symbol != ' ') {
            throw new Exception("Invalid position");
        }

        // update game state
        _lastSymbol = symbol;
        _board.addTileAt(symbol, x, y);
    }

    public char winner() {
        //if the positions in first row are taken
        if (_board.tileAt(0, 0).symbol != ' ' &&
                _board.tileAt(0, 1).symbol != ' ' &&
                _board.tileAt(0, 2).symbol != ' ') {
            //if first row is full with same symbol
            if (_board.tileAt(0, 0).symbol ==
                    _board.tileAt(0, 1).symbol &&
                    _board.tileAt(0, 2).symbol == _board.tileAt(0, 1).symbol) {
                return _board.tileAt(0, 0).symbol;
            }
        }

        //if the positions in first row are taken
        if (_board.tileAt(1, 0).symbol != ' ' &&
                _board.tileAt(1, 1).symbol != ' ' &&
                _board.tileAt(1, 2).symbol != ' ') {
            //if middle row is full with same symbol
            if (_board.tileAt(1, 0).symbol ==
                    _board.tileAt(1, 1).symbol &&
                    _board.tileAt(1, 2).symbol ==
                            _board.tileAt(1, 1).symbol) {
                return _board.tileAt(1, 0).symbol;
            }
        }

        //if the positions in first row are taken
        if (_board.tileAt(2, 0).symbol != ' ' &&
                _board.tileAt(2, 1).symbol != ' ' &&
                _board.tileAt(2, 2).symbol != ' ') {
            //if middle row is full with same symbol
            if (_board.tileAt(2, 0).symbol ==
                    _board.tileAt(2, 1).symbol &&
                    _board.tileAt(2, 2).symbol ==
                            _board.tileAt(2, 1).symbol) {
                return _board.tileAt(2, 0).symbol;
            }
        }

        return ' ';
    }
}

