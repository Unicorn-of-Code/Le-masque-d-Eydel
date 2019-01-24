package input;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;

public final class Input {
    static float down = 0;
    static float up = 0;
    static float left = 0;
    static float right = 0;
    static boolean switchLeft = false;
    static boolean switchRight = false;
    static boolean a1 = false;
    static boolean a2 = false;
    static boolean a3 = false;
    static boolean a4 = false;
    static boolean dodge = false;
    static float mouseX = 0;
    static float mouseY = 0;


    public static float getDown() {
        return down;
    }

    public static float getUp() {
        return up;
    }

    public static float getLeft() {
        return left;
    }

    public static float getRight() {
        return right;
    }

    public static boolean isSwitchLeft() {
        return switchLeft;
    }

    public static boolean isSwitchRight() {
        return switchRight;
    }

    public static boolean isA1() {
        return a1;
    }

    public static boolean isA2() {
        return a2;
    }

    public static boolean isA3() {
        return a3;
    }

    public static boolean isA4() {
        return a4;
    }

    public static boolean isDodge() {
        return dodge;
    }

    public static float getMouseX() {
        return mouseX;
    }

    public static float getMouseY() {
        return mouseY;
    }

    public static void update(GameContainer gc) {
        reset();
        org.newdawn.slick.Input in = gc.getInput();
        up = in.isKeyDown(org.newdawn.slick.Input.KEY_Z)? 1 : 0;
        left = in.isKeyDown(org.newdawn.slick.Input.KEY_Q)? 1 : 0;
        down = in.isKeyDown(org.newdawn.slick.Input.KEY_S)? 1 : 0;
        right = in.isKeyDown(org.newdawn.slick.Input.KEY_D)? 1 : 0;
        switchLeft = in.isKeyDown(org.newdawn.slick.Input.KEY_LSHIFT);
        switchRight = in.isKeyDown(org.newdawn.slick.Input.KEY_F);
        a1 = in.isMouseButtonDown(org.newdawn.slick.Input.MOUSE_LEFT_BUTTON);
        a2 = in.isMouseButtonDown(org.newdawn.slick.Input.MOUSE_RIGHT_BUTTON);
        a3 = in.isKeyDown(org.newdawn.slick.Input.KEY_A);
        a4 = in.isKeyDown(org.newdawn.slick.Input.KEY_E);
        dodge = in.isKeyDown(org.newdawn.slick.Input.KEY_SPACE);
        mouseX = in.getMouseX();
        mouseY = in.getMouseY();
    }

    private static void reset(){
        float down = 0;
        float up = 0;
        float left = 0;
        float right = 0;
        boolean switchLeft = false;
        boolean switchRight = false;
        boolean a1 = false;
        boolean a2 = false;
        boolean a3 = false;
        boolean a4 = false;
        boolean dodge = false;
    }
}
