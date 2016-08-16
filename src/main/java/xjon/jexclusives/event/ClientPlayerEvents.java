package xjon.jexclusives.event;

import org.json.JSONException;
import org.json.JSONObject;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import xjon.jexclusives.util.JEConfiguration;
import xjon.jexclusives.util.JsonReader;
import xjon.jexclusives.util.Log;
import xjon.jexclusives.util.UrlValidator;


public class ClientPlayerEvents {
	
	@SubscribeEvent
	public void onPlayerLogin(PlayerLoggedInEvent event) throws Exception
	{
		if (!JEConfiguration.specialLoginsDisabled)
		{
			String url = "http://api.enderplay.com/pack/" + JEConfiguration.customModpackSlug + ".json";
			
			if (UrlValidator.isUrlValid(url))
			{
				JSONObject remoteConfigs = JsonReader.readJsonFromUrl(url);
				int args = remoteConfigs.getInt("args");
				String message = remoteConfigs.getString("message");
				EnumChatFormatting color = (EnumChatFormatting) remoteConfigs.get("messageColor");
				boolean fireworks = remoteConfigs.getBoolean("fireworks");
				
				if (args != 0)
				{
					//Example for a custom feature \/
					if (args == 1 && JEConfiguration.customModpackSlug.toLowerCase() == "the-1710-pack")
					{
						JSONObject packData = JsonReader.readJsonFromUrl("http://the-1710-pack.com/cache/pack_platform.json");
						if (packData.getInt("downloads") >= 400000 && packData.getInt("downloads") <= 410000)
						{
							event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.AQUA.BOLD + "Thank you for 400,000 downloads!"));
							if (fireworks && !JEConfiguration.specialLoginsFireworksDisabled)
							{
								//Fireworks here
							}
						}
					}
				}
				else
				{
					event.player.addChatMessage(new ChatComponentText(color + message));
					if (fireworks && !JEConfiguration.specialLoginsFireworksDisabled)
					{
						//Fireworks here
					}
				}
			}
			else
			{
				Log.error("Jon's Exclusives' remote configs aren't online");
			}
		}
	}
	
}
