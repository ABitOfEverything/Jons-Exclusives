## Jon's Exclusives
###A modpack utility mod made for Minecraft.

####v1.0.0 for Minecraft 1.7.10 introduces:
* Custom capes for donors, using the DeveloperCapes libraries, based on a remote cape json file (that can be hosted in GitHub, too)
* Custom player login events for special times, with optional fireworks, and optional automatic messages for surpassing x amounts of downloads (for Technic modpacks only) - all client sided.

####Check out `example` for an example of the local configs (.cfg that you put in modpacks), the remote configs (.json), and the remote cape file (.json), (both stored online). The remote configs have a few modes, as followed:
* 0: Basic message (uses message as a string).
* 1: Message (mainly for coloring) + "Thank you for x downloads!". 
shows up until y downloads are reached (x and y are specified in the remote config json file). Will work only for Technic modpacks with the modpack slug setup in the local config and if Technic's API works.
* 2: Message (mainly for coloring) + player name + ", Have fun playing!".
* 3 plus or -1 minus: Unimplemented, would return an error in the log (won't crash).

For coloring and formatting use MOTD codes in the message string, specified [here](http://minecraft.gamepedia.com/Formatting_codes#Use_in_server.properties_and_pack.mcmeta).
