package game.utils;

/**
 * Use this enum class to give `buff` or `debuff`.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by: Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 */
public enum Status {
    HOSTILE_TO_ENEMY,
    RESPAWNABLE,
    RESTING,
    RESTABLE,
    CONSUMABLE,
    // enemy status
    HOSTILE_TO_SKELETAL_TYPE_ENEMY,
    HOSTILE_TO_DOG_TYPE_ENEMY,
    HOSTILE_TO_WATER_TYPE_ENEMY,
    SPECIAL_DEATH,

    DESPAWNABLE
}
