/**
 * DeveloperCapes by Jadar
 * License: MIT License
 * (https://raw.github.com/jadar/DeveloperCapes/master/LICENSE)
 * version 4.0.0.x
 */
package jadarstudios.developercapes.user;

import jadarstudios.developercapes.cape.ICape;

import java.util.ArrayList;
import java.util.List;

/**
 * This player is getting their own cape
 * 
 * @author jadar
 */
public class User {

    public List<ICape> capes;
    public final String username;

    public User(String username) {
        this.username = username;
        this.capes = new ArrayList<ICape>();
    }
}