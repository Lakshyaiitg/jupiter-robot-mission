package org.maxhomes.ai.jupitermission.command;

import org.maxhomes.ai.jupitermission.entities.Robot;

public class TurnRightCommand implements Command {
    @Override
    public void execute(Robot robot) {
        robot.turnRight();
    }
}
