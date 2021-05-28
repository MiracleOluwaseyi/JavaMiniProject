package cardGame;

public enum Suit {
    CIRCLES,
    TRIANGLES,
    CROSSES,
    SQUARES,
    STARS,
    WHOTS;

    @Override
    public String toString(){
        return switch (this){
            case CIRCLES -> "Circles";
            case SQUARES -> "Squares";
            case CROSSES -> "Crosses";
            case TRIANGLES -> "Triangles";
            case STARS -> "Stars";
            case WHOTS -> "Whots";
        };
    }
}
