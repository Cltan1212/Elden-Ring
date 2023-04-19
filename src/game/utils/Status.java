package game.utils;

/**
 * Use this enum class to give `buff` or `debuff`.
 * Created by:
 * @author Riordan D. Alfredo
 */
public enum Status {
    HOSTILE_TO_ENEMY,
    RESPAWNABLE,
    RESTING,

    // trading status
    BUYING,
    SELLING,

    // enemy status
    HOSTILE_TO_SKELETAL_TYPE_ENEMY,
    HOSTILE_TO_DOG_TYPE_ENEMY,
    HOSTILE_TO_WATER_TYPE_ENEMY
}
