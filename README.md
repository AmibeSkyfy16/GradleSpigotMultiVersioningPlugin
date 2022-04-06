# Spigot NMS supporting multi-versionning

Hello, this project is a spigot plugin that supports multi-versionning with the
NMS API.

## Structure of the project :

```
├── core              This is the main module of the project where the cross-version
│                     code is handled.
├── 1_13, 1_14        These are the version-specific modules.
```

The version loading system is already implemented in the core module.

## Build the project :

To build the plugin, you just have to launch the task `:core:createPluginJar`. Your plugin
will be built in the `core/build/libs` directory.

## Rename the packages :

Renaming the packages is pretty straight-forward but needs a bit of time. First,
rename all the packages containing `ch.skyfy.plugin` by the package you want.

After you've done this, you can edit the `core/src/main/resources/plugin.yml` to
match the new package name.

## Add a new version :

### Step 1 : Create a new module

Create a folder named after your version (ex : `1_13` for 1.13.X, `1_14` for
1.14.X, etc...).

Then, go into the `settings.gradle` file, and add at the end :

```groovy
include ':version' // Replace version with the name of the folder you've just created
```

### Step 2 : Configure your module

In the folder of the module, create a `build.gradle` file and fill it with the
following content :

```groovy
dependencies {
    // Replace VERSION with the version you want and make sure that you've run
    // BuildTools for this version before going further.
    implementation name: 'craftbukkit-1.16.5-R0.1-SNAPSHOT'
    implementation name: 'spigot-api-1.16.5-R0.1-SNAPSHOT'
}
```

Then, create a `src/main/java/` folder inside the module, that's where you'll
put your code.

### Step 4 : Add the version loader

Create the `MODULE/src/main/java/your/package/VERSION/VersionLoader.java` file,
replacing `MODULE` with the name of the module you've created, and `VERSION`
with the name of the version you want, following the `spigot-api` naming
convention.
(ex : `v1_13_R1`, `v1_12_R2`, etc...)

Make the VersionLoader class implement the `IVersionLoader` interface.

Then, create the `load()` method and register the version-specific code in it.
And you're good to go !


