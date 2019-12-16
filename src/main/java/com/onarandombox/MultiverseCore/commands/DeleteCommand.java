/******************************************************************************
 * Multiverse 2 Copyright (c) the Multiverse Team 2011.                       *
 * Multiverse 2 is licensed under the BSD License.                            *
 * For more information please check the README.md file included              *
 * with this project.                                                         *
 ******************************************************************************/

package com.onarandombox.MultiverseCore.commands;

import com.onarandombox.MultiverseCore.MultiverseCore;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.PermissionDefault;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;

/**
 * Deletes worlds.
 */
public class DeleteCommand extends MultiverseCommand {

    public DeleteCommand(MultiverseCore plugin) {
        super(plugin);
        this.setName("Delete World");
        this.setCommandUsage("/mv delete" + ChatColor.GREEN + " {WORLD}" + ChatColor.GOLD + " [--force]");
        this.setArgRange(1, 2);
        this.addKey("mvdelete");
        this.addKey("mv delete");
        this.addCommandExample("/mv delete " + ChatColor.GOLD + "MyWorld");
        this.setPermission("multiverse.core.delete", "Deletes a world on your server. " + ChatColor.RED + "PERMANENTLY.", PermissionDefault.OP);
    }

    @Override
    public void runCommand(CommandSender sender, List<String> args) {
        if (args.size() == 2) {
            if (Objects.equals( args.get(1), "--force")) {
                MultiverseCore plugin = this.plugin;
                this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin,
                new Runnable() {
                    @Override
                    public void run() {
                        plugin.deleteWorld(args.get(0));
                    }
                }, 1L);
            } else {
                this.plugin.log(Level.FINE, "Wrong arguments: "+args.get(1));
            }
        } else {
            String worldName = args.get(0);
            Class<?>[] paramTypes = {String.class};
            List<Object> objectArgs = new ArrayList<Object>(args);
        this.plugin.getCommandHandler()
                   .queueCommand(sender, "mvdelete", "deleteWorld", objectArgs,
                                 paramTypes, ChatColor.GREEN + "World '" + worldName + "' Deleted!",
                                 ChatColor.RED + "World '" + worldName + "' could NOT be deleted!");
    }
}
