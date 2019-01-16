# Yildiz_Kripto_Odev

This application uses to encript any application with AES-256 chipper. In this repository, we use [Java-Snake-Game](https://github.com/tolgabuyuktanir/Java-Snake-Game.git) jar file to encrypt and decrypt and then run in this app.

## Prerequirements:
1. USB Stick
USB Stick Serial Number and HDD Serial Number use as a key in this app, because HDD ID and USB ID are unique and constant.

## First Time Usage
1. Insert USB Stick
2. Check USB Strick and HDD Serial Numbers

Bash Script to print HDD Serial Number
```
user@user:~$ udevadm info --query=all --name=/dev/sda | grep ID_SERIAL
E: ID_SERIAL=TOSHIBA_MK5075GSX_617LD0GYB
E: ID_SERIAL_SHORT=617LD0GYB
```

Bash Script to print USB Serial Number
```
user@user:~$ cat /proc/scsi/usb-storage/* | grep "Serial Number"
Serial Number: 4C531001481224103181
```



2. Run this code or jar file(Yildiz-Kripto-Odev jar file and [Java-Snake-Game](https://github.com/tolgabuyuktanir/Java-Snake-Game.git) jar file must be in same directory).
```
java -jar out/artifacts/KriptolojiOdev_jar/KriptolojiOdev.jar 
```
If you get any error message, please check file paths.

Jar file of this repository will be encrypted [Java-Snake-Game](https://github.com/tolgabuyuktanir/Java-Snake-Game.git) jar file with USB Stick ID and HDD ID.
Before encryption, [Java-Snake-Game](https://github.com/tolgabuyuktanir/Java-Snake-Game.git) will be run. In this game, we have a hash verification method which verifies classes of this repository.
Sample Hash Values
```
Hash1: 08ACA509EBB7C4A0584F7D6C5DFADC15
Hash2: 0333A5B35F63954B9A8CD56D7F72EDA0
```
For more information about MD5, go to the [wikipedia page](https://www.wikiwand.com/en/MD5) please.

## Usage

1. Insert USB Stick
2. Run this code or jar file(Working directory must include [Java-Snake-Game](https://github.com/tolgabuyuktanir/Java-Snake-Game.git) encrypted jar file).

The jar file of this repository will be decryped and run [Java-Snake-Game](https://github.com/tolgabuyuktanir/Java-Snake-Game.git) encrypted jar file with USB ID and HDD ID. By the way hash verification method will be checked if it has unchanged.
As soon as the jar is started, plain jar file will be removed to keep in secure the application. 
If jar file has changed, after hash verification control, encrypted jar file will be removed. So, Java-Snake-Game will not used by user.
