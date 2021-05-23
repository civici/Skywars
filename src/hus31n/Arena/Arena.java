package hus31n.Arena;

import java.util.ArrayList;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Arena 
{

}


class executorList
{
	ArrayList<cmdExecutor> players;
	
	executorList()
	{
		this.players = new ArrayList<cmdExecutor>();
	}
	
	cmdExecutor findPlayer(Player p)
	{
		for (cmdExecutor player : players)
		{
			if (player.p == p)
			{
				return player;
			}
		}
		
		return null;
	}
	
}

class cmdExecutor
{
	Player p;
	Block pos1;
	Block pos2;
	
	cmdExecutor(Player p)
	{
		this.p = p;
	}
	
	
}