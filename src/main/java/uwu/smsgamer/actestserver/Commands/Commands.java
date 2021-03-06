package uwu.smsgamer.actestserver.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import uwu.smsgamer.actestserver.ACTestServer;
import uwu.smsgamer.actestserver.Commands.SubCommands.ACCommand;
import uwu.smsgamer.actestserver.Commands.SubCommands.DamageCommand;
import uwu.smsgamer.actestserver.Commands.SubCommands.HungerCommand;
import uwu.smsgamer.actestserver.Commands.SubCommands.VerboseCommand;
import uwu.smsgamer.actestserver.Utils.ChatUtils;
import uwu.smsgamer.actestserver.Vars.Vars;

import java.util.ArrayList;
import java.util.List;

/**
 * Main command executor.
 */
public class Commands implements CommandExecutor, TabCompleter {
    /**
     * Executes the given command, returning its success.
     * <br>
     * If false is returned, then the "usage" plugin.yml entry for this command
     * (if defined) will be sent to the player.
     *
     * @param sender  Source of the command
     * @param cmd Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("anticheat")) {
            ACCommand.acCommand(sender, cmd, label, args);
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("verbose")) {
            VerboseCommand.verboseCommand(sender, cmd, label, args);
        }
        if (cmd.getName().equalsIgnoreCase("damage")) {
            DamageCommand.damageCommand(sender, cmd, label, args);
        }
        if (cmd.getName().equalsIgnoreCase("hunger")) {
            HungerCommand.hungerCommand(sender, cmd, label, args);
        }
        return true;
    }

    /**
     * Requests a list of possible completions for a command argument.
     *
     * @param sender  Source of the command.  For players tab-completing a
     *                command inside of a command block, this will be the player, not
     *                the command block.
     * @param command Command which was executed
     * @param alias   The alias used
     * @param args    The arguments passed to the command, including final
     *                partial argument to be completed and command label
     * @return A List of possible completions for the final argument, or null
     * to default to the command executor
     */
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> tab = new ArrayList<>();
        if(command.getName().equalsIgnoreCase("anticheat")){
            if(args.length == 0){
                tab.add("AAC");
                tab.add("AACAdditionPro");
                tab.add("NCP");
                tab.add("Search");
                tab.add("Phoenix");
                tab.add("Horizon");
                tab.add("Matrix");
                tab.add("None");
            }
        }
        return tab;
    }
}
