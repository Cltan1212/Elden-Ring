package game.utils;

/**
 * Use this enum class to give `buff` or `debuff`.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by: Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 */
public enum Status {
    /**
     * The actor that is hostile to enemy.
     */
    HOSTILE_TO_ENEMY,

    /**
     * The actor that can respawn.
     */
    RESPAWNABLE,

    /**
     * The actor that is resting.
     */
    RESTING,

    /**
     * The character that is restable.
     */
    RESTABLE,

    /**
     * The character that can consume something.
     */
    CONSUMABLE,

    /**
     * The character that is hostile to skeletal type enemy.
     */
    HOSTILE_TO_SKELETAL_TYPE_ENEMY,

    /**
     * The character that is hostile to dog type enemy.
     */
    HOSTILE_TO_DOG_TYPE_ENEMY,

    /**
     * The character that is hostile to water type enemy.
     */
    HOSTILE_TO_WATER_TYPE_ENEMY,

    /**
     * The character that is hostile to flying type enemy.
     */
    HOSTILE_TO_FLYING_TYPE_ENEMY,

    /**
     * The character that is hostile to stormveil castle type enemy.
     */
    HOSTILE_TO_STORMVEIL_CASTLE_ENEMY,

    /**
     * The character that is hostile to invaders.
     */
    HOSTILE_TO_INVADERS,

    /**
     * The character that is hostile to allies.
     */
    HOSTILE_TO_ALLIES,

    /**
     * The character that is friendly.
     */

    FRIENDLY,

    /**
     * The character that has a special death status.
     */
    SPECIAL_DEATH,

    /**
     * The character that can be despawned.
     */
    DESPAWNABLE,

    /**
     * The character that allow player to sell their weapon or item.
     */
    SELL,

    /**
     * The character that allow player to exchange weapon.
     */
    EXCHANGE,

    /**
     * The character that can conversation with enia
     */
    SECRET_ENIA
}
