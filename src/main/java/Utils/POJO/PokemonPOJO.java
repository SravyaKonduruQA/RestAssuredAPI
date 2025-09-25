package Utils.POJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)//If the JSON contains fields that don’t exist in this POJO, just ignore them instead of throwing an exception
public class PokemonPOJO{
    private String name;
    private int height;
    private int weight;
    private int base_experience;
    private List<AbilityEntryPOJO> abilities;

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }

    public List<AbilityEntryPOJO> getAbilities() { return abilities; }
    public void setAbilities(List<AbilityEntryPOJO> abilities) { this.abilities = abilities; }


    public int getBase_experience() { return base_experience; }
    public void setBase_experience(int base_experience) { this.base_experience = base_experience; }
}

