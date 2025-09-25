package Utils.POJO;

public class AbilityEntryPOJO {
    private AbilityPOJO ability;
    private boolean is_hidden;
    private int slot;

    // Getters and Setters
    public AbilityPOJO getAbility() { return ability; }
    public void setAbility(AbilityPOJO ability) { this.ability = ability; }

    public boolean isIs_hidden() { return is_hidden; }
    public void setIs_hidden(boolean is_hidden) { this.is_hidden = is_hidden; }

    public int getSlot() { return slot; }
    public void setSlot(int slot) { this.slot = slot; }
}
