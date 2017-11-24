package by.rudzko.jwd.controller;

import by.rudzko.jwd.controller.command.Command;
import by.rudzko.jwd.controller.command.implementation.AddUserCommand;
import by.rudzko.jwd.controller.command.implementation.FindUserCommand;
import by.rudzko.jwd.controller.command.implementation.ShowUsersCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
	
	private static Map <CommandName, Command> commands;
	private static  CommandProvider provider = new CommandProvider();

	public static CommandProvider getProvider() {
		return provider;
	}

	private CommandProvider() {
		commands = new HashMap<>();
		commands.put(CommandName.FINDUSER, new FindUserCommand());
		commands.put(CommandName.ADDUSER, new AddUserCommand());
		commands.put(CommandName.SHOWUSERS, new ShowUsersCommand());
	}
	
	public Command getCommand (String key) {
		return commands.get(CommandName.valueOf(key.toUpperCase()));
	}
	public String getJsp (String key){ return CommandName.valueOf(key.toUpperCase()).getJsp(); }
}
