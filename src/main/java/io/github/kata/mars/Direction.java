package io.github.kata.mars;

public class Direction {

    public static final String N = "N";
    public static final String E = "E";
    public static final String S = "S";
    public static final String W = "W";

    public static boolean isValid(String direction) {
        return direction.equals(N)
            || direction.equals(E)
            || direction.equals(S)
            || direction.equals(W);
    }

}
