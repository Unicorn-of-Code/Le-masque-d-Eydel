package entity;

import java.util.*;

/**
 * Entity's hp gauge
 */
public class Gauge {

    /**
     * Create a gauge with max as max
     * @param max int
     */
    public Gauge(int max) {
        this.max = max;
    }

    /**
     * entity's max hp
     */
    private int max;

    /**
     * entity's current hp
     */
    private int current;

    /**
     * Add add hp to this.current
     * @param amount int
     */
    public void add(int amount) {
        if (this.current + amount <= max) {
            this.current += amount;
        } else {
            this.current = max;
        }
    }

    /**
     * Remove amount to this.current if this.current > amount else set this to 0
     * @param amount int
     * Return true if this.current > 0 else return false
     * @return boolean
     */
    public boolean rem(int amount) {
        if (this.current - amount <= 0) {
            this.current -= amount;
        } else {
            this.set0();
        }
        return this.current > 0;
    }

    /**
     * Set this.maxLife to maxLife
     * @param maxLife int
     */
    public void setMax(int maxLife) {
        this.max = maxLife;
    }

    /**
     * Set this.current to current
     * @param current int
     */
    public void setCurrent(int current) {
        this.current = current;
    }

    /**
     * Set this.current to 0
     */
    public void set0() {
        this.current = 0;
    }

    /**
     * @return true if this.current = 0, else false
     */
    public boolean isEmpty(){
        return this.current == 0;
    }

}