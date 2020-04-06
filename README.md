# appium
Appium example for Android UI Test with Java Client

Prerequisite

* install npm first
* install npm i -g appium
* install npm i -g appium-doctor
* after install appium-doctor run "appium-doctor" in command line
* follow the instructions according to above command output, note that optinal dependencies can be installed for later
* install eclipse ide
* install TestNG in eclipse ide market place
* check "adb devices" in command line and if no device name is found please run emulator according to "https://developer.android.com/studio/run/emulator-commandline" or connect with real device, make sure that developer options of connected real device switched on and allow install via usb
* import java project in eclipse and then update "deviceName" in setUp of AndroidTest class from "adb devices" command line
* Then run as TestNG in java project, make sure create new proper run configuration according to screenshots
