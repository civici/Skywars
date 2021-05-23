package hus31n.Arena;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Commands 
{
	JavaPlugin plugin;
	
	Commands(JavaPlugin plugin)
	{
		this.plugin = plugin;
	}
	
}


class selectModeCommand implements CommandExecutor
{
	
	executorList players;
	
	selectModeCommand(executorList players)
	{
		this.players = players;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		Player p = (Player) sender;
		if (! p.isOp() )
		{
			p.sendMessage("yetkin yok amýna koyim");
			return false;
		}
		
		cmdExecutor executor = players.findPlayer(p);
		if (executor != null)
		{
			p.sendMessage("zaten yazmýþsýn yarrak");
			return false;
		}
		
		executor = new cmdExecutor(p);
		players.players.add(executor);
		return true;
	}
}

class CreateArenaCommand implements CommandExecutor
{
	executorList players;
	
	CreateArenaCommand(executorList players)
	{
		this.players = players;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
	{
		Player p = (Player) sender;
		if (! p.isOp() )
		{
			p.sendMessage("yetkin yok amýna koyim");
			return false;
		}
		cmdExecutor executor = players.findPlayer(p);
		if (executor == null)
		{
			p.sendMessage("kanka önce baþka komut kullanacan aq");
			return false;
		}
		
		if (executor.pos1 == null)
		{
			p.sendMessage("1. pozisyon seçili deðil");
			return false;
		}
		
		if (executor.pos2 == null)
		{
			p.sendMessage("2. pozisyon seçili deðil");
			return false;
		}
		
		String message = String.format("arena created as pos1 %d %d %d and pos2 %d %d %d", 
						executor.pos1.getX(), executor.pos1.getY(), executor.pos1.getZ(),
						executor.pos2.getX(), executor.pos2.getY(), executor.pos2.getZ());
		p.sendMessage(message);
		players.players.remove(executor);
		return true;
	}
	
}
