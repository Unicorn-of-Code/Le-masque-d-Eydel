package entity;

import java.util.*;

/**
 * Gauge for things
 */
public class Gauge {

    /**
     * Default constructor
     * @param amount int amount of the max
     */
    public Gauge(int amount) {
        this.max = amount;
        this.current = amount;
    }

    /**
     * Max to reach
     */
    private int max;

    /**
     * Current amount of the gauge
     */
    private int current;

    /**
     * If true, doesn't remove
     */
    private boolean invicible;

    /**
     * add an amount to current
     * @param add amount to add
     */
    public void add(int add) {
        current += add;
        if (current>max){
            current = max;
        }
    }

    /**
     * Remove from the amount
     * @param rem amount to remove
     * @return true if 0 reached
     */
    public boolean rem(int rem) {
        if (!invicible) {
            current += rem;
            if (current <= 0) {
                current = 0;
                return true;
            }
        }
        return false;
    }

    /**
     * set a new Maximum
     * @param newMax New Max
     */
    public void setMax(int newMax) {
        this.max = newMax;
    }

    /**
     * set current
     * @param number Number to set
     */
    public void setCurrent(int number) {
        this.current = number;
    }

    /**
     * set To 0
     */
    public void set0() {
        current = 0;
    }

    public boolean isEmpty () {
        return current == 0;
    }

    public void setInvicible (boolean state) {
        this.invicible = state;
    }

}