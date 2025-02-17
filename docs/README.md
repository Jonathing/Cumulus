# Cumulus

A library for custom menu registration, used by the Aether mods.

The library adds a new menu selection screen which can be used to switch the game's main menu and dirt backgrounds. The button to access the selection screen can be found in the top right corner of the main menu.

## :heart: Support The Aether Team

[![Patreon](https://img.shields.io/endpoint.svg?url=https%3A%2F%2Fshieldsio-patreon.vercel.app%2Fapi%3Fusername%3DTheAetherTeam%26type%3Dpatrons&style=flat-square&logoColor=white)](https://patreon.com/TheAetherTeam)
[![Discord](https://img.shields.io/discord/118816101936267265.svg?label=discord&logoColor=FFFFFF&logo=discord&color=7289DA&style=flat-square)](https://discord.gg/aethermod)
[![Twitter](https://img.shields.io/badge/twitter-@DevAether-lightgrey?style=flat-square&logo=twitter&color=1DA1F2&logoColor=white)](https://twitter.com/DevAether)
[![Mastodon](https://img.shields.io/mastodon/follow/110581810287361848?domain=https%3A%2F%2Fmastodon.gamedev.place%2F&style=flat-square&logo=mastodon&logoColor=white&label=mastodon&color=858AFA)](https://mastodon.gamedev.place/@DevAether)
[![Threads](https://custom-icon-badges.demolab.com/badge/threads-devaether-green?logo=instagram-threads&style=flat-square&color=000000)](https://www.threads.net/@devaether)
[![Facebook](https://img.shields.io/badge/facebook-AetherMod-blue?logo=facebook&style=flat-square&color=1877F2&logoColor=white)](https://www.facebook.com/AetherMod)
[![YouTube](https://img.shields.io/badge/youtube-@DevAether-blue?color=FF0000&label=youtube&logo=youtube&style=flat-square)](https://www.youtube.com/@DevAether)
[![Twitch](https://img.shields.io/twitch/status/theaetherteam?logo=twitch&style=flat-square&logoColor=white)](https://www.twitch.tv/theaetherteam)
[![Reddit](https://img.shields.io/reddit/subreddit-subscribers/TheAether?color=FF4500&label=reddit&logo=reddit&style=flat-square&logoColor=white)](https://www.reddit.com/r/TheAether/)
[![wiki.gg](https://custom-icon-badges.demolab.com/badge/wiki.gg-aether-green?logo=wikigg&style=flat-square&color=FF1980)](https://aether.wiki.gg/)

If you enjoy our work, [please consider making a pledge](https://patreon.com/TheAetherTeam) today to help fund development. Every pledge goes directly into our development process and services, enabling us to continue making the Minecraft mods you know and love.

You can also support Cumulus and The Aether Team by telling your friends, joining our Discord server, and sharing our progress and announcements on social media. Every bit helps!

If you're interested in sponsoring Cumulus or The Aether Team, please [contact Oz#1986 on the Aether Community Discord](https://discord.gg/aethermod).

## :package: Download the latest releases
[![Modloader: Forge](https://img.shields.io/badge/mod%20loader-forge-CC974D?style=flat-square)](https://files.minecraftforge.net/net/minecraftforge/forge/)
[![Modrinth Downloads](https://img.shields.io/modrinth/dt/cumulus?color=00AF5C&logo=modrinth)](https://modrinth.com/mod/cumulus)
[![Modrinth Version](https://img.shields.io/modrinth/game-versions/cumulus?color=00AF5C&label=latest&logo=modrinth&last=true)](https://modrinth.com/mod/cumulus)
[![CurseForge Downloads](http://cf.way2muchnoise.eu/cumulus.svg)](https://www.curseforge.com/minecraft/mc-mods/cumulus)
[![CurseForge Version](http://cf.way2muchnoise.eu/versions/cumulus_latest.svg)](https://www.curseforge.com/minecraft/mc-mods/cumulus)
[![CircleCI](https://circleci.com/gh/The-Aether-Team/Cumulus/tree/1.19.4-develop.svg?style=shield)](https://app.circleci.com/pipelines/github/The-Aether-Team/Cumulus?branch=1.19.4-develop)
### Release builds
Cumulus has no stable builds available.

### Bleeding edge builds
If you’re feeling a bit more adventurous or wish to help test the in-development versions, we provide **bleeding edge builds** which are produced on [CircleCI](https://app.circleci.com/pipelines/github/The-Aether-Team/Cumulus). These builds are created for every new commit and contain the latest available code. We do not recommend users treat these builds as releases, as they are unfinished and may contain serious issues. If you wish to download these builds, check out [this guide](https://github.com/The-Aether-Team/Cumulus/wiki/CircleCI-Guide).

### Packages
To install this mod through GitHub Packages in Gradle for development, you will need the [Gradle Github Packages Plugin](https://github.com/0ffz/gpr-for-gradle). To use it, make sure you have access to the Gradle plugins maven and the plugin as a buildscript dependency:

<details>
<summary> Buildscript Code</summary>

```
buildscript {
  repositories {
    ...
    maven {
        name 'Gradle'
        url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    ...
    classpath group: 'io.github.0ffz', name: 'gpr-for-gradle', version: '1.+', changing: true
  }
}
...
apply plugin: 'io.github.0ffz.github-packages'
```

</details>

Then you need to specify the package you want to use in your repository:

<details>
<summary> Repositories Code</summary>

```
repositories {
  ...
  maven githubPackage.invoke("The-Aether-Team/Cumulus")
}
```

</details>

Then load it through your dependencies, with `project.cumulus_version` specified in the `gradle.properties`:

<details>
<summary> Dependencies Code</summary>

```
dependencies {
  ...
  implementation fg.deobf("com.aetherteam.cumulus:cumulus_menus:${project.cumulus_version}")
  ...
}
```

</details>

## :bug: Report bugs or other issues
If you're running into bugs or other problems, feel free to open an issue on our [issue tracker](https://github.com/The-Aether-Team/Cumulus/issues). When doing so, make sure to use one of the provided templates and fill out all the requested information. Make sure to keep your issue's description clear and concise. Your issue's title should also be easy to digest, giving our developers and reporters a good idea of what's wrong without including too many details. Failure to follow any of the above may result in your issue being closed.

## :wrench: Contribute to the project
Looking to contribute to the project? We ask that you read over our [Contributor's Guide](https://github.com/The-Aether-Team/Cumulus/blob/1.19.4-develop/docs/CONTRIBUTING.md) for more details as well as our [Contributor License Agreement (CLA)](https://github.com/The-Aether-Team/Cumulus/blob/1.19.4-develop/docs/AGREEMENT.md) before getting started.

Not sure what to help with? Take a look at our issue tracker for some ideas! [Here's a quick link](https://github.com/The-Aether-Team/Cumulus/labels/status%2Fhelp-wanted) which shows all the currently open issues that we'd love some help on.

## :scroll: License information
[![License (LGPL v3.0)](https://img.shields.io/badge/license-LGPL%20v3.0-green.svg?style=flat-square)](https://github.com/The-Aether-Team/Cumulus/blob/1.19.4-develop/LICENSE.txt)

If you're wanting to create a gameplay video/review, extension or addon, parody, or any other fan work of your own for Cumulus, go for it! We love seeing the content our community creates, and we hope to make it as welcoming as possible for everyone. We ask however that you please don't advertise using our brand (our specific logo assets, team name, official social media posts).

If you are thinking about using Cumulus' code or assets, please note our licensing. The source code and assets of Cumulus is under the LGPL v3.0 license.

If you have a reason that you wish to use our brand or any unlicensed material, please [get in contact with Oz#1986 on the Aether Community Discord](https://discord.gg/aethermod) for details.

## :star2: Special mentions
### :speech_balloon: Translations
[![Crowdin translations](https://img.shields.io/badge/crowdin-cumulus-blue?color=55BC5C&label=crowdin&logo=crowdin&style=flat-square)]()

Cumulus is available in these languages thanks to the following contributors:

| Language                    | Locale  | Translators                                                                                                |
|-----------------------------|---------|------------------------------------------------------------------------------------------------------------|
|                       |  |                                                                                                   |

If you are interested in contributing translations to Cumulus, check out our [Crowdin]() and our [Discord](https://discord.gg/aethermod)! If you have contributed translations in the past and your name is missing from the above list, please contact us.

### :hammer: Contributions
All of our code contribution credits can be found [here](https://github.com/The-Aether-Team/Cumulus/blob/1.19.4-develop/docs/CREDITS.txt). If you contributed to the project and do not see your name, please contact us.
