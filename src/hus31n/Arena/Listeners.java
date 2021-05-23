package hus31n.Arena;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.block.Action;

public class Listeners implements Listener
{
	executorList players;
	
	Listeners(executorList players)
	{
		this.players = players;
	}
	
	@EventHandler
	public void selectPos1(PlayerInteractEvent e)
	{
		if (e.getAction() != Action.LEFT_CLICK_BLOCK) { return; }
		if (! e.getPlayer().isOp()) { return; }
		
		cmdExecutor executor = players.findPlayer(e.getPlayer());
		if (executor == null) { return; }
		
		executor.pos1 = e.getClickedBlock();
	}
	
	@EventHandler
	public void selectPos2(PlayerInteractEvent e)
	{
		if (e.getAction() != Action.RIGHT_CLICK_BLOCK) { return; }
		if (! e.getPlayer().isOp()) { return; }
		
		cmdExecutor executor = players.findPlayer(e.getPlayer());
		if (executor == null) { return; }
		
		executor.pos2 = e.getClickedBlock();
	}
}
