package Model;

public class Card {

    private final int CardID;
    private final String name;
    private final Classification classification;
    private final Location location;
    private final AttackType attackType;
    private final DefenseType defenseType;
    private final int attackDamage; // 1 to 3 or infinite
    private final int defenseLevel; // 1 to 3 or infinite
    private int health; // Current health
    private final HealthType healthType; // Health behavior
    private boolean isDead; // Tracks if the card is dead
    private boolean isCovered; // Indicates if the card is covered by another card

    private boolean placeable;
    private boolean usedTurnForPlacement;
    private Positioning positioning;
    private Card cardOnTop;

    private int lifeCount;
    private LifeType lifeType;
    private int regeneration;
    private int defense;

    private int attack;
    private boolean usedTurnForAttack;
    private int attackRange;
    private AttackArea attackArea;
    private boolean autoAttack;

    private boolean infiltration;
    private boolean attackBounce;

    private boolean invisibility;
    private boolean block;
    private Card armor;
    private int loot;

    public enum Positioning {
        SKY, LAND, UNDERGROUND, NONE
    }

    public enum LifeType {
        HEALTH, TURNS
    }

    public enum AttackArea {
        LINEAR, RADIAL, TOTAL, INDIVIDUAL
    }

    public enum AttackType {
        NONE, ONE_PER_TURN, TWO_PER_TURN, AUTOMATIC
    }

    public enum DefenseType {
        NONE, SELF_DEFENSE, DEFENSE_FOR_OTHERS
    }

    public enum Classification {
        TROOP, SUPPORT, SPECIAL, BONUS, KING
    }

    public enum Location {
        NONE, LAND, AIR
    }

    public enum HealthType {
        LIVES, TURNS, ATTACKS
    }

    // Constructor
    private Card(CardBuilder builder) {
        this.CardID = builder.cardID;
        this.name = builder.name;
        this.classification = builder.classification;
        this.location = builder.location;
        this.attackType = builder.attackType;
        this.defenseType = builder.defenseType;
        this.attackDamage = builder.attackDamage;
        this.defenseLevel = builder.defenseLevel;
        this.health = builder.health;
        this.healthType = builder.healthType;
        this.isDead = this.health <= 0;
        this.isCovered = false;

        this.placeable = builder.placeable;
        this.usedTurnForPlacement = builder.usedTurnForPlacement;
        this.positioning = builder.positioning;
        this.cardOnTop = builder.cardOnTop;

        this.lifeCount = builder.lifeCount;
        this.lifeType = builder.lifeType;
        this.regeneration = builder.regeneration;
        this.defense = builder.defense;

        this.attack = builder.attack;
        this.usedTurnForAttack = builder.usedTurnForAttack;
        this.attackRange = builder.attackRange;
        this.attackArea = builder.attackArea;
        this.autoAttack = builder.autoAttack;

        this.infiltration = builder.infiltration;
        this.attackBounce = builder.attackBounce;

        this.invisibility = builder.invisibility;
        this.block = builder.block;
        this.armor = builder.armor;
        this.loot = builder.loot;
    }

    public int getCardID() {
        return CardID;
    }

    public String getName() {
        return name;
    }

    public Classification getClassification() {
        return classification;
    }

    public Location getLocation() {
        return location;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public DefenseType getDefenseType() {
        return defenseType;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getDefenseLevel() {
        return defenseLevel;
    }

    public int getHealth() {
        return health;
    }

    public boolean isDead() {
        return isDead;
    }

    public boolean isCovered() {
        return isCovered;
    }

    public void setCovered(boolean covered) {
        isCovered = covered;
    }

    // Methods for card actions
    public void takeDamage(int damage) {
        if (isDead) {
            return;
        }

        int effectiveDamage = Math.max(0, damage - this.defenseLevel);
        this.health -= effectiveDamage;

        if (this.health <= 0) {
            this.isDead = true;
            System.out.println(this.name + " has been defeated!");
        }
    }

    @Override
    public String toString() {
        return name + " (" + health + " HP)";
    }

    // Builder for Card
    public static class CardBuilder {

        private int cardID = 0;
        private String name;
        private Classification classification;
        private Location location = Location.NONE;
        private AttackType attackType = AttackType.NONE;
        private DefenseType defenseType = DefenseType.NONE;
        private int attackDamage = 0;
        private int defenseLevel = 0;
        private int health = 1;
        private HealthType healthType = HealthType.LIVES;

        private boolean placeable = true;
        private boolean usedTurnForPlacement = false;
        private Positioning positioning = Positioning.NONE;
        private Card cardOnTop = null;

        private int lifeCount = 1;
        private LifeType lifeType = LifeType.HEALTH;
        private int regeneration = 0;
        private int defense = 0;

        private int attack = 0;
        private boolean usedTurnForAttack = false;
        private int attackRange = 1;
        private AttackArea attackArea = AttackArea.INDIVIDUAL;
        private boolean autoAttack = false;

        private boolean infiltration = false;
        private boolean attackBounce = false;

        private boolean invisibility = false;
        private boolean block = false;
        private Card armor = null;
        private int loot = 0;

        public CardBuilder setCardID(int cardID) {
            this.cardID = cardID;
            return this;
        }

        public CardBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CardBuilder setClassification(Classification classification) {
            this.classification = classification;
            return this;
        }

        public CardBuilder setLocation(Location location) {
            this.location = location;
            return this;
        }

        public CardBuilder setAttackType(AttackType attackType) {
            this.attackType = attackType;
            return this;
        }

        public CardBuilder setDefenseType(DefenseType defenseType) {
            this.defenseType = defenseType;
            return this;
        }

        public CardBuilder setAttackDamage(int attackDamage) {
            this.attackDamage = attackDamage;
            return this;
        }

        public CardBuilder setDefenseLevel(int defenseLevel) {
            this.defenseLevel = defenseLevel;
            return this;
        }

        public CardBuilder setHealth(int health) {
            this.health = health;
            return this;
        }

        public CardBuilder setHealthType(HealthType healthType) {
            this.healthType = healthType;
            return this;
        }

        public CardBuilder setPlaceable(boolean placeable) {
            this.placeable = placeable;
            return this;
        }

        public CardBuilder setUsedTurnForPlacement(boolean usedTurnForPlacement) {
            this.usedTurnForPlacement = usedTurnForPlacement;
            return this;
        }

        public CardBuilder setPositioning(Positioning positioning) {
            this.positioning = positioning;
            return this;
        }

        public CardBuilder setCardOnTop(Card cardOnTop) {
            this.cardOnTop = cardOnTop;
            return this;
        }

        public CardBuilder setLifeCount(int lifeCount) {
            this.lifeCount = lifeCount;
            return this;
        }

        public CardBuilder setLifeType(LifeType lifeType) {
            this.lifeType = lifeType;
            return this;
        }

        public CardBuilder setRegeneration(int regeneration) {
            this.regeneration = regeneration;
            return this;
        }

        public CardBuilder setDefense(int defense) {
            this.defense = defense;
            return this;
        }

        public CardBuilder setAttack(int attack) {
            this.attack = attack;
            return this;
        }

        public CardBuilder setUsedTurnForAttack(boolean usedTurnForAttack) {
            this.usedTurnForAttack = usedTurnForAttack;
            return this;
        }

        public CardBuilder setAttackRange(int attackRange) {
            this.attackRange = attackRange;
            return this;
        }

        public CardBuilder setAttackArea(AttackArea attackArea) {
            this.attackArea = attackArea;
            return this;
        }

        public CardBuilder setAutoAttack(boolean autoAttack) {
            this.autoAttack = autoAttack;
            return this;
        }

        public CardBuilder setInfiltration(boolean infiltration) {
            this.infiltration = infiltration;
            return this;
        }

        public CardBuilder setAttackBounce(boolean attackBounce) {
            this.attackBounce = attackBounce;
            return this;
        }

        public CardBuilder setInvisibility(boolean invisibility) {
            this.invisibility = invisibility;
            return this;
        }

        public CardBuilder setBlock(boolean block) {
            this.block = block;
            return this;
        }

        public CardBuilder setArmor(Card armor) {
            this.armor = armor;
            return this;
        }

        public CardBuilder setLoot(int loot) {
            this.loot = loot;
            return this;
        }

        public Card build() {
            return new Card(this);
        }

        // Template Cards
        public static Card createKingCard(String name) {
            return new Card.CardBuilder()
                    .setCardID(1)
                    .setName(name)
                    .setClassification(Card.Classification.KING)
                    .setLocation(Card.Location.LAND) // Kings start on land
                    .setAttackType(Card.AttackType.NONE) // Kings don't attack
                    .setDefenseType(Card.DefenseType.NONE) // Must be defended
                    .setAttackDamage(0)
                    .setDefenseLevel(5) // Strong defense, must be protected
                    .setHealth(3) // Start with 3 lives
                    .setHealthType(Card.HealthType.LIVES)
                    .setInfiltration(false) // Kings cannot infiltrate
                    .setBlock(true) // Kings can block attacks
                    .setArmor(null) // No special armor initially
                    .build();
        }

        public static Card createTroopCard() {
            return new Card.CardBuilder()
                    .setCardID(2)
                    .setName("Troop Card")
                    .setClassification(Card.Classification.TROOP)
                    .setLocation(Card.Location.LAND)
                    .setAttackType(Card.AttackType.ONE_PER_TURN)
                    .setDefenseType(Card.DefenseType.SELF_DEFENSE)
                    .setAttackDamage(3)
                    .setDefenseLevel(2)
                    .setHealth(5)
                    .setHealthType(Card.HealthType.LIVES)
                    .setAutoAttack(true) // Troops can auto-attack
                    .setUsedTurnForAttack(false) // Doesn't use a turn to attack
                    .setAttackRange(2) // Moderate range
                    .build();
        }

        public static Card createTroopCard(int attack, int defense, int health, Card.Location location) {
            return new Card.CardBuilder()
                    .setCardID(3)
                    .setName("Custom Troop Card")
                    .setClassification(Card.Classification.TROOP)
                    .setLocation(location)
                    .setAttackType(Card.AttackType.ONE_PER_TURN)
                    .setDefenseType(Card.DefenseType.SELF_DEFENSE)
                    .setAttackDamage(attack)
                    .setDefenseLevel(defense)
                    .setHealth(health)
                    .setHealthType(Card.HealthType.LIVES)
                    .setAutoAttack(true) // Troops can auto-attack
                    .setAttackRange(2) // Moderate range
                    .build();
        }

        public static Card createSupportCard(String name, int healingPower) {
            return new Card.CardBuilder()
                    .setCardID(4)
                    .setName(name)
                    .setClassification(Card.Classification.SUPPORT)
                    .setLocation(Card.Location.LAND) // Support cards are typically on land
                    .setAttackType(Card.AttackType.NONE) // Support cards don't attack
                    .setDefenseType(Card.DefenseType.DEFENSE_FOR_OTHERS)
                    .setAttackDamage(0)
                    .setDefenseLevel(2) // Modest defense for survivability
                    .setHealth(4) // Decent health for support
                    .setHealthType(Card.HealthType.LIVES)
                    .setRegeneration(healingPower) // Healing power for allies
                    .setInfiltration(false) // Support cards don't infiltrate
                    .setBlock(false) // Support cards don't block
                    .build();
        }

        public static Card createBonusCard(String name) {
            return new Card.CardBuilder()
                    .setCardID(5)
                    .setName(name)
                    .setClassification(Card.Classification.BONUS)
                    .setLocation(Card.Location.NONE) // Not bound to a specific location
                    .setAttackType(Card.AttackType.NONE) // Bonus cards don't attack
                    .setDefenseType(Card.DefenseType.NONE) // No defense
                    .setAttackDamage(0)
                    .setDefenseLevel(0)
                    .setHealth(1) // Can only "consume" a turn
                    .setHealthType(Card.HealthType.TURNS)
                    .setLoot(3) // Provides loot when used
                    .setInvisibility(false) // Bonus cards are visible
                    .build();
        }

        public static Card createSpecialCard(String name) {
            return new Card.CardBuilder()
                    .setCardID(6)
                    .setName(name)
                    .setClassification(Card.Classification.SPECIAL)
                    .setLocation(Card.Location.NONE) // Not placed on the battlefield
                    .setAttackType(Card.AttackType.NONE) // Special cards don't attack directly
                    .setDefenseType(Card.DefenseType.NONE) // No defense
                    .setAttackDamage(0)
                    .setDefenseLevel(0)
                    .setHealth(1) // Consumes a turn to activate
                    .setHealthType(Card.HealthType.TURNS)
                    .setInvisibility(true) // Special cards are often hidden
                    .build();
        }

    }
}
