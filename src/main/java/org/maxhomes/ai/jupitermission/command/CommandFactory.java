package org.maxhomes.ai.jupitermission.command;

import org.maxhomes.ai.jupitermission.exceptions.InvalidCommandException;

public class CommandFactory {
	public static Command createCommand(char commandChar) throws Exception {
		switch (commandChar) {
		case 'L':
			return new TurnLeftCommand();
		case 'R':
			return new TurnRightCommand();
		case 'M':
			return new MoveForwardCommand();
		default:
			throw new InvalidCommandException("Invalid Command: " + commandChar);
		}
	}
}
