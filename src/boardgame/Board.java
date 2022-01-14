package boardgame;

public class Board {
    private final Piece[][] pieces;
    private int rows;
    private int columns;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Piece piece(int row, int column) {
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        return pieces[position.getRow()][position.getColumn()];

    }

    public void placePiece(Piece piece, Position position) {
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;

    }

    public Piece removePiece(Position position) {
        Piece aux = pieces[position.getRow()][position.getColumn()];
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;

    }

    public boolean positionExists(Position position) {
        return position.getRow() >= 0 && position.getColumn() >= 0
                && position.getRow() < rows && position.getColumn() < columns;

    }

    public boolean isThereAPiece(Position position) {
        return piece(position) != null;

    }

}
