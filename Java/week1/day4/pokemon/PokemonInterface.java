import java.util.ArrayList;

public interface PokemonInterface{
	Pokemon createPokemon(String name,String type,int health);
	void attackPokemon(Pokemon pokemon);
	ArrayList<Object> pokemonInfo(Pokemon pokemon);
}