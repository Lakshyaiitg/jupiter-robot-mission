package org.maxhomes.ai.jupitermission.command;

import org.maxhomes.ai.jupitermission.entities.Robot;

public interface Command {
    void execute(Robot robot);
}
