package org.maxhomes.ai.jupitermission.command;

import org.maxhomes.ai.jupitermission.entities.Robot;

public class TurnLeftCommand implements Command {
    @Override
    public void execute(Robot robot) {
        robot.turnLeft();
    }
}
