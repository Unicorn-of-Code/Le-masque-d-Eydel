package entity.attitude;

import entity.Player;
import entity.Enemy;
import org.newdawn.slick.geom.Vector2f;
import time.Time;
import time.Timer;

import java.util.Random;

public class Attitude {
    private Random r = new Random();

    private double angleDirection;

    private boolean isAttackCast = false;
    private boolean isCac;
    private boolean isAttacking = false;
    private boolean isCool = true;
    private boolean isMoving = false;
    private Enemy enemy;

    private float rangeAttack;

    private Timer timerStepCool;
    private Timer timerStepAttack;
    private Timer timerWaitAttack;
    private Timer cooldownAttack;
    private Timer castTimeAttack;

    public double getAngleDirection() {
        return angleDirection;
    }

    public boolean isAttackCast() {
        return isAttackCast;
    }

    public boolean isAttacking() {
        return isAttacking;
    }

    public boolean isCool() {
        return isCool;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public Attitude (Enemy enemy, boolean isCac, long stepCoolInMs, long stepAttackInMs, long cooldownAttack, long castTime, float rangeAttack) {

        this.enemy = enemy;
        this.isCac = isCac;
        timerStepCool = Time.createTimer(stepCoolInMs);
        timerStepAttack = Time.createTimer(stepAttackInMs);
        this.cooldownAttack = Time.createTimer(cooldownAttack);
        this.castTimeAttack = Time.createTimer(castTime);
    }

    public void update (float deltaTime, Player player) {
        isAttackCast = false;
    	System.out.println("isCool : " + isCool);
        if (isCool) {
            // Si decouvre le player
            if (testCool(player)) {
                isCool = false;
                timerStepAttack.reset();
            } else {
                // Si le mob doit bouger
                if (isMoving) {
                    // Si le timer est a la fin : inverse isMoving
                    if (timerStepCool.getPassed()) {
                        isMoving = false;
                        timerStepCool.reset();
                    }
                // Si Wait :
                } else {
                    // Si timer à la fin
                    if (timerStepCool.getPassed()) {
                        isMoving = true;
                        determineAngleMovement(player);
                        timerStepCool.reset();
                    }
                }
            }
        }
        // Si agressif :
        if (!isCool) {
            // Si bouge :
            if (isMoving) {
                if (timerStepAttack.getPassed()) {
                    // Si attaque dispo (cooldown good) : Attaque, immobilisation et attente de cast
                    if (cooldownAttack.getPassed() && testRange(player)) {
                        determineAngleMovement(player);
                        isAttacking = true;
                        castTimeAttack.reset();
                        isCool = testCool(player);
                    } else {
                        timerStepAttack.reset();
                    }
                    isMoving = false;
                }
                // Sinon si attaque
            } else if (isAttacking) {
                // Si cast terminé
                if (castTimeAttack.getPassed()) {
                    isAttackCast = true;
                    isCool = testCool(player);
                    isMoving = true;
                    determineAngleMovement(player);
                }
                // Si wait en mode attack
            } else {
                // Si terminé
                if (timerStepAttack.getPassed()) {
                    isMoving = true;
                    isCool = testCool(player);
                }
            }
        }
    }

    private boolean testCool(Player player) {
        return !(player.getHitbox().getShape().intersects(enemy.getVision()));
    }


        /**
         * If want moving, return angle of movement
         * @param player dirige
         * @return angle of movement
         */
    private void determineAngleMovement(Player player) {
        if (isCool) {
            angleDirection =  r.nextDouble()*360;
        } else {
            Vector2f direction = new Vector2f(
                    player.getHitbox().getShape().getCenterX() - enemy.getHitbox().getShape().getCenterX(),
                    player.getHitbox().getShape().getCenterY() - enemy.getHitbox().getShape().getCenterY());
            double angleEP = direction.getTheta();
            double randomAngle = r.nextDouble()*90 - 45;
            angleDirection =  ((isCac)? angleEP : angleEP+180) + randomAngle;
        }
    }

    private boolean testRange (Player player) {
        Vector2f v = new Vector2f(
                player.getHitbox().getShape().getCenterX() - enemy.getHitbox().getShape().getCenterX(),
                player.getHitbox().getShape().getCenterY() - enemy.getHitbox().getShape().getCenterY()
        );
        return v.length() <= rangeAttack;
    }
}
