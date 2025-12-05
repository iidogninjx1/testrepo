# AI DISCLAIMER:
This ENTIRE plugin is AI. All credit is to GPT-5 mini!!

# FakeJoin

A small Bukkit plugin that broadcasts fake join messages to all players.

Features
 - /fakejoin <playerName> to broadcast a default yellow "<player> joined the game" message
- /fakejoin <playerName> <message...> to broadcast a custom message (supports & color codes)
- Permission: `fakejoin.use` (default: op)
 - /fakeleave <playerName> to broadcast a default yellow "<player> left the game" message
 - /fakeleave <playerName> <message...> to broadcast a custom message (supports & color codes)
 - Permission: `fakeleave.use` (default: op)

Build

This project uses Maven. To build a jar (requires internet to fetch the spigot API):

```bash
mvn package -DskipTests
```

The resulting jar will be in `target/` — copy it to your server's `plugins/` folder and restart the server.

Usage

- Example: `/fakejoin Notch` => broadcasts a green "Notch joined the game"
- Example: `/fakejoin Steve &aWelcome to the server!` => broadcasts a green name then a green message (use & for color codes)

Notes
- The plugin declares `api-version: "1.21"`. If you need a different api-version, change `plugin.yml` accordingly.
- If compilation fails due to dependency versions, update the `spigot.api.version` in `pom.xml` to match your server API.
