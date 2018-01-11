public abstract class AbstractPokemon implements PokemonInterface{
	public Pokemon createPokemon(String name,String type,int health){
		return new Pokemon(name,type,health);
	}
	public void attackPokemon(Pokemon pokemon){
		pokemon.setHealth( pokemon.getHealth() - 10 );
	}
}